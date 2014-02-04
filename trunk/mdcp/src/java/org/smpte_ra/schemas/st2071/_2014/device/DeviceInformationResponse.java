
package org.smpte_ra.schemas.st2071._2014.device;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeviceInformationResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeviceInformationResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/device}DeviceInformation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeviceInformationResponse", propOrder = {
    "deviceInformation"
})
public class DeviceInformationResponse {

    @XmlElement(name = "DeviceInformation")
    protected DeviceInformation deviceInformation;

    /**
     * Gets the value of the deviceInformation property.
     * 
     * @return
     *     possible object is
     *     {@link DeviceInformation }
     *     
     */
    public DeviceInformation getDeviceInformation() {
        return deviceInformation;
    }

    /**
     * Sets the value of the deviceInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceInformation }
     *     
     */
    public void setDeviceInformation(DeviceInformation value) {
        this.deviceInformation = value;
    }

}
