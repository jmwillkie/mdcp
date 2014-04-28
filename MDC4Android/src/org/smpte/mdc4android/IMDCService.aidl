package org.smpte.mdc4android;

import android.content.Intent;
import android.os.Bundle;
import org.smpte.mdc4android.mdcf.Capability;

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
    
    
    Bundle getAttributes();
    */
    
    
    String getHostname();
    
    
    void setHostname(in String hostname);
    
    
    String[] getDefaultBrowseDomains();
    

    String[] getBrowseDomains();
    

    String[] getDefaultRegistrationDomains();
    

    String[] getRegistrationDomains();
    
    
    Intent browse(in String[] ucns, in String[] domains, in Intent intent);
    
    
    String stopBrowse(in Intent intent);
    
    
    String register(in String ucn, in String path, in String action, in String domain, in Intent intent);
    

    void unregister(in String serviceName);
}