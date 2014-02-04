
package org.smpte_ra.schemas.st2071._2014.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getUSNResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getUSNResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/identity}USN"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getUSNResponse", propOrder = {
    "usn"
})
public class GetUSNResponse {

    @XmlElement(name = "USN", namespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity", required = true)
    protected String usn;

    /**
     * Gets the value of the usn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSN() {
        return usn;
    }

    /**
     * Sets the value of the usn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSN(String value) {
        this.usn = value;
    }

}
