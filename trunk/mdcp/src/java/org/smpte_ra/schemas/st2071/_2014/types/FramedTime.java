
package org.smpte_ra.schemas.st2071._2014.types;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FramedTime complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FramedTime">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.smpte-ra.org/schemas/st2071/2014/types>DateTime">
 *       &lt;attribute name="frame" use="required" type="{http://www.smpte-ra.org/schemas/st2071/2014/types}uint50" />
 *       &lt;attribute name="frame_rate" use="required" type="{http://www.smpte-ra.org/schemas/st2071/2014/types}uint50" />
 *       &lt;attribute name="scale" use="required" type="{http://www.smpte-ra.org/schemas/st2071/2014/types}uint50" />
 *       &lt;attribute name="total_frames" type="{http://www.smpte-ra.org/schemas/st2071/2014/types}uint64" default="0" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FramedTime")
public class FramedTime
    extends DateTime
{

    @XmlAttribute(name = "frame", required = true)
    protected long frame;
    @XmlAttribute(name = "frame_rate", required = true)
    protected long frameRate;
    @XmlAttribute(name = "scale", required = true)
    protected long scale;
    @XmlAttribute(name = "total_frames")
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
        if (totalFrames == null) {
            return new BigInteger("0");
        } else {
            return totalFrames;
        }
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
