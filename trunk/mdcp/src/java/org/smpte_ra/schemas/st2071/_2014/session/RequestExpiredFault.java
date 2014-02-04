
package org.smpte_ra.schemas.st2071._2014.session;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "RequestExpired", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/session")
public class RequestExpiredFault
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private RequestExpired faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public RequestExpiredFault(String message, RequestExpired faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public RequestExpiredFault(String message, RequestExpired faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: org.smpte_ra.schemas.st2071._2014.session.RequestExpired
     */
    public RequestExpired getFaultInfo() {
        return faultInfo;
    }

}