
package org.smpte_ra.schemas.st2071._2014.security;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Permissions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Permissions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/security}PERMISSION_TYPE" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Permissions", propOrder = {
    "permissiontype"
})
public class Permissions {

    @XmlElement(name = "PERMISSION_TYPE")
    protected List<PERMISSIONTYPE> permissiontype;

    /**
     * Gets the value of the permissiontype property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the permissiontype property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPERMISSIONTYPE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PERMISSIONTYPE }
     * 
     * 
     */
    public List<PERMISSIONTYPE> getPERMISSIONTYPE() {
        if (permissiontype == null) {
            permissiontype = new ArrayList<PERMISSIONTYPE>();
        }
        return this.permissiontype;
    }

}
