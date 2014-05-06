package org.smpte.mdc4android.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.smpte.mdc4android.MDC4Android;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.util.Log;

public class NetworkUtils
{
    public static final String LOG_TAG = MDC4Android.LOG_TAG + "." + NetworkUtils.class.getSimpleName();
    
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
                if (!iface.isLoopback() && !iface.isVirtual() && !iface.isPointToPoint())
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
    
    
    /**
     * Parses the output of getprop, which is the only way to get DNS
     * info on Android. getprop might disappear in future releases, so
     * this code comes with a use-by date.
     */
    public static Map<String, String> getProps()
    {
        Map<String, String> props = new LinkedHashMap<String, String>();
        
        try
        {
            String line;
            Process p = Runtime.getRuntime().exec("getprop");
            InputStream in = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(isr);
            while ((line = br.readLine()) != null)
            {
                try
                {
                    int pos = line.indexOf(":");
                    String name = line.substring(0, pos).trim();
                    String value = line.substring(pos + 1).trim();
                    name = name.replaceAll("[ \\[\\]]", "").trim();
                    value = value.replaceAll("[ \\[\\]]", "").trim();
                    props.put(name, value);
                } catch (Exception e)
                {
                    Log.e(LOG_TAG, "Error parsing property -> " + e.getMessage());
                }
            }
        } catch (Exception e)
        {
            Log.e(LOG_TAG, "Error parsing properties -> " + e.getMessage());
        }
        
        return props;
    }


    public static Set<NetworkInterface> getNetworkInterfaces()
    {
        Set<NetworkInterface> results = new LinkedHashSet<NetworkInterface>();
        try
        {
            Enumeration<NetworkInterface> ifaces = NetworkInterface.getNetworkInterfaces();
            while (ifaces.hasMoreElements())
            {
                NetworkInterface iface = ifaces.nextElement();
                if (!iface.isLoopback() && !iface.isVirtual() && !iface.isPointToPoint())
                {
                    results.add(iface);
                }
            }
        } catch (SocketException e)
        {
            e.printStackTrace(System.err);
        }
        
        return results;
    }


    public static DeviceInfo gatherDeviceInformation(Context context)
    {
        String mac = null;
        String name = null;
        String hostname = null;
        DeviceInfo info = new DeviceInfo();
        
        WifiManager wifiMgr = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        if (wifiMgr != null)
        {
            WifiInfo wifiInfo = wifiMgr.getConnectionInfo();
            mac = wifiInfo.getMacAddress();
            DhcpInfo dhcpInfo = wifiMgr.getDhcpInfo();
            if (dhcpInfo != null)
            {
                Set<InetAddress> dnsServers = new LinkedHashSet<InetAddress>();
                if (dhcpInfo.dns1 != 0)
                {
                    try
                    {
                        dnsServers.add(NetworkUtils.toInetAddress(dhcpInfo.dns1));
                    } catch (UnknownHostException e)
                    {
                        Log.e(LOG_TAG, "Error creating address for DNS Server \"" + dhcpInfo.dns1 + "\" - > " + e.getMessage(), e);
                    }
                }
                
                if (dhcpInfo.dns2 != 0)
                {
                    try
                    {
                        dnsServers.add(NetworkUtils.toInetAddress(dhcpInfo.dns2));
                    } catch (UnknownHostException e)
                    {
                        Log.e(LOG_TAG, "Error creating address for DNS Server \"" + dhcpInfo.dns2 + "\" - > " + e.getMessage(), e);
                    }
                }
                
                if (dnsServers.size() > 0)
                {
                    info.addDNSServers(dnsServers);
                }
            }
            
            try
            {
                info.setInetAddress(NetworkUtils.toInetAddress(wifiInfo.getIpAddress()));
            } catch (UnknownHostException e)
            {
                Log.e(LOG_TAG, "Could not get InetAddress");
            }
        }
        
        BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
        if (btAdapter != null)
        {
            name = btAdapter.getName();
            if (mac == null || mac.length() == 0)
            {
                mac = btAdapter.getAddress();
            }
        }
        
        Pattern dnsPattern = Pattern.compile("(.*\\.dns(\\d+))");
        Pattern domainPattern = Pattern.compile("(.*\\.domain)");
        Pattern hostnamePattern = Pattern.compile("(.*\\.hostname)");
        Map<String, String> dnsServers = new LinkedHashMap<String, String>();
        Map<String, String> domains = new LinkedHashMap<String, String>();
        Map<String, String> hostnames = new LinkedHashMap<String, String>();
        
        Map<String, String> props = NetworkUtils.getProps();
        for (Map.Entry<String, String> entry : props.entrySet())
        {
            String key = entry.getKey();
            String value = entry.getValue();
            
            if (value != null && value.length() > 0)
            {
                Matcher m = dnsPattern.matcher(key);
                if (m.matches())
                {
                    dnsServers.put(key, value);
                }
                
                m = domainPattern.matcher(key);
                if (m.matches())
                {
                    domains.put(key, value);
                }
                
                m = hostnamePattern.matcher(key);
                if (m.matches())
                {
                    hostnames.put(key, value);
                }
            }
        }
        
        if (dnsServers.size() > 0)
        {
            for (Map.Entry<String, String> entry : dnsServers.entrySet())
            {
                String value = entry.getValue();
                if (value != null && value.length() > 0)
                {
                    try
                    {
                        info.addDNSServer(NetworkUtils.toInetAddress(value));
                    } catch (UnknownHostException e)
                    {
                        Log.e(LOG_TAG, "Error creating address for DNS Server \"" + value + "\" - > " + e.getMessage(), e);
                    }
                }
            }
        }
        
        if (domains.size() > 0)
        {
            info.addDomains(new LinkedHashSet<String>(domains.values()));
        }
        info.addDomain("local.");
        
        if (hostnames.size() > 0)
        {
            hostname = hostnames.get("net.hostname");
            if (hostname == null || hostname.length() == 0)
            {
                for (String key : hostnames.keySet())
                {
                    if (key.startsWith("net.") && key.contains("hostname"))
                    {
                        hostname = hostnames.get(key);
                        if (hostname != null && hostname.length() > 0)
                        {
                            break;
                        }
                    }
                }
            }
        } else
        {
            hostname = NetworkUtils.getHostname();
        }
        
        String serial = Build.SERIAL;
        if (serial != null && serial.length() > 0)
        {
            info.setId(serial);
        } else 
        {
            if (mac != null && mac.length() > 0)
            {
                info.setId(mac);
            } else
            {
                if (mac == null || mac.length() == 0)
                {
                    mac = NetworkUtils.getMAC();
                }
            } 
            
            if (mac != null && mac.length() > 0)
            {
                info.setId(mac);
            } else
            {
                Log.e(LOG_TAG, "MAC could not be determined!");
            }
        }
        
        if (!"localhost".equalsIgnoreCase(hostname))
        {
            info.setHostname(hostname);
        } else
        {
            info.setHostname(name + "-" + cleanupName(info.getId()));
        }
        
        if (name != null)
        {
            info.setName(name);
        } else
        {
            info.setName(hostname);
        }
        
        if (info.getInetAddresses() == null || info.getInetAddresses().isEmpty())
        {
            Set<NetworkInterface> ifaces = getNetworkInterfaces();
            if (ifaces != null && ifaces.size() > 0)
            {
                for (NetworkInterface netIface : ifaces)
                {
                    try
                    {
                        if (!netIface.isLoopback() && !netIface.isVirtual() && !netIface.isPointToPoint() && netIface.isUp())
                        {
                            Enumeration<InetAddress> addrs = netIface.getInetAddresses();
                            while (addrs.hasMoreElements())
                            {
                                InetAddress addr = addrs.nextElement();
                                if (addr.getAddress().length == 4)
                                {
                                    info.addInetAddress(addr);
                                }
                            }
                        }
                    } catch (SocketException e)
                    {
                        // ignore
                    }
                }
            }
        }
        
        return info;
    }
    

    public static String cleanupName(String name)
    {
        StringBuilder builder = new StringBuilder();
        char[] chars = name.trim().toCharArray();
        for (char c : chars)
        {
            if (Character.isLetterOrDigit(c))
            {
                builder.append(c);
            } else
            {
                builder.append('-');
            }
        }
        
        if (builder.length() > 63)
        {
            builder.setLength(63);
        } else if (builder.length() < 3)
        {
            builder.append("-service");
        }
        
        return builder.toString();
    }
    
    
    public static String reverse(String domain)
    {
        StringBuilder builder = new StringBuilder();
        
        if (domain != null)
        {
            String[] parts = domain.split("\\.");
            if (parts != null)
            {
                for (int i = parts.length - 1; i >= 0; i--)
                {
                    if (parts[i] != null && parts[i].length() > 0)
                    {
                        builder.append(parts[i]).append(".");
                    }
                }
                if (builder.length() > 0)
                {
                    builder.setLength(builder.length() - 1);
                }
            }
        }
        
        return builder.toString();
    }


    public static String replaceProtocol(String url, String protocol)
    throws MalformedURLException
    {
        int pos = url.indexOf(':');
        if (pos > 0)
        {
            return protocol + url.substring(pos);
        } else
        {
            throw new MalformedURLException("Must be an Absolute URL!");
        }
    }


    public static String replaceHostname(String url, String hostname)
    throws MalformedURLException
    {
        int firstPos = url.indexOf("://");
        int secondPos = -1;
        
        if (firstPos >= 0)
        {
            firstPos += 3;
            outer:
            for (int index = firstPos; index < url.length(); index++)
            {
                char c = url.charAt(index);
                switch (c)
                {
                    case ':':
                    case '/':
                        secondPos = index;
                        break outer;
                }
            }
            
            if (secondPos > 0)
            {
                return url.substring(0, firstPos) + hostname + url.substring(secondPos);
            }
        }
        
        throw new MalformedURLException("Must be an Absolute URL!");
    }


    /**
     * Returns the 2 DNS PTR names for the ucn or an array of empty strings, if an invalid ucn is specified.
     * 
     * @param ucn The ucn to create DNS PTR names for.
     * @return The 2 DNS PTR names for the ucn or an array of empty strings, if an invalid ucn is specified
     */
    public static String[] ucnToServiceNames(String ucn)
    {
        "urn:smpte:ucn:org.smpte.st2071:device_v1.0".toCharArray();
        String[] results = new String[2];
        String[] sections = ucn.split(":");
        if (sections.length == 5)
        {
            if ("ucn".equals(sections[2]))
            {
                String iface = sections[4];
                String mdcPTR = "_mdc._tcp";
                String devicePTR = "_" + sections[3] + ":" + iface + "._sub." + mdcPTR;
                results[0] = devicePTR;
                results[1] = mdcPTR;
            }
        }
        
        return results;
    }
}
