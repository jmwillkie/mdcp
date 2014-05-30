package net.posick.mdcdeviceviewer;

import android.app.Application;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.Log;

public class MDCDeviceViewer extends Application
{
    public static final String LOG_TAG = MDCDeviceViewer.class.getName();
    
    
    @Override
    public void onCreate()
    {
        Log.i(LOG_TAG, getClass().getSimpleName() + ".onCreate()");
        super.onCreate();
        
        Intent intent = new Intent(this, MDCDeviceViewerService.class);
        startService(intent);
    }
    
    
    @Override
    public void onTerminate()
    {
        Log.i(LOG_TAG, getClass().getSimpleName() + ".onTerminate()");
        super.onTerminate();
        
        Intent intent = new Intent(this, MDCDeviceViewerService.class);
        stopService(intent);
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
