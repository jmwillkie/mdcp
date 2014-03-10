
package org.smpte_ra.schemas.st2071._2014.session;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.10
 * 2014-03-09T14:41:07.623-04:00
 * Generated source version: 2.7.10
 */

@WebFault(name = "RequestExpired", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/session")
public class RequestExpiredFault extends java.lang.Exception {
    
    private org.smpte_ra.schemas.st2071._2014.session.RequestExpired requestExpired;

    public RequestExpiredFault() {
        super();
    }
    
    public RequestExpiredFault(String message) {
        super(message);
    }
    
    public RequestExpiredFault(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestExpiredFault(String message, org.smpte_ra.schemas.st2071._2014.session.RequestExpired requestExpired) {
        super(message);
        this.requestExpired = requestExpired;
    }

    public RequestExpiredFault(String message, org.smpte_ra.schemas.st2071._2014.session.RequestExpired requestExpired, Throwable cause) {
        super(message, cause);
        this.requestExpired = requestExpired;
    }

    public org.smpte_ra.schemas.st2071._2014.session.RequestExpired getFaultInfo() {
        return this.requestExpired;
    }
}