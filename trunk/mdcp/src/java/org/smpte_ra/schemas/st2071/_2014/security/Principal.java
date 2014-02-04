
package org.smpte_ra.schemas.st2071._2014.security;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Principal complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Principal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/security}Realm"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/security}Identifier"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/security}Roles"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/security}Tokens"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Principal", propOrder = {
    "realm",
    "identifier",
    "roles",
    "tokens"
})
public class Principal {

    @XmlElement(name = "Realm", required = true)
    protected String realm;
    @XmlElement(name = "Identifier", required = true)
    protected String identifier;
    @XmlElement(name = "Roles", required = true)
    protected Principals roles;
    @XmlElement(name = "Tokens", required = true)
    protected SecurityTokens tokens;

    /**
     * Gets the value of the realm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRealm() {
        return realm;
    }

    /**
     * Sets the value of the realm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRealm(String value) {
        this.realm = value;
    }

    /**
     * Gets the value of the identifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Sets the value of the identifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentifier(String value) {
        this.identifier = value;
    }

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
     * Gets the value of the tokens property.
     * 
     * @return
     *     possible object is
     *     {@link SecurityTokens }
     *     
     */
    public SecurityTokens getTokens() {
        return tokens;
    }

    /**
     * Sets the value of the tokens property.
     * 
     * @param value
     *     allowed object is
     *     {@link SecurityTokens }
     *     
     */
    public void setTokens(SecurityTokens value) {
        this.tokens = value;
    }

}
