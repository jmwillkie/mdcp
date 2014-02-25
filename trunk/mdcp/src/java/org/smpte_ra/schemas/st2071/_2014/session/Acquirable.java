
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
 *             UCN = urn:smpte:ucn:org.smpte.st2071:acquirable_v1.0
 *         
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Acquirable", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/session")
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
public interface Acquirable {


    /**
     * 
     * @return
     *     returns boolean
     */
    @WebMethod(action = "http://www.smpte-ra.org/wsdl/st2071/2014/device/control/Acquirable/Acquired")
    @WebResult(name = "Boolean", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/types")
    @RequestWrapper(localName = "getAcquired", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", className = "org.smpte_ra.schemas.st2071._2014.session.EmptyRequest")
    @ResponseWrapper(localName = "getAcquiredResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", className = "org.smpte_ra.schemas.st2071._2014.session.BooleanResponse")
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/session/Acquirable/Acquired", output = "http://www.smpte-ra.org/wsdl/st2071/2014/session/Acquirable/AcquiredResponse")
    public boolean getAcquired();

    /**
     * 
     * @return
     *     returns org.smpte_ra.schemas.st2071._2014.session.Sessions
     */
    @WebMethod(action = "http://www.smpte-ra.org/wsdl/st2071/2014/device/control/Acquirable/AcquiredBy")
    @WebResult(name = "Sessions", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/session")
    @RequestWrapper(localName = "getAcquiredBy", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", className = "org.smpte_ra.schemas.st2071._2014.session.EmptyRequest")
    @ResponseWrapper(localName = "getAcquiredByResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", className = "org.smpte_ra.schemas.st2071._2014.session.GetAcquiredByResponse")
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/session/Acquirable/AcquiredBy", output = "http://www.smpte-ra.org/wsdl/st2071/2014/session/Acquirable/AcquiredByResponse")
    public Sessions getAcquiredBy();

    /**
     * 
     * @param acquire
     * @return
     *     returns org.smpte_ra.schemas.st2071._2014.session.URIResponse
     * @throws LockedFault
     * @throws TooManySessionsFault
     * @throws NotAcquiredFault
     * @throws NameInUseFault
     * @throws SecurityExceptionFault
     */
    @WebMethod(action = "http://www.smpte-ra.org/wsdl/st2071/2014/device/control/Acquirable/acquire")
    @WebResult(name = "acquireResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", partName = "acquireResponse")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/session/Acquirable/acquire", output = "http://www.smpte-ra.org/wsdl/st2071/2014/session/Acquirable/acquireResponse")
    public URIResponse acquire(
        @WebParam(name = "acquire", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", partName = "acquire")
        Acquire acquire)
        throws LockedFault, NameInUseFault, NotAcquiredFault, SecurityExceptionFault, TooManySessionsFault
    ;

    /**
     * 
     * @param release
     * @return
     *     returns org.smpte_ra.schemas.st2071._2014.session.BooleanResponse
     * @throws LockedFault
     * @throws NotAcquiredFault
     * @throws SessionNotFoundFault
     * @throws SecurityExceptionFault
     */
    @WebMethod(action = "http://www.smpte-ra.org/wsdl/st2071/2014/device/control/Acquirable/release")
    @WebResult(name = "releaseResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", partName = "releaseResponse")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/session/Acquirable/release", output = "http://www.smpte-ra.org/wsdl/st2071/2014/session/Acquirable/releaseResponse")
    public BooleanResponse release(
        @WebParam(name = "release", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", partName = "release")
        URIRequest release)
        throws LockedFault, NotAcquiredFault, SecurityExceptionFault, SessionNotFoundFault
    ;

}
