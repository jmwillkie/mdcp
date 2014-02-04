
package org.smpte_ra.schemas.st2071._2014.media;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getMediaContainerResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getMediaContainerResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/media}MediaContainer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMediaContainerResponse", propOrder = {
    "mediaContainer"
})
public class GetMediaContainerResponse {

    @XmlElement(name = "MediaContainer", required = true)
    protected MediaContainer mediaContainer;

    /**
     * Gets the value of the mediaContainer property.
     * 
     * @return
     *     possible object is
     *     {@link MediaContainer }
     *     
     */
    public MediaContainer getMediaContainer() {
        return mediaContainer;
    }

    /**
     * Sets the value of the mediaContainer property.
     * 
     * @param value
     *     allowed object is
     *     {@link MediaContainer }
     *     
     */
    public void setMediaContainer(MediaContainer value) {
        this.mediaContainer = value;
    }

}
