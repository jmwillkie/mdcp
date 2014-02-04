
package org.smpte_ra.schemas.st2071._2014.event;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for heartbeatResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="heartbeatResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/types}Boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "heartbeatResponse", propOrder = {
    "_boolean"
})
public class HeartbeatResponse {

    @XmlElement(name = "Boolean", namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types")
    protected boolean _boolean;

    /**
     * Gets the value of the boolean property.
     * 
     */
    public boolean isBoolean() {
        return _boolean;
    }

    /**
     * Sets the value of the boolean property.
     * 
     */
    public void setBoolean(boolean value) {
        this._boolean = value;
    }

}
