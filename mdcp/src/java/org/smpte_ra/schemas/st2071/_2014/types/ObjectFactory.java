
package org.smpte_ra.schemas.st2071._2014.types;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.smpte_ra.schemas.st2071._2014.types package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Exception_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "Exception");
    private final static QName _MicrosFromEpoch_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "MicrosFromEpoch");
    private final static QName _Boolean_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "Boolean");
    private final static QName _FramedTime_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "FramedTime");
    private final static QName _Attributes_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "Attributes");
    private final static QName _Scale_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "Scale");
    private final static QName _String_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "String");
    private final static QName _DATATYPE_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "DATA_TYPE");
    private final static QName _Image_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "Image");
    private final static QName _Minute_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "Minute");
    private final static QName _Hour_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "Hour");
    private final static QName _Key_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "Key");
    private final static QName _MIMEType_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "MIMEType");
    private final static QName _STATUS_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "STATUS");
    private final static QName _TotalFrames_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "TotalFrames");
    private final static QName _Frame_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "Frame");
    private final static QName _Capabilities_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "Capabilities");
    private final static QName _Width_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "Width");
    private final static QName _Microsecond_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "Microsecond");
    private final static QName _Height_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "Height");
    private final static QName _Map_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "Map");
    private final static QName _Second_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "Second");
    private final static QName _Keys_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "Keys");
    private final static QName _Message_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "Message");
    private final static QName _FrameRate_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "FrameRate");
    private final static QName _Data_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "Data");
    private final static QName _Date_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "Date");
    private final static QName _DateTime_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "DateTime");
    private final static QName _Capability_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "Capability");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.smpte_ra.schemas.st2071._2014.types
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Map }
     * 
     */
    public Map createMap() {
        return new Map();
    }

    /**
     * Create an instance of {@link DateTime }
     * 
     */
    public DateTime createDateTime() {
        return new DateTime();
    }

    /**
     * Create an instance of {@link Key }
     * 
     */
    public Key createKey() {
        return new Key();
    }

    /**
     * Create an instance of {@link Image }
     * 
     */
    public Image createImage() {
        return new Image();
    }

    /**
     * Create an instance of {@link Capabilities }
     * 
     */
    public Capabilities createCapabilities() {
        return new Capabilities();
    }

    /**
     * Create an instance of {@link Keys }
     * 
     */
    public Keys createKeys() {
        return new Keys();
    }

    /**
     * Create an instance of {@link Capability }
     * 
     */
    public Capability createCapability() {
        return new Capability();
    }

    /**
     * Create an instance of {@link FramedTime }
     * 
     */
    public FramedTime createFramedTime() {
        return new FramedTime();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", name = "MicrosFromEpoch")
    public JAXBElement<BigInteger> createMicrosFromEpoch(BigInteger value) {
        return new JAXBElement<BigInteger>(_MicrosFromEpoch_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", name = "Boolean")
    public JAXBElement<Boolean> createBoolean(Boolean value) {
        return new JAXBElement<Boolean>(_Boolean_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FramedTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", name = "FramedTime", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", substitutionHeadName = "DateTime")
    public JAXBElement<FramedTime> createFramedTime(FramedTime value) {
        return new JAXBElement<FramedTime>(_FramedTime_QNAME, FramedTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Map }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", name = "Attributes")
    public JAXBElement<Map> createAttributes(Map value) {
        return new JAXBElement<Map>(_Attributes_QNAME, Map.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", name = "Scale")
    public JAXBElement<Long> createScale(Long value) {
        return new JAXBElement<Long>(_Scale_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", name = "String")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DATATYPE }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", name = "DATA_TYPE")
    public JAXBElement<DATATYPE> createDATATYPE(DATATYPE value) {
        return new JAXBElement<DATATYPE>(_DATATYPE_QNAME, DATATYPE.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Image }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", name = "Image")
    public JAXBElement<Image> createImage(Image value) {
        return new JAXBElement<Image>(_Image_QNAME, Image.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", name = "Minute")
    public JAXBElement<Integer> createMinute(Integer value) {
        return new JAXBElement<Integer>(_Minute_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", name = "Hour")
    public JAXBElement<Integer> createHour(Integer value) {
        return new JAXBElement<Integer>(_Hour_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Key }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", name = "Key")
    public JAXBElement<Key> createKey(Key value) {
        return new JAXBElement<Key>(_Key_QNAME, Key.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", name = "MIMEType")
    public JAXBElement<String> createMIMEType(String value) {
        return new JAXBElement<String>(_MIMEType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link STATUS }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", name = "STATUS")
    public JAXBElement<STATUS> createSTATUS(STATUS value) {
        return new JAXBElement<STATUS>(_STATUS_QNAME, STATUS.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", name = "TotalFrames")
    public JAXBElement<BigInteger> createTotalFrames(BigInteger value) {
        return new JAXBElement<BigInteger>(_TotalFrames_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", name = "Frame")
    public JAXBElement<Long> createFrame(Long value) {
        return new JAXBElement<Long>(_Frame_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Capabilities }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", name = "Capabilities")
    public JAXBElement<Capabilities> createCapabilities(Capabilities value) {
        return new JAXBElement<Capabilities>(_Capabilities_QNAME, Capabilities.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", name = "Width")
    public JAXBElement<Integer> createWidth(Integer value) {
        return new JAXBElement<Integer>(_Width_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", name = "Microsecond")
    public JAXBElement<Integer> createMicrosecond(Integer value) {
        return new JAXBElement<Integer>(_Microsecond_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", name = "Height")
    public JAXBElement<Integer> createHeight(Integer value) {
        return new JAXBElement<Integer>(_Height_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Map }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", name = "Map")
    public JAXBElement<Map> createMap(Map value) {
        return new JAXBElement<Map>(_Map_QNAME, Map.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", name = "Second")
    public JAXBElement<Integer> createSecond(Integer value) {
        return new JAXBElement<Integer>(_Second_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Keys }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", name = "Keys")
    public JAXBElement<Keys> createKeys(Keys value) {
        return new JAXBElement<Keys>(_Keys_QNAME, Keys.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", name = "Message")
    public JAXBElement<String> createMessage(String value) {
        return new JAXBElement<String>(_Message_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", name = "FrameRate")
    public JAXBElement<Long> createFrameRate(Long value) {
        return new JAXBElement<Long>(_FrameRate_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", name = "Data")
    public JAXBElement<byte[]> createData(byte[] value) {
        return new JAXBElement<byte[]>(_Data_QNAME, byte[].class, null, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", name = "Date")
    public JAXBElement<XMLGregorianCalendar> createDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_Date_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", name = "DateTime")
    public JAXBElement<DateTime> createDateTime(DateTime value) {
        return new JAXBElement<DateTime>(_DateTime_QNAME, DateTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Capability }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", name = "Capability")
    public JAXBElement<Capability> createCapability(Capability value) {
        return new JAXBElement<Capability>(_Capability_QNAME, Capability.class, null, value);
    }

}