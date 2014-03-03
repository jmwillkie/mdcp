package net.posick.net;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.List;
import java.util.Map;

public interface NetworkTopologyDiscoveryService
{
    public void registerNetworkTopologyListener(NetworkTopologyListener listener);
    
    
    public void unregisterNetworkTopologyListener(NetworkTopologyListener listener);
    
    
    /**
     * Lists all of the Local Network Interfaces and Internet Addresses matching the virtual, local and up specifications for the service.
     * 
     * @return Returns a list of all of the Internet Address for the local host in the order presented by the system.
     * @throws SocketException if an I/O error occurs
     */
    public Map<NetworkInterface, List<InetAddress>> listAddresses()
    throws SocketException;
    
    
    public int getNetworkPrefixLength(InetAddress address);
    
    
    public boolean isMonitoringSiteLocal();


    public boolean isMonitoringVirtual();


    public boolean isMonitoringLoopback();
    
    
    public void start();
    
    
    public void stop();
}
