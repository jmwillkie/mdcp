package org.smpte_ra.schemas.st2071._2014.device;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;

/**
 * UCN = urn:smpte:ucn:org.smpte.st2071:device_v1.0
 *         
 *
 * This class was generated by Apache CXF 2.7.10
 * 2014-03-09T14:41:46.859-04:00
 * Generated source version: 2.7.10
 * 
 */
@WebService(targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "Device")
@XmlSeeAlso({org.smpte_ra.schemas.st2071._2014.query.ObjectFactory.class, org.smpte_ra.schemas.st2071._2014.mode.ObjectFactory.class, org.smpte_ra.schemas.st2071._2014.media.ObjectFactory.class, org.smpte_ra.schemas.st2071._2014.types.ObjectFactory.class, org.smpte_ra.schemas.st2071._2014.security.ObjectFactory.class, org.smpte_ra.schemas.st2071._2014.identity.ObjectFactory.class, ObjectFactory.class, org.smpte_ra.schemas.st2071._2014.event.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface Device {

    @WebResult(name = "getUDNResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", partName = "getUDNResponse")
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/device/Device/UDN", output = "http://www.smpte-ra.org/wsdl/st2071/2014/device/Device/UDNResponse")
    @WebMethod(action = "http://www.smpte-ra.org/schemas/st2071/2014/device/Device/UDN")
    public GetUDNResponse getUDN(
        @WebParam(partName = "getUDN", name = "getUDN", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/device")
        GetUDN getUDN
    );

    @WebResult(name = "getOnlineResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", partName = "getOnlineResponse")
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/device/Device/Online", output = "http://www.smpte-ra.org/wsdl/st2071/2014/device/Device/OnlineResponse")
    @WebMethod(action = "http://www.smpte-ra.org/schemas/st2071/2014/device/Device/Online")
    public GetOnlineResponse getOnline(
        @WebParam(partName = "getOnline", name = "getOnline", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/device")
        GetOnline getOnline
    );

    @WebResult(name = "getNameResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", partName = "getNameResponse")
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/device/Device/Name", output = "http://www.smpte-ra.org/wsdl/st2071/2014/device/Device/NameResponse")
    @WebMethod(action = "http://www.smpte-ra.org/schemas/st2071/2014/device/Device/Name")
    public GetNameResponse getName(
        @WebParam(partName = "getName", name = "getName", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/device")
        GetName getName
    );

    @WebResult(name = "getCapabilitiesResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", partName = "getCapabilitiesResponse")
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/device/Device/Capabilities", output = "http://www.smpte-ra.org/wsdl/st2071/2014/device/Device/CapabilitiesResponse")
    @WebMethod(action = "http://www.smpte-ra.org/schemas/st2071/2014/device/Device/Capabilities")
    public GetCapabilitiesResponse getCapabilities(
        @WebParam(partName = "getCapabilities", name = "getCapabilities", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/device")
        GetCapabilities getCapabilities
    );

    @WebResult(name = "getAttributesResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", partName = "getAttributesResponse")
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/device/Device/Attributes", output = "http://www.smpte-ra.org/wsdl/st2071/2014/device/Device/AttributesResponse")
    @WebMethod(action = "http://www.smpte-ra.org/schemas/st2071/2014/device/Device/Attributes")
    public GetAttributesResponse getAttributes(
        @WebParam(partName = "getAttributes", name = "getAttributes", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/device")
        GetAttributes getAttributes
    );

    @WebResult(name = "getURLsResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", partName = "getURLsResponse")
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/device/Device/URLs", output = "http://www.smpte-ra.org/wsdl/st2071/2014/device/Device/URLsResponse")
    @WebMethod(action = "http://www.smpte-ra.org/schemas/st2071/2014/device/Device/URLs")
    public GetURLsResponse getURLs(
        @WebParam(partName = "getURLs", name = "getURLs", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/device")
        GetURLs getURLs
    );
}