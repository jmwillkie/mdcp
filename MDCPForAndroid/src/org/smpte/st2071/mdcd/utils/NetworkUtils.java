package org.smpte.st2071.mdcd.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class NetworkUtils
{
    public static InetAddress toInetAddress(int value)
    throws UnknownHostException
    {
        byte[] addr = new byte[4];
        
        addr[0] = (byte) (value & 0x0FF);
        addr[1] = (byte) ((value >> 8) & 0x0FF);
        addr[2] = (byte) ((value >> 16) & 0x0FF);
        addr[3] = (byte) ((value >> 24) & 0x0FF);
        
        return InetAddress.getByAddress(addr);
    }
    
    
    public static InetAddress toInetAddress(long value)
    throws UnknownHostException
    {
        byte[] addr = new byte[8];
        
        if (value < 0x100000000l)
        {
            return toInetAddress((int) value);
        } else
        {
            addr[0] = (byte) (value & 0x0FF);
            addr[1] = (byte) ((value >> 8) & 0x0FF);
            addr[2] = (byte) ((value >> 16) & 0x0FF);
            addr[3] = (byte) ((value >> 24) & 0x0FF);
            addr[4] = (byte) ((value >> 32) & 0x0FF);
            addr[5] = (byte) ((value >> 40) & 0x0FF);
            addr[6] = (byte) ((value >> 48) & 0x0FF);
            addr[7] = (byte) ((value >> 56) & 0x0FF);
            
            return InetAddress.getByAddress(addr);
        }
    }
    
    
    public static InetAddress toInetAddress(String addr)
    throws UnknownHostException
    {
        InetAddress[] addrs = InetAddress.getAllByName(addr);
        return addrs.length > 0 ? addrs[0] : null;
    }
    
    
    public static String getMAC()
    {
        try
        {
            Enumeration<NetworkInterface> ifaces = NetworkInterface.getNetworkInterfaces();
            while (ifaces.hasMoreElements())
            {
                NetworkInterface iface = ifaces.nextElement();
                if (!iface.isLoopback() && !iface.isVirtual())
                {
                    try
                    {
                        byte[] hwAddr = iface.getHardwareAddress();
                        if (hwAddr != null && hwAddr.length > 0)
                        {
                            StringBuilder builder = new StringBuilder();
                            
                            for (byte octet : hwAddr)
                            {
                                builder.append(Integer.toHexString((octet & 0x0FF))).append(":");
                            }
                            
                            if (builder.length() > 1)
                            {
                                builder.setLength(builder.length() - 1);
                            }
                            return builder.toString();
                        }
                    } catch (SocketException e)
                    {
                        System.err.println("Couldn't get hardware address for \"" + iface.getName() + "\" - " + e.getMessage());
                    }
                }
            }
        } catch (SocketException e)
        {
            System.err.println("Couldn't get network interfaces - " + e.getMessage());
        }
        
        return null;
    }
    
    
    public static String getHostname()
    {
        try
        {
            Enumeration<NetworkInterface> ifaces = NetworkInterface.getNetworkInterfaces();
            while (ifaces.hasMoreElements())
            {
                NetworkInterface iface = ifaces.nextElement();
                try
                {
                    if (!iface.isLoopback() && !iface.isVirtual())
                    {
                        Enumeration<InetAddress> addrs = iface.getInetAddresses();
                        while (addrs != null && addrs.hasMoreElements())
                        {
                            InetAddress addr = addrs.nextElement();
                            String hostname = addr.getHostName();
                            String hostAddr = addr.getHostAddress();
                            if (!"localhost".equalsIgnoreCase(hostname) && !hostname.startsWith(hostAddr))
                            {
                                return hostname;
                            }
                        }
                    }
                } catch (SocketException e)
                {
                    System.err.println("Couldn't get network interface - " + e.getMessage());
                }
            }
        } catch (SocketException e)
        {
            System.err.println("Couldn't get network interfaces - " + e.getMessage());
        }
        
        try
        {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e)
        {
            return null;
        }
    }
}
