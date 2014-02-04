
package org.smpte_ra.schemas.st2071._2014.security;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Permission complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Permission">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/security}Roles"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/security}Allow"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/security}Permissions"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/security}Resource"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Permission", propOrder = {
    "roles",
    "allow",
    "permissions",
    "resource"
})
public class Permission {

    @XmlElement(name = "Roles", required = true)
    protected Principals roles;
    @XmlElement(name = "Allow")
    protected boolean allow;
    @XmlElement(name = "Permissions", required = true)
    protected Permissions permissions;
    @XmlElement(name = "Resource", required = true)
    protected String resource;

    /**
     * Gets the value of the roles property.
     * 
     * @return
     *     possible object is
     *     {@link Principals }
     *     
     */
    public Principals getRoles() {
        return roles;
    }

    /**
     * Sets the value of the roles property.
     * 
     * @param value
     *     allowed object is
     *     {@link Principals }
     *     
     */
    public void setRoles(Principals value) {
        this.roles = value;
    }

    /**
     * Gets the value of the allow property.
     * 
     */
    public boolean isAllow() {
        return allow;
    }

    /**
     * Sets the value of the allow property.
     * 
     */
    public void setAllow(boolean value) {
        this.allow = value;
    }

    /**
     * Gets the value of the permissions property.
     * 
     * @return
     *     possible object is
     *     {@link Permissions }
     *     
     */
    public Permissions getPermissions() {
        return permissions;
    }

    /**
     * Sets the value of the permissions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Permissions }
     *     
     */
    public void setPermissions(Permissions value) {
        this.permissions = value;
    }

    /**
     * Gets the value of the resource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResource() {
        return resource;
    }

    /**
     * Sets the value of the resource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResource(String value) {
        this.resource = value;
    }

}
