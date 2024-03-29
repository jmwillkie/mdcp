
package org.smpte_ra.schemas.st2071._2014.media;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.10
 * 2014-03-09T14:41:59.708-04:00
 * Generated source version: 2.7.10
 */

@WebFault(name = "MediaUpdateFailed", targetNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/media")
public class MediaUpdateFailedFault extends java.lang.Exception {
    
    private org.smpte_ra.schemas.st2071._2014.media.MediaUpdateFailed mediaUpdateFailed;

    public MediaUpdateFailedFault() {
        super();
    }
    
    public MediaUpdateFailedFault(String message) {
        super(message);
    }
    
    public MediaUpdateFailedFault(String message, Throwable cause) {
        super(message, cause);
    }

    public MediaUpdateFailedFault(String message, org.smpte_ra.schemas.st2071._2014.media.MediaUpdateFailed mediaUpdateFailed) {
        super(message);
        this.mediaUpdateFailed = mediaUpdateFailed;
    }

    public MediaUpdateFailedFault(String message, org.smpte_ra.schemas.st2071._2014.media.MediaUpdateFailed mediaUpdateFailed, Throwable cause) {
        super(message, cause);
        this.mediaUpdateFailed = mediaUpdateFailed;
    }

    public org.smpte_ra.schemas.st2071._2014.media.MediaUpdateFailed getFaultInfo() {
        return this.mediaUpdateFailed;
    }
}
