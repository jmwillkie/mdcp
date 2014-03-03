package org.smpte.st2071.mdcd;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Map;
import java.util.Set;

import javax.naming.NamingException;

import org.smpte.st2071.types.Resource;
import org.smpte_ra.schemas.st2071._2014.query.QueryExpression;

/**
 * @author Steve Posick
 */
public interface DiscoveryService
{
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
    
    
    /**
     * Sets the configuration for the Discovery Service.
     * 
     * @param properties The configuration map
     */
    public void setConfiguration(Map<String, String> properties);
    
    
    /**
     * Gets the configuration for the Discovery Service.
     * 
     * @return The configuration map
     */
    public Map<String, String> getConfiguration();
    
    
    /**
     * Returns the hostnames associated to this Discovery Service and the network interfaces it represents.
     * 
     * @return The hostnames associated to this Discovery Service and the network interfaces it represents
     */
    public Set<String> getHostNames();
    
    
    /**
     * Returns the hostnames associated to the IP address.
     * 
     * @param address The IP address
     * 
     * @return The hostnames associated to the Ip address
     */
    public Set<String> getHostNamesForAddress(InetAddress address);
    
    
    /**
     * Registers a Discovery Listener
     * 
     * @param listener The Discovery Listener
     */
    public void registerDiscoveryListener(DiscoveryListener listener);
    
    
    /**
     * Unregisters a Discovery Listener
     * 
     * @param listener The Discovery Listener
     */
    public void unregisterDiscoveryListener(DiscoveryListener listener);
    
    
    /**
     * Returns the set of browse domains available on the network, via Unicast DNS and Multicast DNS.
     * The returned Set is concurrent, meaning that new browse domains are added as they are discovered.
     * 
     * @return the concurrent set of browse domains available on the network
     */
    public String[] getBrowseDomains();
    
    
    /**
     * Returns the set of registration domains available on the network, via Unicast DNS and Multicast DNS.
     * The returned Set is concurrent, meaning that new registration domains are added as they are discovered.
     * 
     * @return the concurrent set of registration domains available on the network
     */
    public String[] getRegistrationDomains();
    
    
    /**
     * Searches the DNS infrastructure for the Resource(s) that match the namespace RN and
     * Query Expression.  This method blocks until the browse process is complete. 
     * 
     * @param localAddress The local interface to browse.  If null or 0.0.0.0, all local interfaces are browsed.
     * @param rn The namespace RN narrowing the Resources to a specific namespace hierarchy.
     * @param query The Query Expression limiting the Resources
     * @return The Resource(s) that match the namespace RN and Query Expression by domain.
     */
    public Resource[] listResources(String rn, QueryExpression query)
    throws NamingException;
    
    
    /**
     * Asynchronously Browses the DNS infrastructure for the Resource(s) that match the namespace RN and
     * Query Expression.  Resources that are found are sent to the specified Discovery Listener, if the 
     * Discover Listener is not specified, events are sent to all Discovery Listeners registered to this 
     * discovery Service instance.
     *  
     * @param localAddress The local interface to browse.  If null or 0.0.0.0, all local interfaces are browsed.
     * @param rn The namespace RN narrowing the Resources to a specific namespace hierarchy.
     * @param query The Query Expression limiting the Resources
     * @param listener The Listener to broadcast events to, if null, events will be broadcast to all Discovery
     *                 Listeners registered to this Discovery Service instance.
     */
    public void browse(String rn, QueryExpression query, DiscoveryListener listener)
    throws NamingException;
    
    
    /**
     * Registers the specified Resource for Discovery.
     * 
     * @param resource The Resource to register.
     */
    public void registerResource(Resource resource)
    throws NamingException;
    
    
    /**
     * Unregister a Resource from the Discovery system.
     * 
     * @param instance The Resource to unregister. 
     */
    public void unregisterResource(Resource resource)
    throws NamingException;
    
    
    /**
     * Starts the Discovery Service and its time processes.
     * 
     * @throws Exception if the Discover Service cannot be started for any reason.
     */
    public void start()
    throws Exception;
    
    
    /**
     * Stops the Discovery Service and its time processes, freeing resources.
     */
    public void stop();
}
