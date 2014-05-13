package org.smpte.mdc4android;

import android.content.Intent;
import android.os.Bundle;
import org.smpte.mdc4android.mdcf.Capability;

/**
 * The MDCService Service  
 */
interface IMDCService
{
    String getHostname();
    
    
    void setHostname(in String hostname);
    
    
    String[] getDefaultBrowseDomains();
    

    String[] getBrowseDomains();
    

    String[] getDefaultRegistrationDomains();
    

    String[] getRegistrationDomains();
    
    
    Intent browse(in Intent intent, in String[] domains);
    
    
    boolean stopBrowse(in Intent intent);
    
    
    boolean register(inout Capability capability, in String domain, in String path, in Map actionIntentMap);
    

    Capability unregister(in String ucn, in String domain);
}
