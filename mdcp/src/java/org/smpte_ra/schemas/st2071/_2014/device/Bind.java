
package org.smpte_ra.schemas.st2071._2014.device;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.smpte_ra.schemas.st2071._2014.identity.URLs;
import org.smpte_ra.schemas.st2071._2014.types.Capabilities;


/**
 * <p>Java class for bind complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bind">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/device}UDN"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/device}ParentUDN"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/device}URLs"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/types}Capabilities"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bind", propOrder = {
    "udn",
    "parentUDN",
    "urLs",
    "capabilities"
})
public class Bind {

    @XmlElement(name = "UDN", required = true)
    protected String udn;
    @XmlElement(name = "ParentUDN", required = true)
    protected String parentUDN;
    @XmlElement(name = "URLs", required = true)
    protected URLs urLs;
    @XmlElement(name = "Capabilities", namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", required = true)
    protected Capabilities capabilities;

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
     * Gets the value of the parentUDN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentUDN() {
        return parentUDN;
    }

    /**
     * Sets the value of the parentUDN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentUDN(String value) {
        this.parentUDN = value;
    }

    /**
     * Gets the value of the urLs property.
     * 
     * @return
     *     possible object is
     *     {@link URLs }
     *     
     */
    public URLs getURLs() {
        return urLs;
    }

    /**
     * Sets the value of the urLs property.
     * 
     * @param value
     *     allowed object is
     *     {@link URLs }
     *     
     */
    public void setURLs(URLs value) {
        this.urLs = value;
    }

    /**
     * Gets the value of the capabilities property.
     * 
     * @return
     *     possible object is
     *     {@link Capabilities }
     *     
     */
    public Capabilities getCapabilities() {
        return capabilities;
    }

    /**
     * Sets the value of the capabilities property.
     * 
     * @param value
     *     allowed object is
     *     {@link Capabilities }
     *     
     */
    public void setCapabilities(Capabilities value) {
        this.capabilities = value;
    }

}
