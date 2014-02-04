
package org.smpte_ra.schemas.st2071._2014.mode;

import javax.xml.ws.WebFault;
import org.smpte_ra.schemas.st2071._2014.security.SecurityException;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "SecurityException", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/security")
public class SecurityExceptionFault
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private SecurityException faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public SecurityExceptionFault(String message, SecurityException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public SecurityExceptionFault(String message, SecurityException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: org.smpte_ra.schemas.st2071._2014.security.SecurityException
     */
    public SecurityException getFaultInfo() {
        return faultInfo;
    }

}
