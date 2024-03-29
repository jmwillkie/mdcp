
package org.smpte_ra.schemas.st2071._2014.media;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for create complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="create">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/media}Media"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/media}MediaPointer" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "create", propOrder = {
    "media",
    "mediaPointer"
})
public class Create {

    @XmlElementRef(name = "Media", namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", type = JAXBElement.class)
    protected JAXBElement<? extends Media> media;
    @XmlElement(name = "MediaPointer", required = true)
    protected List<MediaPointer> mediaPointer;

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

    /**
     * Gets the value of the mediaPointer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mediaPointer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMediaPointer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MediaPointer }
     * 
     * 
     */
    public List<MediaPointer> getMediaPointer() {
        if (mediaPointer == null) {
            mediaPointer = new ArrayList<MediaPointer>();
        }
        return this.mediaPointer;
    }

}
