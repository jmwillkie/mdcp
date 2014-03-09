package org.smpte.st2071.types;

import java.util.Date;
import java.util.Map;

import org.smpte.st2071.identity.RN;
import org.smpte.st2071.identity.URL;
import org.smpte.st2071.query.Queryable;


public interface Resource extends Queryable
{
    public static enum ResourceType
    {
        DEVICE, SERVICE;
    };
    
    
    public ResourceType getResourceType();
    
    
    public RN getRN();
    
    
    public URL[] getURLs();
    
    
    public Capability[] getCapabilities();
    
    
    public Map<String, Object> getAttributes();
    
    
    public Date getValidTill();
}
