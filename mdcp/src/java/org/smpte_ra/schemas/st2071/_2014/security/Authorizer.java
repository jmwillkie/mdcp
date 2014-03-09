package org.smpte_ra.schemas.st2071._2014.security;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;

/**
 * UCN = urn:smpte:ucn:org.smpte.st2071:authorizer_v1.0
 *         
 *
 * This class was generated by Apache CXF 2.7.10
 * 2014-03-09T14:42:11.026-04:00
 * Generated source version: 2.7.10
 * 
 */
@WebService(targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", name = "Authorizer")
@XmlSeeAlso({org.smpte_ra.schemas.st2071._2014.types.ObjectFactory.class, ObjectFactory.class, org.smpte_ra.schemas.st2071._2014.identity.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface Authorizer {

    @WebResult(name = "authorizeResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", partName = "authorizeResponse")
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/security/Authorizer/authorize", output = "http://www.smpte-ra.org/wsdl/st2071/2014/security/Authorizer/authorizeResponse", fault = {})
    @WebMethod(action = "http://www.smpte-ra.org/schemas/st2071/2014/security/Authorizer/authorize")
    public AuthorizeResponse authorize(
        @WebParam(partName = "authorize", name = "authorize", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/security")
        Authorize authorize
    ) throws SecurityExceptionFault;

    @WebResult(name = "getMechanismsResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", partName = "getMechanismsResponse")
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/security/Authorizer/Mechanisms", output = "http://www.smpte-ra.org/wsdl/st2071/2014/security/Authorizer/MechanismsResponse")
    @WebMethod(action = "http://www.smpte-ra.org/schemas/st2071/2014/security/Authorizer/Mechanisms")
    public GetMechanismsResponse getMechanisms(
        @WebParam(partName = "getMechanisms", name = "getMechanisms", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/security")
        GetMechanisms getMechanisms
    );
}
