package org.smpte.mdc4android.net;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class DeviceInfo implements Serializable
{
    private static final long serialVersionUID = 201404031232L;
    
    private String id;
    
    private String name;
    
    private String hostname;
    
    private Set<String> domains = new LinkedHashSet<String>();

    private Set<InetAddress> dns = new LinkedHashSet<InetAddress>();

    private Set<InetAddress> addresses = new LinkedHashSet<InetAddress>();
    
    
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
        String sanitizedHostname = sanitizeHostName(hostname);
        
        int pos = -1;
        if ((pos = sanitizedHostname.indexOf('.')) > 0)
        {
            this.hostname = sanitizedHostname.substring(0, pos);
            if (sanitizedHostname.length() > pos)
            {
                String domain = sanitizedHostname.substring(pos + 1);
                if (domain.length() > 0)
                {
                    addDomain(domain);
                }
            }
        } else
        {
            this.hostname = sanitizedHostname;
        }
    }
    
    
    public String getPrimaryDomain()
    {
        for (String domain : domains)
        {
            return domain;
        }
        
        return "local.";
    }


    public Set<String> getDomains()
    {
        return domains;
    }


    public void setDomains(Set<String> domains)
    {
        if (this.domains == null)
        {
            this.domains = new LinkedHashSet<String>();
        } else
        {
            this.domains.clear();
        }
        
        for (String domain : domains)
        {
            addDomain(domain);
        }
    }


    public void addDomains(Set<String> domains)
    {
        for (String domain : domains)
        {
            addDomain(domain);
        }
    }


    public void addDomain(String domain)
    {
        if (this.domains == null)
        {
            this.domains = new LinkedHashSet<String>();
        }
        
        if (!domain.endsWith("."))
        {
            domain += ".";
        }
        
        this.domains.add(domain);
    }


    public void setDNSServers(Set<InetAddress> dns)
    {
        this.dns = dns;
    }


    public void addDNSServers(Set<InetAddress> addresses)
    {
        if (this.dns == null)
        {
            this.dns = new LinkedHashSet<InetAddress>();
        }
        this.dns.addAll(addresses);
    }


    public void addDNSServer(InetAddress addresses)
    {
        if (this.dns == null)
        {
            this.dns = new LinkedHashSet<InetAddress>();
        }
        
        this.dns.add(addresses);
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
            
            char[] chars = hostname.trim().toCharArray();
            for (char c : chars)
            {
                if (Character.isWhitespace(c))
                {
                    builder.append("-");
                } else if (Character.isLetterOrDigit(c) || c == '.' || c == '-')
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


    public void setInetAddress(InetAddress... addresses)
    {
        this.addresses.clear();
        this.addresses.addAll(Arrays.asList(addresses));
    }


    public void addInetAddress(InetAddress... addresses)
    {
        this.addresses.addAll(Arrays.asList(addresses));
    }
    
    
    public Set<InetAddress> getInetAddresses()
    {
        return addresses;
    }
}
