
package org.smpte_ra.schemas.st2071._2014.media;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.smpte_ra.schemas.st2071._2014.types.DateTime;
import org.smpte_ra.schemas.st2071._2014.types.OFFSETTYPE;


/**
 * <p>Java class for MediaSegment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MediaSegment">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.smpte-ra.org/schemas/st2071/2014/media}Media">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/media}Source"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/media}InpointOffset"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/media}OutpointOffset"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/media}OffsetType"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/media}Track"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/media}Inpoint"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/media}Outpoint"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/media}Format"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/media}TrackName"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/media}TrackType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MediaSegment", propOrder = {
    "source",
    "inpointOffset",
    "outpointOffset",
    "offsetType",
    "track",
    "inpoint",
    "outpoint",
    "format",
    "trackName",
    "trackType"
})
public class MediaSegment
    extends Media
{

    @XmlElement(name = "Source", required = true)
    protected String source;
    @XmlElement(name = "InpointOffset", required = true)
    protected BigInteger inpointOffset;
    @XmlElement(name = "OutpointOffset", required = true)
    protected BigInteger outpointOffset;
    @XmlElement(name = "OffsetType", required = true)
    protected OFFSETTYPE offsetType;
    @XmlElement(name = "Track")
    @XmlSchemaType(name = "unsignedShort")
    protected int track;
    @XmlElement(name = "Inpoint", required = true)
    protected DateTime inpoint;
    @XmlElement(name = "Outpoint", required = true)
    protected DateTime outpoint;
    @XmlElement(name = "Format", required = true)
    protected String format;
    @XmlElement(name = "TrackName", required = true)
    protected String trackName;
    @XmlElement(name = "TrackType", required = true)
    protected TRACKTYPE trackType;

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

    /**
     * Gets the value of the inpoint property.
     * 
     * @return
     *     possible object is
     *     {@link DateTime }
     *     
     */
    public DateTime getInpoint() {
        return inpoint;
    }

    /**
     * Sets the value of the inpoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTime }
     *     
     */
    public void setInpoint(DateTime value) {
        this.inpoint = value;
    }

    /**
     * Gets the value of the outpoint property.
     * 
     * @return
     *     possible object is
     *     {@link DateTime }
     *     
     */
    public DateTime getOutpoint() {
        return outpoint;
    }

    /**
     * Sets the value of the outpoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTime }
     *     
     */
    public void setOutpoint(DateTime value) {
        this.outpoint = value;
    }

    /**
     * Gets the value of the format property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets the value of the format property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormat(String value) {
        this.format = value;
    }

    /**
     * Gets the value of the trackName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrackName() {
        return trackName;
    }

    /**
     * Sets the value of the trackName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrackName(String value) {
        this.trackName = value;
    }

    /**
     * Gets the value of the trackType property.
     * 
     * @return
     *     possible object is
     *     {@link TRACKTYPE }
     *     
     */
    public TRACKTYPE getTrackType() {
        return trackType;
    }

    /**
     * Sets the value of the trackType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TRACKTYPE }
     *     
     */
    public void setTrackType(TRACKTYPE value) {
        this.trackType = value;
    }

}
