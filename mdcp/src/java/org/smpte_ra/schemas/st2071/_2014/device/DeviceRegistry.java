package org.smpte_ra.schemas.st2071._2014.device;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;

/**
 * UCN = urn:smpte:ucn:org.smpte.st2071:device_registry_v1.0
 *         
 *
 * This class was generated by Apache CXF 2.7.10
 * 2014-03-09T14:41:46.906-04:00
 * Generated source version: 2.7.10
 * 
 */
@WebService(targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "DeviceRegistry")
@XmlSeeAlso({org.smpte_ra.schemas.st2071._2014.query.ObjectFactory.class, org.smpte_ra.schemas.st2071._2014.mode.ObjectFactory.class, org.smpte_ra.schemas.st2071._2014.media.ObjectFactory.class, org.smpte_ra.schemas.st2071._2014.types.ObjectFactory.class, org.smpte_ra.schemas.st2071._2014.security.ObjectFactory.class, org.smpte_ra.schemas.st2071._2014.identity.ObjectFactory.class, ObjectFactory.class, org.smpte_ra.schemas.st2071._2014.event.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface DeviceRegistry {

    @WebResult(name = "unbindResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", partName = "unbindResponse")
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/device/DeviceRegistry/unbind", output = "http://www.smpte-ra.org/wsdl/st2071/2014/device/DeviceRegistry/unbindResponse", fault = {})
    @WebMethod(action = "http://www.smpte-ra.org/schemas/st2071/2014/device/DeviceRegistry/unbind")
    public UnbindResponse unbind(
        @WebParam(partName = "unbind", name = "unbind", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/device")
        Unbind unbind
    ) throws org.smpte_ra.schemas.st2071._2014.security.SecurityExceptionFault, DeviceNotFoundFault_Exception, DeviceNotUnboundFault;

    @WebResult(name = "setOnlineResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", partName = "setOnlineResponse")
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/device/DeviceRegistry/setOnline", output = "http://www.smpte-ra.org/wsdl/st2071/2014/device/DeviceRegistry/setOnlineResponse", fault = {})
    @WebMethod(action = "http://www.smpte-ra.org/schemas/st2071/2014/device/DeviceRegistry/setOnline")
    public SetOnlineResponse setOnline(
        @WebParam(partName = "setOnline", name = "setOnline", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/device")
        SetOnline setOnline
    ) throws DeviceNotFoundFault_Exception, org.smpte_ra.schemas.st2071._2014.security.SecurityExceptionFault;

    @WebResult(name = "bindResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", partName = "bindResponse")
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/device/DeviceRegistry/bind", output = "http://www.smpte-ra.org/wsdl/st2071/2014/device/DeviceRegistry/bindResponse", fault = {})
    @WebMethod(action = "http://www.smpte-ra.org/schemas/st2071/2014/device/DeviceRegistry/bind")
    public BindResponse bind(
        @WebParam(partName = "bind", name = "bind", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/device")
        Bind bind
    ) throws org.smpte_ra.schemas.st2071._2014.security.SecurityExceptionFault, DeviceNotBoundFault, DeviceNotFoundFault_Exception, DeviceAlreadyBoundFault;
}
