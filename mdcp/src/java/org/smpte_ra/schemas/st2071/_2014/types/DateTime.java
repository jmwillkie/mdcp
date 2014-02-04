
package org.smpte_ra.schemas.st2071._2014.types;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for DateTime complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DateTime">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/types}Date"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/types}Hour"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/types}Minute"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/types}Second"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/types}Microsecond"/>
 *         &lt;element ref="{http://www.smpte-ra.org/schemas/st2071/2014/types}MicrosFromEpoch"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DateTime", propOrder = {
    "date",
    "hour",
    "minute",
    "second",
    "microsecond",
    "microsFromEpoch"
})
@XmlSeeAlso({
    FramedTime.class
})
public class DateTime {

    @XmlElement(name = "Date", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "Hour")
    protected int hour;
    @XmlElement(name = "Minute")
    protected int minute;
    @XmlElement(name = "Second")
    protected int second;
    @XmlElement(name = "Microsecond")
    protected int microsecond;
    @XmlElement(name = "MicrosFromEpoch", required = true)
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger microsFromEpoch;

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Gets the value of the hour property.
     * 
     */
    public int getHour() {
        return hour;
    }

    /**
     * Sets the value of the hour property.
     * 
     */
    public void setHour(int value) {
        this.hour = value;
    }

    /**
     * Gets the value of the minute property.
     * 
     */
    public int getMinute() {
        return minute;
    }

    /**
     * Sets the value of the minute property.
     * 
     */
    public void setMinute(int value) {
        this.minute = value;
    }

    /**
     * Gets the value of the second property.
     * 
     */
    public int getSecond() {
        return second;
    }

    /**
     * Sets the value of the second property.
     * 
     */
    public void setSecond(int value) {
        this.second = value;
    }

    /**
     * Gets the value of the microsecond property.
     * 
     */
    public int getMicrosecond() {
        return microsecond;
    }

    /**
     * Sets the value of the microsecond property.
     * 
     */
    public void setMicrosecond(int value) {
        this.microsecond = value;
    }

    /**
     * Gets the value of the microsFromEpoch property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMicrosFromEpoch() {
        return microsFromEpoch;
    }

    /**
     * Sets the value of the microsFromEpoch property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMicrosFromEpoch(BigInteger value) {
        this.microsFromEpoch = value;
    }

}
