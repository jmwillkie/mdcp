package org.smpte.mdc4android;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import net.posick.ws.soap.ISOAPServerService;
import net.posick.ws.soap.SOAPServerService;
import net.posick.ws.xml.Namespace;
import net.posick.ws.xml.XmlElement;

import org.smpte.mdc4android.mdcf.Capability;
import org.smpte.mdc4android.mdcf.Map;
import org.smpte.mdc4android.net.DeviceInfo;
import org.smpte.mdc4android.net.NetworkUtils;
import org.smpte.mdc4android.xml.XmlUtils;
import org.xbill.DNS.Message;
import org.xbill.DNS.Name;
import org.xbill.DNS.Record;
import org.xbill.DNS.Resolver;
import org.xbill.DNS.SimpleResolver;
import org.xbill.DNS.TextParseException;
import org.xbill.DNS.Type;
import org.xbill.mDNS.Browse;
import org.xbill.mDNS.DNSSDListener;
import org.xbill.mDNS.Lookup;
import org.xbill.mDNS.Lookup.Domain;
import org.xbill.mDNS.MulticastDNSQuerier;
import org.xbill.mDNS.MulticastDNSService;
import org.xbill.mDNS.ServiceInstance;
import org.xbill.mDNS.ServiceName;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentFilter.MalformedMimeTypeException;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.RemoteException;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

public class MDCService extends Service implements IMDCService, Device
{
    protected static final String LOG_TAG = MDC4Android.LOG_TAG + "." + MDCService.class.getSimpleName();
    
    protected static final int NOTIFICATION_ID = 20140527;
    
    public static final String MDC_URL_PROTOCOL = "mdcp";

    public static final String ACTION_MDC_NETWORK_INITIALIZED = "org.smpte.mdc4android.SERVICE_NETWORK_INITIALIZED";

    public static final String ACTION_MDC_NETWORK_STOPPED = "org.smpte.mdc4android.SERVICE_NETWORK_STOPPED";
    
    public static final String ACTION_SERVICE_DISCOVERED = "org.smpte.MDC_SERVICE_DISCOVERED";
    
    public static final String ACTION_SERVICE_REMOVED = "org.smpte.MDC_SERVICE_REMOVED";
    
    public static final String CATEGORY_SERVICE_DISCOVERY = "org.smpte.MDC_SERVICE_DISCOVERY";
    
    public static final String EXTRA_CONNECT_TO_NETWORK = "org.smpte.mdc4android.ConnectToNetwork";
    
    public static final String EXTRA_BROWSE_SERVICE_TYPES = "org.smpte.mdc4android.BrowseServiceTypes";
    
    public static final String EXTRA_SERVICE = "org.smpte.mdc4android.Service";
    
    public static final String EXTRA_SERVICE_DISCOVERED = "org.smpte.mdc4android.ServiceDiscovered";
    
    public static final String EXTRA_SERVICE_REMOVED = "org.smpte.mdc4android.ServiceRemoved";
    
    public static final String EXTRA_NETWORK_CONNECTIVITY_CHANGED = "org.smpte.mdc4android.NetworkConnectivityChanged";
    
    public static final String PERMISSION_MDC_SERVICE_DISCOVERY = "org.smpte.mdc4android.SERVICE_DISCOVERY";

    public static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);
    
    
    protected static class RegistrationInformation
    {
        private String path;
        
        private String domain;
        
        private Capability capability;
        
        private java.util.Map<String, Intent> actionIntentMap;
        
        private Set<ServiceInstance> discoverableServices = new LinkedHashSet<ServiceInstance>();
        
        
        protected RegistrationInformation(String path, String domain, Capability capability, java.util.Map<String, Intent> actionIntentMap)
        {
            this.path = path;
            this.domain = domain;
            this.capability = capability;
            this.actionIntentMap = actionIntentMap;
        }
        
        
        public String getPath()
        {
            return path;
        }
        
        
        public String getDomain()
        {
            return domain;
        }
        
        
        public void setDomain(String domain)
        {
            this.domain = domain;
        }
        
        
        public Capability getCapability()
        {
            return capability;
        }
        
        
        public java.util.Map<String, Intent> getActionIntentMap()
        {
            return actionIntentMap;
        }
        
        
        public void addDiscoverableService(ServiceInstance service)
        {
            this.discoverableServices.add(service);
        }
        
        
        public Set<ServiceInstance> getDiscoverableServices()
        {
            return discoverableServices;
        }
    }
    
    
    protected static class BrowseOperation implements DNSSDListener
    {
        private transient Object id;
        
        private transient Intent intent;
        
        private Set<Name> domains;
        
        private MDCService service;
        
        
        protected BrowseOperation(MDCService service, Intent intent, String[] domains)
        {
            this.service = service;
            this.intent = intent;
            intent.addCategory(CATEGORY_SERVICE_DISCOVERY);
            if (domains != null)
            {
                for (String domain : domains)
                {
                    try
                    {
                        addDomain(domain);
                    } catch (Exception e)
                    {
                        Log.e(LOG_TAG, "Error adding domain \".\" to Browse Operation.");
                    }
                }
            } else
            {
                domains = null;
            }
        }
        
        
        public void setId(Object id)
        {
            this.id = id;
        }
        
        
        public Object getId()
        {
            return id;
        }
        
        
        public Intent getIntent()
        {
            return intent;
        }
        
        
        public Set<Name> getDomains()
        {
            return domains;
        }
        
        
        public void addDomain(Name domain)
        {
            if (domain != null)
            {
                if (domains == null)
                {
                    domains = new LinkedHashSet<Name>();
                }
                domains.add(domain);
            }
        }
        
        
        public void addDomain(String domain)
        throws TextParseException
        {
            addDomain(new Name(domain.endsWith(".") ? domain : domain + "."));
        }
        
        
        public boolean matchesDomain(Name name)
        {
            if (domains == null || domains.size() == 0)
            {
                return true;
            } else
            {
                for (Name domain : domains)
                {
                    if (domain.subdomain(name))
                    {
                        return true;
                    }
                }
            }
            return false;
        }
        
        
        @Override
        public void handleException(Object id, Exception e)
        {
            Log.w(LOG_TAG, e.getMessage(), e);
        }
        
        
        @Override
        public void receiveMessage(Object id, Message message)
        {
            Log.i(LOG_TAG, "-----> mDNS Message Received <-----\n" + message);
        }
        
        
        @Override
        public void serviceDiscovered(Object id, ServiceInstance service)
        {
            Log.i(LOG_TAG, "Service Discovered " + service);
            notifyRegistrants(service, true);
        }
        
        
        @Override
        public void serviceRemoved(Object id, ServiceInstance service)
        {
            Log.i(LOG_TAG, "Service Removed " + service);
            notifyRegistrants(service, false);
        }
        
        
        private void notifyRegistrants(ServiceInstance service, boolean discovered)
        {
            if (domains != null)
            {
                for (Name domain : domains)
                {
                    if (service.getName().subdomain(domain))
                    {
                        this.service.broadcastIntent(service, discovered, (Intent) this.intent.clone());
                        break;
                    }
                }
            } else
            {
                this.service.broadcastIntent(service, discovered, (Intent) this.intent.clone());
            }
        }
    }
    
    private final IMDCService.Stub mBinder = new IMDCService.Stub()
    {
        @Override
        public String getHostname()
        throws RemoteException
        {
            return MDCService.this.getHostname();
        }
        
        
        @Override
        public void setHostname(String hostname)
        throws RemoteException
        {
            MDCService.this.setHostname(hostname);
        }
        
        
        @Override
        public String[] getDefaultBrowseDomains()
        throws RemoteException
        {
            return MDCService.this.getDefaultBrowseDomains();
        }
        
        
        @Override
        public String[] getBrowseDomains()
        throws RemoteException
        {
            return MDCService.this.getBrowseDomains();
        }
        
        
        @Override
        public String[] getDefaultRegistrationDomains()
        throws RemoteException
        {
            return MDCService.this.getDefaultRegistrationDomains();
        }
        
        
        @Override
        public String[] getRegistrationDomains()
        throws RemoteException
        {
            return MDCService.this.getRegistrationDomains();
        }
        
        
        @Override
        public void query(String subType, String[] domains)
        throws RemoteException
        {
            MDCService.this.query(subType, domains);
        }
        /*
        @Override
        public Intent browse(Intent intent, String[] domains)
        throws RemoteException
        {
            return MDCService.this.browse(intent, domains);
        }
        
        
        @Override
        public boolean stopBrowse(Intent intent)
        throws RemoteException
        {
            return MDCService.this.stopBrowse(intent);
        }
        */
        
        @Override
        @SuppressWarnings("rawtypes")
        public boolean register(Capability capability, String domain, String path, java.util.Map actionIntentMap)
        throws RemoteException
        {
            return MDCService.this.register(capability, domain, path, actionIntentMap);
        }
        
        
        @Override
        public Capability unregister(String ucn, String domain)
        throws RemoteException
        {
            return MDCService.this.unregister(ucn, domain);
        }
    };
    
    
    private ServiceConnection soapServiceConnection = new ServiceConnection()
    {
        @Override
        public void onServiceConnected(ComponentName className, IBinder binder)
        {
            Log.i(LOG_TAG, getClass().getSimpleName() + ".onServiceConnected(\"" + className.flattenToString() + "\", " + binder + ")");
            
            soapService = ISOAPServerService.Stub.asInterface(binder);
            
            try
            {
                while (!soapService.isOnline())
                {
                    try
                    {
                        Thread.sleep(10);
                    } catch (InterruptedException e)
                    {
                        // ignore
                    }
                }
                
                if (networkStarted)
                {
                    registerCapabilities();
                }
            } catch (Exception e)
            {
                Log.e(LOG_TAG, "Error registering Web Service Endpoints - " + e.getMessage(), e);
            }
        }
        
        
        @Override
        public void onServiceDisconnected(ComponentName className)
        {
            Log.i(LOG_TAG, getClass().getSimpleName() + ".onServiceDisconnected(\"" + className.flattenToString() + "\")");
            
            if (networkStarted)
            {
                unregisterCapabilities();
            }
            soapService = null;
        }
    };
    
    protected ISOAPServerService soapService;
    
    protected boolean networkStarted = false;

    protected boolean startingNetwork = false;
    
    protected DeviceInfo deviceInfo = null;
    
    protected MulticastDNSQuerier querier = null;
    
    protected MulticastDNSService service;
    
    protected String udn;
    
    protected String name;
    
    protected Set<String> urls = new LinkedHashSet<String>();
    
    protected Set<Capability> capabilities = new LinkedHashSet<Capability>();
    
    protected LocalBroadcastManager localBroadcaster;
    
    protected TwoKeyedMap<String, String, RegistrationInformation> registeredCapabilities = new TwoKeyedMap<String, String, RegistrationInformation>();
    
    protected Capability deviceCapability = new Capability();
    
    protected java.util.Map<String, Intent> actionIntentMap;
    
    protected java.util.Map<Intent, BrowseOperation> browseIntents = new LinkedHashMap<Intent, BrowseOperation>();
    
    protected Intent browseIntent;

    protected ThreadFactory serviceThreadFactory = new ThreadFactory()
    {
        @Override
        public Thread newThread(Runnable r)
        {
            Thread t = new Thread(r, MDCService.class.getSimpleName() + " ServiceDiscovery Thread");
            t.setDaemon(true);
            t.setPriority(Thread.NORM_PRIORITY);
            t.setContextClassLoader(MDCService.class.getClassLoader());
            return t;
        }
    };
    
    protected ThreadFactory networkThreadFactory = new ThreadFactory()
    {
        @Override
        public Thread newThread(Runnable r)
        {
            Thread t = new Thread(r, MDCService.class.getSimpleName() + " Network Thread");
            t.setDaemon(true);
            t.setPriority(Thread.NORM_PRIORITY);
            t.setContextClassLoader(MDCService.class.getClassLoader());
            return t;
        }
    };
    
    BroadcastReceiver endpointerReceiver = new BroadcastReceiver()
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            Log.i(LOG_TAG, getClass().getSimpleName() + ".onReceive(\"" + context + "\", \"" + intent + "\")");
            
            if (intent != null)
            {
                String action = intent.getAction();
                
                Log.i(LOG_TAG, "!!!!! Intent \"" + action + "\" received by \"" + getClass().getSimpleName() + "\" !!!!!");
                XmlElement response = null;
                
                Bundle bundle = getResultExtras(true);
                setResultExtras(bundle);
                try
                {
                    if (INTENT_GET_UDN.equals(action))
                    {
                        bundle.putString(net.posick.ws.Constants.EXTRA_SOAP_ACTION_RESPONSE, SOAP_RESPONSE_UDN);
                        response = new XmlElement(new net.posick.ws.xml.Name(new net.posick.ws.xml.Namespace("device", "http://www.smpte-ra.org/schemas/st2071/2014/device"), "getUDNResponse"));
                        response.addChild(new XmlElement(new net.posick.ws.xml.Name(new net.posick.ws.xml.Namespace("identity", "http://www.smpte-ra.org/schemas/st2071/2014/identity"), "UDN")).setValue(MDCService.this.getUDN()));
                    } else if (INTENT_GET_ONLINE.equals(action))
                    {
                        bundle.putString(net.posick.ws.Constants.EXTRA_SOAP_ACTION_RESPONSE, SOAP_RESPONSE_ONLINE);
                        response = new XmlElement(new net.posick.ws.xml.Name(new net.posick.ws.xml.Namespace("device", "http://www.smpte-ra.org/schemas/st2071/2014/device"), "getOnlineResponse"));
                        response.addChild(new XmlElement(new net.posick.ws.xml.Name(new net.posick.ws.xml.Namespace("types", "http://www.smpte-ra.org/schemas/st2071/2014/types"), "Boolean")).setValue(MDCService.this.isOnline() ? "true" : "false"));
                    } else if (INTENT_GET_NAME.equals(action))
                    {
                        bundle.putString(net.posick.ws.Constants.EXTRA_SOAP_ACTION_RESPONSE, SOAP_RESPONSE_NAME);
                        response = new XmlElement(new net.posick.ws.xml.Name(new net.posick.ws.xml.Namespace("device", "http://www.smpte-ra.org/schemas/st2071/2014/device"), "getNameResponse"));
                        response.addChild(new XmlElement(new net.posick.ws.xml.Name(new net.posick.ws.xml.Namespace("types", "http://www.smpte-ra.org/schemas/st2071/2014/types"), "String")).setValue(MDCService.this.getName()));
                    } else if (INTENT_GET_CAPABILITIES.equals(action))
                    {
                        bundle.putString(net.posick.ws.Constants.EXTRA_SOAP_ACTION_RESPONSE, SOAP_RESPONSE_CAPABILITIES);
                        XmlElement capabilitiesElement = new XmlElement(new net.posick.ws.xml.Name("types:Capabilities"));
                        
                        response = new XmlElement(new net.posick.ws.xml.Name(new net.posick.ws.xml.Namespace("device", "http://www.smpte-ra.org/schemas/st2071/2014/device"), "getCapabilitiesResponse"));
                        response.setNamespace(new Namespace("identity", "http://www.smpte-ra.org/schemas/st2071/2014/identity")).setNamespace(new Namespace("types", "http://www.smpte-ra.org/schemas/st2071/2014/types")).addChild(capabilitiesElement);
                        
                        Capability[] capabilities = MDCService.this.getCapabilities();
                        for (Capability capability : capabilities)
                        {
                            String ucn = capability.getUCN();
                            Map attrs = capability.getAttributes();
                            String[] urls = capability.getUrls();
                            XmlElement capabilityElement = new XmlElement(new net.posick.ws.xml.Name("types", "Capability"));
                            capabilityElement.addChild(new XmlElement(new net.posick.ws.xml.Name("identity", "UCN")).setValue(ucn));
                            capabilityElement.addChild(XmlUtils.toAttributes("types", attrs));
                            capabilityElement.addChild(XmlUtils.toURLs("identity", urls));
                            capabilitiesElement.addChild(capabilityElement);
                        }
                    } else if (INTENT_GET_ATTRIBUTES.equals(action))
                    {
                        bundle.putString(net.posick.ws.Constants.EXTRA_SOAP_ACTION_RESPONSE, SOAP_RESPONSE_ATTRIBUTES);
                        response = new XmlElement(new net.posick.ws.xml.Name(new net.posick.ws.xml.Namespace("device", "http://www.smpte-ra.org/schemas/st2071/2014/device"), "getAttributesResponse"));
                        response.setNamespace(new Namespace("identity", "http://www.smpte-ra.org/schemas/st2071/2014/identity")).setNamespace(new Namespace("types", "http://www.smpte-ra.org/schemas/st2071/2014/types")).addChild(XmlUtils.toAttributes("types", MDCService.this.getAttributes()));
                    } else if (INTENT_GET_URLS.equals(action))
                    {
                        bundle.putString(net.posick.ws.Constants.EXTRA_SOAP_ACTION_RESPONSE, SOAP_RESPONSE_URLS);
                        response = new XmlElement(new net.posick.ws.xml.Name(new net.posick.ws.xml.Namespace("device", "http://www.smpte-ra.org/schemas/st2071/2014/device"), "getURLsResponse"));
                        response.setNamespace(new Namespace("identity", "http://www.smpte-ra.org/schemas/st2071/2014/identity")).addChild(XmlUtils.toURLs("identity", MDCService.this.getURLs()));
                    }
                    
                    if (response != null)
                    {
                        setResultCode(Activity.RESULT_OK);
                        setResultData(response.toString());
                        bundle.putSerializable(net.posick.ws.Constants.EXTRA_RESPONSE, response);
                    }
                } catch (Exception e)
                {
                    bundle.putSerializable(net.posick.ws.Constants.EXTRA_SOAP_FAULT, e);
                }
            }
        }
    };

    protected ScheduledExecutorService serviceExecutor;
    
    protected ScheduledExecutorService networkExecutor;

    protected WifiManager wifiManager;

    protected PowerManager powerManager;

    protected WakeLock wakeLock;
    
    protected WifiLock wifiLock;

    protected boolean capabilitiesRegistered;
    
    protected StringBuilder text = new StringBuilder();
    
    
    @Override
    public IBinder asBinder()
    {
        Log.i(LOG_TAG, getClass().getSimpleName() + ".asBinder()");
        return mBinder;
    }
    
    
    @Override
    public IBinder onBind(Intent intent)
    {
        Log.i(LOG_TAG, "-----> " + getClass().getSimpleName() + ".onBind() <-----");
        displayText(text.toString());
        return mBinder;
    }


    @Override
    public void onCreate()
    {
        Log.i(LOG_TAG, "-----> " + getClass().getSimpleName() + ".onCreate() <-----");
        super.onCreate();
        
        grabWakeLock(LOG_TAG);
        grabWiFiLock(LOG_TAG);
        
        serviceExecutor = Executors.newSingleThreadScheduledExecutor(serviceThreadFactory);
        networkExecutor = Executors.newSingleThreadScheduledExecutor(networkThreadFactory);
        
        localBroadcaster = LocalBroadcastManager.getInstance(getApplicationContext());
        
        try
        {
            Context packageContext = this;
            try
            {
                packageContext = createPackageContext("net.posick.ws", 0);
            } catch (NameNotFoundException e)
            {
                Log.i(LOG_TAG, "Could not find package \"net.posick.ws\", trying in-process SOAPServerService.", e);
            }
            Intent startIntent = new Intent(packageContext, SOAPServerService.class);
            startService(startIntent);
            if (!bindService(startIntent, soapServiceConnection, Context.BIND_IMPORTANT | Context.BIND_ABOVE_CLIENT))
            {
                Log.e(LOG_TAG, "-----> Could NOT bind to SOAP service using action \"" + SOAPServerService.class.getName() + "\" and Package \"net.posick.ws\" <-----");
                try
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=net.posick.ws"));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                    startActivity(intent);
                } catch (android.content.ActivityNotFoundException anfe)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=net.posick.ws")));
                }
                
                displayText("Could NOT bind to services \"" + ISOAPServerService.class.getName() + "\".\nnet.posick.ws.WebServicesForAndroid Required!!");
                errorOnStartupt("Could NOT bind to services \"" + ISOAPServerService.class.getName() + "\".\nnet.posick.ws.WebServicesForAndroid Required!!");
                return;
            }
        } catch (Exception e)
        {
            Log.e(LOG_TAG, e.getMessage(), e);
            Toast toast = Toast.makeText(null, "Could NOT bind to service \"" + SOAPServerService.class.getName() + "\".\n" + e.getLocalizedMessage(), Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
        
        ComponentName service = new ComponentName(this, MDCService.class);
        PackageManager pm = this.getPackageManager();
        pm.setComponentEnabledSetting(service,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
        
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.ic_launcher)
                    .setContentTitle("MDC 4 Android")
                    .setContentText("Implementation of SMPTE ST2071 Media & Device Conrol standard");
        
        Intent notifyIntent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(notifyIntent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_CANCEL_CURRENT);
        notificationBuilder.setContentIntent(pendingIntent);
        
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = notificationBuilder.build();
        notificationManager.notify(NOTIFICATION_ID, notification);
        startForeground(NOTIFICATION_ID, notification);
        
        onConnectivityChange();
    }
    
    
    protected void broadcastIntent(ServiceInstance service, boolean discovered, Intent intent)
    {
        Log.i(LOG_TAG, "Broadcasting Intent + \"" + intent + "\"");
        
        intent.setAction(discovered ? ACTION_SERVICE_DISCOVERED : ACTION_SERVICE_REMOVED);
        intent.addCategory(MDCService.CATEGORY_SERVICE_DISCOVERY);
        intent.putExtra(EXTRA_SERVICE_DISCOVERED, discovered);
        intent.putExtra(EXTRA_SERVICE_REMOVED, !discovered);
        intent.putExtra(EXTRA_SERVICE, service);
        
        sendBroadcast(intent, PERMISSION_MDC_SERVICE_DISCOVERY);
    }


    @Override
    public void onDestroy()
    {
        Log.i(LOG_TAG, "-----> " + getClass().getSimpleName() + ".onDestroy() <-----");
        
        releaseWakeLock();
        releaseWiFiLock();
        
        networkExecutor.execute(new Runnable()
        {
            @Override
            public void run()
            {
                stopNetwork();
            }
        });
        networkExecutor.shutdown();
        serviceExecutor.shutdown();
        
        try
        {
            networkExecutor.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e)
        { // ignore
        }
        
        if (soapServiceConnection != null)
        {
            unbindService(soapServiceConnection);
        }
        
        super.onDestroy();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        Log.i(LOG_TAG, "-----> " + getClass().getSimpleName() + ".onStartCommand() <-----");
        
        if (intent != null)
        {
            String action = intent.getAction();
            
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action))
            {
                onConnectivityChange();
            } else if (MDCService.ACTION_SERVICE_DISCOVERED.equals(action))
            {
                ServiceInstance service = (ServiceInstance) intent.getSerializableExtra(MDCService.EXTRA_SERVICE);
                BrowseOperation browseOp = browseIntents.get(browseIntent);
                browseOp.serviceDiscovered(browseOp.id, service);
            } else if (MDCService.ACTION_SERVICE_REMOVED.equals(action))
            {
                ServiceInstance service = (ServiceInstance) intent.getSerializableExtra(MDCService.EXTRA_SERVICE);
                BrowseOperation browseOp = browseIntents.get(browseIntent);
                browseOp.serviceRemoved(browseOp.id, service);
            }
        }
        
        return START_STICKY;
    }
    
    
    protected void onConnectivityChange()
    {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connMgr != null)
        {
            NetworkInfo info = connMgr.getActiveNetworkInfo();
            Log.i(LOG_TAG, "Network Connectivity Changed - " + (info != null ? "Connected to \"" + info.getTypeName() + "/" + info.getSubtypeName() + "\"." : "NOT Connected to any network."));
            if (info != null)
            {
                switch (info.getState())
                {
                    case CONNECTED:
                    case CONNECTING:
                        networkExecutor.execute(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                startNetwork();
                            }
                        });
                        break;
                    case DISCONNECTED:
                    case DISCONNECTING:
                    case SUSPENDED:
                    case UNKNOWN:
                        networkExecutor.execute(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                stopNetwork();
                            }
                        });
                        break;
                }
            }
        } else
        {
            Log.e(LOG_TAG, "-----> ConnectivityManager could not be acquired! <-----");
        }
    }


    protected void initDevice()
    {
        Set<String> domains = deviceInfo.getDomains();
        Set<InetAddress> dnsServers = deviceInfo.getDNSServers();
        Set<InetAddress> addresses = deviceInfo.getInetAddresses();
        String id = deviceInfo.getId();
        String name = deviceInfo.getName();
        String hostname = deviceInfo.getHostname();
        
        String scope = "";
        if (domains != null && domains.size() > 0)
        {
            scope = NetworkUtils.reverse(domains.toArray(new String[domains.size()])[0]);
        }
        
        if (scope == null || scope.length() == 0)
        {
            scope = "local";
        }
        
        this.udn = "urn:smpte:udn:" + scope + ":id=" + id + ";hostname=" + hostname;
        this.name = name != null ? name : hostname;
        
        displayText("This Device is being initialized as:");
        displayText("UDN: " + this.udn + "");
        displayText("Name: " + this.name + "");
        displayText("Hostname: " + hostname + "");
        
        if (addresses != null && addresses.size() > 0)
        {
            displayText("Local IP Addresses for " + hostname + ":");
            for (InetAddress address : addresses)
            {
                if (addresses != null)
                {
                    displayText("    " + address + "");
                }
            }
        }
        
        if (domains != null && domains.size() > 0)
        {
            displayText("Domains: ");
            for (String domain : domains)
            {
                if (domain != null && domain.length() > 0)
                {
                    displayText("    " + domain + "");
                }
            }
        }
        
        if (dnsServers != null && dnsServers.size() > 0)
        {
            displayText("DNS Servers:");
            for (InetAddress addr : deviceInfo.getDNSServers())
            {
                if (addr != null)
                {
                    displayText("    " + addr.getHostAddress() + "");
                }
            }
        }
        
        Map attributes = new Map();
        attributes.put("hostname", deviceInfo.getHostname());
        attributes.put("os", "Android");
        attributes.put("brand", Build.BRAND);
        attributes.put("host", Build.HOST);
        attributes.put("device", Build.DEVICE);
        attributes.put("manufacturer", Build.MANUFACTURER);
        attributes.put("model", Build.MODEL);
        attributes.put("product", Build.PRODUCT);
        attributes.put("sdk", Build.VERSION.SDK_INT);
        
        java.util.Map<String, Intent> actionIntentMap = new LinkedHashMap<String, Intent>();
        
        Capability deviceCapability = this.deviceCapability;
        if (deviceCapability == null)
        {
            this.deviceCapability = deviceCapability = new Capability();
        }
        deviceCapability.setUcn(Device.UCN);
        deviceCapability.setMakeDiscoverable(true);
        deviceCapability.putAttributes(attributes);
        
        for (int index = 0; index < ACTIONS.length; index++)
        {
            actionIntentMap.put(SOAP_ACTIONS[index], new Intent(ACTIONS[index]).addCategory(net.posick.ws.Constants.CATEGORY_ENDPOINT_CALLBACK));
        }
        
        Set<Capability> capabilities = this.capabilities;
        if (!capabilities.contains(deviceCapability))
        {
            capabilities.add(deviceCapability);
        }
        
        for (String domain : deviceInfo.getDomains())
        {
            RegistrationInformation regInfo = new RegistrationInformation(PATH, domain, deviceCapability, actionIntentMap);
            synchronized (registeredCapabilities)
            {
                registeredCapabilities.put(regInfo.getCapability().getUCN(), domain, regInfo);
            }
        }
        
        this.actionIntentMap = actionIntentMap;
    }
    
    
    protected void startNetwork()
    {
        synchronized (this)
        {
            if (startingNetwork)
            {
                return;
            }
            startingNetwork = true;
        }
        
        if (querier != null && !querier.isOperational() && networkStarted)
        {
            stopNetwork();
        }
        
        Log.i(LOG_TAG, getClass().getSimpleName() + ".startupNetwork()");
        
        if (!networkStarted)
        {
            ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connMgr != null)
            {
                NetworkInfo netInfo = connMgr.getActiveNetworkInfo();
                if (netInfo != null)
                {
                    String type = netInfo.getTypeName();
                    String subType = netInfo.getSubtypeName();
                    displayText("Initializing " + type + (subType != null && subType.length() > 0 ? ":" + subType : "") + " Network.");
                } else
                {
                    displayText("Initializing Network.");
                }
            } else
            {
                displayText("Initializing Network.");
            }
            
            deviceInfo = NetworkUtils.gatherDeviceInformation(this);
            initDevice();
            
            try
            {
                if (querier == null)
                {
                    Set<InetAddress> dnsServers = deviceInfo.getDNSServers();
                    List<Resolver> resolvers = new ArrayList<Resolver>();
                    
                    if (dnsServers != null && dnsServers.size() > 0)
                    {
                        for (InetAddress dnsServer : dnsServers)
                        {
                            SimpleResolver r = new SimpleResolver();
                            r.setAddress(dnsServer);
                            resolvers.add(r);
                        }
                    }
                    
                    querier = new MulticastDNSQuerier(true, true, resolvers.toArray(new Resolver[resolvers.size()]));
                }
                
                MulticastDNSService.setDefaultQuerier(querier);
                service = new MulticastDNSService();
            } catch (IOException e)
            {
                Log.e(LOG_TAG, e.getMessage(), e);
                RuntimeException re = new RuntimeException(e.getMessage());
                re.setStackTrace(e.getStackTrace());
                throw re;
            }
            
            Intent intent = new Intent().addCategory(CATEGORY_SERVICE_DISCOVERY);
            try
            {
                browseIntent = browse(intent, deviceInfo.getDomains().toArray(new String[0]));
            } catch (Exception e)
            {
                Log.e(LOG_TAG, "Error registering general Service Discovery Intent - " + e.getMessage(), e);
            }
            
            Intent networkStartedIntent = new Intent(ACTION_MDC_NETWORK_INITIALIZED).addCategory(CATEGORY_SERVICE_DISCOVERY);
            sendBroadcast(networkStartedIntent, PERMISSION_MDC_SERVICE_DISCOVERY);
            
            if (soapService != null)
            {
                registerCapabilities();
            }
            
            startingNetwork = false;
            networkStarted = true;
        }
    }
    
    
    protected void displayText(String text)
    {
        this.text.append(text);
        if (localBroadcaster != null)
        {
            Intent intent = new Intent(MainActivity.MESSAGE_DISPLAY_TEXT);
            intent.putExtra(MainActivity.EXTRA_TEXT, text);
            localBroadcaster.sendBroadcast(intent);
        }
    }
    
    
    protected void errorOnStartupt(String text)
    {
        if (localBroadcaster != null)
        {
            Intent intent = new Intent(MainActivity.MESSAGE_ERROR_ON_STARTUP);
            intent.putExtra(MainActivity.EXTRA_TEXT, "Could NOT bind to services \"" + ISOAPServerService.class.getName() + "\".\nnet.posick.ws.WebServicesForAndroid Required!!");
            localBroadcaster.sendBroadcast(intent);
        }
    }
    
    
    protected synchronized void stopNetwork()
    {
        Log.i(LOG_TAG, getClass().getSimpleName() + ".stopNetwork()");
        
        if (networkStarted && !startingNetwork)
        {
            networkStarted = false;
            
            if (soapService != null)
            {
                unregisterCapabilities();
            }
            
            if (browseIntent != null)
            {
                try
                {
                    stopBrowse(browseIntent);
                } catch (Exception e)
                {
                    Log.e(LOG_TAG, "Error stopping general Service Discovery Browse - " + e.getLocalizedMessage(), e);
                }
            }
            
            if (browseIntents.size() > 0)
            {
                for (Intent intent : browseIntents.keySet())
                {
                    try
                    {
                        stopBrowse(browseIntent);
                    } catch (Exception e)
                    {
                        Log.e(LOG_TAG, "Error stopping Service Discovery Browse for intent \"" + intent + "\" - " + e.getLocalizedMessage(), e);
                    }
                }
            }
            
            Intent networkStoppedIntent = new Intent(ACTION_MDC_NETWORK_STOPPED).addCategory(CATEGORY_SERVICE_DISCOVERY);
            sendBroadcast(networkStoppedIntent, PERMISSION_MDC_SERVICE_DISCOVERY);
            
            if (service != null)
            {
                try
                {
                    service.close();
                } catch (IOException e)
                {
                    Log.e(LOG_TAG, e.getMessage(), e);
                }
                service = null;
            }
            
            if (querier != null)
            {
                try
                {
                    querier.close();
                } catch (IOException e)
                {
                    Log.e(LOG_TAG, e.getMessage(), e);
                }
                querier = null;
            }
        }
    }
    
    
    @Override
    public String getRN()
    {
        return getUDN();
    }
    
    
    @Override
    public String getUDN()
    {
        return udn;
    }
    
    
    @Override
    public synchronized boolean isOnline()
    {
        return networkStarted;
    }
    
    
    @Override
    public String getName()
    {
        return name;
    }
    
    
    @Override
    public String[] getURLs()
    {
        return urls.toArray(new String[urls.size()]);
    }
    
    
    @Override
    public Capability[] getCapabilities()
    {
        List<Capability> capabilities = new LinkedList<Capability>();
        synchronized (this.capabilities)
        {
            capabilities.addAll(this.capabilities);
        }
        
        return capabilities.toArray(new Capability[capabilities.size()]);
    }
    
    
    @Override
    public Map getAttributes()
    {
        Map attributes = deviceCapability.getAttributes();
        synchronized (format)
        {
            attributes.put("time", format.format(new Date()));
        }
        return attributes;
    }
    
    
    @Override
    public String getHostname()
    throws RemoteException
    {
        return deviceInfo.getHostname();
    }
    
    
    @Override
    public void setHostname(String hostname)
    throws RemoteException
    {
        deviceInfo.setHostname(hostname);
    }
    
    
    @Override
    public String[] getDefaultBrowseDomains()
    throws RemoteException
    {
        List<String> results = new ArrayList<String>();
        Set<Name> searchPath = new LinkedHashSet<Name>();
        for (String domain : deviceInfo.getDomains())
        {
            if (!domain.endsWith("."))
            {
                domain += ".";
            }
            try
            {
                searchPath.add(new Name(domain));
            } catch (Exception e)
            {
                Log.w(LOG_TAG, "Error parsing domain \"" + domain + "\" - " + e.getMessage());
            }
        }
        Set<Domain> defaultDomains = service.getDefaultBrowseDomains(searchPath);
        for (Domain domain : defaultDomains)
        {
            results.add(domain.getName().toString());
        }
        return results.toArray(new String[results.size()]);
    }
    
    
    @Override
    public String[] getBrowseDomains()
    throws RemoteException
    {
        List<String> results = new ArrayList<String>();
        Set<Name> searchPath = new LinkedHashSet<Name>();
        for (String domain : deviceInfo.getDomains())
        {
            if (!domain.endsWith("."))
            {
                domain += ".";
            }
            try
            {
                searchPath.add(new Name(domain));
            } catch (Exception e)
            {
                Log.w(LOG_TAG, "Error parsing domain \"" + domain + "\" - " + e.getMessage());
            }
        }
        Set<Domain> defaultDomains = service.getBrowseDomains(searchPath);
        for (Domain domain : defaultDomains)
        {
            results.add(domain.getName().toString());
        }
        return results.toArray(new String[results.size()]);
    }
    
    
    @Override
    public String[] getDefaultRegistrationDomains()
    throws RemoteException
    {
        List<String> results = new ArrayList<String>();
        Set<Name> searchPath = new LinkedHashSet<Name>();
        for (String domain : deviceInfo.getDomains())
        {
            if (!domain.endsWith("."))
            {
                domain += ".";
            }
            try
            {
                searchPath.add(new Name(domain));
            } catch (Exception e)
            {
                Log.w(LOG_TAG, "Error parsing domain \"" + domain + "\" - " + e.getMessage());
            }
        }
        Set<Domain> defaultDomains = service.getDefaultRegistrationDomains(searchPath);
        for (Domain domain : defaultDomains)
        {
            results.add(domain.getName().toString());
        }
        return results.toArray(new String[results.size()]);
    }
    
    
    @Override
    public String[] getRegistrationDomains()
    throws RemoteException
    {
        List<String> results = new ArrayList<String>();
        Set<Name> searchPath = new LinkedHashSet<Name>();
        for (String domain : deviceInfo.getDomains())
        {
            if (!domain.endsWith("."))
            {
                domain += ".";
            }
            try
            {
                searchPath.add(new Name(domain));
            } catch (Exception e)
            {
                Log.w(LOG_TAG, "Error parsing domain \"" + domain + "\" - " + e.getMessage());
            }
        }
        Set<Domain> defaultDomains = service.getRegistrationDomains(searchPath);
        for (Domain domain : defaultDomains)
        {
            results.add(domain.getName().toString());
        }
        return results.toArray(new String[results.size()]);
    }
    
    
    @Override
    public void query(String subType, String[] domains)
    throws RemoteException
    {
        String[] browseDomains = domains;
        if (browseDomains == null || browseDomains.length == 0)
        {
            browseDomains = getDefaultBrowseDomains();
        }
        
        if (browseDomains == null)
        {
            Log.e(LOG_TAG, "-----> No Browse Domains! <-----");
            return;
        }
        
        Set<Name> names = new LinkedHashSet<Name>();
        for (String domain : browseDomains)
        {
            try
            {
                names.add(new Name("_mdc._tcp." + domain));
                if (subType != null)
                {
                    names.add(new Name(subType + "._sub._mdc._tcp." + domain));
                }
            } catch (Exception e)
            {
                Log.w(LOG_TAG, e.getMessage());
            }
        }
        
        Lookup lookup = null;
        try
        {
            Intent intent = new Intent();
            intent.setAction(ACTION_SERVICE_DISCOVERED);
            intent.addCategory(MDCService.CATEGORY_SERVICE_DISCOVERY);
            intent.putExtra(EXTRA_SERVICE_DISCOVERED, true);
            intent.putExtra(EXTRA_SERVICE_REMOVED, false);
            
            lookup = new Lookup(names.toArray(new Name[names.size()]));
            lookup.setQuerier(querier);
            ServiceInstance[] services = lookup.lookupServices();
            if (services != null && services.length > 0)
            {
                for (ServiceInstance service : services)
                {
                    intent.putExtra(EXTRA_SERVICE, service);
                    broadcastIntent(service, true, intent);
                }
            }
        } catch (IOException e)
        {
            Log.e(LOG_TAG, "Error executing lookup for Services.", e);
        } finally
        {
            if (lookup != null)
            {
                try
                {
                    lookup.close();
                } catch (Exception e)
                {
                }
            }
        }
    }
    
    
    /**
     * Registers an Intent to be broadcast whenever a Service is discovered or
     * removed using DNS-SD and mDNS. The browse operation returns the Intent
     * that will be used for the base of the broadcast Intent. The Action of the
     * Intent will be set to:
     * <ul>
     * <li>ACTION_SERVICE_DISCOVERED ("org.smpte.MDC_SERVICE_DISCOVERED") when a
     * service is discovered
     * <li>ACTION_SERVICE_REMOVED ("org.smpte.MDC_SERVICE_REMOVED") when a
     * service is removed
     * </ul>
     * The category CATEGORY_SERVICE_DISCOVERY
     * ("org.smpte.mdc4android.SERVICE_DISCOVERY") will be added to each
     * registered intent to ensure all Intents are categorized properly.
     * 
     * @param intent The intent to broadcast when Services are discovered and
     *            removed (The action is changed).
     * @param domains The list of domains to restrict the browse operation to or
     *            null for all domains.
     * @return The intent that will be broadcast when Services are discovered or
     *         removed and the intent to use when stopping the browse operation.
     */
    public Intent browse(Intent intent, String[] domains)
    {
        BrowseOperation browseOp = browseIntents.get(intent);
        if (browseOp == null)
        {
            if (domains == null || domains.length == 0)
            {
                browseOp = new BrowseOperation(this, intent, null);
            } else
            {
                browseOp = new BrowseOperation(this, intent, domains);
            }
            browseIntents.put(intent, browseOp);
        }
        
        Set<Name> serviceTypes = new LinkedHashSet<Name>();
        for (Name domain : browseOp.getDomains())
        {
            try
            {
                serviceTypes.add(new Name("_mdc._tcp", domain));
            } catch (TextParseException e)
            {
                Log.e(LOG_TAG, "Error adding service type \"_mdc._tcp." + domain + "\" - " + e.getMessage());
            }
        }
        
        Name[] serviceTypesArray = serviceTypes.toArray(new Name[serviceTypes.size()]);
        try
        {
            browseOp.setId(service.startServiceDiscovery(new Browse(serviceTypesArray), browseOp));
            intent.putExtra(EXTRA_BROWSE_SERVICE_TYPES, serviceTypesArray);
        } catch (IOException e)
        {
            Log.e(LOG_TAG, "Error starting service discovery - " + e.getMessage());
        }
        
        if (browseOp.getId() != null)
        {
            return intent;
        } else
        {
            return null;
        }
    }
    
    
    public boolean stopBrowse(Intent intent)
    throws RemoteException
    {
        BrowseOperation browseOp = browseIntents.remove(intent);
        if (browseOp != null)
        {
            try
            {
                return service.stopServiceDiscovery(browseOp.getId());
            } catch (IOException e)
            {
                Log.e(LOG_TAG, "Error starting service discovery - " + e.getMessage());
            }
        }
        
        return false;
    }
    
    
    @Override
    @SuppressWarnings("rawtypes")
    public boolean register(Capability capability, String domain, String path, java.util.Map actionIntentMap)
    throws RemoteException
    {
        LinkedHashMap<String, Intent> actionMap = new LinkedHashMap<String, Intent>();
        for (Object o : actionIntentMap.keySet())
        {
            String key = (String) o;
            Intent intent = (Intent) actionIntentMap.get(key);
            actionMap.put(key, intent);
        }
        
        RegistrationInformation regInfo = new RegistrationInformation(path, domain, capability, actionMap);
        
        synchronized (registeredCapabilities)
        {
            try
            {
                registeredCapabilities.put(capability.getUCN(), domain, regInfo);
                if (networkStarted)
                {
                    capability.addUrls(_register(regInfo).toArray(new String[urls.size()]));
                    displayText("Capability \"" + capability.getUCN() + "\" activated for domain \"" + domain + "\".");
                } else
                {
                    displayText("Capability \"" + capability.getUCN() + "\" registered for domain \"" + domain + "\".");
                }
                return true;
            } catch (Exception e)
            {
                Log.e(LOG_TAG, "Error registering capability \"" + capability.getUCN() + "\" - " + e.getMessage(), e);
            }
        }
        
        return false;
    }
    
    
    protected Set<String> _register(RegistrationInformation regInfo)
    {
        Set<String> urls = new LinkedHashSet<String>();
        
        ISOAPServerService soapService = this.soapService;
        if (soapService != null)
        {
            java.util.Map<String, Intent> actionMap = regInfo.getActionIntentMap();
            Capability capability = regInfo.getCapability();
            String path = regInfo.getPath();
            String domain = regInfo.getDomain();
            String hostname = deviceInfo.getHostname() + "." + (domain.endsWith(".") ? domain : domain + ".");
            
            for (java.util.Map.Entry<String, Intent> entry : actionMap.entrySet())
            {
                String action = entry.getKey();
                Intent intent = entry.getValue();
                
                try
                {
                    String url = null;
                    Intent registeredIntent = soapService.lookup(path, action);
                    if (registeredIntent == null)
                    {
                        url = soapService.register(path, action, intent);
                    } else
                    {
                        url = soapService.lookupUrl(path, action);
                        Log.i(LOG_TAG, "Endpoint for \"Path=\"" + path + " & Action=\"" + action + "\" already registered to URL \"" + url + "\".");
                    }
                    
                    if (url != null)
                    {
                        urls.add(NetworkUtils.replaceHostname(NetworkUtils.replaceProtocol(url, MDC_URL_PROTOCOL), hostname));
                    } else
                    {
                        throw new MalformedURLException("No URL was returned from soapService.register(\"Path=\"" + path + " & Action=\"" + action + "\")");
                    }
                } catch (MalformedURLException e)
                {
                    Log.e(LOG_TAG, "Hostname \"" + hostname + "\" is not valid - " + e.getMessage(), e);
                } catch (Exception e)
                {
                    Log.e(LOG_TAG, "Error registering endpoint for Capability");
                }
            }
            
            for (String url : urls)
            {
                if (capability.makeDiscoverable())
                {
                    try
                    {
                        Name fqn = new Name(hostname);
                        int priority = 10;
                        int weight = 10;
                        int port = NetworkUtils.extractPort(url);
                        String ucnPTRName = NetworkUtils.ucnToServiceName(capability.getUCN());
                        
                        ServiceName srvName = new ServiceName(deviceInfo.getHostname() + "." + ucnPTRName + "." + (domain.endsWith(".") ? domain : domain + "."));
                        
                        ServiceInstance serviceInstance = new ServiceInstance(srvName, priority, weight, port, fqn, deviceInfo.getInetAddresses().toArray(new InetAddress[0]), "textvers=1", "rn=" + getUDN(), "proto=mdcp", "path=" + path);
                        ServiceInstance registeredService = service.register(serviceInstance);
                        if (registeredService != null)
                        {
                            regInfo.addDiscoverableService(registeredService);
                            Log.i(LOG_TAG, "Services Successfully Registered: \n\t" + registeredService);
                        } else
                        {
                            boolean hostnameResolves = false;
                            
                            Lookup lookup = new Lookup(fqn);
                            Record[] rrs = lookup.lookupRecords();
                            if (rrs != null && rrs.length > 0)
                            {
                                outer: for (Record rr : rrs)
                                {
                                    switch (rr.getType())
                                    {
                                        case Type.A:
                                        case Type.A6:
                                        case Type.AAAA:
                                        case Type.DNAME:
                                        case Type.CNAME:
                                        case Type.PTR:
                                            if (rr.getName().equals(fqn))
                                            {
                                                hostnameResolves = true;
                                                break outer;
                                            }
                                            break;
                                    }
                                }
                            }
                            
                            Log.e(LOG_TAG, "Services Registration for UCN \"" + capability.getUCN() + "\" in domain \"" + domain + "\" Failed!");
                            if (hostnameResolves)
                            {
                                Log.i(LOG_TAG, "Hostname \"" + fqn + "\" can be resolved.");
                            } else
                            {
                                Log.e(LOG_TAG, "Hostname \"" + fqn + "\" cannot be resolved!");
                            }
                        }
                    } catch (Exception e)
                    {
                        Log.e(LOG_TAG, "Error Registering Capability \"" + capability.getUCN() + "\" for Discovery - " + e.getMessage(), e);
                    }
                }
            }
        }
        
        return urls;
    }
    
    
    @Override
    public Capability unregister(String ucn, String domain)
    throws RemoteException
    {
        Capability capability = null;
        
        synchronized (registeredCapabilities)
        {
            RegistrationInformation regInfo = registeredCapabilities.remove(ucn, domain);
            if (regInfo != null)
            {
                for (ServiceInstance instance : regInfo.getDiscoverableServices())
                {
                    try
                    {
                        service.unregister(instance);
                    } catch (IOException e)
                    {
                        Log.e(LOG_TAG, "Error unregistering discoverable service - " + e.getMessage(), e);
                    }
                }
                
                String path = regInfo.getPath();
                java.util.Map<String, Intent> actionMap = regInfo.getActionIntentMap();
                if (soapService != null)
                {
                    for (java.util.Map.Entry<String, Intent> entry : actionMap.entrySet())
                    {
                        String action = entry.getKey();
                        if (soapService.lookup(path, action) != null)
                        {
                            try
                            {
                                if (!soapService.unregister(path, action))
                                {
                                    Log.w(LOG_TAG, "Endpoint Path=\"" + path + "\" Action=\"" + action + "\" was NOT unregistered.");
                                }
                            } catch (Exception e)
                            {
                                Log.e(LOG_TAG, "Error unregistering endpoint Path=\"" + path + "\" Action=\"" + action + "\" - " + e.getMessage(), e);
                            }
                        }
                    }
                }
                capability = regInfo.getCapability();
                if (capability != null)
                {
                    capability.setUrls(new String[0]);
                }
            }
        }
        
        return capability;
    }
    
    
    protected synchronized void registerCapabilities()
    {
        // TODO: Maybe Use thread pool here.
        if (!capabilitiesRegistered && registeredCapabilities != null && registeredCapabilities.size() > 0)
        {
            synchronized (registeredCapabilities)
            {
                capabilitiesRegistered = true;
                new Thread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        try
                        {
                            // Register Device Capability using a single URL for all device endpoints.
                            // The soapAction being different for each endpoint/method.
                            synchronized (registeredCapabilities)
                            {
                                for (java.util.Map.Entry<String, java.util.Map<String, RegistrationInformation>> entry : registeredCapabilities.entrySet())
                                {
                                    java.util.Map<String, RegistrationInformation> domainMap = entry.getValue();
                                    for (java.util.Map.Entry<String, RegistrationInformation> domainEntry : domainMap.entrySet())
                                    {
                                        final String domain = domainEntry.getKey();
                                        final RegistrationInformation regInfo = domainEntry.getValue();
                                        Capability capability = regInfo.getCapability();
                                        capability.addUrls(_register(regInfo).toArray(new String[urls.size()]));
                                        displayText("Capability \"" + capability.getUCN() + "\" activated for path \"" + regInfo.getPath() + "\" and domain \"" + regInfo.getDomain() + "\".");
                                        
                                        if (!domain.equals(regInfo.getDomain()))
                                        {
                                            Log.e(LOG_TAG, "Domain for Capability \"" + capability.getUCN() + "\" activated for path \"" + regInfo.getPath() + "\" does not match its placement in the Map! Map domain: \"" + domain + "\" != RegInfo Domain: \"" + regInfo.getDomain() + "\"!");
                                        }
                                        Log.i(LOG_TAG, "Registered Capability \"" + capability.getUCN() + "\" activated for path \"" + regInfo.getPath() + "\" and domain \"" + regInfo.getDomain() + "\".");
                                    }
                                }
                            }
                            
                            IntentFilter filter = new IntentFilter();
                            try
                            {
                                filter.addDataType(net.posick.ws.Constants.MEDIA_TYPE_SOAP);
                                filter.addCategory(net.posick.ws.Constants.CATEGORY_ENDPOINT_CALLBACK);
                                for (String action : ACTIONS)
                                {
                                    filter.addAction(action);
                                }
                                filter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY);
                                registerReceiver(endpointerReceiver, filter, net.posick.ws.Constants.PERMISSION_REGISTER_ENDPOINT, null);
                            } catch (MalformedMimeTypeException e)
                            {
                                Log.e(LOG_TAG, "Error setting Endpoint BroadcatReceiver - Media Type \"" + net.posick.ws.Constants.MEDIA_TYPE_SOAP + "\" is invalid - " + e.getCause(), e);
                            }
                        } catch (Exception e)
                        {
                            Log.e(LOG_TAG, "Error registering Capability - " + e.getMessage(), e);
                        }
                    }
                }).start();
            }
        }
    }
    
    
    protected void unregisterCapabilities()
    {
        // TODO: Maybe Use thread pool here.
        if (capabilitiesRegistered && registeredCapabilities != null && registeredCapabilities.size() > 0)
        {
            synchronized (registeredCapabilities)
            {
                new Thread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        try
                        {
                            synchronized (registeredCapabilities)
                            {
                                String[] keys1 = registeredCapabilities.keySet().toArray(new String[0]);
                                for (String ucn : keys1)
                                {
                                    String[] keys2 = registeredCapabilities.keySet(ucn).toArray(new String[0]);
                                    for (String domain :keys2)
                                    {
                                        Capability capability = null;
                                        try
                                        {
                                            if ((capability = unregister(ucn, domain)) == null)
                                            {
                                                Log.e(LOG_TAG, "Error unregistering Capability \"" + ucn + "\".");
                                            } else
                                            {
                                                Log.i(LOG_TAG, "Unregistered Capabaility \"" + capability.getUCN() + "\".");
                                            }
                                        } catch (Exception e)
                                        {
                                            Log.e(LOG_TAG, "Error unregistering Capability \"" + ucn + "\" - " + e.getMessage(), e);
                                        }
                                    }
                                    
                                    capabilitiesRegistered = true;
                                }
                            }
                        } catch (Exception e)
                        {
                            Log.e(LOG_TAG, "Error unregistering Capabilities - " + e.getMessage(), e);
                        }
                        
                        unregisterReceiver(endpointerReceiver);
                    }
                }).start();
            }
        }
    }
    
    
    protected PowerManager powerManager()
    {
        if (powerManager == null)
        {
            powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        }
        
        // If still null display error!
        if (powerManager == null)
        {
            String message = super.getString(R.string.error_wake_lock_not_created_no_manager);
            Log.e(LOG_TAG, message);
            Toast toast = Toast.makeText(null, message, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
        return powerManager;
    }
    
    
    protected synchronized void grabWakeLock(String tag)
    {
        if (wakeLock == null)
        {
            wakeLock = powerManager().newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, tag);
            if (wakeLock != null)
            {
                wakeLock.acquire();
            }
        }
    }
    
    
    protected synchronized void releaseWakeLock()
    {
        if (wakeLock == null)
        {
            if (wakeLock.isHeld())
            {
                wakeLock.release();
            }
            wakeLock = null;
        }
    }
    
    
    protected WifiManager wifiManager()
    {
        if (wifiManager == null)
        {
            wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        }
        
        // If still null display error!
        if (wifiManager == null)
        {
            String message = super.getString(R.string.error_wifi_lock_not_created_no_manager);
            Log.e(LOG_TAG, message);
            Toast toast = Toast.makeText(null, message, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
        return wifiManager;
    }
    
    
    protected synchronized void grabWiFiLock(String tag)
    {
        if (wifiLock == null)
        {
            wifiLock = wifiManager().createWifiLock(WifiManager.WIFI_MODE_FULL, tag);
            if (wifiLock != null)
            {
                wifiLock.acquire();
            }
        }
    }
    
    
    protected synchronized void releaseWiFiLock()
    {
        if (wifiLock == null)
        {
            if (wifiLock.isHeld())
            {
                wifiLock.release();
            }
            wifiLock = null;
        }
    }
}
