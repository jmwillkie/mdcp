package org.smpte.st2071.mdcd.net;

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
        
        
        @Override
        public void run()
        {
            try
            {
                log.fine("Polling Network Topology");
                
                Map<NetworkInterface, List<InetAddress>> newInterfaces = topologyDiscovery.listAddresses();
                for (Map.Entry<NetworkInterface, List<InetAddress>> entry : newInterfaces.entrySet())
                {
                    if (!knownInterfaces.containsKey(entry.getKey()))
                    {
                        knownInterfaces.put(entry.getKey(), entry.getValue());
                        listenerProcessor.interfaceAdded(entry.getKey(), entry.getValue());
                    } else
                    {
                        List<InetAddress> knownAddresses = knownInterfaces.get(entry.getKey());
                        if (knownAddresses != null && !knownAddresses.isEmpty() && entry.getValue() != null && !entry.getValue().isEmpty())
                        {
                            List<InetAddress> newAddresses = new ArrayList<InetAddress>();
                            for (InetAddress newAddress : entry.getValue())
                            {
                                if (!knownAddresses.contains(newAddress))
                                {
                                    newAddresses.add(newAddress);
                                    listenerProcessor.addressAdded(entry.getKey(), newAddress);
                                }
                            }
                            knownAddresses.addAll(newAddresses);
                        }
                    }
                }
                
                for (Map.Entry<NetworkInterface, List<InetAddress>> entry : knownInterfaces.entrySet())
                {
                    if (!newInterfaces.containsKey(entry.getKey()))
                    {
                        knownInterfaces.remove(entry.getKey());
                        listenerProcessor.interfaceRemoved(entry.getKey(), entry.getValue());
                    } else
                    {
                        List<InetAddress> knownAddresses = entry.getValue();
                        List<InetAddress> newAddresses = newInterfaces.get(entry.getKey());
                        if (newAddresses != null && !newAddresses.isEmpty() && entry.getValue() != null && !entry.getValue().isEmpty())
                        {
                            List<InetAddress> removedAddresses = new ArrayList<InetAddress>();
                            for (InetAddress knownAddress : entry.getValue())
                            {
                                if (!newAddresses.contains(knownAddress))
                                {
                                    removedAddresses.add(knownAddress);
                                    listenerProcessor.addressRemoved(entry.getKey(), knownAddress);
                                }
                            }
                            knownAddresses.removeAll(removedAddresses);
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

    private Set<String> hostnames = new HashSet<>();
    
    
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
        
        hostnames = determineHostNames();
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
    public Set<String> getHostNames()
    {
        return hostnames;
    }


    @Override
    public String lookupName(InetAddress address)
    {
        if (address.isLoopbackAddress())
        {
            try
            {
                return InetAddress.getLocalHost().getCanonicalHostName();
            } catch (UnknownHostException e)
            {
                // ignore
            }
        } else
        {
            return address.getCanonicalHostName();
        }
        
        return address.getHostAddress();
    }
}