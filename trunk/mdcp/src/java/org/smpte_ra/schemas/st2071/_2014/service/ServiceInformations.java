
package org.smpte_ra.schemas.st2071._2014.service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ServiceInformations complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceInformations">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/service}ServiceInformation" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceInformations", propOrder = {
    "serviceInformation"
})
public class ServiceInformations {

    @XmlElement(name = "ServiceInformation")
    protected List<ServiceInformation> serviceInformation;

    /**
     * Gets the value of the serviceInformation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceInformation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceInformation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceInformation }
     * 
     * 
     */
    public List<ServiceInformation> getServiceInformation() {
        if (serviceInformation == null) {
            serviceInformation = new ArrayList<ServiceInformation>();
        }
        return this.serviceInformation;
    }

}
