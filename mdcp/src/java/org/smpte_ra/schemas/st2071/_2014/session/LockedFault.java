
package org.smpte_ra.schemas.st2071._2014.session;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.10
 * 2014-03-09T14:41:07.475-04:00
 * Generated source version: 2.7.10
 */

@WebFault(name = "Locked", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/session")
public class LockedFault extends java.lang.Exception {
    
    private org.smpte_ra.schemas.st2071._2014.session.Locked locked;

    public LockedFault() {
        super();
    }
    
    public LockedFault(String message) {
        super(message);
    }
    
    public LockedFault(String message, Throwable cause) {
        super(message, cause);
    }

    public LockedFault(String message, org.smpte_ra.schemas.st2071._2014.session.Locked locked) {
        super(message);
        this.locked = locked;
    }

    public LockedFault(String message, org.smpte_ra.schemas.st2071._2014.session.Locked locked, Throwable cause) {
        super(message, cause);
        this.locked = locked;
    }

    public org.smpte_ra.schemas.st2071._2014.session.Locked getFaultInfo() {
        return this.locked;
    }
}
