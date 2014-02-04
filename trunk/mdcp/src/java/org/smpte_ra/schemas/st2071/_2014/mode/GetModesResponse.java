
package org.smpte_ra.schemas.st2071._2014.mode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getModesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getModesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/mode}Modes"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getModesResponse", propOrder = {
    "modes"
})
public class GetModesResponse {

    @XmlElement(name = "Modes", required = true)
    protected Modes modes;

    /**
     * Gets the value of the modes property.
     * 
     * @return
     *     possible object is
     *     {@link Modes }
     *     
     */
    public Modes getModes() {
        return modes;
    }

    /**
     * Sets the value of the modes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Modes }
     *     
     */
    public void setModes(Modes value) {
        this.modes = value;
    }

}
