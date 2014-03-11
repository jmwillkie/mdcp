package org.smpte.st2071.mdcd.android;

import android.app.Application;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.Log;

public class MDCDForAndroid extends Application
{
    
    public MDCDForAndroid()
    {
        super();
    }
    
    
    @Override
    public void onCreate()
    {
        Log.i(Constants.LOG_TAG, getClass().getSimpleName() + ".onCreate()");
        super.onCreate();
        
        Intent serviceIntent = new Intent(this, MDCDService.class);
        startService(serviceIntent);
    }
    
    
    @Override
    public void onTerminate()
    {
        Log.i(Constants.LOG_TAG, getClass().getSimpleName() + ".onTerminate()");
        super.onTerminate();
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
