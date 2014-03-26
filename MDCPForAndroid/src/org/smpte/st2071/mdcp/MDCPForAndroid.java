package org.smpte.st2071.mdcp;

import android.app.Application;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.Log;

public class MDCPForAndroid extends Application
{
    public static final String LOG_TAG = MDCPForAndroid.class.getName();
    
    
    public MDCPForAndroid()
    {
        super();
    }
    
    
    @Override
    public void onCreate()
    {
        Log.i(Constants.LOG_TAG, getClass().getSimpleName() + ".onCreate()");
        super.onCreate();
        
        Intent mdcpServiceIntent = new Intent(this, MDCPService.class);
        startService(mdcpServiceIntent);
    }
    
    
    @Override
    public void onTerminate()
    {
        Log.i(Constants.LOG_TAG, getClass().getSimpleName() + ".onTerminate()");
        super.onTerminate();
        
        Intent mdcpServiceIntent = new Intent(this, MDCPService.class);
        stopService(mdcpServiceIntent);
    }
    
    
    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        Log.i(Constants.LOG_TAG, getClass().getSimpleName() + ".onConfigurationChanged()");
        super.onConfigurationChanged(newConfig);
    }
    
    
    @Override
    public void onLowMemory()
    {
        Log.i(Constants.LOG_TAG, getClass().getSimpleName() + ".onLowMemory()");
        super.onLowMemory();
    }
}
