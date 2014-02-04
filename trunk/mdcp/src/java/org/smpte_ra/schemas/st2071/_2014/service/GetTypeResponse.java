
package org.smpte_ra.schemas.st2071._2014.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getTypeResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getTypeResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/service}ServiceTemplate"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTypeResponse", propOrder = {
    "serviceTemplate"
})
public class GetTypeResponse {

    @XmlElement(name = "ServiceTemplate", required = true)
    protected ServiceTemplate serviceTemplate;

    /**
     * Gets the value of the serviceTemplate property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceTemplate }
     *     
     */
    public ServiceTemplate getServiceTemplate() {
        return serviceTemplate;
    }

    /**
     * Sets the value of the serviceTemplate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceTemplate }
     *     
     */
    public void setServiceTemplate(ServiceTemplate value) {
        this.serviceTemplate = value;
    }

}
