
package org.smpte_ra.schemas.st2071._2014.device;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeviceNotFoundFault complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeviceNotFoundFault">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/device}DeviceNotFound"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeviceNotFoundFault", propOrder = {
    "deviceNotFound"
})
public class DeviceNotFoundFault {

    @XmlElement(name = "DeviceNotFound", required = true)
    protected DeviceNotFound deviceNotFound;

    /**
     * Gets the value of the deviceNotFound property.
     * 
     * @return
     *     possible object is
     *     {@link DeviceNotFound }
     *     
     */
    public DeviceNotFound getDeviceNotFound() {
        return deviceNotFound;
    }

    /**
     * Sets the value of the deviceNotFound property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceNotFound }
     *     
     */
    public void setDeviceNotFound(DeviceNotFound value) {
        this.deviceNotFound = value;
    }

}
