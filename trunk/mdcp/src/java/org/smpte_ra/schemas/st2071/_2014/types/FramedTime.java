
package org.smpte_ra.schemas.st2071._2014.types;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *       &lt;attribute ref="{http://www.smpte-ra.org/schemas/st2071/2014/types}Frame use="required""/>
 *       &lt;attribute ref="{http://www.smpte-ra.org/schemas/st2071/2014/types}FrameRate use="required""/>
 *       &lt;attribute ref="{http://www.smpte-ra.org/schemas/st2071/2014/types}Scale use="required""/>
 *       &lt;attribute ref="{http://www.smpte-ra.org/schemas/st2071/2014/types}TotalFrames use="required""/>
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

    @XmlAttribute(name = "Frame", namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", required = true)
    protected long frame;
    @XmlAttribute(name = "FrameRate", namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", required = true)
    protected long frameRate;
    @XmlAttribute(name = "Scale", namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", required = true)
    protected long scale;
    @XmlAttribute(name = "TotalFrames", namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", required = true)
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
