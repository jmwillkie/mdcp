
package org.smpte_ra.schemas.st2071._2014.device;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.smpte_ra.schemas.st2071._2014.identity.URLs;
import org.smpte_ra.schemas.st2071._2014.types.Capabilities;


/**
 * <p>Java class for DeviceNotUnbound complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeviceNotUnbound">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.smpte-ra.org/schemas/st2071/2014/device}DeviceException">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/device}ParentUDN"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/identity}URLs"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/device}Name"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/types}Capabilities"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeviceNotUnbound", propOrder = {
    "parentUDN",
    "urLs",
    "name",
    "capabilities"
})
public class DeviceNotUnbound
    extends DeviceException
{

    @XmlElement(name = "ParentUDN", required = true)
    protected String parentUDN;
    @XmlElement(name = "URLs", namespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity", required = true)
    protected URLs urLs;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Capabilities", namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", required = true)
    protected Capabilities capabilities;

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
