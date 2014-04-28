package org.smpte.mdc4android;

import android.app.Application;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.Log;

public class MDC4Android extends Application
{
    public static final String LOG_TAG = MDC4Android.class.getName();
    
    
    @Override
    public void onCreate()
    {
        Log.i(LOG_TAG, getClass().getSimpleName() + ".onCreate()");
        super.onCreate();
        
        Intent mdcpServiceIntent = new Intent(this, MDCService.class);
        startService(mdcpServiceIntent);
    }
    
    
    @Override
    public void onTerminate()
    {
        Log.i(LOG_TAG, getClass().getSimpleName() + ".onTerminate()");
        super.onTerminate();
        
        Intent mdcpServiceIntent = new Intent(this, MDCService.class);
        stopService(mdcpServiceIntent);
    }
    
    
    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        Log.i(LOG_TAG, getClass().getSimpleName() + ".onConfigurationChanged()");
        super.onConfigurationChanged(newConfig);
    }
    
    
    @Override
    public void onLowMemory()
    {
        Log.i(LOG_TAG, getClass().getSimpleName() + ".onLowMemory()");
        super.onLowMemory();
    }
}
