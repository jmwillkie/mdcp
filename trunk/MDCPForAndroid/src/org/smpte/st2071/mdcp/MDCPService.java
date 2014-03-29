package org.smpte.st2071.mdcp;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import net.posick.ws.soap.ISOAPServerService;
import net.posick.ws.soap.SOAPServerService;
import net.posick.ws.xml.Name;
import net.posick.ws.xml.Namespace;
import net.posick.ws.xml.XmlElement;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentFilter.MalformedMimeTypeException;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class MDCPService extends Service implements IMDCPService
{
    public static final String LOG_TAG = Constants.LOG_TAG;// + "." + MDCPService.class.getSimpleName();
    
    
    public class MDCPServiceBinder extends Binder
    {
        public MDCPService getService()
        {
            // Return this instance of LocalService so clients can call public methods
            return MDCPService.this;
        }
    }
        
    private final IMDCPService.Stub mBinder = new IMDCPService.Stub()
    {
        @Override
        public Intent lookup(String pattern, String action)
        throws RemoteException
        {
            Log.i(LOG_TAG, getClass().getSimpleName() + ".lookup(\"" + pattern + "\", \"" + action + "\")");
            return MDCPService.this.lookup(pattern, action);
        }

        @Override
        public Intent register(String pattern, String action, Intent intent)
        throws RemoteException
        {
            Log.i(LOG_TAG, getClass().getSimpleName() + ".register(\"" + pattern + "\", \"" + action + "\", \"" + intent + "\")");
            return MDCPService.this.register(pattern, action, intent);
        }

        @Override
        public Intent unregister(String pattern, String action)
        throws RemoteException
        {
            Log.i(LOG_TAG, getClass().getSimpleName() + ".unregister(\"" + pattern + "\", \"" + action + "\")");
            return MDCPService.this.unregister(pattern, action);
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
                
                try
                {
                    Bundle bundle = getResultExtras(true);
                    setResultExtras(bundle);
                    
                    if (Constants.INTENT_GET_UDN.equals(action))
                    {
                        bundle.putString(net.posick.ws.Constants.EXTRA_SOAP_ACTION_RESPONSE, Constants.SOAP_RESPONSE_UDN);
                        response = getUDN();
                    } else if (Constants.INTENT_GET_ONLINE.equals(action))
                    {
                        bundle.putString(net.posick.ws.Constants.EXTRA_SOAP_ACTION_RESPONSE, Constants.SOAP_RESPONSE_ONLINE);
                        response = getOnline();
                    } else if (Constants.INTENT_GET_NAME.equals(action))
                    {
                        bundle.putString(net.posick.ws.Constants.EXTRA_SOAP_ACTION_RESPONSE, Constants.SOAP_RESPONSE_NAME);
                        response = getName();
                    } else if (Constants.INTENT_GET_CAPABILITIES.equals(action))
                    {
                        bundle.putString(net.posick.ws.Constants.EXTRA_SOAP_ACTION_RESPONSE, Constants.SOAP_RESPONSE_CAPABILITIES);
                        response = getCapabilities();
                    } else if (Constants.INTENT_GET_ATTRIBUTES.equals(action))
                    {
                        bundle.putString(net.posick.ws.Constants.EXTRA_SOAP_ACTION_RESPONSE, Constants.SOAP_RESPONSE_ATTRIBUTES);
                        response = getAttributes();
                    } else if (Constants.INTENT_GET_URLS.equals(action))
                    {
                        bundle.putString(net.posick.ws.Constants.EXTRA_SOAP_ACTION_RESPONSE, Constants.SOAP_RESPONSE_URLS);
                        response = getURLs();
                    }
                    
                    if (response != null)
                    {
                        setResultCode(Activity.RESULT_OK);
                        setResultData(response.toString());
                        bundle.putSerializable(net.posick.ws.Constants.EXTRA_RESPONSE, response);
                    }
                } catch (Exception e)
                {
                    intent.putExtra(net.posick.ws.Constants.EXTRA_SOAP_FAULT, e);
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
            Log.i(LOG_TAG, getClass().getSimpleName() + ".onServiceConnected(\"" + className.flattenToString() + "\") sucessfully casted IBinder to \"" + ISOAPServerService.class.getName() + "\".");
            
            try
            {
                final String[] PATHS = new String[]
                {
                     Constants.PATH_UDN,
                     Constants.PATH_ONLINE,
                     Constants.PATH_NAME,
                     Constants.PATH_CAPABILITIES,
                     Constants.PATH_ATTRIBUTES,
                     Constants.PATH_URLS
                };
                
                final String[] SOAP_ACTIONS = new String[]
                {
                     "",//Constants.SOAP_ACTION_UDN,
                     "",//Constants.SOAP_ACTION_ONLINE,
                     "",//Constants.SOAP_ACTION_NAME,
                     "",//Constants.SOAP_ACTION_CAPABILITIES,
                     "",//Constants.SOAP_ACTION_ATTRIBUTES,
                     ""//Constants.SOAP_ACTION_URLS
                };
                
                final String[] ACTIONS = new String[]
                {
                     Constants.INTENT_GET_UDN,
                     Constants.INTENT_GET_ONLINE,
                     Constants.INTENT_GET_NAME,
                     Constants.INTENT_GET_CAPABILITIES,
                     Constants.INTENT_GET_ATTRIBUTES,
                     Constants.INTENT_GET_URLS
                };
                
                for (int index = 0; index < PATHS.length; index++)
                {
                    Intent intent = new Intent(ACTIONS[index]).addCategory(net.posick.ws.Constants.CATEGORY_ENDPOINT_CALLBACK);
                    
                    soapService.register(PATHS[index], SOAP_ACTIONS[index], intent);
//                    Log.i(LOG_TAG, "Endpoint: path=\"" + PATHS[index] + "\", action=\"" + SOAP_ACTIONS[index] + "\" registered to Intent Action \"" + ACTIONS[index] + "\" [" + intent + "]");
                }
                
                IntentFilter filter = new IntentFilter();
                try
                {
                    filter.addDataType(net.posick.ws.Constants.MEDIA_TYPE_SOAP);
                    filter.addCategory("net.posick.ws.ENDPOINT_CALLBACK");
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
    

    public MDCPService()
    {
        super();
    }
    
    
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
        
        Log.i(LOG_TAG, "Binding to Service \"" + ISOAPServerService.class.getName() + "\".");
        if (!bindService(new Intent(ISOAPServerService.class.getName()), soapServiceConnection, Context.BIND_AUTO_CREATE | Context.BIND_ABOVE_CLIENT| Context.BIND_IMPORTANT))
        {
            Log.i(LOG_TAG, "Binding to Service \"" + SOAPServerService.class.getName() + "\".");
            if (!bindService(new Intent(ISOAPServerService.class.getName()), soapServiceConnection, Context.BIND_AUTO_CREATE | Context.BIND_ABOVE_CLIENT| Context.BIND_IMPORTANT))
            {
                Log.e(LOG_TAG, "Could NOT bind to services \"" + ISOAPServerService.class.getName() + "\" or \"" + SOAPServerService.class.getName() + "\"!");
            }
        }
    }
    
    
    @Override
    public void onDestroy()
    {
        Log.i(LOG_TAG, getClass().getSimpleName() + ".onCreate()");
        
        unbindService(soapServiceConnection);
        
        super.onDestroy();
    }
    
    
    @Override
    public boolean onUnbind(Intent intent)
    {
        Log.i(LOG_TAG, getClass().getSimpleName() + ".onUnbind(\"" + intent + "\")");
        return super.onUnbind(intent);
    }
    
    
    @Override
    public void onStart(Intent intent, int startId)
    {
    }
    
    
    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        return START_NOT_STICKY;
    }

    
    public Intent lookup(String pattern, String action)
    {
        Log.i(LOG_TAG, getClass().getSimpleName() + ".lookup(\"" + pattern + "\", \"" + action + "\")");
        
        Intent intent = null;
        
        ISOAPServerService soapService = this.soapService;
        if (soapService != null)
        {
            try
            {
                intent = soapService.lookup(pattern, action);
            } catch (RemoteException e)
            {
                Log.e(LOG_TAG, "Error executing lookup on SOAPServerService - " + e.getMessage(), e);
            }
        }
        
        return intent;
    }


    public Intent register(String pattern, String action, Intent intent)
    {
        Log.i(LOG_TAG, getClass().getSimpleName() + ".register(\"" + pattern + "\", \"" + action + "\")");
        
        ISOAPServerService soapService = this.soapService;
        if (soapService != null)
        {
            try
            {
                return soapService.register(pattern, action, intent);
            } catch (RemoteException e)
            {
                Log.e(LOG_TAG, "Error executing lookup on SOAPServerService - " + e.getMessage(), e);
                throw new RuntimeException(e.getMessage());
            }
        } else
        {
            throw new RuntimeException("SOAPServerService unavailable!");
        }
    }


    public Intent unregister(String pattern, String action)
    {
        Log.i(LOG_TAG, getClass().getSimpleName() + ".unregister(\"" + pattern + "\", \"" + action + "\")");
        
        ISOAPServerService soapService = this.soapService;
        if (soapService != null)
        {
            try
            {
                return soapService.unregister(pattern, action);
            } catch (RemoteException e)
            {
                Log.e(LOG_TAG, "Error executing lookup on SOAPServerService - " + e.getMessage(), e);
                throw new RuntimeException(e.getMessage());
            }
        } else
        {
            throw new RuntimeException("SOAPServerService unavailable!");
        }
    }
    

    protected XmlElement getUDN()
    {
        Log.i(LOG_TAG, getClass().getSimpleName() + ".getUDN()");
        
        XmlElement udnResponse = new XmlElement(new Name("device:getUDNResponse")).setNamespace(new Namespace("device", "http://www.smpte-ra.org/schemas/st2071/2014/device"));
        XmlElement udn = new XmlElement(new Name("identity:UDN")).setNamespace(new Namespace("identity", "http://www.smpte-ra.org/schemas/st2071/2014/identity"));
        // TODO: Implement UDN value
        udn.setValue("urn:smpte:udn:net.posick.test:test=1");
        udnResponse.addChild(udn);
        
        return udnResponse;
    }
    

    protected XmlElement getOnline()
    {
        Log.i(LOG_TAG, getClass().getSimpleName() + ".getOnline()");
        
        XmlElement onlineResponse = new XmlElement(new Name("device:getOnlineResponse")).setNamespace(new Namespace("device", "http://www.smpte-ra.org/schemas/st2071/2014/device"));
        XmlElement online = new XmlElement(new Name("types:Boolean")).setNamespace(new Namespace("types", "http://www.smpte-ra.org/schemas/st2071/2014/types"));
        
        online.setValue("true");
        onlineResponse.addChild(online);
        
        return onlineResponse;
    }
    

    protected XmlElement getName()
    {
        Log.i(LOG_TAG, getClass().getSimpleName() + ".getName()");
        
        XmlElement nameResponse = new XmlElement(new Name("device:getNameResponse")).setNamespace(new Namespace("device", "http://www.smpte-ra.org/schemas/st2071/2014/device"));
        XmlElement name = new XmlElement(new Name("types:String")).setNamespace(new Namespace("types", "http://www.smpte-ra.org/schemas/st2071/2014/types"));
        // TODO: Implement Name value
        name.setValue("Test");
        nameResponse.addChild(name);
        
        return nameResponse;
    }
    

    protected XmlElement getCapabilities()
    {
        Log.i(LOG_TAG, getClass().getSimpleName() + ".getCapabilities()");
        
        // TODO Auto-generated method stub
        return null;
    }
    

    protected XmlElement getAttributes()
    {
        Log.i(LOG_TAG, getClass().getSimpleName() + ".getAttributes()");
        
        // TODO Auto-generated method stub
        return null;
    }
    

    protected XmlElement getURLs()
    {
        Log.i(LOG_TAG, getClass().getSimpleName() + ".getURLs()");
        
        // TODO Auto-generated method stub
        return null;
    }
}
