package org.smpte.st2071.mdcd.android;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Set;

import javax.xml.ws.Endpoint;

import org.smpte.st2071.mdcd.DiscoveryException;
import org.smpte.st2071.mdcd.DiscoveryListener;
import org.smpte.st2071.mdcd.DiscoveryService;
import org.smpte.st2071.mdcd.android.test.Hello;
import org.smpte.st2071.mdcd.android.test.HelloImpl;
import org.smpte.st2071.types.Resource;
import org.smpte_ra.schemas.st2071._2014.query.QueryExpression;
import org.xbill.mDNS.MulticastDNSService;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.util.Log;

public class MDCDService extends Service implements DiscoveryService
{
    MulticastDNSService mdnsService;
    
    
    protected ArrayList<String> findBrowseDomains()
    {
        return null;
    }
    
    
    @Override
    public IBinder onBind(Intent intent)
    {
        Log.i(Constants.LOG_TAG, getClass().getSimpleName() + ".onBind()");
        // TODO Auto-generated method stub
        return null;
    }
    
    
    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        Log.i(Constants.LOG_TAG, getClass().getSimpleName() + ".onConfigurationChanged()");
        // TODO Auto-generated method stub
        super.onConfigurationChanged(newConfig);
    }
    
    protected Hello hello;
    protected Endpoint helloEndpoint;
    
    @Override
    public void onCreate()
    {
        Log.i(Constants.LOG_TAG, getClass().getSimpleName() + ".onCreate()");
        super.onCreate();
        
        hello = new HelloImpl();
        helloEndpoint = Endpoint.create(hello);
        helloEndpoint.publish("http://0.0.0.0:9000/Hello/sayHello");
        
        try
        {
            mdnsService = new MulticastDNSService();
        } catch (IOException e)
        {
            
        }
    }
    
    
    @Override
    public void onDestroy()
    {
        Log.i(Constants.LOG_TAG, getClass().getSimpleName() + ".onDestroy()");
        // TODO Auto-generated method stub
        super.onDestroy();
    }
    
    
    @Override
    public void onLowMemory()
    {
        Log.i(Constants.LOG_TAG, getClass().getSimpleName() + ".onLowMemory()");
        // TODO Auto-generated method stub
        super.onLowMemory();
    }
    
    
    @Override
    public void onRebind(Intent intent)
    {
        Log.i(Constants.LOG_TAG, getClass().getSimpleName() + ".onRebind()");
        // TODO Auto-generated method stub
        super.onRebind(intent);
    }
    
    
    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        Log.i(Constants.LOG_TAG, getClass().getSimpleName() + ".onStartCommand()");
        // TODO Auto-generated method stub
        return super.onStartCommand(intent, flags, startId);
    }
    
    
    @Override
    public boolean onUnbind(Intent intent)
    {
        Log.i(Constants.LOG_TAG, getClass().getSimpleName() + ".onUnbind()");
        // TODO Auto-generated method stub
        return super.onUnbind(intent);
    }


    @Override
    public void browse(String rn, QueryExpression query, DiscoveryListener listener)
    throws DiscoveryException
    {
        // TODO Auto-generated method stub
        
    }


    @Override
    public String[] getBrowseDomains()
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public Set<String> getHostNames()
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public Set<String> getHostNamesForAddress(InetAddress address)
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public String[] getRegistrationDomains()
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public Resource[] listResources(String rn, QueryExpression query)
    throws DiscoveryException
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public void registerResource(Resource resource)
    throws DiscoveryException
    {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void unregisterResource(Resource resource)
    throws DiscoveryException
    {
        // TODO Auto-generated method stub
        
    }
}
