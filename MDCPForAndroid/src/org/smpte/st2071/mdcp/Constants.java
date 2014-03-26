package org.smpte.st2071.mdcp;

public interface Constants
{
    public static final String LOG_TAG = MDCPForAndroid.LOG_TAG;
    

    public static final String PATH_UDN = "/Device/UDN";
    
    public static final String PATH_ONLINE = "/Device/Online";
    
    public static final String PATH_NAME = "/Device/Name";

    public static final String PATH_CAPABILITIES = "/Device/Capabilities";
    
    public static final String PATH_ATTRIBUTES = "/Device/Attributes";
    
    public static final String PATH_URLS = "/Device/URLs";

    
    public static final String SOAP_ACTION_UDN = "http://www.smpte-ra.org/wsdl/st2071/2014/device/Device/UDN";
    
    public static final String SOAP_ACTION_ONLINE = "http://www.smpte-ra.org/schemas/st2071/2014/device/Device/Online";
    
    public static final String SOAP_ACTION_NAME = "http://www.smpte-ra.org/schemas/st2071/2014/device/Device/Name";
    
    public static final String SOAP_ACTION_CAPABILITIES = "http://www.smpte-ra.org/schemas/st2071/2014/device/Device/Capabilities";
    
    public static final String SOAP_ACTION_ATTRIBUTES = "http://www.smpte-ra.org/schemas/st2071/2014/device/Device/Attributes";
    
    public static final String SOAP_ACTION_URLS = "http://www.smpte-ra.org/schemas/st2071/2014/device/Device/URLs";

    
    public static final String SOAP_RESPONSE_UDN = "http://www.smpte-ra.org/wsdl/st2071/2014/device/Device/UDNResponse";
    
    public static final String SOAP_RESPONSE_ONLINE = "http://www.smpte-ra.org/schemas/st2071/2014/device/Device/OnlineResponse";
    
    public static final String SOAP_RESPONSE_NAME = "http://www.smpte-ra.org/schemas/st2071/2014/device/Device/NameResponse";
    
    public static final String SOAP_RESPONSE_CAPABILITIES = "http://www.smpte-ra.org/schemas/st2071/2014/device/Device/CapabilitiesResponse";
    
    public static final String SOAP_RESPONSE_ATTRIBUTES = "http://www.smpte-ra.org/schemas/st2071/2014/device/Device/AttributesResponse";
    
    public static final String SOAP_RESPONSE_URLS = "http://www.smpte-ra.org/schemas/st2071/2014/device/Device/URLsResponse";


    public static final String INTENT_GET_UDN = "org.smpte.st2071.device.Device.getUDN";
    
    public static final String INTENT_GET_ONLINE = "org.smpte.st2071.device.Device.getOnline";
    
    public static final String INTENT_GET_NAME = "org.smpte.st2071.device.Device.getName";
    
    public static final String INTENT_GET_CAPABILITIES = "org.smpte.st2071.device.Device.getCapabilities";
    
    public static final String INTENT_GET_ATTRIBUTES = "org.smpte.st2071.device.Device.getAttributes";
    
    public static final String INTENT_GET_URLS = "org.smpte.st2071.device.Device.getURLs";
}
