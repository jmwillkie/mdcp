
package org.smpte_ra.schemas.st2071._2014.security;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.smpte_ra.schemas.st2071._2014.types.DateTime;


/**
 * <p>Java class for SecurityToken complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SecurityToken">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/security}Mechanism"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/security}Data"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/security}ValidTill"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SecurityToken", propOrder = {
    "mechanism",
    "data",
    "validTill"
})
public class SecurityToken {

    @XmlElement(name = "Mechanism", required = true)
    protected String mechanism;
    @XmlElement(name = "Data", required = true)
    protected byte[] data;
    @XmlElement(name = "ValidTill", required = true)
    protected DateTime validTill;

    /**
     * Gets the value of the mechanism property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMechanism() {
        return mechanism;
    }

    /**
     * Sets the value of the mechanism property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMechanism(String value) {
        this.mechanism = value;
    }

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setData(byte[] value) {
        this.data = value;
    }

    /**
     * Gets the value of the validTill property.
     * 
     * @return
     *     possible object is
     *     {@link DateTime }
     *     
     */
    public DateTime getValidTill() {
        return validTill;
    }

    /**
     * Sets the value of the validTill property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTime }
     *     
     */
    public void setValidTill(DateTime value) {
        this.validTill = value;
    }

}
