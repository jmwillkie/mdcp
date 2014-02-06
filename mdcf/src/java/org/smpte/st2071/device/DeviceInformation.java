package org.smpte.st2071.device;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.smpte.st2071.identity.UDN;
import org.smpte.st2071.identity.URL;
import org.smpte.st2071.types.Capability;
import org.smpte.st2071.types.Resource;

public class DeviceInformation implements Resource, Serializable
{
    private static final long serialVersionUID = 201402051618L;

    private UDN udn;
    
    private String name;

    private URL[] urls;

    private Map<String, Object> attributes;
    
    private Capability[] capabilities;

    private boolean online;
    
    private Date validTill;

    private String string;


    public DeviceInformation()
    {
        super();
    }


    public UDN getRN()
    {
        return udn;
    }
    
    
    public void setRN(UDN udn)
    {
        this.udn = udn;
    }


    public ResourceType getResourceType()
    {
        return ResourceType.DEVICE;
    }
    
    
    public URL[] getURLs()
    {
        return urls;
    }
    
    
    public void setURLs(URL[] urls)
    {
        this.urls = urls;
    }
    
    
    public String getName()
    {
        return name;
    }
    
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    
    public boolean isOnline()
    {
        return online;
    }
    
    
    public void setOnline(boolean online)
    {
        this.online = online;
    }
    
    
    public Map<String, Object> getAttributes()
    {
        return attributes;
    }
    
    
    public void setAttributes(Map<String, Object> attributes)
    {
        this.attributes.clear();
        this.attributes.putAll(attributes);
    }
    
    
    public Capability[] getCapabilities()
    {
        return capabilities;
    }
    
    
    public void setCapabilities(Capability[] capabilities)
    {
        this.capabilities = capabilities;
    }
    
    
    public Date getValidTill()
    {
        return validTill;
    }
    
    
    public void setValidTill(Date validTill)
    {
        this.validTill = validTill;
    }
    
    
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        } else if (obj instanceof DeviceInformation)
        {
            DeviceInformation that = (DeviceInformation) obj;
            
            return this.udn.equals(that.udn) && this.name.equals(that.name) && this.online == that.online &&
                   this.attributes.equals(that.attributes) && Arrays.equals(this.capabilities, that.capabilities) &&
                   Arrays.equals(this.urls, that.urls);
        }
        
        return false;
    }
    
    
    @Override
    public String toString()
    {
        if (string == null)
        {
            StringBuilder b = new StringBuilder(50);
            b.append("Device {\n");
            b.append("\tudn = ").append(udn).append(";\n");
            b.append("\tname = ").append(name).append(";\n");
            b.append("\tonline = ").append(online).append(";\n");
            b.append("\turls = ").append(Arrays.toString(urls)).append(";\n");
            b.append("\tattributes = ").append(attributes.toString()).append(";\n");
            b.append("\tcapabilities = ").append(Arrays.toString(capabilities)).append(";\n");
            b.append("\tvalidTill = ").append(validTill).append(";\n");
            b.append("}");
            string = b.toString();
        }
        
        return string;
    }
}
