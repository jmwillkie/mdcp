
package org.smpte_ra.schemas.st2071._2014.types;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FramedTime complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FramedTime">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.smpte-ra.org/schemas/st2071/2014/types}DateTime">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/types}Frame"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/types}FrameRate"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/types}Scale"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/types}TotalFrames"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FramedTime", propOrder = {
    "frame",
    "frameRate",
    "scale",
    "totalFrames"
})
public class FramedTime
    extends DateTime
{

    @XmlElement(name = "Frame")
    protected long frame;
    @XmlElement(name = "FrameRate")
    protected long frameRate;
    @XmlElement(name = "Scale")
    protected long scale;
    @XmlElement(name = "TotalFrames", required = true)
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger totalFrames;

    /**
     * Gets the value of the frame property.
     * 
     */
    public long getFrame() {
        return frame;
    }

    /**
     * Sets the value of the frame property.
     * 
     */
    public void setFrame(long value) {
        this.frame = value;
    }

    /**
     * Gets the value of the frameRate property.
     * 
     */
    public long getFrameRate() {
        return frameRate;
    }

    /**
     * Sets the value of the frameRate property.
     * 
     */
    public void setFrameRate(long value) {
        this.frameRate = value;
    }

    /**
     * Gets the value of the scale property.
     * 
     */
    public long getScale() {
        return scale;
    }

    /**
     * Sets the value of the scale property.
     * 
     */
    public void setScale(long value) {
        this.scale = value;
    }

    /**
     * Gets the value of the totalFrames property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalFrames() {
        return totalFrames;
    }

    /**
     * Sets the value of the totalFrames property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalFrames(BigInteger value) {
        this.totalFrames = value;
    }

}
