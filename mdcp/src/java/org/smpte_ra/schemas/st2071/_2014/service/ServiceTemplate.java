
package org.smpte_ra.schemas.st2071._2014.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.smpte_ra.schemas.st2071._2014.types.Capabilities;
import org.smpte_ra.schemas.st2071._2014.types.Map;


/**
 * <p>Java class for ServiceTemplate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceTemplate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/identity}USN"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/service}Attributes"/>
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
@XmlType(name = "ServiceTemplate", propOrder = {
    "usn",
    "attributes",
    "capabilities"
})
public class ServiceTemplate {

    @XmlElement(name = "USN", namespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity", required = true)
    protected String usn;
    @XmlElement(name = "Attributes", required = true)
    protected Map attributes;
    @XmlElement(name = "Capabilities", namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", required = true)
    protected Capabilities capabilities;

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

    /**
     * Gets the value of the attributes property.
     * 
     * @return
     *     possible object is
     *     {@link Map }
     *     
     */
    public Map getAttributes() {
        return attributes;
    }

    /**
     * Sets the value of the attributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Map }
     *     
     */
    public void setAttributes(Map value) {
        this.attributes = value;
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
