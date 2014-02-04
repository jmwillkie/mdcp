
package org.smpte_ra.schemas.st2071._2014.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ServiceInformationsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceInformationsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/service}ServiceInformations"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceInformationsResponse", propOrder = {
    "serviceInformations"
})
public class ServiceInformationsResponse {

    @XmlElement(name = "ServiceInformations", required = true)
    protected ServiceInformations serviceInformations;

    /**
     * Gets the value of the serviceInformations property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceInformations }
     *     
     */
    public ServiceInformations getServiceInformations() {
        return serviceInformations;
    }

    /**
     * Sets the value of the serviceInformations property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceInformations }
     *     
     */
    public void setServiceInformations(ServiceInformations value) {
        this.serviceInformations = value;
    }

}
