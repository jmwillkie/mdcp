package org.smpte.mdc4android;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;

import net.posick.ws.soap.ISOAPServerService;
import net.posick.ws.soap.SOAPServerService;
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
import org.xbill.DNS.Update;
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
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class MDCService extends Service implements IMDCService, Device
{
    public static final String LOG_TAG = MDC4Android.LOG_TAG + "." + MDCService.class.getSimpleName();
    
    public static final String EXTRA_CONNECT_TO_NETWORK = "ConnectToNetwork";

    public static final String ACTION_GET_UDN = "org.smpte.st2071.device.Device/getUDN";
    
    
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
        public Capability register(String path, String action, String domain, Capability capability, Intent intent)
        throws RemoteException
        {
            return MDCService.this.register(path, action, domain, capability, intent);
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
                
                // TODO: Register Device Capability using a single URL for all device endpoints.  
                //       The soapAction being different for each endpoint/method.

                
                for (int index = 0; index < PATHS.length; index++)
                {
                    Intent intent = new Intent(ACTIONS[index]).addCategory(net.posick.ws.Constants.CATEGORY_ENDPOINT_CALLBACK);
                    
                    String url = soapService.register(PATHS[index], SOAP_ACTIONS[index], intent);
                    Log.i(LOG_TAG, "Endpoint: url=\"" + url + "\" path=\"" + PATHS[index] + "\", action=\"" + SOAP_ACTIONS[index] + "\" registered to Intent Action \"" + ACTIONS[index] + "\" [" + intent + "]");
                    if (url != null)
                    {
                        try
                        {
                            String newURL = NetworkUtils.replaceProtocol(url, "mdcp");
                            String hostname = deviceInfo.getHostname();
                            for (String domain : deviceInfo.getDomains())
                            {
                                String fqn = hostname + "." + domain;
                                try
                                {
                                    urls.add(NetworkUtils.replaceHostname(newURL, (fqn.endsWith(".") ? fqn.substring(0, fqn.length() - 1) : fqn)));
                                } catch (Exception e)
                                {
                                    Log.e(LOG_TAG, "Hostname \"" + fqn + "\" is not valid - " + e.getMessage(), e);
                                }
                            }
                        } catch (MalformedURLException e)
                        {
                            Log.e(LOG_TAG, "URL \"" + url + "\" returned from SOAPServerService is not an absolute URL!", e);
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

//    protected Map attributes;
    
    protected Set<String> urls = new LinkedHashSet<String>();
    
    Set<Capability> capabilities = new LinkedHashSet<Capability>();
    
    
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


    protected synchronized void startNetwork()
    {
        Log.i(LOG_TAG, getClass().getSimpleName() + ".startupNetwork()");
        
        if (!networkStarted)
        {
            deviceInfo = NetworkUtils.gatherDeviceInformation(this);
            
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
            
            if (!bindService(new Intent(ISOAPServerService.class.getName()), soapServiceConnection, Context.BIND_AUTO_CREATE | Context.BIND_ABOVE_CLIENT| Context.BIND_IMPORTANT))
            {
                Log.i(LOG_TAG, "Binding to Service \"" + SOAPServerService.class.getName() + "\".");
                if (!bindService(new Intent(ISOAPServerService.class.getName()), soapServiceConnection, Context.BIND_AUTO_CREATE | Context.BIND_ABOVE_CLIENT| Context.BIND_IMPORTANT))
                {
                    Log.e(LOG_TAG, "Could NOT bind to services \"" + ISOAPServerService.class.getName() + "\" or \"" + SOAPServerService.class.getName() + "\"!");
                }
            }
            
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
            
            networkStarted = true;
        }
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
        
        Capability deviceCapability = new Capability();
        deviceCapability.setUcn("urn:smpte:ucn:org.smpte.st2071:device_v1.0");
        deviceCapability.setUrls(getURLs());
        deviceCapability.setAttributes(getAttributes());
        capabilities.add(0, deviceCapability);
        
        return capabilities.toArray(new Capability[capabilities.size()]);
    }


    @Override
    public Map getAttributes()
    {
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
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);
        attributes.put("time", format.format(new Date()));
        
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
    public Capability register(String path, String action, String domain, Capability capability, Intent intent)
    throws RemoteException
    {
        // TODO Auto-generated method stub
        return null;
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
