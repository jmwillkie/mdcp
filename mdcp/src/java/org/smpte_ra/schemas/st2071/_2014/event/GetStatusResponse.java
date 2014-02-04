
package org.smpte_ra.schemas.st2071._2014.event;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getStatusResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getStatusResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/event}StatusEvent" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getStatusResponse", propOrder = {
    "statusEvent"
})
public class GetStatusResponse {

    @XmlElement(name = "StatusEvent")
    protected StatusEvent statusEvent;

    /**
     * Gets the value of the statusEvent property.
     * 
     * @return
     *     possible object is
     *     {@link StatusEvent }
     *     
     */
    public StatusEvent getStatusEvent() {
        return statusEvent;
    }

    /**
     * Sets the value of the statusEvent property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusEvent }
     *     
     */
    public void setStatusEvent(StatusEvent value) {
        this.statusEvent = value;
    }

}
