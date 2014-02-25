
package org.smpte_ra.schemas.st2071._2014.session;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * 
 *             UCN = urn:smpte:ucn:org.smpte.st2071:lockable_v1.0
 *         
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Lockable", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/session")
@XmlSeeAlso({
    org.smpte_ra.schemas.st2071._2014.device.ObjectFactory.class,
    org.smpte_ra.schemas.st2071._2014.event.ObjectFactory.class,
    org.smpte_ra.schemas.st2071._2014.identity.ObjectFactory.class,
    org.smpte_ra.schemas.st2071._2014.media.ObjectFactory.class,
    org.smpte_ra.schemas.st2071._2014.mode.ObjectFactory.class,
    org.smpte_ra.schemas.st2071._2014.query.ObjectFactory.class,
    org.smpte_ra.schemas.st2071._2014.security.ObjectFactory.class,
    org.smpte_ra.schemas.st2071._2014.session.ObjectFactory.class,
    org.smpte_ra.schemas.st2071._2014.types.ObjectFactory.class
})
public interface Lockable {


    /**
     * 
     * @return
     *     returns boolean
     */
    @WebMethod(action = "http://www.smpte-ra.org/wsdl/st2071/2014/device/control/Lockable/Locked")
    @WebResult(name = "Boolean", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/types")
    @RequestWrapper(localName = "getLocked", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", className = "org.smpte_ra.schemas.st2071._2014.session.EmptyRequest")
    @ResponseWrapper(localName = "getLockedResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", className = "org.smpte_ra.schemas.st2071._2014.session.BooleanResponse")
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/session/Lockable/Locked", output = "http://www.smpte-ra.org/wsdl/st2071/2014/session/Lockable/LockedResponse")
    public boolean getLocked();

    /**
     * 
     * @return
     *     returns org.smpte_ra.schemas.st2071._2014.session.Session
     */
    @WebMethod(action = "http://www.smpte-ra.org/wsdl/st2071/2014/device/control/Lockable/LockedBy")
    @WebResult(name = "Session", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/session")
    @RequestWrapper(localName = "getLockedBy", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", className = "org.smpte_ra.schemas.st2071._2014.session.EmptyRequest")
    @ResponseWrapper(localName = "getLockedByResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", className = "org.smpte_ra.schemas.st2071._2014.session.GetLockedByResponse")
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/session/Lockable/LockedBy", output = "http://www.smpte-ra.org/wsdl/st2071/2014/session/Lockable/LockedByResponse")
    public Session getLockedBy();

    /**
     * 
     * @param lock
     * @return
     *     returns org.smpte_ra.schemas.st2071._2014.session.URIResponse
     * @throws SecurityExceptionFault
     * @throws NotAcquiredFault
     * @throws SessionNotFoundFault
     * @throws NotLockedFault
     */
    @WebMethod(action = "http://www.smpte-ra.org/wsdl/st2071/2014/device/control/Lockable/lock")
    @WebResult(name = "lockResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", partName = "lockResponse")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/session/Lockable/lock", output = "http://www.smpte-ra.org/wsdl/st2071/2014/session/Lockable/lockResponse")
    public URIResponse lock(
        @WebParam(name = "lock", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", partName = "lock")
        Lock lock)
        throws NotAcquiredFault, NotLockedFault, SecurityExceptionFault, SessionNotFoundFault
    ;

    /**
     * 
     * @param unlock
     * @return
     *     returns org.smpte_ra.schemas.st2071._2014.session.BooleanResponse
     * @throws SecurityExceptionFault
     * @throws NotAcquiredFault
     * @throws LockNotFoundFault
     * @throws NotLockedFault
     */
    @WebMethod(action = "http://www.smpte-ra.org/wsdl/st2071/2014/device/control/Lockable/unlock")
    @WebResult(name = "unlockResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", partName = "unlockResponse")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/session/Lockable/unlock", output = "http://www.smpte-ra.org/wsdl/st2071/2014/session/Lockable/unlockResponse")
    public BooleanResponse unlock(
        @WebParam(name = "unlock", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", partName = "unlock")
        URIRequest unlock)
        throws LockNotFoundFault, NotAcquiredFault, NotLockedFault, SecurityExceptionFault
    ;

}
