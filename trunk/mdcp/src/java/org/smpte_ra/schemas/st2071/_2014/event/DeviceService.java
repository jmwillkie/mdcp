package org.smpte_ra.schemas.st2071._2014.event;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.10
 * 2014-03-09T14:41:23.058-04:00
 * Generated source version: 2.7.10
 * 
 */
@WebServiceClient(name = "DeviceService", 
                  wsdlLocation = "device.event_services.wsdl",
                  targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/event") 
public class DeviceService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.smpte-ra.org/schemas/st2071/2014/event", "DeviceService");
    public final static QName CallbackHandlerPort = new QName("http://www.smpte-ra.org/schemas/st2071/2014/event", "CallbackHandlerPort");
    public final static QName StatusSupportPort = new QName("http://www.smpte-ra.org/schemas/st2071/2014/event", "StatusSupportPort");
    public final static QName EventerPort = new QName("http://www.smpte-ra.org/schemas/st2071/2014/event", "EventerPort");
    public final static QName EventBroadcasterPort = new QName("http://www.smpte-ra.org/schemas/st2071/2014/event", "EventBroadcasterPort");
    static {
        URL url = DeviceService.class.getResource("device.event_services.wsdl");
        if (url == null) {
            url = DeviceService.class.getClassLoader().getResource("device.event_services.wsdl");
        } 
        if (url == null) {
            java.util.logging.Logger.getLogger(DeviceService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "device.event_services.wsdl");
        }       
        WSDL_LOCATION = url;
    }

    public DeviceService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public DeviceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DeviceService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public DeviceService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public DeviceService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public DeviceService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns CallbackHandler
     */
    @WebEndpoint(name = "CallbackHandlerPort")
    public CallbackHandler getCallbackHandlerPort() {
        return super.getPort(CallbackHandlerPort, CallbackHandler.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CallbackHandler
     */
    @WebEndpoint(name = "CallbackHandlerPort")
    public CallbackHandler getCallbackHandlerPort(WebServiceFeature... features) {
        return super.getPort(CallbackHandlerPort, CallbackHandler.class, features);
    }
    /**
     *
     * @return
     *     returns StatusSupport
     */
    @WebEndpoint(name = "StatusSupportPort")
    public StatusSupport getStatusSupportPort() {
        return super.getPort(StatusSupportPort, StatusSupport.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns StatusSupport
     */
    @WebEndpoint(name = "StatusSupportPort")
    public StatusSupport getStatusSupportPort(WebServiceFeature... features) {
        return super.getPort(StatusSupportPort, StatusSupport.class, features);
    }
    /**
     *
     * @return
     *     returns Eventer
     */
    @WebEndpoint(name = "EventerPort")
    public Eventer getEventerPort() {
        return super.getPort(EventerPort, Eventer.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Eventer
     */
    @WebEndpoint(name = "EventerPort")
    public Eventer getEventerPort(WebServiceFeature... features) {
        return super.getPort(EventerPort, Eventer.class, features);
    }
    /**
     *
     * @return
     *     returns EventBroadcaster
     */
    @WebEndpoint(name = "EventBroadcasterPort")
    public EventBroadcaster getEventBroadcasterPort() {
        return super.getPort(EventBroadcasterPort, EventBroadcaster.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EventBroadcaster
     */
    @WebEndpoint(name = "EventBroadcasterPort")
    public EventBroadcaster getEventBroadcasterPort(WebServiceFeature... features) {
        return super.getPort(EventBroadcasterPort, EventBroadcaster.class, features);
    }

}
