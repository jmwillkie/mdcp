package org.smpte.st2071.mdcd.net;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.List;

/**
 * A NetworkTopologyListener is registered with the NetworkTopologyDicovery
 * 
 * @author Steve Posick
 */
public interface NetworkTopologyListener
{
    public void interfaceAdded(NetworkInterface networkInterface, List<InetAddress> addresses);
    
    
    public void interfaceRemoved(NetworkInterface networkInterface, List<InetAddress> addresses);
    
    
    public void addressAdded(NetworkInterface networkInterface, InetAddress address);
    
    
    public void addressRemoved(NetworkInterface networkInterface, InetAddress address);
}
