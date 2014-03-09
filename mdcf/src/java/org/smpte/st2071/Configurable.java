package org.smpte.st2071;

import java.util.Map;

public interface Configurable
{
    /**
     * Sets the configuration for the Discovery Service.
     * 
     * @param properties The configuration map
     */
    public void setConfiguration(Map<String, String> properties);
    
    
    /**
     * Gets the configuration for the Discovery Service.
     * 
     * @return The configuration map
     */
    public Map<String, String> getConfiguration();
}
