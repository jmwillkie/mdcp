package org.smpte.st2071.mdcd;

import java.net.InetAddress;
import java.net.NetworkInterface;

import org.smpte.st2071.types.Resource;

/**
 * The Discovery Listener is used to notify Discovery clients of changes to the Network Topology 
 * and when new Browse Domains or Naming Services and Resources are found.
 * 
 * @author Steve Posick
 */
public interface DiscoveryListener
{
    public static enum DomainType
    {
        BROWSE, REGISTRATION;
    }
    
    public void addressAdded(final NetworkInterface networkInterface, final InetAddress address);
    
    
    public void addressRemoved(final NetworkInterface networkInterface, final InetAddress address);
    
    
    public void domainAdded(final DomainType type, final String domain);
    
    
    public void domainRemoved(final DomainType type, final String domain);
    
    
    public void resourceAdded(final String domain, final Resource resource);
    
    
    public void resourceRemoved(final String domain, final Resource resource);
}
