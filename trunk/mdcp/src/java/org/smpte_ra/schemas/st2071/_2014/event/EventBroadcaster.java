package org.smpte_ra.schemas.st2071._2014.event;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;

/**
 * UCN = urn:smpte:ucn:org.smpte.st2071:event_broadcaster_v1.0
 *         
 *
 * This class was generated by Apache CXF 2.7.10
 * 2014-03-09T14:41:23.039-04:00
 * Generated source version: 2.7.10
 * 
 */
@WebService(targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/event", name = "EventBroadcaster")
@XmlSeeAlso({org.smpte_ra.schemas.st2071._2014.types.ObjectFactory.class, org.smpte_ra.schemas.st2071._2014.security.ObjectFactory.class, org.smpte_ra.schemas.st2071._2014.identity.ObjectFactory.class, ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface EventBroadcaster {

    @WebResult(name = "unregisterCallbackResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/event", partName = "unregisterCallbackResponse")
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/event/EventBroadcaster/unregisterCallback", output = "http://www.smpte-ra.org/wsdl/st2071/2014/event/EventBroadcaster/unregisterCallbackResponse", fault = {})
    @WebMethod(action = "http://www.smpte-ra.org/schemas/st2071/2014/eventBroadcaster/unregisterCallback")
    public UnregisterCallbackResponse unregisterCallback(
        @WebParam(partName = "unregisterCallback", name = "unregisterCallback", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/event")
        URIParameter unregisterCallback
    ) throws org.smpte_ra.schemas.st2071._2014.security.SecurityExceptionFault;

    @WebResult(name = "registerCallbackResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/event", partName = "registerCallbackResponse")
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/event/EventBroadcaster/registerCallback", output = "http://www.smpte-ra.org/wsdl/st2071/2014/event/EventBroadcaster/registerCallbackResponse", fault = {})
    @WebMethod(action = "http://www.smpte-ra.org/schemas/st2071/2014/eventBroadcaster/registerCallback")
    public RegisterCallbackResponse registerCallback(
        @WebParam(partName = "registerCallback", name = "registerCallback", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/event")
        URIParameter registerCallback
    ) throws org.smpte_ra.schemas.st2071._2014.security.SecurityExceptionFault;
}
