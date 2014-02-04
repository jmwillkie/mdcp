
package org.smpte_ra.schemas.st2071._2014.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.smpte_ra.schemas.st2071._2014.identity.USNs;


/**
 * <p>Java class for getNamespacesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getNamespacesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/identity}USNs"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getNamespacesResponse", propOrder = {
    "usNs"
})
public class GetNamespacesResponse {

    @XmlElement(name = "USNs", namespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity", required = true)
    protected USNs usNs;

    /**
     * Gets the value of the usNs property.
     * 
     * @return
     *     possible object is
     *     {@link USNs }
     *     
     */
    public USNs getUSNs() {
        return usNs;
    }

    /**
     * Sets the value of the usNs property.
     * 
     * @param value
     *     allowed object is
     *     {@link USNs }
     *     
     */
    public void setUSNs(USNs value) {
        this.usNs = value;
    }

}
