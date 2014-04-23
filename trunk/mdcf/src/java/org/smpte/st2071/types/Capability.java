package org.smpte.st2071.types;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.smpte.st2071.identity.UCN;
import org.smpte.st2071.identity.URL;
import org.smpte_ra.schemas.st2071._2014.identity.URLs;

public class Capability
{
    protected UCN ucn;
    
    protected List<String> keys = new ArrayList<String>();
    
    protected Map<String, Object> attributes = new HashMap<String, Object>();
    
    protected List<URL> urls = new ArrayList<URL>();

    
    public Capability(org.smpte_ra.schemas.st2071._2014.types.Capability capability)
    throws ParseException
    {
        this.ucn = new UCN(capability.getUCN());
        URLs urls = capability.getURLs();
        if (urls != null)
        {
            List<String> values = urls.getURL();
            if (values != null)
            {
                for (String value : values)
                {
                    this.urls.add(new URL(value));
                }
            }
        }
        
        Map<String, Object> map = Utils.mapToJavaMap(capability.getAttributes());
        if (map != null)
        {
            attributes.clear();
            attributes.putAll(map);
        }
    }


    public UCN getUCN()
    {
        return ucn;
    }


    public Map<String, Object> getAttributes()
    {
        return attributes;
    }
    
    
    public String[] getKeys()
    {
        return keys.toArray(new String[keys.size()]);
    }


    @SuppressWarnings("unchecked")
    public <T> T getAttribute(String key)
    {
        return (T) attributes.get(key);
    }


    public URL[] getUrls()
    {
        return urls.toArray(new URL[urls.size()]);
    }
}
