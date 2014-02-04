
package org.smpte_ra.schemas.st2071._2014.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import org.smpte_ra.schemas.st2071._2014.identity.USNs;
import org.smpte_ra.schemas.st2071._2014.query.QueryExpression;


/**
 * 
 *             UCN = urn:smpte:ucn:org.smpte.st2071:service_directory_v1.0
 *         
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ServiceDirectory", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/service")
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
public interface ServiceDirectory {


    /**
     * 
     * @return
     *     returns org.smpte_ra.schemas.st2071._2014.identity.USNs
     */
    @WebMethod(action = "http://www.smpte-ra.org/wsdl/st2071/2014/service/ServiceDirectory/Namespaces")
    @WebResult(name = "USNs", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity")
    @RequestWrapper(localName = "getNamespaces", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", className = "org.smpte_ra.schemas.st2071._2014.service.GetNamespaces")
    @ResponseWrapper(localName = "getNamespacesResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", className = "org.smpte_ra.schemas.st2071._2014.service.GetNamespacesResponse")
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/service/ServiceDirectory/Namespaces", output = "http://www.smpte-ra.org/wsdl/st2071/2014/service/ServiceDirectory/NamespacesResponse")
    public USNs getNamespaces();

    /**
     * 
     * @param usn
     * @return
     *     returns org.smpte_ra.schemas.st2071._2014.service.ServiceInformation
     * @throws ServiceExceptionFault
     * @throws ServiceNotFoundFault
     * @throws SecurityExceptionFault
     */
    @WebMethod(action = "http://www.smpte-ra.org/wsdl/st2071/2014/service/ServiceDirectory/lookup")
    @WebResult(name = "ServiceInformation", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/service")
    @RequestWrapper(localName = "lookup", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", className = "org.smpte_ra.schemas.st2071._2014.service.USNRequest")
    @ResponseWrapper(localName = "lookupResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", className = "org.smpte_ra.schemas.st2071._2014.service.ServiceInformationResponse")
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/service/ServiceDirectory/lookup", output = "http://www.smpte-ra.org/wsdl/st2071/2014/service/ServiceDirectory/lookupResponse")
    public ServiceInformation lookup(
        @WebParam(name = "USN", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity")
        String usn)
        throws SecurityExceptionFault, ServiceExceptionFault, ServiceNotFoundFault
    ;

    /**
     * 
     * @param queryExpression
     * @return
     *     returns org.smpte_ra.schemas.st2071._2014.service.ServiceInformations
     * @throws InvalidQueryFault
     * @throws ServiceExceptionFault
     * @throws SecurityExceptionFault
     */
    @WebMethod(action = "http://www.smpte-ra.org/wsdl/st2071/2014/service/ServiceDirectory/search")
    @WebResult(name = "ServiceInformations", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/service")
    @RequestWrapper(localName = "search", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", className = "org.smpte_ra.schemas.st2071._2014.service.QueryRequest")
    @ResponseWrapper(localName = "searchResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", className = "org.smpte_ra.schemas.st2071._2014.service.ServiceInformationsResponse")
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/service/ServiceDirectory/search", output = "http://www.smpte-ra.org/wsdl/st2071/2014/service/ServiceDirectory/searchResponse")
    public ServiceInformations search(
        @WebParam(name = "QueryExpression", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/query")
        QueryExpression queryExpression)
        throws InvalidQueryFault, SecurityExceptionFault, ServiceExceptionFault
    ;

}
