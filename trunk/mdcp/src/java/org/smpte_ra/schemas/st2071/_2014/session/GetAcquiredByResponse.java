
package org.smpte_ra.schemas.st2071._2014.session;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getAcquiredByResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAcquiredByResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/session}Sessions"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAcquiredByResponse", propOrder = {
    "sessions"
})
public class GetAcquiredByResponse {

    @XmlElement(name = "Sessions", required = true)
    protected Sessions sessions;

    /**
     * Gets the value of the sessions property.
     * 
     * @return
     *     possible object is
     *     {@link Sessions }
     *     
     */
    public Sessions getSessions() {
        return sessions;
    }

    /**
     * Sets the value of the sessions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Sessions }
     *     
     */
    public void setSessions(Sessions value) {
        this.sessions = value;
    }

}
