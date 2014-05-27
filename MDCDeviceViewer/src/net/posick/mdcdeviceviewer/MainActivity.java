package net.posick.mdcdeviceviewer;

import net.posick.mdcdeviceviewer.MDCDeviceViewerService.MDCDeviceViewerServiceBinder;

import org.smpte.mdc4android.MDCService;
import org.xbill.mDNS.ServiceInstance;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
//import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.Menu;
import android.widget.ExpandableListView;
import android.widget.Toast;

public class MainActivity extends Activity
{
    protected static final String LOG_TAG = MDCDeviceViewer.LOG_TAG;

    public static final String SERVICE_PREFIX = "SERVICE_";
    
    
    protected static class ServiceDiscoveryBroadcastReceiver extends BroadcastReceiver
    {
        private DeviceExpandableListAdapter deviceListAdapter;
        
        
        protected ServiceDiscoveryBroadcastReceiver(DeviceExpandableListAdapter deviceListAdapter)
        {
            this.deviceListAdapter = deviceListAdapter;
        }
        
        
        @Override
        public void onReceive(Context context, Intent intent)
        {
            ServiceInstance service = (ServiceInstance) intent.getSerializableExtra(MDCDeviceViewerService.EXTRA_SERVICE);
            
            if (MDCDeviceViewerService.SERVICE_DISCOVERED.equals(intent.getAction()))
            {
                Log.i(LOG_TAG, "-----> Service \"" + (service != null ? service.getName() : "<null>") + "\" DISCOVERED <-----");
                deviceListAdapter.addService(service);
                deviceListAdapter.notifyDataSetChanged();
            } else if (MDCDeviceViewerService.SERVICE_REMOVED.equals(intent.getAction()))
            {
                Log.i(LOG_TAG, "-----> Service \"" + (service != null ? service.getName() : "<null>") + "\" REMOVED <-----");
                deviceListAdapter.removeService(service);
                deviceListAdapter.notifyDataSetChanged();
            }
        }
    };
    
    
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
                deviceListAdapter.addService(service);
                deviceListAdapter.notifyDataSetChanged();
            } else if (MDCService.ACTION_SERVICE_REMOVED.equals(intent.getAction()))
            {
                Log.i(LOG_TAG, "-----> Service Removed <-----\n" + service);
                deviceListAdapter.removeService(service);
                deviceListAdapter.notifyDataSetChanged();
            }
        }
    };
    
    private ExpandableListView deviceList = null;
    
    private DeviceExpandableListAdapter deviceListAdapter = new DeviceExpandableListAdapter(this, null);

//    private LocalBroadcastManager localBroadcaster;
    
    private MDCDeviceViewerService mdcDeviceViewerService = null;
    
//    private BroadcastReceiver discoveryReceiver = new ServiceDiscoveryBroadcastReceiver(deviceListAdapter);
    
    private IntentFilter serviceDiscoveredFilter = null;
    
    private IntentFilter serviceRemovedFilter = null;
    
    private ServiceConnection serviceConnection = new ServiceConnection()
    {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service)
        {
            initializeBroadcastReceiver();
            mdcDeviceViewerService = ((MDCDeviceViewerServiceBinder) service).getService();
            mdcDeviceViewerService.refresh();
        }

        @Override
        public void onServiceDisconnected(ComponentName name)
        {
            teardownBroadcastReceiver();
            mdcDeviceViewerService = null;
        }
    };

    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Log.i(LOG_TAG, getClass().getName() + ".onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        deviceList = (ExpandableListView) findViewById(R.id.deviceList);
        deviceList.setAdapter(deviceListAdapter);
        
        /*
        localBroadcaster = LocalBroadcastManager.getInstance(getApplicationContext());
        localBroadcaster.registerReceiver(discoveryReceiver, new IntentFilter(MDCDeviceViewerService.SERVICE_DISCOVERED));
        localBroadcaster.registerReceiver(discoveryReceiver, new IntentFilter(MDCDeviceViewerService.SERVICE_REMOVED));
        */
        
        if (!bindService(new Intent(this, MDCDeviceViewerService.class), serviceConnection, Context.BIND_AUTO_CREATE | Context.BIND_IMPORTANT | Context.BIND_NOT_FOREGROUND | Context.BIND_ABOVE_CLIENT))
        {
            Log.e(LOG_TAG, "-----> Could NOT bind to MDC Device Veiwer Service using local Intent \"" + MDCService.class.getName() + "\" <-----");
            Toast.makeText(getApplicationContext(), "Could NOT bind to MDC Device Veiwer Service using local Intent \"" + MDCService.class.getName() + "\"", Toast.LENGTH_LONG).show();
            finish();
        }
    }
    
    
    private IntentFilter initFilter(String action)
    {
        IntentFilter filter = new IntentFilter();
        filter.addAction(action);
        filter.addCategory(MDCService.CATEGORY_SERVICE_DISCOVERY);
        filter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY);
        return filter;
    }
    
    
    private void initializeBroadcastReceiver()
    {
        if (serviceDiscoveredFilter == null)
        {
            serviceDiscoveredFilter = initFilter(MDCService.ACTION_SERVICE_DISCOVERED);
            Intent result = registerReceiver(browseReceiver, serviceDiscoveredFilter, MDCService.PERMISSION_MDC_SERVICE_DISCOVERY, null);
            if (result != null)
            {
                browseReceiver.onReceive(this, result);
            }
        }
        
        if (serviceRemovedFilter == null)
        {
            serviceRemovedFilter = initFilter(MDCService.ACTION_SERVICE_REMOVED);
            Intent result = registerReceiver(browseReceiver, serviceRemovedFilter, MDCService.PERMISSION_MDC_SERVICE_DISCOVERY, null);
            if (result != null)
            {
                browseReceiver.onReceive(this, result);
            }
        }
    }
    
    
    private void teardownBroadcastReceiver()
    {
        if (serviceDiscoveredFilter != null || serviceRemovedFilter != null)
        {
            unregisterReceiver(browseReceiver);
            serviceRemovedFilter = serviceDiscoveredFilter = null;
        }
    }


    @Override
    public boolean onSearchRequested()
    {
        return super.onSearchRequested();
    }
    
    
    @Override
    protected void onResume()
    {
        Log.i(LOG_TAG, getClass().getName() + ".onResume()");
        super.onResume();
        /*
        localBroadcaster.registerReceiver(discoveryReceiver, new IntentFilter(MDCDeviceViewerService.SERVICE_DISCOVERED));
        localBroadcaster.registerReceiver(discoveryReceiver, new IntentFilter(MDCDeviceViewerService.SERVICE_REMOVED));
        */
        if (!bindService(new Intent(this, MDCDeviceViewerService.class), serviceConnection, Context.BIND_AUTO_CREATE | Context.BIND_IMPORTANT | Context.BIND_NOT_FOREGROUND | Context.BIND_ABOVE_CLIENT))
        {
            Log.e(LOG_TAG, "-----> Could NOT bind to MDC Device Veiwer Service using local Intent \"" + MDCService.class.getName() + "\" <-----");
            Toast.makeText(getApplicationContext(), "Could NOT bind to MDC Device Veiwer Service using local Intent \"" + MDCService.class.getName() + "\"", Toast.LENGTH_LONG).show();
            finish();
        }
    }


    @Override
    protected void onPause()
    {
        Log.i(LOG_TAG, getClass().getName() + ".onResume()");
//        localBroadcaster.unregisterReceiver(discoveryReceiver);
        super.onPause();
        if (mdcDeviceViewerService != null)
        {
            unbindService(serviceConnection);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        Log.i(LOG_TAG, getClass().getName() + ".onCreateOptions()");
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    protected void onDestroy()
    {
        Log.i(LOG_TAG, getClass().getName() + ".onDestroy()");
//        localBroadcaster.unregisterReceiver(discoveryReceiver);
        super.onDestroy();
        if (mdcDeviceViewerService != null)
        {
            unbindService(serviceConnection);
        }
    }
}
