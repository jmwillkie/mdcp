package org.smpte_ra.schemas.st2071._2014.session;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;

/**
 * UCN = urn:smpte:ucn:org.smpte.st2071:requestable_v1.0
 *         
 *
 * This class was generated by Apache CXF 2.7.10
 * 2014-03-09T14:41:07.759-04:00
 * Generated source version: 2.7.10
 * 
 */
@WebService(targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "Requestable")
@XmlSeeAlso({org.smpte_ra.schemas.st2071._2014.query.ObjectFactory.class, org.smpte_ra.schemas.st2071._2014.mode.ObjectFactory.class, org.smpte_ra.schemas.st2071._2014.media.ObjectFactory.class, org.smpte_ra.schemas.st2071._2014.types.ObjectFactory.class, ObjectFactory.class, org.smpte_ra.schemas.st2071._2014.security.ObjectFactory.class, org.smpte_ra.schemas.st2071._2014.identity.ObjectFactory.class, org.smpte_ra.schemas.st2071._2014.device.ObjectFactory.class, org.smpte_ra.schemas.st2071._2014.event.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface Requestable {

    @WebResult(name = "denyResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", partName = "denyResponse")
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/session/Requestable/deny", output = "http://www.smpte-ra.org/wsdl/st2071/2014/session/Requestable/denyResponse", fault = {})
    @WebMethod(action = "http://www.smpte-ra.org/wsdl/st2071/2014/session/Requestable/deny")
    public EmptyResponse deny(
        @WebParam(partName = "deny", name = "deny", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/session")
        Deny deny
    ) throws org.smpte_ra.schemas.st2071._2014.security.SecurityExceptionFault, RequestNotFoundFault, RequestExpiredFault;

    @WebResult(name = "takeResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", partName = "takeResponse")
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/session/Requestable/take", output = "http://www.smpte-ra.org/wsdl/st2071/2014/session/Requestable/takeResponse", fault = {})
    @WebMethod(action = "http://www.smpte-ra.org/wsdl/st2071/2014/session/Requestable/take")
    public URIResponse take(
        @WebParam(partName = "take", name = "take", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/session")
        RequestParameters take
    ) throws org.smpte_ra.schemas.st2071._2014.security.SecurityExceptionFault, LockNotFoundFault, SessionNotFoundFault, NotAcquiredFault;

    @WebResult(name = "approveResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", partName = "approveResponse")
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/session/Requestable/approve", output = "http://www.smpte-ra.org/wsdl/st2071/2014/session/Requestable/approveResponse", fault = {})
    @WebMethod(action = "http://www.smpte-ra.org/wsdl/st2071/2014/session/Requestable/approve")
    public EmptyResponse approve(
        @WebParam(partName = "approve", name = "approve", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/session")
        URIRequest approve
    ) throws org.smpte_ra.schemas.st2071._2014.security.SecurityExceptionFault, RequestNotFoundFault, RequestExpiredFault;

    @WebResult(name = "requestResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", partName = "requestResponse")
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/session/Requestable/request", output = "http://www.smpte-ra.org/wsdl/st2071/2014/session/Requestable/requestResponse", fault = {})
    @WebMethod(action = "http://www.smpte-ra.org/wsdl/st2071/2014/session/Requestable/request")
    public URIResponse request(
        @WebParam(partName = "request", name = "request", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/session")
        RequestParameters request
    ) throws SessionNotFoundFault, org.smpte_ra.schemas.st2071._2014.security.SecurityExceptionFault, NotAcquiredFault, RequestDeniedFault;
}