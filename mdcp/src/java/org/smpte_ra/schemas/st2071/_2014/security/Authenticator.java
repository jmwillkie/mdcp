package org.smpte_ra.schemas.st2071._2014.security;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;

/**
 * UCN = urn:smpte:ucn:org.smpte.st2071:authenticator_v1.0
 *         
 *
 * This class was generated by Apache CXF 2.7.10
 * 2014-03-09T14:42:10.998-04:00
 * Generated source version: 2.7.10
 * 
 */
@WebService(targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", name = "Authenticator")
@XmlSeeAlso({org.smpte_ra.schemas.st2071._2014.types.ObjectFactory.class, ObjectFactory.class, org.smpte_ra.schemas.st2071._2014.identity.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface Authenticator {

    @WebResult(name = "logoutResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", partName = "logoutResponse")
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/security/Authorizer/logout", output = "http://www.smpte-ra.org/wsdl/st2071/2014/security/Authorizer/logoutResponse", fault = {})
    @WebMethod(action = "http://www.smpte-ra.org/schemas/st2071/2014/security/Authenticator/logout")
    public LogoutResponse logout(
        @WebParam(partName = "logout", name = "logout", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/security")
        Logout logout
    ) throws SecurityExceptionFault;

    @WebResult(name = "authenticateResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", partName = "authenticateResponse")
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/security/Authorizer/authenticate", output = "http://www.smpte-ra.org/wsdl/st2071/2014/security/Authorizer/authenticateResponse", fault = {})
    @WebMethod(action = "http://www.smpte-ra.org/schemas/st2071/2014/security/Authenticator/authenticate")
    public AuthenticateResponse authenticate(
        @WebParam(partName = "authenticate", name = "authenticate", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/security")
        Authenticate authenticate
    ) throws SecurityExceptionFault;

    @WebResult(name = "getMechanismsResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", partName = "getMechanismsResponse")
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/security/Authenticator/Mechanisms", output = "http://www.smpte-ra.org/wsdl/st2071/2014/security/Authenticator/MechanismsResponse")
    @WebMethod(action = "http://www.smpte-ra.org/schemas/st2071/2014/security/Authenticator/Mechanisms")
    public GetMechanismsResponse getMechanisms(
        @WebParam(partName = "getMechanisms", name = "getMechanisms", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/security")
        GetMechanisms getMechanisms
    );
}
