package org.smpte.mdc4android;

import org.smpte.mdc4android.mdcf.Capability;
import org.smpte.mdc4android.mdcf.Map;

public interface Device
{
    public static final String UCN = "urn:smpte:ucn:org.smpte.st2071:device_v1.0";
    
    public static final String PATH = "/Device";
    
    
    public static final String SOAP_ACTION_UDN = "http://www.smpte-ra.org/wsdl/st2071/2014/device/Device/UDN";
    
    public static final String SOAP_ACTION_ONLINE = "http://www.smpte-ra.org/wsdl/st2071/2014/device/Device/Online";
    
    public static final String SOAP_ACTION_NAME = "http://www.smpte-ra.org/wsdl/st2071/2014/device/Device/Name";
    
    public static final String SOAP_ACTION_CAPABILITIES = "http://www.smpte-ra.org/wsdl/st2071/2014/device/Device/Capabilities";
    
    public static final String SOAP_ACTION_ATTRIBUTES = "http://www.smpte-ra.org/wsdl/st2071/2014/device/Device/Attributes";
    
    public static final String SOAP_ACTION_URLS = "http://www.smpte-ra.org/wsdl/st2071/2014/device/Device/URLs";
    
    
    public static final String SOAP_RESPONSE_UDN = "http://www.smpte-ra.org/wsdl/st2071/2014/device/Device/UDNResponse";
    
    public static final String SOAP_RESPONSE_ONLINE = "http://www.smpte-ra.org/wsdl/st2071/2014/device/Device/OnlineResponse";
    
    public static final String SOAP_RESPONSE_NAME = "http://www.smpte-ra.org/wsdl/st2071/2014/device/Device/NameResponse";
    
    public static final String SOAP_RESPONSE_CAPABILITIES = "http://www.smpte-ra.org/wsdl/st2071/2014/device/Device/CapabilitiesResponse";
    
    public static final String SOAP_RESPONSE_ATTRIBUTES = "http://www.smpte-ra.org/wsdl/st2071/2014/device/Device/AttributesResponse";
    
    public static final String SOAP_RESPONSE_URLS = "http://www.smpte-ra.org/wsdl/st2071/2014/device/Device/URLsResponse";
    
    
    public static final String INTENT_GET_UDN = "org.smpte.st2071.device.Device.getUDN";
    
    public static final String INTENT_GET_ONLINE = "org.smpte.st2071.device.Device.getOnline";
    
    public static final String INTENT_GET_NAME = "org.smpte.st2071.device.Device.getName";
    
    public static final String INTENT_GET_CAPABILITIES = "org.smpte.st2071.device.Device.getCapabilities";
    
    public static final String INTENT_GET_ATTRIBUTES = "org.smpte.st2071.device.Device.getAttributes";
    
    public static final String INTENT_GET_URLS = "org.smpte.st2071.device.Device.getURLs";
    
    
    final String[] SOAP_ACTIONS = new String[]
    {
         SOAP_ACTION_UDN,
         SOAP_ACTION_ONLINE,
         SOAP_ACTION_NAME,
         SOAP_ACTION_CAPABILITIES,
         SOAP_ACTION_ATTRIBUTES,
         SOAP_ACTION_URLS
    };
    
    final String[] ACTIONS = new String[]
    {
         INTENT_GET_UDN,
         INTENT_GET_ONLINE,
         INTENT_GET_NAME,
         INTENT_GET_CAPABILITIES,
         INTENT_GET_ATTRIBUTES,
         INTENT_GET_URLS
    };
    
    
    public String getRN();


    public String getUDN();


    public boolean isOnline();


    public String getName();


    public String[] getURLs();


    public Capability[] getCapabilities();


    public Map getAttributes();
}
