package net.posick.net;

import java.io.IOException;
import java.net.BindException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import org.dhcp4java.DHCPOption;
import org.dhcp4java.DHCPPacket;

public class DHCPClient
{
    public static final byte DHCP_OP_INFORM = 8;
    
    public static final int DHCP_TTL = 3600000; // 1 Hour
    
    
    private static class CacheEntry
    {
        private long ttl;
        
        private long created;
        
        private DHCPOption[] options;
        
        
        private CacheEntry(int ttl, DHCPOption[] options)
        {
            this.ttl = ttl;
            this.options = options;
            this.created = System.currentTimeMillis();
        }
        
        
        private boolean isValid()
        {
            long now = System.currentTimeMillis();
            return now <= (created + ttl);
        }
    }
    
    
    private static Map<InetAddress, CacheEntry> cache = Collections.synchronizedMap(new HashMap<InetAddress, CacheEntry>());
    
    
    static
    {
        Timer timer = new Timer("DHCPClient Cache Cleaner", true);
        timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                synchronized (cache)
                {
                    ArrayList<InetAddress> keys = new ArrayList<InetAddress>(cache.keySet());
                    for (InetAddress key : keys)
                    {
                        CacheEntry entry = cache.get(key);
                        if (entry == null || !entry.isValid())
                        {
                            cache.remove(key);
                        }
                    }
                }
            }
        }, 60000);
    }
    
    
    static DHCPOption[] resolveDHCPOptions(InetAddress address)
    throws SocketException, IOException, BindException
    {
        DHCPOption[] options = null;
        CacheEntry entry = cache.get(address);
        
        if (entry != null && entry.isValid())
        {
            options = entry.options;
        } else
        {
            NetworkInterface iface = NetworkInterface.getByInetAddress(address);
            byte[] chaddr = iface.getHardwareAddress();
            
            DHCPPacket packet = new DHCPPacket();
            packet.setOp(DHCP_OP_INFORM);
            packet.setHtype((byte) 1);
            packet.setHlen((byte) 6);
            packet.setHops((byte) 0);
            packet.setXid(new Random().nextInt());
            packet.setSecs((short) 0);
            packet.setFlags((short) 0);
            packet.setChaddr(chaddr);
            packet.setCiaddr(address);
            
            DatagramSocket socket = new DatagramSocket(68, address);
            socket.setBroadcast(true);
            try
            {
                byte[] raw = packet.serialize();
                socket.send(new DatagramPacket(raw, raw.length));
                DatagramPacket pac = new DatagramPacket(new byte[1500], 1500);
                socket.receive(pac);
                DHCPPacket response = DHCPPacket.getPacket(pac);
                options = response.getOptionsArray();
                if (options != null)
                {
                    cache.put(address, new CacheEntry(DHCP_TTL, options));
                } else
                {
                    cache.remove(address);
                }
            } finally
            {
                socket.close();
            }
        }
        
        return options;
    }
    
    
    public static Set<String> resolveDHCPDomainNames(InetAddress address)
    throws SocketException, IOException, BindException
    {
        Set<String> names = new HashSet<String>();
        byte[] domainSearch = null;
        
        DHCPOption[] options = resolveDHCPOptions(address);
        if (options != null)
        {
            for (DHCPOption option : options)
            {
                switch (option.getCode())
                {
                    case 6 :
                        //  Domain Name Servers
                        break;
                    case 12 :
                        // Hostname
                        break;
                    case 15 :
                        // Domain name
                        names.add(option.getValueAsString());
                        break;
                    case 119 :
                        // Domain Search [RFC3397]
                        byte[] value = option.getValueAsBytes();
                        if (value != null && value.length > 0)
                        {
                            if (domainSearch != null && domainSearch.length > 0)
                            {
                                byte[] newDomainSearch = new byte[domainSearch.length + value.length];
                                System.arraycopy(domainSearch, 0, newDomainSearch, 0, domainSearch.length);
                                System.arraycopy(value, 0, newDomainSearch, domainSearch.length, value.length);
                                domainSearch = newDomainSearch;
                            } else
                            {
                                domainSearch = new byte[value.length];
                                System.arraycopy(value, 0, domainSearch, 0, value.length);
                            }
                        }
                        break;
                }
            }
            
            // Domain Search [RFC 3397] extract domain names
            if (domainSearch != null && domainSearch.length > 0)
            {
                for (int index = 0; index < domainSearch.length;)
                {
                    String domainName = getDomainName(domainSearch, index);
                    names.add(domainName);
                    index += domainName.length() + 1;
                }
            }
        }
        
        return names;
    }

    
    public static Set<InetAddress> resolveDHCPDomainNameServers(InetAddress address)
    throws SocketException, IOException, BindException
    {
        Set<InetAddress> addresses = new LinkedHashSet<InetAddress>();
        byte[] domainServers = null;
        
        DHCPOption[] options = resolveDHCPOptions(address);
        if (options != null)
        {
            for (DHCPOption option : options)
            {
                if (option.getCode() == 6)
                {
                    byte[] value = option.getValueAsBytes();
                    if (value != null && value.length > 0)
                    {
                        if (domainServers != null && domainServers.length > 0)
                        {
                            byte[] newDomainSevers = new byte[domainServers.length + value.length];
                            System.arraycopy(domainServers, 0, newDomainSevers, 0, domainServers.length);
                            System.arraycopy(value, 0, newDomainSevers, domainServers.length, value.length);
                            domainServers = newDomainSevers;
                        } else
                        {
                            domainServers = new byte[value.length];
                            System.arraycopy(value, 0, domainServers, 0, value.length);
                        }
                    }
                }
            }
            
            if (domainServers != null && domainServers.length > 0)
            {
                for (int index = 0; index < domainServers.length; index += 4)
                {
                    byte[] octets = new byte[4];
                    System.arraycopy(domainServers, index, octets, 0, octets.length);
                    addresses.add(InetAddress.getByAddress(octets));
                }
            }
        }
        
        return addresses;
    }
    
    
    /**
     * Extract/Uncompress Domain Name from Domain Search Option [RFC 3397]
     * 
     * @param domainSearch The byte[] of the Domain Search value.
     * @param offset The offset into the Domain Search value to start parsing.
     * @return The full uncompressed domain name.
     */
    private static String getDomainName(byte[] domainSearch, int offset)
    {
        StringBuilder name = new StringBuilder();
        
        for (int index = offset; index < domainSearch.length;)
        {
            int length = domainSearch[index++];
            String namePart = new String(domainSearch, index, length);
            name.append(namePart);
            index += length;
            if (domainSearch[index] == 0x00)
            {
                break;
            } else if ((domainSearch[index] & 0xC0) == 0xC0)
            {
                String domain = getDomainName(domainSearch, domainSearch[index] ^ 0xC0);
                if (domain != null)
                {
                    name.append(".").append(domain);
                }
                break;
            } else
            {
                name.append(".");
            }
        }
        
        return name.length() != 0 ? name.toString() : null; 
    }
}
