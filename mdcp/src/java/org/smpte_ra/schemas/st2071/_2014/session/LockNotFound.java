
package org.smpte_ra.schemas.st2071._2014.session;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.smpte_ra.schemas.st2071._2014.types.Exception;


/**
 * <p>Java class for LockNotFound complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LockNotFound">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.smpte-ra.org/schemas/st2071/2014/types}Exception">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/session}LockID"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LockNotFound", propOrder = {
    "lockID"
})
public class LockNotFound
    extends Exception
{

    @XmlElement(name = "LockID", required = true)
    protected String lockID;

    /**
     * Gets the value of the lockID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLockID() {
        return lockID;
    }

    /**
     * Sets the value of the lockID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLockID(String value) {
        this.lockID = value;
    }

}
