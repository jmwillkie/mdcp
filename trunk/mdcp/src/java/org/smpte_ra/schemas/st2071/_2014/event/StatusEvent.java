
package org.smpte_ra.schemas.st2071._2014.event;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.smpte_ra.schemas.st2071._2014.device.DeviceEvent;
import org.smpte_ra.schemas.st2071._2014.media.MediaEvent;
import org.smpte_ra.schemas.st2071._2014.mode.ModeEvent;
import org.smpte_ra.schemas.st2071._2014.types.STATUS;


/**
 * <p>Java class for StatusEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StatusEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.smpte-ra.org/schemas/st2071/2014/event}Event">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/event}Ready"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/types}STATUS"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/event}Message"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StatusEvent", propOrder = {
    "ready",
    "status",
    "message"
})
@XmlSeeAlso({
    DeviceEvent.class,
    ModeEvent.class,
    MediaEvent.class
})
public class StatusEvent
    extends Event
{

    @XmlElement(name = "Ready")
    protected boolean ready;
    @XmlElement(name = "STATUS", namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", required = true)
    protected STATUS status;
    @XmlElement(name = "Message", required = true)
    protected String message;

    /**
     * Gets the value of the ready property.
     * 
     */
    public boolean isReady() {
        return ready;
    }

    /**
     * Sets the value of the ready property.
     * 
     */
    public void setReady(boolean value) {
        this.ready = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link STATUS }
     *     
     */
    public STATUS getSTATUS() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link STATUS }
     *     
     */
    public void setSTATUS(STATUS value) {
        this.status = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

}
