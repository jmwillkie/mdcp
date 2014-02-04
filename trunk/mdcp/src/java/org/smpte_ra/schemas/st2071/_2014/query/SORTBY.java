
package org.smpte_ra.schemas.st2071._2014.query;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SORT_BY complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SORT_BY">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="field" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="descending" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SORT_BY")
public class SORTBY {

    @XmlAttribute(name = "field", required = true)
    protected String field;
    @XmlAttribute(name = "descending")
    protected Boolean descending;

    /**
     * Gets the value of the field property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getField() {
        return field;
    }

    /**
     * Sets the value of the field property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setField(String value) {
        this.field = value;
    }

    /**
     * Gets the value of the descending property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isDescending() {
        if (descending == null) {
            return false;
        } else {
            return descending;
        }
    }

    /**
     * Sets the value of the descending property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDescending(Boolean value) {
        this.descending = value;
    }

}
