package net.posick.net.sunjre;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.posick.net.NetworkTopologyDiscoveryService;
import net.posick.net.NetworkTopologyListener;

import org.smpte.util.ListenerProcessor;


public class NetworkTopologyDiscoveryServiceImpl implements NetworkTopologyDiscoveryService
{
    static class TopologyPoller extends TimerTask
    {
        private static final Logger log = Logger.getLogger(TopologyPoller.class.getName());
        
        private static final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        
        
        private transient boolean started = false;
        
        private NetworkTopologyDiscoveryService topologyDiscovery;
        
        private Map<NetworkInterface, List<InetAddress>> knownInterfaces = new ConcurrentHashMap<NetworkInterface, List<InetAddress>>();

        private NetworkTopologyListener listenerProcessor;
        
        
        TopologyPoller(NetworkTopologyDiscoveryService topologyDiscovery, NetworkTopologyListener listenerProcessor)
        {
            this.topologyDiscovery = topologyDiscovery;
            this.listenerProcessor = listenerProcessor;
        }
        
        
        public synchronized boolean isStarted()
        {
            return started;
        }
        
        
        public synchronized void start()
        {
            if (!started)
            {
                log.finer("Network Topology Poller Starting");
                started = true;
                executor.scheduleAtFixedRate(this, 0, 10, TimeUnit.SECONDS);
                log.fine("Network Topology Poller Started");
            }
        }
        
        
        public synchronized void stop()
        {
            if (started)
            {
                log.finer("Network Topology Poller Stopping");
                started = false;
                executor.shutdown();;
                log.fine("Network Topology Poller Stopped");
            }
        }
        
        
        protected Set<String> determineHostNames()
        {
            HashSet<String> hostnames = new HashSet<>();
            String hostname;
            
            try
            {
                InetAddress localHost = InetAddress.getLocalHost();
                hostname = localHost.getCanonicalHostName();
                
                if (hostname != null && hostname.length() > 0 && !hostname.equals(localHost.getHostAddress()) && !hostname.startsWith(localHost.getHostAddress()))
                {
                    hostnames.add(hostname);
                }
            } catch (UnknownHostException e)
            {
                // ignore
                log.log(Level.FINE, e.getMessage(), e);
            }
            
            try
            {
                Map<NetworkInterface, List<InetAddress>> interfaces = topologyDiscovery.listAddresses();
                if (interfaces != null && interfaces.size() > 0)
                {
                    for (Map.Entry<NetworkInterface, List<InetAddress>> entry : interfaces.entrySet())
                    {
                        if (!entry.getKey().isLoopback())
                        {
                            for (InetAddress address : entry.getValue())
                            {
                                try
                                {
                                    hostname = address.getCanonicalHostName();
                                    if (hostname != null && hostname.length() > 0 && !hostname.equals(address.getHostAddress()) && !hostname.startsWith(address.getHostAddress()))
                                    {
                                        hostnames.add(hostname);
                                    }
                                } catch (Exception e)
                                {
                                    log.log(Level.FINER, "Error looking up name for address \"" + address.getHostAddress() + " - " + e.getMessage(), e);
                                }
                            }
                        }
                    }
                }
            } catch (Throwable e)
            {
                log.log(Level.FINE, e.getMessage(), e);
            }
                
            String[] PROPRTY_NAMES = new String[] {"COMPUTERNAME", "HOSTNAME", "hostname"};
            
            for (String varName : PROPRTY_NAMES)
            {
                hostname = System.getenv(varName);
                if (hostname != null && hostname.length() > 0)
                {
                    hostnames.add(hostname);
                }
            }
            
            for (String varName : PROPRTY_NAMES)
            {
                hostname = System.getProperty(varName);
                if (hostname != null && hostname.length() > 0)
                {
                    hostnames.add(hostname);
                }
            }
                
            String[] COMMANDS = new String[]{"hostname", "hostname -f"};
            for (String command : COMMANDS)
            {
                try
                {
                    Process process = Runtime.getRuntime().exec(command);
                    int returnValue = process.waitFor();
                    if (returnValue == 0)
                    {
                        DataInputStream in = new DataInputStream(process.getInputStream());
                        if (in.available() > 0)
                        {
                            StringBuilder b = new StringBuilder();
                            int value;
                            while ((value = in.read()) >= 0)
                            {
                                b.append((char) value);
                            }
                            if (b.length() > 0)
                            {
                                hostnames.add(b.toString());
                            }
                        }
                    }
                } catch (Throwable e)
                {
                    log.log(Level.FINE, "Error executing system command \"hostname -f\" - " + e.getMessage(), e);
                }
            }
            
            return hostnames;
        }
        
        
        @Override
        public void run()
        {
            try
            {
                log.fine("Polling Network Topology");
                
                Map<NetworkInterface, List<InetAddress>> newInterfaces = topologyDiscovery.listAddresses();
                for (Map.Entry<NetworkInterface, List<InetAddress>> entry : newInterfaces.entrySet())
                {
                    NetworkInterface iface = entry.getKey();
                    List<InetAddress> addresses = entry.getValue();
                    
                    if (!knownInterfaces.containsKey(iface))
                    {
                        knownInterfaces.put(iface, addresses);
                        listenerProcessor.interfaceAdded(iface, addresses);
                    } else
                    {
                        if (addresses != null && !addresses.isEmpty())
                        {
                            List<InetAddress> knownAddresses = knownInterfaces.get(iface);
                            List<InetAddress> newAddresses = new ArrayList<>();
                            
                            for (InetAddress address : addresses)
                            {
                                if (knownAddresses == null)
                                {
                                    knownAddresses = new ArrayList<>();
                                }
                                
                                if (!knownAddresses.contains(address))
                                {
                                    newAddresses.add(address);
                                }
                            }
                            
                            if (newAddresses.size() > 0)
                            {
                                knownAddresses.addAll(newAddresses);
                                for (InetAddress newAddress : newAddresses)
                                {
                                    listenerProcessor.addressAdded(iface, newAddress);
                                }
                            }
                        }
                    }
                }
                
                for (Map.Entry<NetworkInterface, List<InetAddress>> entry : knownInterfaces.entrySet())
                {
                    NetworkInterface iface = entry.getKey();
                    List<InetAddress> addresses = entry.getValue();
                    
                    if (!newInterfaces.containsKey(iface))
                    {
                        List<InetAddress> removedAddresses = knownInterfaces.remove(iface);
                        listenerProcessor.interfaceRemoved(iface, removedAddresses);
                    } else
                    {
                        List<InetAddress> newAddresses = newInterfaces.get(iface);
                        if (newAddresses != null && !newAddresses.isEmpty() && addresses != null && !addresses.isEmpty())
                        {
                            List<InetAddress> removedAddresses = new ArrayList<InetAddress>();
                            for (InetAddress knownAddress : addresses)
                            {
                                if (!newAddresses.contains(knownAddress))
                                {
                                    removedAddresses.add(knownAddress);
                                    listenerProcessor.addressRemoved(iface, knownAddress);
                                }
                            }
                            
                            if (removedAddresses.size() > 0)
                            {
                                List<InetAddress> knownAddresses = knownInterfaces.get(iface);
                                if (knownAddresses != null)
                                {
                                    knownAddresses.removeAll(removedAddresses);
                                }
                            }
                        }
                    }
                }
            } catch (Throwable t)
            {
                log.log(Level.WARNING, t.getMessage(), t);
            }
        }
        
        
        @Override
        protected void finalize()
        {
            stop();
        }
    }
    
    private final Logger log = Logger.getLogger(getClass().getName());
    
    private ListenerProcessor<NetworkTopologyListener> listenerProcessor = new ListenerProcessor<>(NetworkTopologyListener.class);
    
    private boolean useIPv6;
    
    private boolean useSiteLocal;
    
    private boolean useVirtual;
    
    private boolean useLoopback;
    
    private TopologyPoller topologyPoller = new TopologyPoller(this, listenerProcessor.getDispatcher());
    
    
    public NetworkTopologyDiscoveryServiceImpl(boolean useIPv6, boolean useSiteLocal, boolean useVirtual, boolean useLoopback)
    {
        this.useIPv6 = useIPv6;
        this.useSiteLocal = useSiteLocal;
        this.useVirtual = useVirtual;
        this.useLoopback = useLoopback;
    }
    
    
    public void start()
    {
        log.finer("Network Topology Monitor Starting");
        
        topologyPoller.start();
        
        log.fine("Network Topology Monitor Started");
    }
    
    
    public void stop()
    {
        log.finer("Network Topology Monitor Stopping");
        
        topologyPoller.stop();
        
        try
        {
            listenerProcessor.close();
        } catch (IOException e)
        {
            // ignore
        }
        
        log.fine("Network Topology Monitor Stopped");
    }


    public Map<NetworkInterface, List<InetAddress>> listAddresses()
    throws SocketException
    {
        Map<NetworkInterface, List<InetAddress>> interfaces = new HashMap<NetworkInterface, List<InetAddress>>();
        
        Enumeration<NetworkInterface> ifaces = NetworkInterface.getNetworkInterfaces();
        while (ifaces.hasMoreElements())
        {
            NetworkInterface networkInterface = ifaces.nextElement();
            if (useNetworkInterface(networkInterface))
            {
                Enumeration<InetAddress> addrs = networkInterface.getInetAddresses();
                while (addrs.hasMoreElements())
                {
                    InetAddress inetAddress = addrs.nextElement();
                    if (useInetAddress(inetAddress))
                    {
                        List<InetAddress> addresses = interfaces.get(networkInterface);
                        if (addresses == null)
                        {
                            addresses = new ArrayList<InetAddress>();
                            interfaces.put(networkInterface, addresses);
                        }
                        
                        addresses.add(inetAddress);
                    }
                }
            }
            
            if (useVirtual)
            {
                Enumeration<NetworkInterface> virtualIfaces = networkInterface.getSubInterfaces();
                while (virtualIfaces.hasMoreElements())
                {
                    NetworkInterface subNetworkInterface = virtualIfaces.nextElement();
                    if (useNetworkInterface(networkInterface))
                    {
                        Enumeration<InetAddress> addrs = subNetworkInterface.getInetAddresses();
                        while (addrs.hasMoreElements())
                        {
                            InetAddress inetAddress = addrs.nextElement();
                            if (useInetAddress(inetAddress))
                            {
                                List<InetAddress> addresses = interfaces.get(networkInterface);
                                if (addresses == null)
                                {
                                    addresses = new ArrayList<InetAddress>();
                                    interfaces.put(networkInterface, addresses);
                                }
                                
                                addresses.add(inetAddress);
                            }
                        }
                    }
                }
            }
        }
        
        return Collections.unmodifiableMap(interfaces);
    }
    
    
    public boolean isMonitoringIPv6()
    {
        return useIPv6;
    }
    
    
    public boolean isMonitoringSiteLocal()
    {
        return useSiteLocal;
    }


    public boolean isMonitoringVirtual()
    {
        return useVirtual;
    }


    public boolean isMonitoringLoopback()
    {
        return useLoopback;
    }


    protected boolean useNetworkInterface(NetworkInterface networkInterface)
    {
        if (useVirtual && networkInterface.isVirtual())
        {
            return true;
        }
        
        try
        {
            if (useLoopback && networkInterface.isLoopback())
            {
                return true;
            }
            
            return networkInterface.isUp();
        } catch (SocketException e)
        {
            return false;
        }
    }
    
    
    protected boolean useInetAddress(InetAddress inetAddress)
    {
        if ((useSiteLocal && (inetAddress.isSiteLocalAddress() || inetAddress.isLinkLocalAddress() || inetAddress.isAnyLocalAddress())) ||
            (useLoopback && inetAddress.isLoopbackAddress()))
        {
            if (useIPv6)
            {
                return true;
            } else
            {
                return inetAddress.getAddress().length == 4;
            }
        }
        
        return false;
    }
    
    
    public void registerNetworkTopologyListener(NetworkTopologyListener listener)
    {
        listenerProcessor.registerListener(listener);
    }
    
    
    public void unregisterNetworkTopologyListener(NetworkTopologyListener listener)
    {
        listenerProcessor.unregisterListener(listener);
    }


    @Override
    public int getNetworkPrefixLength(InetAddress address)
    {
        try
        {
            NetworkInterface iface = NetworkInterface.getByInetAddress(address);
            if (useNetworkInterface(iface))
            {
                List<InterfaceAddress> ifaceAddresses = iface.getInterfaceAddresses();
                if (ifaceAddresses != null)
                {
                    for (InterfaceAddress ifaceAddress : ifaceAddresses)
                    {
                        try
                        {
                            if (useInetAddress(ifaceAddress.getAddress()) && ifaceAddress.getAddress().equals(address))
                            {
                                return ifaceAddress.getNetworkPrefixLength();
                            }
                        } catch (Exception e)
                        {
                            log.log(Level.WARNING, "Could not determine ARPA domain for address \"" + ifaceAddress + "\" on Network Interface \"" + iface + "\"" + (e.getMessage() != null ? " - " + e.getMessage() : "."), e);
                        }
                    }
                }
            }
        } catch (Exception e)
        {
            log.log(Level.WARNING, "Error Adding Subnet ARPA domain" + (e.getMessage() != null ? " - " + e.getMessage() : "."), e);
        }
        
        return -1;
    }
}