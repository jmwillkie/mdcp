
package org.smpte_ra.schemas.st2071._2014.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.smpte_ra.schemas.st2071._2014.identity.URLs;


/**
 * <p>Java class for Capability complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Capability">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/identity}UCN"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/types}Attributes"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/identity}URLs"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Capability", propOrder = {
    "ucn",
    "attributes",
    "urLs"
})
public class Capability {

    @XmlElement(name = "UCN", namespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity", required = true)
    protected String ucn;
    @XmlElement(name = "Attributes", required = true)
    protected Map attributes;
    @XmlElement(name = "URLs", namespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity", required = true)
    protected URLs urLs;

    /**
     * Gets the value of the ucn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUCN() {
        return ucn;
    }

    /**
     * Sets the value of the ucn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUCN(String value) {
        this.ucn = value;
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

}
