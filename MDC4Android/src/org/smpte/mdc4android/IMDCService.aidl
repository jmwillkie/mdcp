package org.smpte.mdc4android;

import android.content.Intent;
import android.os.Bundle;
import org.smpte.mdc4android.mdcf.Capability;
//import org.smpte.mdc4android.mdcf.Map;

/**
 * The MDCService Service  
 */
interface IMDCService
{
    /*
    String getRN();
    
    
    String getUDN();
    
    
    boolean isOnline();
    

    String getName();
    
    
    String[] getURLs();
    
    
    Capability[] getCapabilities();
    
    
    org.smpte.mdc4android.mdcf.Map getAttributes();
    */
    
    
    String getHostname();
    
    
    void setHostname(in String hostname);
    
    
    String[] getDefaultBrowseDomains();
    

    String[] getBrowseDomains();
    

    String[] getDefaultRegistrationDomains();
    

    String[] getRegistrationDomains();
    
    
    Intent browse(in String[] ucns, in String[] domains, in Intent intent);
    
    
    String stopBrowse(in Intent intent);
    
    
    Capability register(in String path, in String domain, inout Capability capability, in Map actionIntentMap);
    

    void unregister(in Capability capability);
}