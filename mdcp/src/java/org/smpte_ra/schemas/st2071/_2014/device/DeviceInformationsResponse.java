
package org.smpte_ra.schemas.st2071._2014.device;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeviceInformationsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeviceInformationsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/device}DeviceInformations"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeviceInformationsResponse", propOrder = {
    "deviceInformations"
})
public class DeviceInformationsResponse {

    @XmlElement(name = "DeviceInformations", required = true)
    protected DeviceInformations deviceInformations;

    /**
     * Gets the value of the deviceInformations property.
     * 
     * @return
     *     possible object is
     *     {@link DeviceInformations }
     *     
     */
    public DeviceInformations getDeviceInformations() {
        return deviceInformations;
    }

    /**
     * Sets the value of the deviceInformations property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceInformations }
     *     
     */
    public void setDeviceInformations(DeviceInformations value) {
        this.deviceInformations = value;
    }

}
