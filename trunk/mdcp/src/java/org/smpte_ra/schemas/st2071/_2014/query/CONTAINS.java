
package org.smpte_ra.schemas.st2071._2014.query;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.smpte_ra.schemas.st2071._2014.media.MediaPointer;


/**
 * <p>Java class for CONTAINS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CONTAINS">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.smpte-ra.org/schemas/st2071/2014/query}Expression">
 *       &lt;choice>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/media}MediaPointer"/>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONTAINS", propOrder = {
    "mediaPointer"
})
public class CONTAINS
    extends Expression
{

    @XmlElement(name = "MediaPointer", namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media")
    protected MediaPointer mediaPointer;

    /**
     * Gets the value of the mediaPointer property.
     * 
     * @return
     *     possible object is
     *     {@link MediaPointer }
     *     
     */
    public MediaPointer getMediaPointer() {
        return mediaPointer;
    }

    /**
     * Sets the value of the mediaPointer property.
     * 
     * @param value
     *     allowed object is
     *     {@link MediaPointer }
     *     
     */
    public void setMediaPointer(MediaPointer value) {
        this.mediaPointer = value;
    }

}
