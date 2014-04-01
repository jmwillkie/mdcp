package org.smpte.st2071.mdcp;

import android.content.Intent;

/**
 * The MDCP Server Service  
 */
interface IMDCPService
{
    boolean isOnline();
    
    
    Intent lookup(String pattern, String action);
    
    
    Intent register(String pattern, String action, in Intent intent);
    
    
    Intent unregister(String pattern, String action);
}