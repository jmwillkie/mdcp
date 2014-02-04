
package org.smpte_ra.schemas.st2071._2014.media;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.smpte_ra.schemas.st2071._2014.types.FramedTime;


/**
 * <p>Java class for MediaInstance complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MediaInstance">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.smpte-ra.org/schemas/st2071/2014/media}MediaFile">
 *       &lt;sequence>
 *         &lt;element name="Duration" type="{http://www.smpte-ra.org/schemas/st2071/2014/types}FramedTime"/>
 *         &lt;element name="Composition" type="{http://www.smpte-ra.org/schemas/st2071/2014/media}MediaSegments"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MediaInstance", propOrder = {
    "duration",
    "composition"
})
@XmlSeeAlso({
    MediaBundle.class
})
public class MediaInstance
    extends MediaFile
{

    @XmlElement(name = "Duration", required = true)
    protected FramedTime duration;
    @XmlElement(name = "Composition", required = true)
    protected MediaSegments composition;

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link FramedTime }
     *     
     */
    public FramedTime getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link FramedTime }
     *     
     */
    public void setDuration(FramedTime value) {
        this.duration = value;
    }

    /**
     * Gets the value of the composition property.
     * 
     * @return
     *     possible object is
     *     {@link MediaSegments }
     *     
     */
    public MediaSegments getComposition() {
        return composition;
    }

    /**
     * Sets the value of the composition property.
     * 
     * @param value
     *     allowed object is
     *     {@link MediaSegments }
     *     
     */
    public void setComposition(MediaSegments value) {
        this.composition = value;
    }

}
