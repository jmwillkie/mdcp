
package org.smpte_ra.schemas.st2071._2014.device;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.10
 * 2014-03-09T14:41:46.801-04:00
 * Generated source version: 2.7.10
 */

@WebFault(name = "DeviceNotFound", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/device")
public class DeviceNotBoundFault extends java.lang.Exception {
    
    private org.smpte_ra.schemas.st2071._2014.device.DeviceNotFound deviceNotFound;

    public DeviceNotBoundFault() {
        super();
    }
    
    public DeviceNotBoundFault(String message) {
        super(message);
    }
    
    public DeviceNotBoundFault(String message, Throwable cause) {
        super(message, cause);
    }

    public DeviceNotBoundFault(String message, org.smpte_ra.schemas.st2071._2014.device.DeviceNotFound deviceNotFound) {
        super(message);
        this.deviceNotFound = deviceNotFound;
    }

    public DeviceNotBoundFault(String message, org.smpte_ra.schemas.st2071._2014.device.DeviceNotFound deviceNotFound, Throwable cause) {
        super(message, cause);
        this.deviceNotFound = deviceNotFound;
    }

    public org.smpte_ra.schemas.st2071._2014.device.DeviceNotFound getFaultInfo() {
        return this.deviceNotFound;
    }
}
