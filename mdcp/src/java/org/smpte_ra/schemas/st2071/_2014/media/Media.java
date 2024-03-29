
package org.smpte_ra.schemas.st2071._2014.media;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.smpte_ra.schemas.st2071._2014.types.DateTime;
import org.smpte_ra.schemas.st2071._2014.types.Map;


/**
 * <p>Java class for Media complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Media">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/identity}UMN"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/media}Name"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/media}Location"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/media}Created"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/media}Modified"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/media}Metadata"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Media", propOrder = {
    "umn",
    "name",
    "location",
    "created",
    "modified",
    "metadata"
})
@XmlSeeAlso({
    MediaFile.class,
    MediaSegment.class,
    MediaAsset.class,
    MediaContainer.class
})
public class Media {

    @XmlElement(name = "UMN", namespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity", required = true)
    protected String umn;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Location", required = true)
    protected String location;
    @XmlElement(name = "Created", required = true)
    protected DateTime created;
    @XmlElement(name = "Modified", required = true)
    protected DateTime modified;
    @XmlElement(name = "Metadata", required = true)
    protected Map metadata;

    /**
     * Gets the value of the umn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUMN() {
        return umn;
    }

    /**
     * Sets the value of the umn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUMN(String value) {
        this.umn = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * Gets the value of the created property.
     * 
     * @return
     *     possible object is
     *     {@link DateTime }
     *     
     */
    public DateTime getCreated() {
        return created;
    }

    /**
     * Sets the value of the created property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTime }
     *     
     */
    public void setCreated(DateTime value) {
        this.created = value;
    }

    /**
     * Gets the value of the modified property.
     * 
     * @return
     *     possible object is
     *     {@link DateTime }
     *     
     */
    public DateTime getModified() {
        return modified;
    }

    /**
     * Sets the value of the modified property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTime }
     *     
     */
    public void setModified(DateTime value) {
        this.modified = value;
    }

    /**
     * Gets the value of the metadata property.
     * 
     * @return
     *     possible object is
     *     {@link Map }
     *     
     */
    public Map getMetadata() {
        return metadata;
    }

    /**
     * Sets the value of the metadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link Map }
     *     
     */
    public void setMetadata(Map value) {
        this.metadata = value;
    }

}
