
package org.smpte_ra.schemas.st2071._2014.media;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MediaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MediaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/media}Media"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MediaResponse", propOrder = {
    "media"
})
public class MediaResponse {

    @XmlElementRef(name = "Media", namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", type = JAXBElement.class)
    protected JAXBElement<? extends Media> media;

    /**
     * Gets the value of the media property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MediaInstance }{@code >}
     *     {@link JAXBElement }{@code <}{@link MediaContainer }{@code >}
     *     {@link JAXBElement }{@code <}{@link MediaAsset }{@code >}
     *     {@link JAXBElement }{@code <}{@link MediaFile }{@code >}
     *     {@link JAXBElement }{@code <}{@link Media }{@code >}
     *     {@link JAXBElement }{@code <}{@link MaterialAsset }{@code >}
     *     {@link JAXBElement }{@code <}{@link MediaSegment }{@code >}
     *     {@link JAXBElement }{@code <}{@link MediaBundle }{@code >}
     *     
     */
    public JAXBElement<? extends Media> getMedia() {
        return media;
    }

    /**
     * Sets the value of the media property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MediaInstance }{@code >}
     *     {@link JAXBElement }{@code <}{@link MediaContainer }{@code >}
     *     {@link JAXBElement }{@code <}{@link MediaAsset }{@code >}
     *     {@link JAXBElement }{@code <}{@link MediaFile }{@code >}
     *     {@link JAXBElement }{@code <}{@link Media }{@code >}
     *     {@link JAXBElement }{@code <}{@link MaterialAsset }{@code >}
     *     {@link JAXBElement }{@code <}{@link MediaSegment }{@code >}
     *     {@link JAXBElement }{@code <}{@link MediaBundle }{@code >}
     *     
     */
    public void setMedia(JAXBElement<? extends Media> value) {
        this.media = value;
    }

}
