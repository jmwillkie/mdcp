
package org.smpte_ra.schemas.st2071._2014.device;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.smpte_ra.schemas.st2071._2014.identity.URLs;
import org.smpte_ra.schemas.st2071._2014.types.Capabilities;
import org.smpte_ra.schemas.st2071._2014.types.DateTime;
import org.smpte_ra.schemas.st2071._2014.types.Map;


/**
 * <p>Java class for DeviceInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeviceInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/identity}UDN"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/identity}URLs"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/device}Name"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/device}Online"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/types}Attributes"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/types}Capabilities"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/device}ValidTill"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeviceInformation", propOrder = {
    "udn",
    "urLs",
    "name",
    "online",
    "attributes",
    "capabilities",
    "validTill"
})
public class DeviceInformation {

    @XmlElement(name = "UDN", namespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity", required = true)
    protected String udn;
    @XmlElement(name = "URLs", namespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity", required = true)
    protected URLs urLs;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Online")
    protected boolean online;
    @XmlElement(name = "Attributes", namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", required = true)
    protected Map attributes;
    @XmlElement(name = "Capabilities", namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", required = true)
    protected Capabilities capabilities;
    @XmlElement(name = "ValidTill", required = true)
    protected DateTime validTill;

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
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the online property.
     * 
     */
    public boolean isOnline() {
        return online;
    }

    /**
     * Sets the value of the online property.
     * 
     */
    public void setOnline(boolean value) {
        this.online = value;
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

}
