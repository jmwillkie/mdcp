
package org.smpte_ra.schemas.st2071._2014.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ServiceService", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", wsdlLocation = "file:/Users/Shared/DropBox/Dropbox/SMPTE/MDC/workspace/MDC/MDCF/src/main/xml/service_services.wsdl")
public class ServiceService
    extends javax.xml.ws.Service
{

    private final static URL SERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException SERVICESERVICE_EXCEPTION;
    private final static QName SERVICESERVICE_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "ServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/Users/Shared/DropBox/Dropbox/SMPTE/MDC/workspace/MDC/MDCF/src/main/xml/service_services.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SERVICESERVICE_WSDL_LOCATION = url;
        SERVICESERVICE_EXCEPTION = e;
    }

    public ServiceService() {
        super(__getWsdlLocation(), SERVICESERVICE_QNAME);
    }

    public ServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SERVICESERVICE_QNAME, features);
    }

    public ServiceService(URL wsdlLocation) {
        super(wsdlLocation, SERVICESERVICE_QNAME);
    }

    public ServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SERVICESERVICE_QNAME, features);
    }

    public ServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Service
     */
    @WebEndpoint(name = "ServicePort")
    public org.smpte_ra.schemas.st2071._2014.service.Service getServicePort() {
        return super.getPort(new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "ServicePort"), Service.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Service
     */
    @WebEndpoint(name = "ServicePort")
    public org.smpte_ra.schemas.st2071._2014.service.Service getServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "ServicePort"), Service.class, features);
    }

    /**
     * 
     * @return
     *     returns ServiceDirectory
     */
    @WebEndpoint(name = "ServiceDirectoryPort")
    public ServiceDirectory getServiceDirectoryPort() {
        return super.getPort(new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "ServiceDirectoryPort"), ServiceDirectory.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServiceDirectory
     */
    @WebEndpoint(name = "ServiceDirectoryPort")
    public ServiceDirectory getServiceDirectoryPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "ServiceDirectoryPort"), ServiceDirectory.class, features);
    }

    /**
     * 
     * @return
     *     returns ServiceRegistry
     */
    @WebEndpoint(name = "ServiceRegistryPort")
    public ServiceRegistry getServiceRegistryPort() {
        return super.getPort(new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "ServiceRegistryPort"), ServiceRegistry.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServiceRegistry
     */
    @WebEndpoint(name = "ServiceRegistryPort")
    public ServiceRegistry getServiceRegistryPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "ServiceRegistryPort"), ServiceRegistry.class, features);
    }

    /**
     * 
     * @return
     *     returns ServiceFactory
     */
    @WebEndpoint(name = "ServiceFactoryPort")
    public ServiceFactory getServiceFactoryPort() {
        return super.getPort(new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "ServiceFactoryPort"), ServiceFactory.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServiceFactory
     */
    @WebEndpoint(name = "ServiceFactoryPort")
    public ServiceFactory getServiceFactoryPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "ServiceFactoryPort"), ServiceFactory.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SERVICESERVICE_EXCEPTION!= null) {
            throw SERVICESERVICE_EXCEPTION;
        }
        return SERVICESERVICE_WSDL_LOCATION;
    }

}
