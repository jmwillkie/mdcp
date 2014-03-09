package org.smpte_ra.schemas.st2071._2014.security;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.10
 * 2014-03-09T14:42:11.052-04:00
 * Generated source version: 2.7.10
 * 
 */
@WebServiceClient(name = "DeviceService", 
                  wsdlLocation = "security_services.wsdl",
                  targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/security") 
public class DeviceService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "DeviceService");
    public final static QName AuthenticatorPort = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "AuthenticatorPort");
    public final static QName AuthorizerPort = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "AuthorizerPort");
    static {
        URL url = DeviceService.class.getResource("security_services.wsdl");
        if (url == null) {
            url = DeviceService.class.getClassLoader().getResource("security_services.wsdl");
        } 
        if (url == null) {
            java.util.logging.Logger.getLogger(DeviceService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "security_services.wsdl");
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
     *     returns Authenticator
     */
    @WebEndpoint(name = "AuthenticatorPort")
    public Authenticator getAuthenticatorPort() {
        return super.getPort(AuthenticatorPort, Authenticator.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Authenticator
     */
    @WebEndpoint(name = "AuthenticatorPort")
    public Authenticator getAuthenticatorPort(WebServiceFeature... features) {
        return super.getPort(AuthenticatorPort, Authenticator.class, features);
    }
    /**
     *
     * @return
     *     returns Authorizer
     */
    @WebEndpoint(name = "AuthorizerPort")
    public Authorizer getAuthorizerPort() {
        return super.getPort(AuthorizerPort, Authorizer.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Authorizer
     */
    @WebEndpoint(name = "AuthorizerPort")
    public Authorizer getAuthorizerPort(WebServiceFeature... features) {
        return super.getPort(AuthorizerPort, Authorizer.class, features);
    }

}
