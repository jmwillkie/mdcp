
package org.smpte_ra.schemas.st2071._2014.security;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.smpte_ra.schemas.st2071._2014.types.Exception;


/**
 * <p>Java class for SecurityException complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SecurityException">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.smpte-ra.org/schemas/st2071/2014/types}Exception">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/security}Type"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/security}Status"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/security}Resource"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/security}Subject"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SecurityException", propOrder = {
    "type",
    "status",
    "resource",
    "subject"
})
public class SecurityException
    extends Exception
{

    @XmlElement(name = "Type", required = true)
    protected EXCEPTIONTYPE type;
    @XmlElement(name = "Status", required = true)
    protected EXCEPTIONSTATUS status;
    @XmlElement(name = "Resource", required = true)
    protected String resource;
    @XmlElement(name = "Subject", required = true)
    protected Subject subject;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link EXCEPTIONTYPE }
     *     
     */
    public EXCEPTIONTYPE getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link EXCEPTIONTYPE }
     *     
     */
    public void setType(EXCEPTIONTYPE value) {
        this.type = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link EXCEPTIONSTATUS }
     *     
     */
    public EXCEPTIONSTATUS getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link EXCEPTIONSTATUS }
     *     
     */
    public void setStatus(EXCEPTIONSTATUS value) {
        this.status = value;
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

    /**
     * Gets the value of the subject property.
     * 
     * @return
     *     possible object is
     *     {@link Subject }
     *     
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * Sets the value of the subject property.
     * 
     * @param value
     *     allowed object is
     *     {@link Subject }
     *     
     */
    public void setSubject(Subject value) {
        this.subject = value;
    }

}
