
package org.smpte_ra.schemas.st2071._2014.session;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "TooManySessions", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/session")
public class TooManySessionsFault
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private TooManySessions faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public TooManySessionsFault(String message, TooManySessions faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public TooManySessionsFault(String message, TooManySessions faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: org.smpte_ra.schemas.st2071._2014.session.TooManySessions
     */
    public TooManySessions getFaultInfo() {
        return faultInfo;
    }

}
