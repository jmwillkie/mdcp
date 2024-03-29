
package org.smpte_ra.schemas.st2071._2014.media;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MediaPointers complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MediaPointers">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/media}MediaPointer" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MediaPointers", propOrder = {
    "mediaPointer"
})
public class MediaPointers {

    @XmlElement(name = "MediaPointer")
    protected List<MediaPointer> mediaPointer;

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
