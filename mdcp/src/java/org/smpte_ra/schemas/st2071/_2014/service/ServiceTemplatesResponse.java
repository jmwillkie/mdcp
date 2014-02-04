
package org.smpte_ra.schemas.st2071._2014.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ServiceTemplatesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceTemplatesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/service}ServiceTemplates"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceTemplatesResponse", propOrder = {
    "serviceTemplates"
})
public class ServiceTemplatesResponse {

    @XmlElement(name = "ServiceTemplates", required = true)
    protected ServiceTemplates serviceTemplates;

    /**
     * Gets the value of the serviceTemplates property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceTemplates }
     *     
     */
    public ServiceTemplates getServiceTemplates() {
        return serviceTemplates;
    }

    /**
     * Sets the value of the serviceTemplates property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceTemplates }
     *     
     */
    public void setServiceTemplates(ServiceTemplates value) {
        this.serviceTemplates = value;
    }

}
