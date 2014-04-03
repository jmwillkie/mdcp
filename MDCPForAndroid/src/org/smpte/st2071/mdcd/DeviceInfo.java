package org.smpte.st2071.mdcd;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.LinkedHashSet;
import java.util.Set;

public class DeviceInfo implements Serializable
{
    private static final long serialVersionUID = 201404031232L;
    
    private String id;
    
    private String name;
    
    private String hostname;
    
    private Set<String> domains = new LinkedHashSet<String>();

    private Set<InetAddress> dns;
    
    
    public DeviceInfo()
    {
        super();
    }

    
    public DeviceInfo(String id, String name, String hostname, String... domains)
    {
        super();
        
        this.id = id;
        this.name = name;
        this.hostname = hostname;
        
        if (domains != null && domains.length > 0)
        {
            for (String domain : domains)
            {
                this.domains.add(domain);
            }
        }
    }


    public String getId()
    {
        return id;
    }


    public void setId(String id)
    {
        this.id = id;
    }


    public String getName()
    {
        return name;
    }


    public void setName(String name)
    {
        this.name = name;
    }


    public String getHostname()
    {
        return hostname;
    }


    public void setHostname(String hostname)
    {
        this.hostname = sanitizeHostName(hostname);
    }


    public Set<String> getDomains()
    {
        return domains;
    }


    public void setDomains(Set<String> domains)
    {
        this.domains = domains;
    }


    public void setDNSServers(Set<InetAddress> dns)
    {
        this.dns = dns;
    }


    public Set<InetAddress> getDNSServers()
    {
        return dns;
    }


    protected String sanitizeHostName(String hostname)
    {
        if (hostname != null)
        {
            StringBuilder builder = new StringBuilder();
            
            char[] chars = hostname.toCharArray();
            for (char c : chars)
            {
                if (Character.isWhitespace(c))
                {
                    builder.append("_");
                } else if (Character.isLetterOrDigit(c) || c == '.')
                {
                    builder.append(c);
                }
            }
            
            return builder.toString();
        } else
        {
            return null;
        }
    }
}
