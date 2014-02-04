
package org.smpte_ra.schemas.st2071._2014.media;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.smpte_ra.schemas.st2071._2014.types.OFFSETTYPE;


/**
 * <p>Java class for MediaPointer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MediaPointer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/media}Source"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/media}InpointOffset"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/media}OutpointOffset"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/media}OffsetType"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/media}Track"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MediaPointer", propOrder = {
    "source",
    "inpointOffset",
    "outpointOffset",
    "offsetType",
    "track"
})
public class MediaPointer {

    @XmlElement(name = "Source", required = true)
    protected String source;
    @XmlElement(name = "InpointOffset", required = true)
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger inpointOffset;
    @XmlElement(name = "OutpointOffset", required = true)
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger outpointOffset;
    @XmlElement(name = "OffsetType", required = true)
    protected OFFSETTYPE offsetType;
    @XmlElement(name = "Track")
    @XmlSchemaType(name = "unsignedShort")
    protected int track;

    /**
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSource(String value) {
        this.source = value;
    }

    /**
     * Gets the value of the inpointOffset property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getInpointOffset() {
        return inpointOffset;
    }

    /**
     * Sets the value of the inpointOffset property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setInpointOffset(BigInteger value) {
        this.inpointOffset = value;
    }

    /**
     * Gets the value of the outpointOffset property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOutpointOffset() {
        return outpointOffset;
    }

    /**
     * Sets the value of the outpointOffset property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOutpointOffset(BigInteger value) {
        this.outpointOffset = value;
    }

    /**
     * Gets the value of the offsetType property.
     * 
     * @return
     *     possible object is
     *     {@link OFFSETTYPE }
     *     
     */
    public OFFSETTYPE getOffsetType() {
        return offsetType;
    }

    /**
     * Sets the value of the offsetType property.
     * 
     * @param value
     *     allowed object is
     *     {@link OFFSETTYPE }
     *     
     */
    public void setOffsetType(OFFSETTYPE value) {
        this.offsetType = value;
    }

    /**
     * Gets the value of the track property.
     * 
     */
    public int getTrack() {
        return track;
    }

    /**
     * Sets the value of the track property.
     * 
     */
    public void setTrack(int value) {
        this.track = value;
    }

}
