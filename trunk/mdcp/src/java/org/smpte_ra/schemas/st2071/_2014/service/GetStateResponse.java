
package org.smpte_ra.schemas.st2071._2014.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getStateResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getStateResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/service}State"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getStateResponse", propOrder = {
    "state"
})
public class GetStateResponse {

    @XmlElement(name = "State", required = true)
    protected SERVICESTATE state;

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link SERVICESTATE }
     *     
     */
    public SERVICESTATE getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link SERVICESTATE }
     *     
     */
    public void setState(SERVICESTATE value) {
        this.state = value;
    }

}
