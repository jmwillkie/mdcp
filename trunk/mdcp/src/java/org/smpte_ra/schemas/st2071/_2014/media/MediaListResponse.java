
package org.smpte_ra.schemas.st2071._2014.media;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MediaListResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MediaListResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/media}MediaList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MediaListResponse", propOrder = {
    "mediaList"
})
public class MediaListResponse {

    @XmlElement(name = "MediaList", required = true)
    protected MediaList mediaList;

    /**
     * Gets the value of the mediaList property.
     * 
     * @return
     *     possible object is
     *     {@link MediaList }
     *     
     */
    public MediaList getMediaList() {
        return mediaList;
    }

    /**
     * Sets the value of the mediaList property.
     * 
     * @param value
     *     allowed object is
     *     {@link MediaList }
     *     
     */
    public void setMediaList(MediaList value) {
        this.mediaList = value;
    }

}
