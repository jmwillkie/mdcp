package org.smpte.mdc4android;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;

import net.posick.ws.soap.ISOAPServerService;
import net.posick.ws.xml.Namespace;
import net.posick.ws.xml.XmlElement;

import org.smpte.mdc4android.mdcf.Capability;
import org.smpte.mdc4android.mdcf.Map;
import org.smpte.mdc4android.net.DeviceInfo;
import org.smpte.mdc4android.net.NetworkUtils;
import org.smpte.mdc4android.xml.XmlUtils;
import org.xbill.DNS.Name;
import org.xbill.DNS.Resolver;
import org.xbill.DNS.SimpleResolver;
import org.xbill.mDNS.Lookup;
import org.xbill.mDNS.Lookup.Domain;
import org.xbill.mDNS.MulticastDNSQuerier;
import org.xbill.mDNS.MulticastDNSService;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentFilter.MalformedMimeTypeException;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

public class MDCService extends Service implements IMDCService, Device
{
    private static final String MDC_URL_PROTOCOL = "mdcp";

    public static final String LOG_TAG = MDC4Android.LOG_TAG + "." + MDCService.class.getSimpleName();
    
    public static final String EXTRA_CONNECT_TO_NETWORK = "ConnectToNetwork";

    public static final String ACTION_GET_UDN = "org.smpte.st2071.device.Device/getUDN";
    
    public static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);

    
    
    protected static class RegistrationInformation
    {
        private String path;
        
        private String domain;
        
        private Capability capability;
        
        private java.util.Map<String, Intent> actionIntentMap;
        
        
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


        public Capability getCapability()
        {
            return capability;
        }


        public java.util.Map<String, Intent> getActionIntentMap()
        {
            return actionIntentMap;
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
        public Intent browse(String[] ucns, String[] domains, Intent intent)
        throws RemoteException
        {
            return MDCService.this.browse(ucns, domains, intent);
        }

        @Override
        public String stopBrowse(Intent intent)
        throws RemoteException
        {
            return MDCService.this.stopBrowse(intent);
        }

        @Override
        @SuppressWarnings("rawtypes")
        public Capability register(String path, String domain, Capability capability, java.util.Map actionIntentMap)
        throws RemoteException
        {
            return MDCService.this.register(path, domain, capability, actionIntentMap);
        }

        @Override
        public void unregister(Capability capability)
        throws RemoteException
        {
            MDCService.this.unregister(capability);
        }
    };
    
    protected class EndpointBroadcastReceiver extends BroadcastReceiver
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
                        response.addChild(new XmlElement(new net.posick.ws.xml.Name(new net.posick.ws.xml.Namespace("identity", "http://www.smpte-ra.org/schemas/st2071/2014/identity"), "UDN"))
                                                .setValue(MDCService.this.getUDN()));
                    } else if (INTENT_GET_ONLINE.equals(action))
                    {
                        bundle.putString(net.posick.ws.Constants.EXTRA_SOAP_ACTION_RESPONSE, SOAP_RESPONSE_ONLINE);
                        response = new XmlElement(new net.posick.ws.xml.Name(new net.posick.ws.xml.Namespace("device", "http://www.smpte-ra.org/schemas/st2071/2014/device"), "getOnlineResponse"));
                        response.addChild(new XmlElement(new net.posick.ws.xml.Name(new net.posick.ws.xml.Namespace("types", "http://www.smpte-ra.org/schemas/st2071/2014/types"), "Boolean"))
                                                .setValue(MDCService.this.isOnline() ? "true" : "false"));
                    } else if (INTENT_GET_NAME.equals(action))
                    {
                        bundle.putString(net.posick.ws.Constants.EXTRA_SOAP_ACTION_RESPONSE, SOAP_RESPONSE_NAME);
                        response = new XmlElement(new net.posick.ws.xml.Name(new net.posick.ws.xml.Namespace("device", "http://www.smpte-ra.org/schemas/st2071/2014/device"), "getNameResponse"));
                        response.addChild(new XmlElement(new net.posick.ws.xml.Name(new net.posick.ws.xml.Namespace("types", "http://www.smpte-ra.org/schemas/st2071/2014/types"), "String"))
                                                .setValue(MDCService.this.getName()));
                    } else if (INTENT_GET_CAPABILITIES.equals(action))
                    {
                        bundle.putString(net.posick.ws.Constants.EXTRA_SOAP_ACTION_RESPONSE, SOAP_RESPONSE_CAPABILITIES);
                        XmlElement capabilitiesElement = new XmlElement(new net.posick.ws.xml.Name("types:Capabilities"));
                        
                        response = new XmlElement(new net.posick.ws.xml.Name(new net.posick.ws.xml.Namespace("device", "http://www.smpte-ra.org/schemas/st2071/2014/device"), "getCapabilitiesResponse"));
                        response.setNamespace(new Namespace("identity", "http://www.smpte-ra.org/schemas/st2071/2014/identity"))
                                .setNamespace(new Namespace("types", "http://www.smpte-ra.org/schemas/st2071/2014/types"))
                                .addChild(capabilitiesElement);
                        
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
                        response.setNamespace(new Namespace("identity", "http://www.smpte-ra.org/schemas/st2071/2014/identity"))
                                .setNamespace(new Namespace("types", "http://www.smpte-ra.org/schemas/st2071/2014/types"))
                                .addChild(XmlUtils.toAttributes("types", MDCService.this.getAttributes()));
                    } else if (INTENT_GET_URLS.equals(action))
                    {
                        bundle.putString(net.posick.ws.Constants.EXTRA_SOAP_ACTION_RESPONSE, SOAP_RESPONSE_URLS);
                        response = new XmlElement(new net.posick.ws.xml.Name(new net.posick.ws.xml.Namespace("device", "http://www.smpte-ra.org/schemas/st2071/2014/device"), "getURLsResponse"));
                        response.setNamespace(new Namespace("identity", "http://www.smpte-ra.org/schemas/st2071/2014/identity"))
                                .addChild(XmlUtils.toURLs("identity", MDCService.this.getURLs()));
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
    }
    
    private ServiceConnection soapServiceConnection = new ServiceConnection()
    {
        private List<EndpointBroadcastReceiver> endpointReceivers = new ArrayList<EndpointBroadcastReceiver>();
        
        
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
                
                // TODO: Remove When testing is done!
                soapService.register("/Device/Capabilities", "", actionIntentMap.get(Device.INTENT_GET_CAPABILITIES));
                
                // Register Device Capability using a single URL for all device endpoints.  
                // The soapAction being different for each endpoint/method.
                for (String domain : deviceInfo.getDomains())
                {
                    register(PATH, domain, deviceCapability, actionIntentMap);
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
                    EndpointBroadcastReceiver endpointReceiver = new EndpointBroadcastReceiver();
                    if (endpointReceivers.add(endpointReceiver))
                    {
                        registerReceiver(endpointReceiver, filter, net.posick.ws.Constants.PERMISSION_REGISTER_ENDPOINT, null);
                    }
                } catch (MalformedMimeTypeException e)
                {
                    Log.e(LOG_TAG, "Error setting Endpoint BroadcatReceiver - Media Type \"" + net.posick.ws.Constants.MEDIA_TYPE_SOAP + "\" is invalid - " + e.getCause(), e);
                }
            } catch (RemoteException e)
            {
                Log.e(LOG_TAG, "Error registering Device Endpoints - " + e.getMessage(), e);
            }
        }
        
        @Override
        public void onServiceDisconnected(ComponentName className)
        {
            Log.i(LOG_TAG, getClass().getSimpleName() + ".onServiceDisconnected(\"" + className.flattenToString() + "\")");
            for (EndpointBroadcastReceiver endpointReceiver : endpointReceivers)
            {
                unregisterReceiver(endpointReceiver);
            }
            endpointReceivers.clear();
            soapService = null;
        }
    };
    
    protected ISOAPServerService soapService;
    
    protected boolean networkStarted = false;
    
    protected DeviceInfo deviceInfo = null;
    
    protected MulticastDNSQuerier querier = null;
    
    protected MulticastDNSService service;

    protected String udn;

    protected String name;

    protected Set<String> urls = new LinkedHashSet<String>();
    
    protected Set<Capability> capabilities = new LinkedHashSet<Capability>();

    protected LocalBroadcastManager localBroadcaster;
    
    protected java.util.Map<String, RegistrationInformation> registeredCapabilities = new LinkedHashMap<String, RegistrationInformation>();
    
    protected Capability deviceCapability = new Capability();

    protected java.util.Map<String, Intent> actionIntentMap;
    
    
    @Override
    public IBinder asBinder()
    {
        Log.i(LOG_TAG, getClass().getSimpleName() + ".asBinder()");
        return mBinder;
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
        Log.i(LOG_TAG, getClass().getSimpleName() + ".onCreate()");
        super.onCreate();
        
        localBroadcaster = LocalBroadcastManager.getInstance(getApplicationContext());
        
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connMgr != null)
        {
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected())
            {
                startNetwork();
            } else
            {
                stopNetwork();
            }
        } else
        {
            Log.e(LOG_TAG, "ConnectivityManager could not be acquired!");
        }
    }
    
    
    @Override
    public void onDestroy()
    {
        Log.i(LOG_TAG, getClass().getSimpleName() + ".onDestroy()");
        stopNetwork();
        super.onDestroy();
    }

    
    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        Log.i(LOG_TAG, getClass().getSimpleName() + ".onStartCommand()");
        super.onStartCommand(intent, flags, startId);
        
        if (intent != null)
        {
            if (intent.hasExtra(EXTRA_CONNECT_TO_NETWORK))
            {
                boolean connected = intent.getBooleanExtra(EXTRA_CONNECT_TO_NETWORK, false);
                if (connected)
                {
                    startNetwork();
                } else
                {
                    stopNetwork();
                }
            }
        }
        
        return START_STICKY;
    }
    
    
    protected void initDevice()
    {
        Set<String> domains = deviceInfo.getDomains();
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
        
        Capability deviceCapability = new Capability();
        deviceCapability.setUcn(Device.UCN);
        deviceCapability.setAttributes(attributes);
        for (int index = 0; index < ACTIONS.length; index++)
        {
            actionIntentMap.put(ACTIONS[index], new Intent(ACTIONS[index]).addCategory(net.posick.ws.Constants.CATEGORY_ENDPOINT_CALLBACK));
        }
        this.capabilities.add(deviceCapability);
        this.deviceCapability = deviceCapability;
        this.actionIntentMap = actionIntentMap;
    }
    
    
    protected synchronized void startNetwork()
    {
        Log.i(LOG_TAG, getClass().getSimpleName() + ".startupNetwork()");
        
        if (!networkStarted)
        {
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
                
                service = new MulticastDNSService();
                service.setQuerier(querier);
            } catch (IOException e)
            {
                Log.e(LOG_TAG, e.getMessage(), e);
                RuntimeException re = new RuntimeException(e.getMessage());
                re.setStackTrace(e.getStackTrace());
                throw re;
            }
            
            if (!bindService(new Intent(ISOAPServerService.class.getName()), soapServiceConnection, Context.BIND_AUTO_CREATE | Context.BIND_ABOVE_CLIENT| Context.BIND_IMPORTANT))
            {
                Log.e(LOG_TAG, "Could NOT bind to services \"" + ISOAPServerService.class.getName() + "\".\nnet.posick.ws.WebServicesForAndroid Required!!");
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
            
            networkStarted = true;
        }
    }


    protected void displayText(String text)
    {
        Intent intent = new Intent(MainActivity.MESSAGE_DISPLAY_TEXT);
        intent.putExtra(MainActivity.EXTRA_TEXT, text);
        localBroadcaster.sendBroadcast(intent);
    }


    protected void errorOnStartupt(String text)
    {
        Intent intent = new Intent(MainActivity.MESSAGE_ERROR_ON_STARTUP);
        intent.putExtra(MainActivity.EXTRA_TEXT, "Could NOT bind to services \"" + ISOAPServerService.class.getName() + "\".\nnet.posick.ws.WebServicesForAndroid Required!!");
        localBroadcaster.sendBroadcast(intent);
    }
    
    
    protected synchronized void stopNetwork()
    {
        Log.i(LOG_TAG, getClass().getSimpleName() + ".shutdownNetwork()");
        
        if (!networkStarted)
        {
            unbindService(soapServiceConnection);
            
            networkStarted = false;
            
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
        searchPath.addAll(Arrays.asList(Lookup.ALL_MULTICAST_DNS_DOMAINS));
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
        Set<Domain> domains = getDomains(new String[] {Lookup.DEFAULT_BROWSE_DOMAIN_NAME}, searchPath.toArray(new Name[searchPath.size()]));
        for (Domain domain : domains)
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
        searchPath.addAll(Arrays.asList(Lookup.ALL_MULTICAST_DNS_DOMAINS));
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
        Set<Domain> domains = getDomains(new String[] {Lookup.DEFAULT_BROWSE_DOMAIN_NAME, Lookup.BROWSE_DOMAIN_NAME, Lookup.LEGACY_BROWSE_DOMAIN_NAME}, searchPath.toArray(new Name[searchPath.size()]));
        for (Domain domain : domains)
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
        searchPath.addAll(Arrays.asList(Lookup.ALL_MULTICAST_DNS_DOMAINS));
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
        Set<Domain> domains = getDomains(new String[] {Lookup.DEFAULT_REGISTRATION_DOMAIN_NAME}, searchPath.toArray(new Name[searchPath.size()]));
        for (Domain domain : domains)
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
        searchPath.addAll(Arrays.asList(Lookup.ALL_MULTICAST_DNS_DOMAINS));
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
        Set<Domain> domains = getDomains(new String[] {Lookup.DEFAULT_REGISTRATION_DOMAIN_NAME, Lookup.REGISTRATION_DOMAIN_NAME}, searchPath.toArray(new Name[searchPath.size()]));
        for (Domain domain : domains)
        {
            results.add(domain.getName().toString());
        }
        return results.toArray(new String[results.size()]);
    }


    @Override
    public Intent browse(String[] ucns, String[] domains, Intent intent)
    throws RemoteException
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public String stopBrowse(Intent intent)
    throws RemoteException
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    
    @Override
    @SuppressWarnings("rawtypes")
    public Capability register(String path, String domain, Capability capability, java.util.Map actionIntentMap)
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
        registeredCapabilities.put(capability.getUCN(), regInfo);
        
        Set<String> urls = _register(regInfo);
        capability.addUrls(urls.toArray(new String[urls.size()]));
        
        return capability;
    }
    
    
    protected Set<String> _register(RegistrationInformation regInfo)
    {
        Set<String> urls = new LinkedHashSet<String>();
        
        ISOAPServerService soapService = this.soapService;
        if (soapService != null)
        {
            java.util.Map<String, Intent> actionMap = regInfo.getActionIntentMap();
            String path = regInfo.getPath();
            String domain = regInfo.getDomain();
            
            for (java.util.Map.Entry<String, Intent> entry : actionMap.entrySet())
            {
                String action = entry.getKey();
                Intent intent = entry.getValue();
                String fqn = deviceInfo.getHostname() + "." + (domain.endsWith(".") ? domain.substring(0, domain.length() - 1) : domain);
                
                try
                {
                    Intent registeredIntent = soapService.lookup(path, action);
                    String url = null;
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
                        urls.add(NetworkUtils.replaceHostname(NetworkUtils.replaceProtocol(url, MDC_URL_PROTOCOL), fqn));
                    } else
                    {
                        throw new MalformedURLException("No URL was returned from soapService.register(\"Path=\"" + path + " & Action=\"" + action + "\")");
                    }
                } catch (MalformedURLException e)
                {
                    Log.e(LOG_TAG, "Hostname \"" + fqn + "\" is not valid - " + e.getMessage(), e);
                } catch (Exception e)
                {
                    Log.e(LOG_TAG, "Error registering endpoint for Capability");
                }
            }
        }
        
        return urls;
    }
    

    @Override
    public void unregister(Capability capability)
    throws RemoteException
    {
        // TODO Auto-generated method stub
        
    }
    
    
    protected Set<Domain> getDomains(String[] names, Name[] path)
    {
        Set<Domain> results = new LinkedHashSet<Domain>();
        
        Stack<Name[]> stack = new Stack<Name[]>();
        stack.push(path);
        
        while (!stack.isEmpty())
        {
            Name[] searchPath = stack.pop();
            
            Lookup lookup = null;
            try
            {
                lookup = new Lookup(names);
                lookup.setSearchPath(searchPath);
                lookup.setQuerier(querier);
                Domain[] domains = lookup.lookupDomains();
                if (domains != null && domains.length > 0)
                {
                    List<Name> newDomains = new ArrayList<Name>();
                    for (int index = 0; index < domains.length; index++)
                    {
                        if (!results.contains(domains[index].getName()))
                        {
                            newDomains.add(domains[index].getName());
                            results.add(domains[index]);
                        }
                    }
                    if (newDomains.size() > 0)
                    {
                        stack.push(newDomains.toArray(new Name[newDomains.size()]));
                    }
                }
            } catch (IOException e)
            {
                Log.e(LOG_TAG, e.getMessage(), e);
            } finally
            {
                if (lookup != null)
                {
                    try
                    {
                        lookup.close();
                    } catch (Exception e)
                    {
                        // ignore
                    }
                }
            }
        }
        
        return results;
    }
}
