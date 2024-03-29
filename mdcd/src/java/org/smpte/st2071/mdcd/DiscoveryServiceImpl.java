package org.smpte.st2071.mdcd;

import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.posick.net.DHCPClient;
import net.posick.net.InetAddressUtils;
import net.posick.net.NetworkTopology;
import net.posick.net.NetworkTopologyListener;

import org.smpte.st2071.Configurable;
import org.smpte.st2071.Startable;
import org.smpte.st2071.mdcd.DiscoveryListener.DomainType;
import org.smpte.st2071.types.Resource;
import org.smpte.util.ListenerProcessor;
import org.smpte_ra.schemas.st2071._2014.query.QueryExpression;
import org.xbill.DNS.Message;
import org.xbill.DNS.Name;
import org.xbill.DNS.PTRRecord;
import org.xbill.DNS.Rcode;
import org.xbill.DNS.Record;
import org.xbill.DNS.ResolverListener;
import org.xbill.DNS.Section;
import org.xbill.DNS.Type;
import org.xbill.mDNS.Browse;
import org.xbill.mDNS.MulticastDNSQuerier;
import org.xbill.mDNS.MulticastDNSService;
import org.xbill.mDNS.Resolve;
import org.xbill.mDNS.Resolve.Domain;

public class DiscoveryServiceImpl implements DiscoveryService, DiscoveryServiceEventer, Startable, Closeable, Configurable, NetworkTopologyListener
{
    protected class DomainBrowser implements Runnable, ResolverListener
    {
        private Browse browser;

        private Resolve resolver;

        private DomainType type;
        
        private long delay = 0;
        
        private List<String> defaultDomains = new ArrayList<>();
        
        private List<String> domains = new ArrayList<>();
        
        private String[] queryNames;
        
        protected DomainBrowser(DomainType type, String... defaultDomains) 
        throws IOException
        {
            this.type = type;
            
            if (defaultDomains != null)
            {
                this.defaultDomains.addAll(Arrays.asList(defaultDomains));
            }
            
            switch (type)
            {
                case BROWSE :
                    queryNames = new String[]{MulticastDNSService.DEFAULT_BROWSE_DOMAIN_NAME, MulticastDNSService.BROWSE_DOMAIN_NAME, MulticastDNSService.LEGACY_BROWSE_DOMAIN_NAME};
                    break;
                case REGISTRATION :
                    queryNames = new String[]{MulticastDNSService.DEFAULT_REGISTRATION_DOMAIN_NAME, MulticastDNSService.REGISTRATION_DOMAIN_NAME};
                    break;
                default :
                    throw new IllegalArgumentException("\"" + type + "\" is not an accepted value.");
            }
            this.browser = new Browse(queryNames);
            this.resolver = new Resolve(queryNames);
        }
        
        public String[] getDomains()
        {
            List<String> domains = null;
            synchronized (this.domains)
            {
                domains = this.domains;
            }
            return domains.toArray(new String[domains.size()]);
        }
        
        
        public void start()
        throws IOException
        {
            browser.start(this);
        }
        
        
        public void close() 
        throws IOException
        {
            browser.close();
        }
        
        @Override
        public void run()
        {
            try
            {
                synchronized (this.domains)
                {
                    final DiscoveryListener dispatcher = discoveryListener.getDispatcher();
                    final DomainType type = this.type;
                    Domain[] domainNames = resolver.resolveDomains();
                    if (domainNames != null)
                    {
                        List<String> copy = new ArrayList<>(this.domains);
                        
                        // Add newly discovered Domain names to list.
                        List<String> names = new ArrayList<>();
                        
                        List<String> defaultDomains = this.defaultDomains; // avoid getfield opcode
                        for (String defaultDomain : defaultDomains)
                        {
                            if (!copy.contains(defaultDomain))
                            {
                                dispatcher.domainAdded(type, defaultDomain);
                            }
                            names.add(defaultDomain);
                        }
                        
                        for (Domain domainName : domainNames)
                        {
                            String name = domainName.getName();
                            if (!copy.contains(name))
                            {
                                dispatcher.domainAdded(type, name);
                            }
                            names.add(name);
                        }
                        copy.removeAll(names);
                        
                        // Remove domain names that no longer exist.
                        for (String name : copy)
                        {
                            if (names.remove(name))
                            {
                                dispatcher.domainRemoved(type, name);
                            }
                        }
                        
                        this.domains = names;
                    }
                }
            } catch (IOException e)
            {
                log.log(Level.FINE, e.getMessage(), e);
            }
            
            // Reschedule query for every 
            delay = delay > 0 ? Math.min(delay * 2, 3600) : 1;
            executor.schedule(this, delay, TimeUnit.SECONDS);
        }

        @Override
        public void receiveMessage(Object id, Message m)
        {
            if (m.getRcode() == Rcode.NOERROR)
            {
                int[] sections = new int[] {Section.ANSWER, Section.ADDITIONAL, Section.AUTHORITY};
                for (int section : sections)
                {
                    Record[] records = m.getSectionArray(section);
                    if (records != null)
                    {
                        for (Record record : records)
                        {
                            if (record.getType() == Type.PTR)
                            {
                                PTRRecord ptr = (PTRRecord) record;
                                Name name = ptr.getName();
                                for (String query : queryNames)
                                {
                                    if (name.toString().startsWith(query))
                                    {
                                        domains.add(ptr.getTarget().toString());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override
        public void handleException(Object id, Exception e)
        {
            log.log(Level.FINE, e.getMessage(), e);
        }
    }


    protected class RunnableTask implements Runnable
    {
        Runnable r;
        
        protected RunnableTask(Runnable r)
        {
            this.r = r;
        }
        
        @Override
        public void run()
        {
            try
            {
                r.run();
            } catch (Throwable t)
            {
                log.log(Level.FINE, t.getMessage(), t);
            }
        }
    }

    public static final String PROP_DOMAINS = "domains";
    
    protected NetworkTopology topology;
    
    protected ScheduledExecutorService executor;
    
    protected ListenerProcessor<DiscoveryListener> discoveryListener = new ListenerProcessor<>(DiscoveryListener.class);
    
    protected Logger log = Logger.getLogger(getClass().getName());
    
    protected MulticastDNSQuerier querier = null;
    
    protected MulticastDNSService service = null;

    protected DomainBrowser browseDomains;

    protected DomainBrowser registrationDomains;
    
    protected Set<String> defaultDomains = new HashSet<String>();
    
    protected Map<String, String> properties = new HashMap<>();

    private Map<InetAddress, Set<String>> hostnamesByAddress = new HashMap<>();


    @Override
    public void setConfiguration(Map<String, String> properties)
    {
        this.properties.clear();
        this.properties.putAll(properties);
    }


    @Override
    public Map<String, String> getConfiguration()
    {
        return properties;
    }
    
    
    @Override
    public void registerDiscoveryListener(DiscoveryListener listener)
    {
        discoveryListener.registerListener(listener);
    }
    
    
    @Override
    public void unregisterDiscoveryListener(DiscoveryListener listener)
    {
        discoveryListener.unregisterListener(listener);
    }
    
    
    @Override
    public String[] getBrowseDomains()
    {
        return browseDomains.getDomains();
    }
    
    
    @Override
    public String[] getRegistrationDomains()
    {
        return registrationDomains.getDomains();
    }
    
    
    @Override
    public Resource[] listResources(String rn, QueryExpression query)
    throws DiscoveryException
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    
    @Override
    public void browse(String rn, QueryExpression query, DiscoveryListener listener)
    throws DiscoveryException
    {
        // TODO Auto-generated method stub
        
    }
    
    
    @Override
    public void registerResource(Resource resource)
    throws DiscoveryException
    {
        // TODO Auto-generated method stub
        
    }
    
    
    @Override
    public void unregisterResource(Resource resource)
    throws DiscoveryException
    {
        // TODO Auto-generated method stub
        
    }
    
    
    @Override
    public Set<String> getHostNames()
    {
        HashSet<String> hostnames = new HashSet<>();
        for (Set<String> names : hostnamesByAddress.values())
        {
            if (names != null && names.size() > 0)
            {
                hostnames.addAll(names);
            }
        }
        
        return hostnames;
    }


    @Override
    public Set<String> getHostNamesForAddress(InetAddress address)
    {
        return hostnamesByAddress.get(address);
    }
    
    
    @Override
    public void start()
    throws Exception
    {
        try
        {
            if (properties == null)
            {
                properties = loadConfiguration();
            }
            
            executor = Executors.newScheduledThreadPool(1);
            
            querier = new MulticastDNSQuerier(true, true);
        
            service = new MulticastDNSService();
            service.setQuerier(querier);
        
            browseDomains = new DomainBrowser(DomainType.BROWSE);
            registrationDomains = new DomainBrowser(DomainType.REGISTRATION);
            
            executor.execute(new RunnableTask(browseDomains));
            executor.execute(new RunnableTask(registrationDomains));
            
            
            topology = NetworkTopologyFactory.newNetworkTopology(true, true, true, true);
            topology.registerNetworkTopologyListener(this);
            topology.start();
        } catch (InvocationTargetException e)
        {
            throw (Exception) e.getTargetException();
        } catch (IOException e)
        {
            log.log(Level.SEVERE, e.getMessage(), e);
            throw e;
        }
    }


    @Override
    public void close()
    throws IOException
    {
        topology.stop();
        
        try
        {
            browseDomains.close();
        } catch (IOException e)
        {
            log.log(Level.FINE, e.getMessage(), e);
        }
        
        try
        {
            registrationDomains.close();
        } catch (IOException e)
        {
            log.log(Level.FINE, e.getMessage(), e);
        }
        
        try
        {
            querier.close();
        } catch (IOException e)
        {
            log.log(Level.FINE, e.getMessage(), e);
        }
        
        try
        {
            service.close();
        } catch (IOException e)
        {
            log.log(Level.FINE, e.getMessage(), e);
        }
        
        try
        {
            discoveryListener.close();
        } catch (IOException e)
        {
            log.log(Level.FINE, e.getMessage(), e);
        }
    }


    public void interfaceAdded(NetworkInterface networkInterface, List<InetAddress> addresses)
    {
        log.fine("Interface Added : " + networkInterface.getDisplayName() + "; Addresses: " + addresses +".");
        for (InetAddress address : addresses)
        {
            addressAdded(networkInterface, address);
        }
    }


    public void interfaceRemoved(NetworkInterface networkInterface, List<InetAddress> addresses)
    {
        log.fine("Interface Removed : " + networkInterface.getDisplayName() + "; Addresses: " + addresses +".");
        for (InetAddress address : addresses)
        {
            addressRemoved(networkInterface, address);
        }
    }


    // 1: Create reverse subnet mask domain names (IP 192.168.1.20 becomes 0.1.168.192.in-addr.arpa.)
    // 2: Add configured domain names
    // 3: Get domain name from hostname
    // 4: Get domain names from hostnames derived from reverse lookups of the IP Address
    // 5: Add "local."
    // 6: Get domain names from DHCP "Domain" option code 15 (RFC 2132)
    // 7: Get domain names from DHCP "Domain Search" option code 119 (RFC 3397)
    // 8: If IPv6, Get domain names from IPv6 Router Advertisement DNSSL (RFC 6106)
    public void addressAdded(NetworkInterface networkInterface, InetAddress address)
    {
        log.fine("Address Added : " + networkInterface.getDisplayName() + "; Address: " + address +".");
        
        Set<String> defaultDomains = new HashSet<String>();

        // 1: Create reverse subnet mask domain names (IP 192.168.1.20 becomes 0.1.168.192.in-addr.arpa.)
        if (!address.isLoopbackAddress())
        {
            String reverseMaskDomain = InetAddressUtils.reverseMapAddress(address);
            if (!defaultDomains.contains(reverseMaskDomain))
            {
                defaultDomains.add(reverseMaskDomain);
            }
        }
        
        // 2: Add configured domain names
        String configuredDomains = properties.get(PROP_DOMAINS);
        if (configuredDomains != null)
        {
            String[] domains = configuredDomains.split(";,");
            if (domains != null && domains.length > 0)
            {
                for (String domain : domains)
                {
                    if (domain != null && domain.length() > 0)
                    {
                        defaultDomains.add(domain + (domain.endsWith(".") ? "" : "."));
                    }
                }
            }
        }
        
        // 3: Get domain names from the hostnames assigned to the address, if any.
        // 4: (Already done by Topology Service) Get domain names from hostnames derived from reverse lookups of the IP Address
        try
        {
            String hostname = address.getCanonicalHostName();
            if (hostname != null && hostname.length() > 0 && !hostname.equals(address.getHostAddress()) && !hostname.startsWith(address.getHostAddress()))
            {
                synchronized (hostnamesByAddress)
                {
                    Set<String> hostnames = hostnamesByAddress.get(address);
                    if (hostnames == null)
                    {
                        hostnames = new HashSet<>();
                        hostnamesByAddress.put(address, hostnames);
                    }
                    
                    if (!hostnames.contains(hostname))
                    {
                        hostnames.add(hostname);
                    }
                }
                
                String domain = determineDomain(hostname);
                if (domain != null && domain.length() > 0)
                {
                    defaultDomains.add(domain + (domain.endsWith(".") ? "" : "."));
                }
            }
        } catch (Exception e)
        {
            log.log(Level.FINER, "Error looking up name for address \"" + address.getHostAddress() + " - " + e.getMessage(), e);
        }
        
        // 5: Add "local."
        defaultDomains.add(MulticastDNSService.LINK_LOCAL_DOMAIN);
        
        // If IPv4 Address use DHCP
        if (address.getAddress().length == 4)
        {
            // 6: Get domain names from DHCP "Domain" option code 15 (RFC 2132)
            // 7: Get domain names from DHCP "Domain Search" option code 119 (RFC 3397)
            try
            {
                Set<String> domains = DHCPClient.resolveDHCPDomainNames(address);
                if (domains != null && domains.size() > 0)
                {
                    for (String domain : domains)
                    {
                        defaultDomains.add(domain + (domain.endsWith(".") ? "" : "."));
                    }
                }
            } catch (Exception e)
            {
                log.log(Level.WARNING, "Could not get domain names from DHCP - " + e.getMessage(), e);
            }
        }
        
        // TODO: 8: If IPv6, Get domain names from IPv6 Router Advertisement DNSSL (RFC 6106)
        
        this.defaultDomains.addAll(defaultDomains);
        log.info("Domains for IP: " + address + " = " + defaultDomains);
    }
    

    private String determineDomain(String hostname)
    {
        
        int pos = hostname.indexOf('.');
        if (pos >= 0)
        {
            String domain = hostname.substring(pos + 1);
            return domain == null || domain.length() == 0 ? null : domain;
        } else
        {
            return null;
        }
    }


    public void addressRemoved(NetworkInterface networkInterface, InetAddress address)
    {
        // TODO: Remove artifacts related to only this address.
        log.fine("Address Removed : " + networkInterface.getDisplayName() + "; Address: " + address +".");
        hostnamesByAddress.remove(address);
    }
    
    
    protected Map<String, String> loadConfiguration()
    {
        Map<String, String> map = new HashMap<>();
        Properties properties = new Properties();
        
        Class<?> clazz = getClass();
        java.net.URL url = clazz.getResource(clazz.getSimpleName());
        
        if (url != null && url.getProtocol().equalsIgnoreCase("file"))
        {
            try
            {
                File file = new File(url.toURI());
                properties.load(new FileReader(file));
            } catch (IOException e)
            {
                log.log(Level.WARNING, "Error opening configuration file \"" + url + "\" - " + e.getMessage(), e);
            } catch (URISyntaxException e)
            {
                log.log(Level.WARNING, "Error opening configuration file \"" + url + "\" - " + e.getMessage(), e);
            }
        } else
        {
            try
            {
                properties.load(url.openStream());
            } catch (IOException e)
            {
                log.log(Level.WARNING, "Error opening configuration URL \"" + url + "\" - " + e.getMessage(), e);
            }
        }
        
        for (Map.Entry<Object, Object> entry : properties.entrySet())
        {
            Object key = entry.getKey();
            Object value = entry.getValue();
            
            if (key != null)
            {
                map.put(key.toString(), value == null ? null : value.toString());
            }
        }
        
        return map;
    }
    
    
    public static void main(String... args)
    throws Exception
    {
        DiscoveryService service = new DiscoveryServiceImpl();
        
        try
        {
            ((Startable) service).start();
            
            System.out.println("\nPress \'q\' or \'Q\' to quit.");
            
            int count = 0;
            while (true && count < Integer.MAX_VALUE)
            {
                // Test Browse Domain Discovery
                printArray(service.getBrowseDomains(), "Browse Domains:\n", "\t%s\n", "\n");
                
                // Test Registration Domain Discovery
                printArray(service.getRegistrationDomains(), "Registration Domains:\n", "\t%s\n", "\n");
                
                // Test DNS Record Discovery
                // Test Service Discovery Discovery
                
                try
                {
                    Thread.sleep(1000);
                } catch (InterruptedException e)
                {
                    // ignore
                }
                
                int c;
                if (System.in.available() > 0 && ((c = System.in.read()) == 'q' || (c == 'Q')))
                {
                    break;
                }
            } 
        } finally
        {
            ((Closeable) service).close();
        }
        
        System.exit(0);
    }


    private static void printArray(Object[] array, String... format)
    {
        if (array != null && format != null && format.length > 0)
        {
            int startFormat = 0;
            int endFormat = format.length - 1;
            int lastElementFormat = -1;
            
            // Process Headers
            if (format.length > 1) 
            {
                while (startFormat < endFormat && !format[startFormat].contains("%"))
                {
                    System.out.print(format[startFormat++]);
                }
            }
            
            // Process Footers
            if (format.length > 1)
            {
                while (endFormat > startFormat && !format[endFormat].contains("%"))
                {
                    endFormat--;
                }
            }
            
            // Get Last Element Format (last format that is not a footer)
            lastElementFormat = endFormat;
            if ((endFormat - startFormat) > 0)
            {
                endFormat--;
            }
            
            int index = 0;
            int fIndex = startFormat;
            
            for (; index < array.length - 1;)
            {
                while (!format[fIndex].contains("%"))
                {
                    System.out.print(format[fIndex++]);
                    if (fIndex > endFormat)
                    {
                        fIndex = startFormat;
                    }
                }
                
                System.out.printf(format[fIndex++], array[index++]);
                if (fIndex > endFormat)
                {
                    fIndex = startFormat;
                }
            }
            
            // Format last element
            while (!format[fIndex].contains("%"))
            {
                System.out.print(format[fIndex++]);
                if (fIndex > endFormat)
                {
                    fIndex = startFormat;
                }
            }
            
            if (index < array.length)
            {
                System.out.printf(format[lastElementFormat], array[index++]);
            }
            
            for (fIndex = lastElementFormat + 1; fIndex < format.length; fIndex++)
            {
                System.out.print(format[fIndex]);
            }
        }
    }
}