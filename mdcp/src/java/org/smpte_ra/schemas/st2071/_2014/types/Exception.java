
package org.smpte_ra.schemas.st2071._2014.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.smpte_ra.schemas.st2071._2014.device.DeviceException;
import org.smpte_ra.schemas.st2071._2014.media.MediaCreationFailed;
import org.smpte_ra.schemas.st2071._2014.media.MediaDeletionFailed;
import org.smpte_ra.schemas.st2071._2014.media.MediaNotFound;
import org.smpte_ra.schemas.st2071._2014.media.MediaUpdateFailed;
import org.smpte_ra.schemas.st2071._2014.mode.InvalidMode;
import org.smpte_ra.schemas.st2071._2014.mode.ModeException;
import org.smpte_ra.schemas.st2071._2014.query.InvalidQuery;
import org.smpte_ra.schemas.st2071._2014.security.SecurityException;
import org.smpte_ra.schemas.st2071._2014.service.ServiceException;


/**
 * <p>Java class for Exception complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Exception">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/types}Message"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Exception", propOrder = {
    "message"
})
@XmlSeeAlso({
    InvalidQuery.class,
    ModeException.class,
    InvalidMode.class,
    MediaDeletionFailed.class,
    MediaCreationFailed.class,
    MediaUpdateFailed.class,
    MediaNotFound.class,
    DeviceException.class,
    SecurityException.class,
    ServiceException.class
})
public abstract class Exception {

    @XmlElement(name = "Message", required = true)
    protected String message;

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

}
