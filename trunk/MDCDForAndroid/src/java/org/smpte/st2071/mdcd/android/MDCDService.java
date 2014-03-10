package org.smpte.st2071.mdcd.android;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Set;

import org.smpte.st2071.mdcd.DiscoveryException;
import org.smpte.st2071.mdcd.DiscoveryListener;
import org.smpte.st2071.mdcd.DiscoveryService;
import org.smpte.st2071.types.Resource;
import org.smpte_ra.schemas.st2071._2014.query.QueryExpression;
import org.xbill.mDNS.MulticastDNSService;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.nsd.NsdManager;
import android.os.IBinder;

public class MDCDService extends Service implements DiscoveryService
{
    NsdManager discoverManager;
    
    MulticastDNSService mdnsService;
    
    
    protected ArrayList<String> findBrowseDomains()
    {
        return null;
    }
    
    
    @Override
    public IBinder onBind(Intent intent)
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    
    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        // TODO Auto-generated method stub
        super.onConfigurationChanged(newConfig);
    }
    
    
    @Override
    public void onCreate()
    {
        super.onCreate();
        
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
        // TODO Auto-generated method stub
        super.onDestroy();
    }
    
    
    @Override
    public void onLowMemory()
    {
        // TODO Auto-generated method stub
        super.onLowMemory();
    }
    
    
    @Override
    public void onRebind(Intent intent)
    {
        // TODO Auto-generated method stub
        super.onRebind(intent);
    }
    
    
    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        // TODO Auto-generated method stub
        return super.onStartCommand(intent, flags, startId);
    }
    
    
    @Override
    public boolean onUnbind(Intent intent)
    {
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
