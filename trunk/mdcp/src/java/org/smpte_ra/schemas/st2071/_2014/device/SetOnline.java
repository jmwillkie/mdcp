
package org.smpte_ra.schemas.st2071._2014.device;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for setOnline complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="setOnline">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/identity}UDN"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/types}Boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setOnline", propOrder = {
    "udn",
    "_boolean"
})
public class SetOnline {

    @XmlElement(name = "UDN", namespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity", required = true)
    protected String udn;
    @XmlElement(name = "Boolean", namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types")
    protected boolean _boolean;

    /**
     * Gets the value of the udn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUDN() {
        return udn;
    }

    /**
     * Sets the value of the udn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUDN(String value) {
        this.udn = value;
    }

    /**
     * Gets the value of the boolean property.
     * 
     */
    public boolean isBoolean() {
        return _boolean;
    }

    /**
     * Sets the value of the boolean property.
     * 
     */
    public void setBoolean(boolean value) {
        this._boolean = value;
    }

}
