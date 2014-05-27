package net.posick.mdcdeviceviewer;

import java.util.LinkedHashMap;
import java.util.Map;

import org.smpte.mdc4android.IMDCService;
import org.smpte.mdc4android.MDCService;
import org.xbill.mDNS.ServiceInstance;
import org.xbill.mDNS.ServiceName;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

public class MDCDeviceViewerService extends Service
{
    protected static final String LOG_TAG = MDCDeviceViewer.LOG_TAG;

    public static final String SERVICE_DISCOVERED = "net.posick.mdcdeviceviewer.SERVICE_DISCOVERED";

    public static final String SERVICE_REMOVED = "net.posick.mdcdeviceviewer.SERVICE_REMOVED";

    public static final String EXTRA_SERVICE = "net.posick.mdcdeviceviewer.SERVICE";
    
    
    private IMDCService mdcService;
    
    private LocalBroadcastManager localBroadcaster;
    
    private IntentFilter serviceDiscoveredFilter = null;
    
    private IntentFilter serviceRemovedFilter = null;
    
    private Map<ServiceName, ServiceInstance> cache = new LinkedHashMap<ServiceName, ServiceInstance>();
    
    
    // Binder given to clients
    private final IBinder mBinder = new MDCDeviceViewerServiceBinder();
    
    /**
     * Class used for the client Binder. Because we know this service always
     * runs in the same process as its clients, we don't need to deal with IPC.
     */
    public class MDCDeviceViewerServiceBinder extends Binder
    {
        public MDCDeviceViewerService getService()
        {
            // Return this instance of LocalService so clients can call public methods
            return MDCDeviceViewerService.this;
        }
    }
    
    private BroadcastReceiver browseReceiver = new BroadcastReceiver()
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            Log.i(LOG_TAG, getClass().getName() + ".onReceive(" + context +", " + intent + ")");
            ServiceInstance service = (ServiceInstance) intent.getSerializableExtra(MDCService.EXTRA_SERVICE);
            if (MDCService.ACTION_SERVICE_DISCOVERED.equals(intent.getAction()))
            {
                Log.i(LOG_TAG, "-----> Service Discovered <-----\n" + service);
                cache.put(service.getName(), service);
                serviceDiscovered(service);
            } else if (MDCService.ACTION_SERVICE_REMOVED.equals(intent.getAction()))
            {
                Log.i(LOG_TAG, "-----> Service Removed <-----\n" + service);
                cache.remove(service.getName());
                serviceRemoved(service);
            }
        }
    };
    
    
    private ServiceConnection mdcServiceConnection = new ServiceConnection()
    {
        @Override
        public void onServiceConnected(ComponentName className, IBinder binder)
        {
            Log.i(LOG_TAG, getClass().getSimpleName() + ".onServiceConnected(\"" + className.flattenToString() + "\", " + binder + ")");
            
            if (mdcService == null)
            {
                mdcService = IMDCService.Stub.asInterface(binder);
                new Thread(new Runnable()
                {
                    public void run()
                    {
                        try
                        {
                            mdcService.query(null, (String[]) null);
                        } catch (RemoteException e)
                        {
                            String message = "Error Starting Service Discovery Browse - " + e.getMessage();
                            Log.e(LOG_TAG, message, e);
                        }
                    }
                }).start();
            }
        }


        @Override
        public void onServiceDisconnected(ComponentName name)
        {
            if (mdcService != null)
            {
                /*
                try
                {
                    mdcService.stopBrowse(browseIntent);
                } catch (RemoteException e)
                {
                    String message = "Error Stopping Service Discovery Browse - " + e.getMessage();
                    Log.e(LOG_TAG, message, e);
                }
                */
                mdcService = null;
            }
        }
    };
    
    
    private IntentFilter initFilter(String action)
    {
        IntentFilter filter = new IntentFilter();
        filter.addAction(action);
        filter.addCategory(MDCService.CATEGORY_SERVICE_DISCOVERY);
        filter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY);
        return filter;
    }


    protected void serviceDiscovered(ServiceInstance service)
    {
        if (localBroadcaster != null)
        {
            Intent intent = new Intent(SERVICE_DISCOVERED);
            intent.putExtra(EXTRA_SERVICE, service);
            localBroadcaster.sendBroadcast(intent);
        }
    }


    protected void serviceRemoved(ServiceInstance service)
    {
        if (localBroadcaster != null)
        {
            Intent intent = new Intent(SERVICE_REMOVED);
            intent.putExtra(EXTRA_SERVICE, service);
            localBroadcaster.sendBroadcast(intent);
        }
    }
    
    
    @Override
    public IBinder onBind(Intent intent)
    {
        Log.i(LOG_TAG, getClass().getSimpleName() + ".onBind()");
        return mBinder;
    }
    
    
    @Override
    public void onCreate()
    {
        super.onCreate();
        
        localBroadcaster = LocalBroadcastManager.getInstance(getApplicationContext());
        
        if (serviceDiscoveredFilter == null)
        {
            try
            {
                serviceDiscoveredFilter = initFilter(MDCService.ACTION_SERVICE_DISCOVERED);
                Intent result = registerReceiver(browseReceiver, serviceDiscoveredFilter, MDCService.PERMISSION_MDC_SERVICE_DISCOVERY, null);
                if (result != null)
                {
                    browseReceiver.onReceive(this, result);
                }
            } catch (Exception e)
            {
                Log.e(LOG_TAG, "Could not register a broadcast receiver for \"" + serviceDiscoveredFilter + "\" intents.", e);
            }
        }
        
        if (serviceRemovedFilter == null)
        {
            try
            {
                serviceRemovedFilter = initFilter(MDCService.ACTION_SERVICE_REMOVED);
                Intent result = registerReceiver(browseReceiver, serviceRemovedFilter, MDCService.PERMISSION_MDC_SERVICE_DISCOVERY, null);
                if (result != null)
                {
                    browseReceiver.onReceive(this, result);
                }
            } catch (Exception e)
            {
                Log.e(LOG_TAG, "Could not register a broadcast receiver for \"" + serviceRemovedFilter + "\" intents.", e);
            }
        }
        
        try
        {
            Intent startIntent = new Intent(createPackageContext("org.smpte.mdc4android", 0), MDCService.class);
            startService(startIntent);
            if (!bindService(startIntent, mdcServiceConnection, Context.BIND_IMPORTANT | Context.BIND_ABOVE_CLIENT))
            {
                Log.e(LOG_TAG, "Could NOT bind to service \"" + MDCService.class.getName() + "\". Program \"org.smpte.mdc4android\" is required!");
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=org.smpte.mdc4android"));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                startActivity(intent);
                return;
            }
        } catch (Exception e)
        {
            Log.e(LOG_TAG, e.getMessage(), e);
        }
    }
    

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        return super.onStartCommand(intent, flags, startId);
    }
    

    @Override
    public void onDestroy()
    {
        if (mdcService != null)
        {
            unbindService(mdcServiceConnection);
        }
        
        if (serviceDiscoveredFilter != null || serviceRemovedFilter != null)
        {
            unregisterReceiver(browseReceiver);
            serviceRemovedFilter = serviceDiscoveredFilter = null;
        }
        
        super.onDestroy();
    }


    public void refresh()
    {
        for (Map.Entry<ServiceName, ServiceInstance> entry : cache.entrySet())
        {
            serviceDiscovered(entry.getValue());
        }
    }
}
