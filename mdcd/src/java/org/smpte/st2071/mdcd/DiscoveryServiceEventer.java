package org.smpte.st2071.mdcd;

public interface DiscoveryServiceEventer
{
    /**
     * Registers a Discovery Listener
     * 
     * @param listener The Discovery Listener
     */
    public void registerDiscoveryListener(DiscoveryListener listener);
    
    
    /**
     * Unregisters a Discovery Listener
     * 
     * @param listener The Discovery Listener
     */
    public void unregisterDiscoveryListener(DiscoveryListener listener);
}
