package org.smpte.st2071.mdcd;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.smpte.st2071.identity.RN;
import org.smpte.st2071.mdcd.DiscoveryListener.DomainType;
import org.smpte.st2071.mdcp.Constants;
import org.smpte.st2071.query.QueryExpression;
import org.smpte.st2071.types.Resource;
import org.smpte.util.ListenerProcessor;
import org.xbill.DNS.Message;
import org.xbill.DNS.Name;
import org.xbill.DNS.PTRRecord;
import org.xbill.DNS.Rcode;
import org.xbill.DNS.Record;
import org.xbill.DNS.ResolverListener;
import org.xbill.DNS.Section;
import org.xbill.DNS.Type;
import org.xbill.mDNS.Browse;
import org.xbill.mDNS.MulticastDNSQuerier;
import org.xbill.mDNS.MulticastDNSService;
import org.xbill.mDNS.Resolve;
import org.xbill.mDNS.Resolve.Domain;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MDCDService extends Service
{
    public static final String LOG_TAG = Constants.LOG_TAG + "." + MDCDService.class.getSimpleName();
    
    public static final String SERVICE_TYPE_MDC = "_mdc._tcp";
    
    public static final String SERVICE_TYPE_DEVICE = "_org.smpte.st2071:device_v1._sub." + SERVICE_TYPE_MDC;
    
    public static final String SERVICE_TYPE_DEVICE_DIRECTORY = "_org.smpte.st2071:device_directory_v1._sub." + SERVICE_TYPE_MDC;
    
    public static final String SERVICE_TYPE_MEDIA_DIRECTORY = "_org.smpte.st2071:media_directory_v1._sub." + SERVICE_TYPE_MDC;
    
    public static final String _DOMAIN_UDP = "_domain._udp";

    public static final String UCN_DEVICE_v1 = "urn:smpte:ucn:org.smpte.st2071:device_v1";

    public static final String UCN_DEVICE_DIRECTORY_v1 = "urn:smpte:ucn:org.smpte.st2071:device_directory_v1";

    public static final String UCN_MEDIA_DIRECTORY_v1 = "urn:smpte:ucn:org.smpte.st2071:media_directory_v1";

    public static final String TXT_PROP_TXTVERS = "txtvers";

    public static final String TXT_PROP_RN = "rn";

    public static final String TXT_PROP_PROTOCOL = "proto";
    
    public static final String TXT_PROP_PATH = "path";

    public static final String EXTRA_CONNECTED_NETWORKS = "ConnectedNetworks";

    public static final String EXTRA_AVAILABLE_NETWORKS = "AvailableNetworks";

    
    protected class DomainBrowser implements Runnable, ResolverListener
    {
        private Browse browser;

        private Resolve resolver;

        private DomainType type;
        
        private long delay = 0;
        
        private List<String> defaultDomains = new ArrayList<String>();
        
        private Set<String> domains = new LinkedHashSet<String>();
        
        private String[] queryNames;
        
        protected DomainBrowser(DomainType type, String... defaultDomains) 
        throws IOException
        {
            this.type = type;
            
            if (defaultDomains != null)
            {
                this.defaultDomains.addAll(Arrays.asList(defaultDomains));
            }
            
            switch (type)
            {
                case BROWSE :
                    queryNames = new String[]{MulticastDNSService.DEFAULT_BROWSE_DOMAIN_NAME, MulticastDNSService.BROWSE_DOMAIN_NAME, MulticastDNSService.LEGACY_BROWSE_DOMAIN_NAME};
                    break;
                case REGISTRATION :
                    queryNames = new String[]{MulticastDNSService.DEFAULT_REGISTRATION_DOMAIN_NAME, MulticastDNSService.REGISTRATION_DOMAIN_NAME};
                    break;
                default :
                    throw new IllegalArgumentException("\"" + type + "\" is not an accepted value.");
            }
            this.browser = new Browse(queryNames);
            this.resolver = new Resolve(queryNames);
        }
        
        public Set<String> getDomains()
        {
            synchronized (this.domains)
            {
                return Collections.unmodifiableSet(this.domains);
            }
        }
        
        
        public void start()
        throws IOException
        {
            browser.start(this);
        }
        
        
        public synchronized void close() 
        throws IOException
        {
            browser.close();
            browser = null;
        }
        
        @Override
        public void run()
        {
            try
            {
                synchronized (this.domains)
                {
                    final DiscoveryListener dispatcher = discoveryListener.getDispatcher();
                    final DomainType type = this.type;
                    Domain[] domainNames = resolver.resolveDomains();
                    if (domainNames != null)
                    {
                        List<String> copy = new ArrayList<String>(this.domains);
                        
                        // Add newly discovered Domain names to list.
                        Set<String> names = new LinkedHashSet<String>();
                        
                        List<String> defaultDomains = this.defaultDomains; // avoid getfield opcode
                        for (String defaultDomain : defaultDomains)
                        {
                            if (!copy.contains(defaultDomain))
                            {
                                dispatcher.domainAdded(type, defaultDomain);
                            }
                            names.add(defaultDomain);
                        }
                        
                        for (Domain domainName : domainNames)
                        {
                            String name = domainName.getName();
                            if (!copy.contains(name))
                            {
                                dispatcher.domainAdded(type, name);
                            }
                            names.add(name);
                        }
                        copy.removeAll(names);
                        
                        // Remove domain names that no longer exist.
                        for (String name : copy)
                        {
                            if (names.remove(name))
                            {
                                dispatcher.domainRemoved(type, name);
                            }
                        }
                        
                        this.domains = names;
                    }
                }
            } catch (IOException e)
            {
                Log.i(LOG_TAG, e.getMessage(), e);
            }
            
            // Reschedule query for every 
            delay = delay > 0 ? Math.min(delay * 2, 3600) : 1;
            executor.schedule(this, delay, TimeUnit.SECONDS);
        }

        @Override
        public void receiveMessage(Object id, Message m)
        {
            if (m.getRcode() == Rcode.NOERROR)
            {
                int[] sections = new int[] {Section.ANSWER, Section.ADDITIONAL, Section.AUTHORITY};
                for (int section : sections)
                {
                    Record[] records = m.getSectionArray(section);
                    if (records != null)
                    {
                        for (Record record : records)
                        {
                            if (record.getType() == Type.PTR)
                            {
                                PTRRecord ptr = (PTRRecord) record;
                                Name name = ptr.getName();
                                for (String query : queryNames)
                                {
                                    if (name.toString().startsWith(query))
                                    {
                                        domains.add(ptr.getTarget().toString());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override
        public void handleException(Object id, Exception e)
        {
            Log.i(LOG_TAG, e.getMessage(), e);
        }

        public synchronized  boolean isClosed()
        {
            return browser == null;
        }
    }


    protected class RunnableTask implements Runnable
    {
        Runnable r;
        
        protected RunnableTask(Runnable r)
        {
            this.r = r;
        }
        
        @Override
        public void run()
        {
            try
            {
                r.run();
            } catch (Throwable t)
            {
                Log.i(LOG_TAG, t.getMessage(), t);
            }
        }
    }

    // Binder given to clients
    private final IBinder mBinder = new LocalBinder();
    
    protected ScheduledExecutorService executor;
    
    protected ListenerProcessor<DiscoveryListener> discoveryListener = new ListenerProcessor<DiscoveryListener>(DiscoveryListener.class);
    
    protected MulticastDNSQuerier querier = null;
    
    protected MulticastDNSService service = null;

    protected DomainBrowser browseDomains;

    protected DomainBrowser registrationDomains;
    
    protected Set<String> defaultDomains = new HashSet<String>();
    
    private Map<InetAddress, Set<String>> hostnamesByAddress = new HashMap<InetAddress, Set<String>>();

    private boolean networkRunning;
    
    
    public class LocalBinder extends Binder
    {
        MDCDService getService()
        {
            // Return this instance of LocalService so clients can call public methods
            return MDCDService.this;
        }
    }


    @Override
    public IBinder onBind(Intent intent)
    {
        return mBinder;
    }
    
    
    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        super.onStartCommand(intent, flags, startId);
        
        boolean canConnect = false;
        ArrayList<Integer> availableNetworks = intent.getIntegerArrayListExtra(EXTRA_AVAILABLE_NETWORKS);
        ArrayList<Integer> connectedNetworks = intent.getIntegerArrayListExtra(EXTRA_CONNECTED_NETWORKS);

        if (connectedNetworks != null)
        {
            for (int networkType : connectedNetworks)
            {
                switch (networkType)
                {
                    case ConnectivityManager.TYPE_ETHERNET:
                    case ConnectivityManager.TYPE_WIFI:
                        canConnect = true;
                        break;
                    case ConnectivityManager.TYPE_MOBILE:
                        canConnect = false;
                        break;
                    default:
                        canConnect = false;
                        break;
                }
            }
        }
        
        if (availableNetworks != null)
        {
            for (int networkType : availableNetworks)
            {
                switch (networkType)
                {
                    case ConnectivityManager.TYPE_ETHERNET:
                    case ConnectivityManager.TYPE_WIFI:
                        canConnect = true;
                        break;
                    case ConnectivityManager.TYPE_MOBILE:
                        canConnect = false;
                        break;
                    default:
                        canConnect = false;
                        break;
                }
            }
        }
        
        if (canConnect)
        {
            startupNetwork();
            return START_STICKY;
        } else
        {
            shutdownNetwork();
            return START_STICKY;
        }
    }


    @Override
    public void onCreate()
    {
        super.onCreate();
        
        try
        {
            ArrayList<Integer> available = new ArrayList<Integer>();
            ArrayList<Integer> connected = new ArrayList<Integer>();
            ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            
            if (connMgr != null)
            {
                NetworkInfo[] networkInfos = connMgr.getAllNetworkInfo();
                for (NetworkInfo networkInfo : networkInfos)
                {
                    if (networkInfo.isConnected())
                    {
                        if (networkInfo.isAvailable())
                        {
                            available.add(networkInfo.getType());
                        }
                        
                        if (networkInfo.isConnected())
                        {
                            connected.add(networkInfo.getType());
                        }
                    }
                }
            }
            
            if (connected.size() > 0 || available.size() > 0)
            {
                startupNetwork();
            } else
            {
                throw new IOException("Cannot start MDCDService -> No networks available.");
            }
        } catch (IOException e)
        {
            Log.e(LOG_TAG, e.getMessage(), e);
            RuntimeException re = new RuntimeException(e.getMessage());
            re.setStackTrace(e.getStackTrace());
            throw re;
        }
    }


    @Override
    public void onDestroy()
    {
        shutdownNetwork();
        
        try
        {
            discoveryListener.close();
        } catch (IOException e)
        {
            Log.e(LOG_TAG, e.getMessage(), e);
        }
        super.onDestroy();
    }
    
    
    protected synchronized void startupNetwork()
    {
        try
        {
            if (querier == null)
            {
                querier = new MulticastDNSQuerier(true, true);
            }
            
            if (service != null)
            {
                service = new MulticastDNSService();
                service.setQuerier(querier);
            }
        } catch (IOException e)
        {
            Log.e(LOG_TAG, e.getMessage(), e);
            RuntimeException re = new RuntimeException(e.getMessage());
            re.setStackTrace(e.getStackTrace());
            throw re;
        }

        if (executor == null || executor.isShutdown())
        {
            executor = Executors.newScheduledThreadPool(1);
            
            if (browseDomains == null || browseDomains.isClosed())
            {
                try
                {
                    browseDomains = new DomainBrowser(DomainType.BROWSE);
                } catch (IOException e)
                {
                    Log.e(LOG_TAG, e.getMessage(), e);
                    RuntimeException re = new RuntimeException(e.getMessage());
                    re.setStackTrace(e.getStackTrace());
                    throw re;
                }
            }
            
            if (registrationDomains == null || registrationDomains.isClosed())
            {
                try
                {
                    registrationDomains = new DomainBrowser(DomainType.REGISTRATION);
                } catch (IOException e)
                {
                    Log.e(LOG_TAG, e.getMessage(), e);
                    RuntimeException re = new RuntimeException(e.getMessage());
                    re.setStackTrace(e.getStackTrace());
                    throw re;
                }
            }
            
            executor.execute(new RunnableTask(browseDomains));
            executor.execute(new RunnableTask(registrationDomains));
        }
        
        networkRunning = true;
    }


    protected void shutdownNetwork()
    {
        if (executor != null)
        {
            executor.shutdownNow();
            executor = null;
        }
        
        if (browseDomains != null)
        {
            try
            {
                browseDomains.close();
            } catch (IOException e)
            {
                Log.e(LOG_TAG, e.getMessage());
            }
            browseDomains = null;
        }

        if (registrationDomains != null)
        {
            try
            {
                registrationDomains.close();
            } catch (IOException e)
            {
                Log.e(LOG_TAG, e.getMessage());
            }
            registrationDomains = null;
        }

        if (querier != null)
        {
            try
            {
                querier.close();
                querier = null;
            } catch (IOException e)
            {
                Log.e(LOG_TAG, e.getMessage(), e);
            }
        }
        
        if (service != null)
        {
            try
            {
                service.close();
                service = null;
            } catch (IOException e)
            {
                Log.e(LOG_TAG, e.getMessage(), e);
            }
        }
        
        networkRunning = true;
    }


    /**
     * Returns the hostnames associated to this Discovery Service and the network interfaces it represents.
     * 
     * @return The hostnames associated to this Discovery Service and the network interfaces it represents
     */
    public Set<String> getHostNames()
    {
        Set<String> set = new HashSet<String>();
        
        synchronized (hostnamesByAddress)
        {
            for (Map.Entry<InetAddress, Set<String>> entry : hostnamesByAddress.entrySet())
            {
                for (String hostname : entry.getValue())
                {
                    set.add(hostname);
                }
            }
        }
        
        return set;
    }
    
    
    /**
     * Returns the hostnames associated to the IP address.
     * 
     * @param address The IP address
     * 
     * @return The hostnames associated to the Ip address
     */
    public Set<String> getHostNamesForAddress(InetAddress address)
    {
        synchronized (hostnamesByAddress)
        {
            return this.hostnamesByAddress.get(address);
        }
    }
    
    
    /**
     * Returns the set of browse domains available on the network, via Unicast DNS and Multicast DNS.
     * The returned Set is concurrent, meaning that new browse domains are added as they are discovered.
     * 
     * @return the concurrent set of browse domains available on the network
     */
    public Set<String> getBrowseDomains()
    {
        return browseDomains.getDomains();
    }
    
    
    /**
     * Returns the set of registration domains available on the network, via Unicast DNS and Multicast DNS.
     * The returned Set is concurrent, meaning that new registration domains are added as they are discovered.
     * 
     * @return the concurrent set of registration domains available on the network
     */
    public Set<String> getRegistrationDomains()
    {
        return registrationDomains.getDomains();
    }
    
    
    /**
     * Searches the DNS infrastructure for the Resource(s) that match the namespace RN and
     * Query Expression.  This method blocks until the browse process is complete. 
     * 
     * @param rn The namespace RN narrowing the Resources to a specific namespace hierarchy.
     * @param query The Query Expression limiting the Resources
     * @return The Resource(s) that match the namespace RN and Query Expression by domain.
     * @throws DiscoveryException 
     */
    public List<Resource> listResources(RN rn, QueryExpression query)
    throws DiscoveryException
    {
        if (networkRunning)
        {
            return null;
        } else
        {
            throw new DiscoveryException("Network unavailable");
        }
    }
    
    
    /**
     * Asynchronously Browses the DNS infrastructure for the Resource(s) that match the namespace RN and
     * Query Expression.  Resources that are found are sent to the specified Discovery Listener, if the 
     * Discover Listener is not specified, events are sent to all Discovery Listeners registered to this 
     * discovery Service instance.
     *  
     * @param localAddress The local interface to browse.  If null or 0.0.0.0, all local interfaces are browsed.
     * @param rn The namespace RN narrowing the Resources to a specific namespace hierarchy.
     * @param query The Query Expression limiting the Resources
     * @param intent The Intent that is broadcast to broadcast events to, if null, events will be broadcast to all Discovery
     *                 Listeners registered to this Discovery Service instance.
     */
    public void browse(RN rn, QueryExpression query, DiscoveryListener listener)
    throws DiscoveryException
    {
        
    }
    
    
    /**
     * Registers the specified Resource for Discovery.
     * 
     * @param resource The Resource to register.
     */
    public void registerResource(Resource resource)
    throws DiscoveryException
    {
        if (networkRunning)
        {
        } else
        {
            throw new DiscoveryException("Network unavailable");
        }
    }
    
    
    /**
     * Unregister a Resource from the Discovery system.
     * 
     * @param instance The Resource to unregister. 
     */
    public void unregisterResource(Resource resource)
    throws DiscoveryException
    {
        if (networkRunning)
        {
        } else
        {
            throw new DiscoveryException("Network unavailable");
        }
    }
}
