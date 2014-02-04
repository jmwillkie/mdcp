
package org.smpte_ra.schemas.st2071._2014.media;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for lookupAssetResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="lookupAssetResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/media}MediaAsset"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lookupAssetResponse", propOrder = {
    "mediaAsset"
})
public class LookupAssetResponse {

    @XmlElement(name = "MediaAsset", required = true)
    protected MediaAsset mediaAsset;

    /**
     * Gets the value of the mediaAsset property.
     * 
     * @return
     *     possible object is
     *     {@link MediaAsset }
     *     
     */
    public MediaAsset getMediaAsset() {
        return mediaAsset;
    }

    /**
     * Sets the value of the mediaAsset property.
     * 
     * @param value
     *     allowed object is
     *     {@link MediaAsset }
     *     
     */
    public void setMediaAsset(MediaAsset value) {
        this.mediaAsset = value;
    }

}
