package org.smpte_ra.schemas.st2071._2014.media;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;

/**
 * UCN = urn:smpte:ucn:org.smpte.st2071:media_access_v1.0
 *         
 *
 * This class was generated by Apache CXF 2.7.10
 * 2014-03-09T14:41:59.807-04:00
 * Generated source version: 2.7.10
 * 
 */
@WebService(targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "MediaAccess")
@XmlSeeAlso({org.smpte_ra.schemas.st2071._2014.query.ObjectFactory.class, org.smpte_ra.schemas.st2071._2014.mode.ObjectFactory.class, ObjectFactory.class, org.smpte_ra.schemas.st2071._2014.types.ObjectFactory.class, org.smpte_ra.schemas.st2071._2014.security.ObjectFactory.class, org.smpte_ra.schemas.st2071._2014.identity.ObjectFactory.class, org.smpte_ra.schemas.st2071._2014.device.ObjectFactory.class, org.smpte_ra.schemas.st2071._2014.event.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface MediaAccess {

    @WebResult(name = "lookupURLsResponse", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", partName = "lookupURLsResponse")
    @Action(input = "http://www.smpte-ra.org/wsdl/st2071/2014/media/MediaDirectory/lookupURLs", output = "http://www.smpte-ra.org/wsdl/st2071/2014/media/MediaDirectory/lookupURLsResponse", fault = {})
    @WebMethod(action = "http://www.smpte-ra.org/wsdl/st2071/2014/media/MediaAccess/lookupURLs")
    public LookupURLsResponse lookupURLs(
        @WebParam(partName = "lookupURLs", name = "lookupURLs", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/media")
        UMNParameter lookupURLs
    ) throws org.smpte_ra.schemas.st2071._2014.security.SecurityExceptionFault, MediaNotFoundFault;
}
