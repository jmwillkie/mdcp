package net.posick.mdcdeviceviewer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.ClientProtocolException;
import org.smpte.mdc4android.IMDCService;
import org.smpte.mdc4android.MDCService;
import org.smpte.mdc4android.TwoKeyedMap;
import org.smpte.mdc4android.net.NetworkUtils;
import org.xbill.DNS.Options;
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

    static final int DEFAULT_SCHEDULED_THREAD_PRIORITY = Thread.NORM_PRIORITY;
    
    static final int CORE_THREADS_SCHEDULED_EXECUTOR = 1;

    static final int MAX_THREADS_SCHEDULED_EXECUTOR = Integer.MAX_VALUE;
    
    static final int TTL_THREADS_SCHEDULED_EXECUTOR = 10000;
    
    static final TimeUnit THREAD_TTL_TIME_UNIT = TimeUnit.MILLISECONDS;
    
    
    private IMDCService mdcService;
    
    private LocalBroadcastManager localBroadcaster;
    
    private IntentFilter serviceDiscoveredFilter = null;
    
    private IntentFilter serviceRemovedFilter = null;
    
    private Map<ServiceName, ServiceInstance> cache = new LinkedHashMap<ServiceName, ServiceInstance>();

    private Map<ServiceName, TwoKeyedMap<String, String, Object>> deviceAttrs = new HashMap<ServiceName, TwoKeyedMap<String, String, Object>>();

    private ScheduledThreadPoolExecutor scheduledExecutor;
    
    
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
            final ServiceInstance service = (ServiceInstance) intent.getSerializableExtra(MDCService.EXTRA_SERVICE);
            if (MDCService.ACTION_SERVICE_DISCOVERED.equals(intent.getAction()))
            {
                Log.i(LOG_TAG, "-----> Service Discovered <-----\n" + service);
                cache.put(service.getName(), service);
                scheduledExecutor.schedule(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        synchronized (deviceAttrs)
                        {
                            try
                            {
                                deviceAttrs.put(service.getName(), WebServiceUtil.callDeviceWebService(resolveNames(WebServiceUtil.toURLs(service))));
                            } catch (ClientProtocolException e)
                            {
                                Log.w(LOG_TAG, "Could not execute Device Web Services.", e);
                            } catch (IOException e)
                            {
                                Log.w(LOG_TAG, "Could not execute Device Web Services.", e);
                            }
                        }
                    }
                }, 1, TimeUnit.SECONDS);
                serviceDiscovered(service);
            } else if (MDCService.ACTION_SERVICE_REMOVED.equals(intent.getAction()))
            {
                Log.i(LOG_TAG, "-----> Service Removed <-----\n" + service);
                cache.remove(service.getName());
                deviceAttrs.remove(service.getName());
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


        @Override
        public void onServiceDisconnected(ComponentName name)
        {
            mdcService = null;
        }
    };

    private Runnable deviceInterogator = new Runnable()
    {
        @Override
        public void run()
        {
            // TODO Auto-generated method stub
            for (ServiceInstance service : cache.values())
            {
                synchronized (deviceAttrs)
                {
                    if (!deviceAttrs.containsKey(service.getName()))
                    {
                        try
                        {
                            deviceAttrs.put(service.getName(), WebServiceUtil.callDeviceWebService(resolveNames(WebServiceUtil.toURLs(service))));
                        } catch (ClientProtocolException e)
                        {
                            Log.w(LOG_TAG, "Could not execute Device Web Services.", e);
                        } catch (IOException e)
                        {
                            Log.w(LOG_TAG, "Could not execute Device Web Services.", e);
                        }
                    }
                }
            }
        }
    };

    private ThreadFactory scheduleThreadFactory = new ThreadFactory()
    {
        public Thread newThread(Runnable r)
        {
            Thread t = new Thread(r, "mDNS Scheduled Thread");
            t.setDaemon(true);
            
            int threadPriority = DEFAULT_SCHEDULED_THREAD_PRIORITY;
            try
            {
                String value = Options.value("mdns_scheduled_thread_priority");
                if (value == null || value.length() == 0)
                {
                    value = Options.value("mdns_thread_priority");
                }
                if (value != null && value.length() == 0)
                {
                    threadPriority = Integer.parseInt(value);
                }
            } catch (Exception e)
            {
                // ignore
            }
            t.setPriority(threadPriority);
            t.setContextClassLoader(this.getClass().getClassLoader());
            return t;
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
        
        System.setProperty("sun.net.spi.nameservice.provider.1", "mdns,dns,sun");
        
        scheduledExecutor = (ScheduledThreadPoolExecutor) java.util.concurrent.Executors.newScheduledThreadPool(CORE_THREADS_SCHEDULED_EXECUTOR, scheduleThreadFactory );
        scheduledExecutor.setCorePoolSize(CORE_THREADS_SCHEDULED_EXECUTOR);
        scheduledExecutor.setMaximumPoolSize(MAX_THREADS_SCHEDULED_EXECUTOR);
        scheduledExecutor.setKeepAliveTime(TTL_THREADS_SCHEDULED_EXECUTOR, THREAD_TTL_TIME_UNIT);
        scheduledExecutor.allowCoreThreadTimeOut(true);
        
        scheduledExecutor.scheduleWithFixedDelay(deviceInterogator, 5, 5, TimeUnit.SECONDS);
        
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
            Intent mdcpServiceIntent = new Intent(this, MDCService.class);
            startService(mdcpServiceIntent);
            
            Intent startIntent = new Intent(createPackageContext("org.smpte.mdc4android", 0), MDCService.class);
            startService(startIntent);
            if (mdcService == null)
            {
                if (!bindService(startIntent, mdcServiceConnection, Context.BIND_IMPORTANT | Context.BIND_ABOVE_CLIENT))
                {
                    Log.e(LOG_TAG, "Could NOT bind to service \"" + MDCService.class.getName() + "\". Program \"org.smpte.mdc4android\" is required!");
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=org.smpte.mdc4android"));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                    startActivity(intent);
                    return;
                }
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
        scheduledExecutor.shutdownNow();
        scheduledExecutor = null;
        
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

    
    protected List<String> resolveNames(List<String> urls)
    {
        List<String> newURLs = new ArrayList<String>();
        
        if (urls != null && urls.size() > 0)
        {
            for (String url : urls)
            {
                if (mdcService != null)
                {
                    try
                    {
                        String hostname = NetworkUtils.extractHostname(url);
                        String[] addresses = mdcService.resolveAddresses(hostname);
                        if (addresses != null && addresses.length > 0)
                        {
                            for (String address : addresses)
                            {
                                newURLs.add(NetworkUtils.replaceHostname(url, address));
                            }
                        }
                    } catch (Exception e)
                    {
                        Log.e(LOG_TAG, "Could not resolve hostname for URL \"" + url + "\"!", e);
                    }
                }
            }
        }
        
        return newURLs;
    }
}
