package org.smpte.st2071.service;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.smpte.st2071.identity.URL;
import org.smpte.st2071.identity.USN;
import org.smpte.st2071.types.Capability;
import org.smpte.st2071.types.Resource;

public class ServiceInformation implements Resource, Serializable
{
    private static final long serialVersionUID = 201402051618L;

    private USN usn;
    
    private Map<String, Object> attributes;
    
    private Capability[] capabilities;

    private Date created;

    private Date validTill;

    private String createdBy;
    
    private ServiceTemplate template;
    
    private ServiceState state;

    private String string;


    public ServiceInformation()
    {
        super();
    }


    public USN getRN()
    {
        return usn;
    }
    
    
    public void setRN(USN usn)
    {
        this.usn = usn;
    }
    
    
    public Date getCreated()
    {
        return created;
    }


    public void setCreated(Date created)
    {
        this.created = created;
    }


    public String getCreatedBy()
    {
        return createdBy;
    }


    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }


    public ServiceTemplate getTemplate()
    {
        return template;
    }


    public void setTemplate(ServiceTemplate template)
    {
        this.template = template;
    }


    public ServiceState getState()
    {
        return state;
    }


    public void setState(ServiceState state)
    {
        this.state = state;
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


    public ResourceType getResourceType()
    {
        return ResourceType.SERVICE;
    }


    public URL[] getURLs()
    {
        return null;
    }
    
    
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        } else if (obj instanceof ServiceInformation)
        {
            ServiceInformation that = (ServiceInformation) obj;
            
            return this.usn.equals(that.usn) && this.createdBy.equals(that.createdBy) && this.state == that.state &&
                   this.attributes.equals(that.attributes) && Arrays.equals(this.capabilities, that.capabilities) &&
                   this.created.equals(that.created) && this.template.equals(that.template);
        }
        
        return false;
    }
    
    
    @Override
    public String toString()
    {
        if (string == null)
        {
            StringBuilder b = new StringBuilder(50);
            b.append("Service {\n");
            b.append("\tusn = ").append(usn).append(";\n");
            b.append("\tstate = ").append(state).append(";\n");
            b.append("\tcreated = ").append(created).append(";\n");
            b.append("\tcreatedBy = ").append(createdBy).append(";\n");
            b.append("\tattributes = ").append(attributes.toString()).append(";\n");
            b.append("\tcapabilities = ").append(Arrays.toString(capabilities)).append(";\n");
            b.append("\ttemplate = ").append(template).append(";\n");
            b.append("\tvalidTill = ").append(validTill).append(";\n");
            b.append("}");
            string = b.toString();
        }
        
        return string;
    }
}
