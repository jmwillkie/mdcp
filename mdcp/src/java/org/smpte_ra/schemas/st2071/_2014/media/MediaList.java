
package org.smpte_ra.schemas.st2071._2014.media;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MediaList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MediaList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/media}Media" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MediaList", propOrder = {
    "media"
})
public class MediaList {

    @XmlElementRef(name = "Media", namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends Media>> media;

    /**
     * Gets the value of the media property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the media property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMedia().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link MediaInstance }{@code >}
     * {@link JAXBElement }{@code <}{@link MediaContainer }{@code >}
     * {@link JAXBElement }{@code <}{@link MediaAsset }{@code >}
     * {@link JAXBElement }{@code <}{@link MediaFile }{@code >}
     * {@link JAXBElement }{@code <}{@link Media }{@code >}
     * {@link JAXBElement }{@code <}{@link MaterialAsset }{@code >}
     * {@link JAXBElement }{@code <}{@link MediaSegment }{@code >}
     * {@link JAXBElement }{@code <}{@link MediaBundle }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends Media>> getMedia() {
        if (media == null) {
            media = new ArrayList<JAXBElement<? extends Media>>();
        }
        return this.media;
    }

}
