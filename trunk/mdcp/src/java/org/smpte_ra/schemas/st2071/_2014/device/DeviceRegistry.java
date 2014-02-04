
package org.smpte_ra.schemas.st2071._2014.device;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import org.smpte_ra.schemas.st2071._2014.identity.URLs;
import org.smpte_ra.schemas.st2071._2014.types.Capabilities;


/**
 * 
 *             UCN = urn:smpte:ucn:org.smpte.st2071:device_registry_v1.0
 *         
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "DeviceRegistry", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/device")
@XmlSeeAlso({
    org.smpte_ra.schemas.st2071._2014.device.ObjectFactory.class,
    org.smpte_ra.schemas.st2071._2014.event.ObjectFactory.class,
    org.smpte_ra.schemas.st2071._2014.identity.ObjectFactory.class,
    org.smpte_ra.schemas.st2071._2014.media.ObjectFactory.class,
    org.smpte_ra.schemas.st2071._2014.mode.ObjectFactory.class,
    org.smpte_ra.schemas.st2071._2014.query.ObjectFactory.class,
    org.smpte_ra.schemas.st2071._2014.security.ObjectFactory.class,
    org.smpte_ra.schemas.st2071._2014.types.ObjectFactory.class
})
public interface DeviceRegistry {


    /**
     * 
     * @param urLs
     * @param parentUDN
     * @param capabilities
     * @param udn
     * @throws DeviceNotBoundFault
     * @throws DeviceAlreadyBoundFault
     * @throws SecurityExceptionFault
     * @throws DeviceNotFoundFault_Exception
     */
    @WebMethod(action = "http://www.smpte-ra.org/schemas/st2071/2014/device/DeviceRegistry/bind")
    @RequestWrapper(localName = "bind", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", className = "org.smpte_ra.schemas.st2071._2014.device.Bind")
    @ResponseWrapper(localName = "bindResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", className = "org.smpte_ra.schemas.st2071._2014.device.BindResponse")
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/device/DeviceRegistry/bind", output = "http://www.smpte-ra.org/wsdl/st2071/2014/device/DeviceRegistry/bindResponse")
    public void bind(
        @WebParam(name = "UDN", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/device")
        String udn,
        @WebParam(name = "ParentUDN", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/device")
        String parentUDN,
        @WebParam(name = "URLs", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/device")
        URLs urLs,
        @WebParam(name = "Capabilities", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/types")
        Capabilities capabilities)
        throws DeviceAlreadyBoundFault, DeviceNotBoundFault, DeviceNotFoundFault_Exception, SecurityExceptionFault
    ;

    /**
     * 
     * @param udn
     * @throws SecurityExceptionFault
     * @throws DeviceNotUnboundFault
     * @throws DeviceNotFoundFault_Exception
     */
    @WebMethod(action = "http://www.smpte-ra.org/schemas/st2071/2014/device/DeviceRegistry/unbind")
    @RequestWrapper(localName = "unbind", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", className = "org.smpte_ra.schemas.st2071._2014.device.Unbind")
    @ResponseWrapper(localName = "unbindResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", className = "org.smpte_ra.schemas.st2071._2014.device.UnbindResponse")
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/device/DeviceRegistry/unbind", output = "http://www.smpte-ra.org/wsdl/st2071/2014/device/DeviceRegistry/unbindResponse")
    public void unbind(
        @WebParam(name = "UDN", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity")
        String udn)
        throws DeviceNotFoundFault_Exception, DeviceNotUnboundFault, SecurityExceptionFault
    ;

    /**
     * 
     * @param _boolean
     * @param udn
     * @throws SecurityExceptionFault
     * @throws DeviceNotFoundFault_Exception
     */
    @WebMethod(action = "http://www.smpte-ra.org/schemas/st2071/2014/device/DeviceRegistry/setOnline")
    @RequestWrapper(localName = "setOnline", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", className = "org.smpte_ra.schemas.st2071._2014.device.SetOnline")
    @ResponseWrapper(localName = "setOnlineResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", className = "org.smpte_ra.schemas.st2071._2014.device.SetOnlineResponse")
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/device/DeviceRegistry/setOnline", output = "http://www.smpte-ra.org/wsdl/st2071/2014/device/DeviceRegistry/setOnlineResponse")
    public void setOnline(
        @WebParam(name = "UDN", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity")
        String udn,
        @WebParam(name = "Boolean", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", mode = WebParam.Mode.INOUT)
        Holder<Boolean> _boolean)
        throws DeviceNotFoundFault_Exception, SecurityExceptionFault
    ;

}
