
package org.smpte_ra.schemas.st2071._2014.media;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MediaSegments complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MediaSegments">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/media}MediaSegment" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MediaSegments", propOrder = {
    "mediaSegment"
})
public class MediaSegments {

    @XmlElement(name = "MediaSegment")
    protected List<MediaSegment> mediaSegment;

    /**
     * Gets the value of the mediaSegment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mediaSegment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMediaSegment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MediaSegment }
     * 
     * 
     */
    public List<MediaSegment> getMediaSegment() {
        if (mediaSegment == null) {
            mediaSegment = new ArrayList<MediaSegment>();
        }
        return this.mediaSegment;
    }

}
