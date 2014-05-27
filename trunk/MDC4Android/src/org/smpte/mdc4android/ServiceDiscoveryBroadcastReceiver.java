package org.smpte.mdc4android;

import org.xbill.mDNS.ServiceInstance;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;

public class ServiceDiscoveryBroadcastReceiver extends BroadcastReceiver
{
    protected static final String LOG_TAG = MDC4Android.LOG_TAG + "." + ServiceDiscoveryBroadcastReceiver.class.getSimpleName();
    
    @Override
    public void onReceive(Context context, Intent intent)
    {
        Log.i(LOG_TAG, getClass().getName() + ".onReceive(" + context +", " + intent + ")");
        
        ServiceInstance service = (ServiceInstance) intent.getSerializableExtra(MDCService.EXTRA_SERVICE);
        boolean discovered = intent.getBooleanExtra(MDCService.EXTRA_SERVICE_DISCOVERED, false);
        
        try
        {
            Intent startIntent = new Intent(context.createPackageContext("org.smpte.mdc4android", 0), MDCService.class);
            context.startService(startIntent);
        } catch (NameNotFoundException e)
        {
            Log.e(LOG_TAG, "-----> Error starting Service \"" + MDCService.class.getName() + "\" - " + e.getMessage() + " <-----\n" + service, e);
        }
        
        if (discovered)
        {
            Log.i(LOG_TAG, "-----> Service Discovered <-----\n" + service);
        } else
        {
            Log.i(LOG_TAG, "-----> Service Removed <-----\n" + service);
        }
    }
}
