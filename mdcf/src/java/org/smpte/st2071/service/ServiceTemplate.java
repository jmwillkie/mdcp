package org.smpte.st2071.service;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.smpte.st2071.identity.USN;
import org.smpte.st2071.types.Capability;
import org.smpte.st2071.types.Utils;
import org.smpte_ra.schemas.st2071._2014.types.Capabilities;

public class ServiceTemplate implements Serializable
{
    private static final long serialVersionUID = 201403091517L;

    protected USN usn;
    
    protected Map<String, Object> attributes = new HashMap<String, Object>();
    
    protected List<Capability> capabilities = new ArrayList<Capability>();

    
    public ServiceTemplate(org.smpte_ra.schemas.st2071._2014.service.ServiceTemplate service)
    throws ParseException
    {
        this.usn = new USN(service.getUSN());
        Capabilities capabilities = service.getCapabilities();
        if (capabilities != null)
        {
            List<org.smpte_ra.schemas.st2071._2014.types.Capability> values = capabilities.getCapability();
            if (values != null)
            {
                for (org.smpte_ra.schemas.st2071._2014.types.Capability value : values)
                {
                    this.capabilities.add(new Capability(value));
                }
            }
        }
        
        Map<String, Object> map = Utils.mapToJavaMap(service.getAttributes());
        if (map != null)
        {
            attributes.clear();
            attributes.putAll(map);
        }
    }


    public USN getUSN()
    {
        return usn;
    }


    public Map<String, Object> getAttributes()
    {
        return attributes;
    }


    public Capability[] getCapabilities()
    {
        return capabilities.toArray(new Capability[capabilities.size()]);
    }
    
    
    public boolean equals(Object obj)
    {
        // TODO: Implement
        return false;
    }
    
    
    public boolean matches(ServiceTemplate template)
    {
        // TODO: Implement
        return false;
    }
}
