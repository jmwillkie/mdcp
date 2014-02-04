
package org.smpte_ra.schemas.st2071._2014.security;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getMechanismsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getMechanismsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/security}Mechanisms"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMechanismsResponse", propOrder = {
    "mechanisms"
})
public class GetMechanismsResponse {

    @XmlElement(name = "Mechanisms", required = true)
    protected Mechanisms mechanisms;

    /**
     * Gets the value of the mechanisms property.
     * 
     * @return
     *     possible object is
     *     {@link Mechanisms }
     *     
     */
    public Mechanisms getMechanisms() {
        return mechanisms;
    }

    /**
     * Sets the value of the mechanisms property.
     * 
     * @param value
     *     allowed object is
     *     {@link Mechanisms }
     *     
     */
    public void setMechanisms(Mechanisms value) {
        this.mechanisms = value;
    }

}
