package org.smpte_ra.schemas.st2071._2014.event;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;

/**
 * The CallbackHandler Interface is a Client Side Interface Used to Receive Asynchronous Events
 *         
 *
 * This class was generated by Apache CXF 2.7.10
 * 2014-03-09T14:41:22.949-04:00
 * Generated source version: 2.7.10
 * 
 */
@WebService(targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/event", name = "CallbackHandler")
@XmlSeeAlso({org.smpte_ra.schemas.st2071._2014.types.ObjectFactory.class, org.smpte_ra.schemas.st2071._2014.security.ObjectFactory.class, org.smpte_ra.schemas.st2071._2014.identity.ObjectFactory.class, ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface CallbackHandler {

    @Oneway
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/event/CallbackHandler/unregistered")
    @WebMethod(action = "http://www.smpte-ra.org/schemas/st2071/2014/event/CallbackHandler/unregistered")
    public void unregistered(
        @WebParam(partName = "unregistered", name = "unregistered", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/event")
        URIParameter unregistered
    );

    @Oneway
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/event/CallbackHandler/registered")
    @WebMethod(action = "http://www.smpte-ra.org/schemas/st2071/2014/event/CallbackHandler/registered")
    public void registered(
        @WebParam(partName = "registered", name = "registered", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/event")
        URIParameter registered
    );

    @Oneway
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/event/CallbackHandler/callback")
    @WebMethod(action = "http://www.smpte-ra.org/schemas/st2071/2014/event/CallbackHandler/callback")
    public void callback(
        @WebParam(partName = "callback", name = "callback", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/event")
        Callback callback
    );

    @WebResult(name = "heartbeatResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/event", partName = "heartbeatResponse")
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/event/CallbackHandler/heartbeat", output = "http://www.smpte-ra.org/wsdl/st2071/2014/event/CallbackHandler/heartbeatResponse")
    @WebMethod
    public HeartbeatResponse heartbeat(
        @WebParam(partName = "heartbeat", name = "heartbeat", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/event")
        UDNParameter heartbeat
    );
}
