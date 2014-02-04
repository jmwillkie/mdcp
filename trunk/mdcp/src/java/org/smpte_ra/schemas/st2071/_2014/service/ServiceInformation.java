
package org.smpte_ra.schemas.st2071._2014.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.smpte_ra.schemas.st2071._2014.identity.URLs;
import org.smpte_ra.schemas.st2071._2014.types.Capabilities;
import org.smpte_ra.schemas.st2071._2014.types.DateTime;
import org.smpte_ra.schemas.st2071._2014.types.Map;


/**
 * <p>Java class for ServiceInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/identity}USN"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/service}Type"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/service}State"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/identity}URLs"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/service}Attributes"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/types}Capabilities"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/service}ValidTill"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/service}Created"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/service}CreatedBy"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceInformation", propOrder = {
    "usn",
    "type",
    "state",
    "urLs",
    "attributes",
    "capabilities",
    "validTill",
    "created",
    "createdBy"
})
public class ServiceInformation {

    @XmlElement(name = "USN", namespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity", required = true)
    protected String usn;
    @XmlElement(name = "Type", required = true)
    protected ServiceTemplate type;
    @XmlElement(name = "State", required = true)
    protected SERVICESTATE state;
    @XmlElement(name = "URLs", namespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity", required = true)
    protected URLs urLs;
    @XmlElement(name = "Attributes", required = true)
    protected Map attributes;
    @XmlElement(name = "Capabilities", namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", required = true)
    protected Capabilities capabilities;
    @XmlElement(name = "ValidTill", required = true)
    protected DateTime validTill;
    @XmlElement(name = "Created", required = true)
    protected DateTime created;
    @XmlElement(name = "CreatedBy", required = true)
    protected String createdBy;

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
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceTemplate }
     *     
     */
    public ServiceTemplate getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceTemplate }
     *     
     */
    public void setType(ServiceTemplate value) {
        this.type = value;
    }

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

    /**
     * Gets the value of the created property.
     * 
     * @return
     *     possible object is
     *     {@link DateTime }
     *     
     */
    public DateTime getCreated() {
        return created;
    }

    /**
     * Sets the value of the created property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTime }
     *     
     */
    public void setCreated(DateTime value) {
        this.created = value;
    }

    /**
     * Gets the value of the createdBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets the value of the createdBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatedBy(String value) {
        this.createdBy = value;
    }

}
