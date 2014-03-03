package org.smpte.st2071.mdcd;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;

import com.sun.istack.internal.logging.Logger;

import net.posick.net.NetworkTopology;

public class NetworkTopologyFactory
{
    private final static Logger log = Logger.getLogger(NetworkTopologyFactory.class);
    
    protected final static String DEFAULT_NETWORK_TOPOLOGY = "net.posick.net.sunjre.NetworkTopologyImpl";
    
    
    @SuppressWarnings("unchecked")
    public static NetworkTopology newNetworkTopology(boolean useIPv6, boolean useSiteLocal, boolean useVirtual, boolean useLoopback)
    throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
    {
        Map<String, String> properties = loadConfiguration();
        String javaVendor = System.getProperty("java.vendor");
        
        String className = properties.get(javaVendor);
        if (className == null || className.length() == 0)
        {
            className = DEFAULT_NETWORK_TOPOLOGY;
        }
        
        Class<NetworkTopology> clazz = (Class<NetworkTopology>) Class.forName(className);
        Constructor<NetworkTopology> constructor = clazz.getConstructor(Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE);
        return constructor.newInstance(useIPv6, useSiteLocal, useVirtual, useLoopback);
    }
    
    
    protected static Map<String, String> loadConfiguration()
    {
        Map<String, String> map = new HashMap<>();
        Properties properties = new Properties();
        
        Class<NetworkTopologyFactory> clazz = NetworkTopologyFactory.class;
        java.net.URL url = clazz.getResource(clazz.getSimpleName());
        
        if (url != null && url.getProtocol().equalsIgnoreCase("file"))
        {
            try
            {
                File file = new File(url.toURI());
                properties.load(new FileReader(file));
            } catch (IOException e)
            {
                log.log(Level.WARNING, "Error opening configuration file \"" + url + "\" - " + e.getMessage(), e);
            } catch (URISyntaxException e)
            {
                log.log(Level.WARNING, "Error opening configuration file \"" + url + "\" - " + e.getMessage(), e);
            }
        } else
        {
            try
            {
                properties.load(url.openStream());
            } catch (IOException e)
            {
                log.log(Level.WARNING, "Error opening configuration URL \"" + url + "\" - " + e.getMessage(), e);
            }
        }
        
        for (Map.Entry<Object, Object> entry : properties.entrySet())
        {
            Object key = entry.getKey();
            Object value = entry.getValue();
            
            if (key != null)
            {
                map.put(key.toString(), value == null ? null : value.toString());
            }
        }
        
        return map;
    }
}
