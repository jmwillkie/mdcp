package org.smpte.st2071.mdcd;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.NamingException;

import org.smpte.st2071.mdcd.DiscoveryListener.DomainType;
import org.smpte.st2071.mdcd.net.InetAddressUtils;
import org.smpte.st2071.mdcd.net.NetworkTopologyDiscoveryService;
import org.smpte.st2071.mdcd.net.NetworkTopologyDiscoveryServiceImpl;
import org.smpte.st2071.mdcd.net.NetworkTopologyListener;
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

public class DiscoveryServiceImpl implements DiscoveryService, NetworkTopologyListener
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
    
    protected NetworkTopologyDiscoveryService topology;
    
    protected ScheduledExecutorService executor;
    
    protected ListenerProcessor<DiscoveryListener> discoveryListener = new ListenerProcessor<>(DiscoveryListener.class);
    
    protected Logger log = Logger.getLogger(getClass().getName());
    
    protected MulticastDNSQuerier querier = null;
    
    protected MulticastDNSService service = null;

    protected DomainBrowser browseDomains;

    protected DomainBrowser registrationDomains;
    
    protected List<String> defaultDomains = new ArrayList<String>();
    
    protected Map<String, String> properties = new HashMap<>();


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
    throws NamingException
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    
    @Override
    public void browse(String rn, QueryExpression query, DiscoveryListener listener)
    throws NamingException
    {
        // TODO Auto-generated method stub
        
    }
    
    
    @Override
    public void registerResource(Resource resource)
    throws NamingException
    {
        // TODO Auto-generated method stub
        
    }
    
    
    @Override
    public void unregisterResource(Resource resource)
    throws NamingException
    {
        // TODO Auto-generated method stub
        
    }
    
    
    @Override
    public void start()
    throws IOException
    {
        try
        {
            // TODO: Load configured domains
            if (properties == null)
            {
                properties = loadConfiguration();
            }
            
            executor = Executors.newScheduledThreadPool(1);
            
            querier = new MulticastDNSQuerier(true, true);
        
            service = new MulticastDNSService();
            service.setQuerier(querier);
        
            browseDomains = new DomainBrowser(DomainType.BROWSE, determineDefaultBrowseDomains());
            registrationDomains = new DomainBrowser(DomainType.REGISTRATION);
            
            executor.execute(new RunnableTask(browseDomains));
            executor.execute(new RunnableTask(registrationDomains));
            
            topology = new NetworkTopologyDiscoveryServiceImpl(true, true, true, true);
            topology.registerNetworkTopologyListener(this);
            topology.start();
        } catch (IOException e)
        {
            log.log(Level.SEVERE, e.getMessage(), e);
            throw e;
        }
    }


    @Override
    public void stop()
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
        System.out.println("Interface Added : " + networkInterface.getDisplayName() + "; Addresses: " + addresses +".");
    }


    public void interfaceRemoved(NetworkInterface networkInterface, List<InetAddress> addresses)
    {
        System.out.println("Interface Removed : " + networkInterface.getDisplayName() + "; Addresses: " + addresses +".");
    }


    public void addressAdded(NetworkInterface networkInterface, InetAddress address)
    {
        System.out.println("Address Added : " + networkInterface.getDisplayName() + "; Address: " + address +".");
        // TODO: Create reverse subnet mask domain names (IP 192.168.1.20 becomes 0.1.168.192.in-addr.arpa.)
        String reverseMaskDomain = InetAddressUtils.reverseMapAddress(address);
        if (!defaultDomains.contains(reverseMaskDomain))
        {
            defaultDomains.add(reverseMaskDomain);
        }
    }


    public void addressRemoved(NetworkInterface networkInterface, InetAddress address)
    {
        // TODO: Remove artifacts related to only this address.
        System.out.println("Address Removed : " + networkInterface.getDisplayName() + "; Address: " + address +".");
        
    }
    
    
    protected String[] determineDefaultBrowseDomains()
    {
        // TODO: Create reverse subnet mask domain names (IP 192.168.1.20 becomes 0.1.168.192.in-addr.arpa.)
        // TODO: Add configured domain names
        // TODO: Get domain name from hostname
        // TODO: Get domain names from hostnames derived from reverse lookups of the IP Address
        // TODO: Add "local."
        // TODO: Get domain names from DHCP "Domain" option code 15 (RFC 2132)
        // TODO: Get domain names from DHCP "Domain Search" option code 119 (RFC 3397)
        // TODO: If IPv6, Get domain names from IPv6 Router Advertisement DNSSL (RFC 6106)
        return null;
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
            service.start();
            
            int count = 0;
            while (true && count < Integer.MAX_VALUE)
            {
                // Test Browse Domain Discovery
                printArray(service.getBrowseDomains(), "Browse Domains:\n", "\t%s\n", "\n");
                
                // Test Registration Domain Discovery
                printArray(service.getRegistrationDomains(), "Registration Domains:\n", "\t%s\n", "\n");
                
                // Test DNS Record Discovery
                // Test Service Discovery Discovery
                
                System.out.println("\nPress \'q\' or \'Q\' to quit.");
                
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
            service.stop();
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