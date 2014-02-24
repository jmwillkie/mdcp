
package org.smpte_ra.schemas.st2071._2014.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * 
 *             UCN = urn:smpte:ucn:org.smpte.st2071:service_registry_v1.0
 *         
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ServiceRegistry", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/service")
@XmlSeeAlso({
    org.smpte_ra.schemas.st2071._2014.device.ObjectFactory.class,
    org.smpte_ra.schemas.st2071._2014.event.ObjectFactory.class,
    org.smpte_ra.schemas.st2071._2014.identity.ObjectFactory.class,
    org.smpte_ra.schemas.st2071._2014.media.ObjectFactory.class,
    org.smpte_ra.schemas.st2071._2014.mode.ObjectFactory.class,
    org.smpte_ra.schemas.st2071._2014.query.ObjectFactory.class,
    org.smpte_ra.schemas.st2071._2014.security.ObjectFactory.class,
    org.smpte_ra.schemas.st2071._2014.service.ObjectFactory.class,
    org.smpte_ra.schemas.st2071._2014.types.ObjectFactory.class
})
public interface ServiceRegistry {


    /**
     * 
     * @param serviceInformation
     * @throws ServiceExceptionFault
     * @throws SecurityExceptionFault
     * @throws ServiceNotFoundFault
     */
    @WebMethod(action = "http://www.smpte-ra.org/wsdl/st2071/2014/service/ServiceRegistry/bind")
    @RequestWrapper(localName = "bind", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", className = "org.smpte_ra.schemas.st2071._2014.service.ServiceInformationRequest")
    @ResponseWrapper(localName = "bindResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", className = "org.smpte_ra.schemas.st2071._2014.service.EmptyResponse")
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/service/ServiceRegistry/bind", output = "http://www.smpte-ra.org/wsdl/st2071/2014/service/ServiceRegistry/bindResponse")
    public void bind(
        @WebParam(name = "ServiceInformation", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/service")
        ServiceInformation serviceInformation)
        throws SecurityExceptionFault, ServiceExceptionFault, ServiceNotFoundFault
    ;

    /**
     * 
     * @param usn
     * @throws ServiceExceptionFault
     * @throws SecurityExceptionFault
     * @throws ServiceNotFoundFault
     */
    @WebMethod(action = "http://www.smpte-ra.org/wsdl/st2071/2014/service/ServiceRegistry/unbind")
    @RequestWrapper(localName = "unbind", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", className = "org.smpte_ra.schemas.st2071._2014.service.USNRequest")
    @ResponseWrapper(localName = "unbindResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", className = "org.smpte_ra.schemas.st2071._2014.service.EmptyResponse")
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/service/ServiceRegistry/unbind", output = "http://www.smpte-ra.org/wsdl/st2071/2014/service/ServiceRegistry/unbindResponse")
    public void unbind(
        @WebParam(name = "USN", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity")
        String usn)
        throws SecurityExceptionFault, ServiceExceptionFault, ServiceNotFoundFault
    ;

}
