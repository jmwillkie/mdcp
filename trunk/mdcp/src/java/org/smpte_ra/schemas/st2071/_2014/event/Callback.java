
package org.smpte_ra.schemas.st2071._2014.event;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import org.smpte_ra.schemas.st2071._2014.device.DeviceEvent;
import org.smpte_ra.schemas.st2071._2014.media.MediaEvent;
import org.smpte_ra.schemas.st2071._2014.mode.ModeEvent;


/**
 * <p>Java class for callback complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="callback">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/event}Event"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "callback", propOrder = {
    "event"
})
public class Callback {

    @XmlElementRef(name = "Event", namespace = "http://www.smpte-ra.org/schemas/st2071/2014/event", type = JAXBElement.class)
    protected JAXBElement<? extends Event> event;

    /**
     * Gets the value of the event property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DeviceEvent }{@code >}
     *     {@link JAXBElement }{@code <}{@link Event }{@code >}
     *     {@link JAXBElement }{@code <}{@link StatusEvent }{@code >}
     *     {@link JAXBElement }{@code <}{@link ModeEvent }{@code >}
     *     {@link JAXBElement }{@code <}{@link MediaEvent }{@code >}
     *     
     */
    public JAXBElement<? extends Event> getEvent() {
        return event;
    }

    /**
     * Sets the value of the event property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DeviceEvent }{@code >}
     *     {@link JAXBElement }{@code <}{@link Event }{@code >}
     *     {@link JAXBElement }{@code <}{@link StatusEvent }{@code >}
     *     {@link JAXBElement }{@code <}{@link ModeEvent }{@code >}
     *     {@link JAXBElement }{@code <}{@link MediaEvent }{@code >}
     *     
     */
    public void setEvent(JAXBElement<? extends Event> value) {
        this.event = value;
    }

}
