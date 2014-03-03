package net.posick.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressUtils
{
    public static String ARPA_DOMAIN_IPv4 = "in-addr.arpa.";
    public static String ARPA_DOMAIN_IPv6 = "ip6.arpa.";
    
    
    public static InetAddress subnetAddress(InetAddress address, int networkPrefixLength)
    throws IllegalArgumentException
    {
        byte[] rawAddress = address.getAddress();
        byte[] newRawAddress = new byte[rawAddress.length];
        
        int count = 0;
        for (int i = 0; i < rawAddress.length; i++)
        {
            byte octet = 0x00;
            
            if (count < networkPrefixLength)
            {
                int value;
                
                for (int bit = 7; bit >= 0; bit--)
                {
                    value = 0x00;
                    if (count < networkPrefixLength)
                    {
                        value = ((rawAddress[i] >>> bit) & 0x01);
                    }
                    
                    octet |= ((value & 0x01) << bit);
                    count++;
                }
            }
            newRawAddress[i] = octet;
        }
        
        try
        {
            return InetAddress.getByAddress(newRawAddress);
        } catch (UnknownHostException e)
        {
            throw new IllegalArgumentException("Internet Address must contain either 4 or 16 octets!");
        }
    }
    
    
    public static String reverseSubnetMaskDomain(InetAddress address, int networkPrefixLength)
    throws IllegalArgumentException
    {
        byte[] rawAddress = address.getAddress();
        
        if (rawAddress.length != 4 && rawAddress.length != 16)
        {
            throw new IllegalArgumentException("Internet Address must contain either 4 or 16 octets!");
        }
        
        ;
//        int length = networkPrefixLength / 8;
        int length = rawAddress.length;
        
        StringBuffer builder = new StringBuffer();
        if (rawAddress.length == 4)
        {
            for (int index = length - 1; index >= 0; index--)
            {
                builder.append(rawAddress[index] & 0xFF);
                if (index > 0)
                {
                    builder.append(".");
                }
            }
        } else
        {
            int[] nibbles = new int[2];
            for (int index = length - 1; index >= 0; index--)
            {
                nibbles[0] = (rawAddress[index] & 0x0FF) >> 4;
                nibbles[1] = (rawAddress[index] & 0x0FF) & 0x0F;
                for (int nibbleIndex = nibbles.length - 1; nibbleIndex >= 0; nibbleIndex--)
                {
                    builder.append(Integer.toHexString(nibbles[nibbleIndex]));
                    if (index > 0 || nibbleIndex > 0)
                    {
                        builder.append(".");
                    }
                }
            }
        }
        
        if (rawAddress.length == 4)
        {
            return builder.toString() + "." + ARPA_DOMAIN_IPv4;
        } else
        {
            return builder.toString() + "." + ARPA_DOMAIN_IPv6;
        }
    }
    
    
    public static String reverseMapAddress(InetAddress address)
    throws IllegalArgumentException
    {
        byte[] rawAddress = address.getAddress();
        
        if (rawAddress.length != 4 && rawAddress.length != 16)
        {
            throw new IllegalArgumentException("Internet Address must contain either 4 or 16 octets!");
        }
        
        ;
        StringBuffer builder = new StringBuffer();
        if (rawAddress.length == 4)
        {
            for (int index = rawAddress.length - 1; index >= 0; index--)
            {
                builder.append(rawAddress[index] & 0xFF);
                if (index > 0)
                {
                    builder.append(".");
                }
            }
        } else
        {
            int[] nibbles = new int[2];
            for (int index = rawAddress.length - 1; index >= 0; index--)
            {
                nibbles[0] = (rawAddress[index] & 0x0FF) >> 4;
                nibbles[1] = (rawAddress[index] & 0x0FF) & 0x0F;
                for (int nibbleIndex = nibbles.length - 1; nibbleIndex >= 0; nibbleIndex--)
                {
                    builder.append(Integer.toHexString(nibbles[nibbleIndex]));
                    if (index > 0 || nibbleIndex > 0)
                    {
                        builder.append(".");
                    }
                }
            }
        }
        
        if (rawAddress.length == 4)
        {
            return builder.toString() + "." + ARPA_DOMAIN_IPv4;
        } else
        {
            return builder.toString() + "." + ARPA_DOMAIN_IPv6;
        }
    }
}
