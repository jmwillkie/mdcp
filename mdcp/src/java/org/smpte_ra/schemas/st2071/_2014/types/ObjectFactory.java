
package org.smpte_ra.schemas.st2071._2014.types;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
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
    private final static QName _Boolean_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "Boolean");
    private final static QName _FramedTime_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "FramedTime");
    private final static QName _Attributes_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "Attributes");
    private final static QName _Entries_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "Entries");
    private final static QName _String_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "String");
    private final static QName _DATATYPE_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "DATA_TYPE");
    private final static QName _Image_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "Image");
    private final static QName _MIMEType_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "MIMEType");
    private final static QName _STATUS_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "STATUS");
    private final static QName _Width_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "Width");
    private final static QName _Capabilities_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "Capabilities");
    private final static QName _Height_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "Height");
    private final static QName _Map_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "Map");
    private final static QName _Message_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "Message");
    private final static QName _MapEntry_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "MapEntry");
    private final static QName _Data_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "Data");
    private final static QName _DateTime_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "DateTime");
    private final static QName _Capability_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/types", "Capability");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.smpte_ra.schemas.st2071._2014.types
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DateTime }
     * 
     */
    public DateTime createDateTime() {
        return new DateTime();
    }

    /**
     * Create an instance of {@link Map }
     * 
     */
    public Map createMap() {
        return new Map();
    }

    /**
     * Create an instance of {@link Capabilities }
     * 
     */
    public Capabilities createCapabilities() {
        return new Capabilities();
    }

    /**
     * Create an instance of {@link MapEntry }
     * 
     */
    public MapEntry createMapEntry() {
        return new MapEntry();
    }

    /**
     * Create an instance of {@link Entries }
     * 
     */
    public Entries createEntries() {
        return new Entries();
    }

    /**
     * Create an instance of {@link Capability }
     * 
     */
    public Capability createCapability() {
        return new Capability();
    }

    /**
     * Create an instance of {@link Image }
     * 
     */
    public Image createImage() {
        return new Image();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Entries }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", name = "Entries")
    public JAXBElement<Entries> createEntries(Entries value) {
        return new JAXBElement<Entries>(_Entries_QNAME, Entries.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", name = "Width")
    public JAXBElement<Integer> createWidth(Integer value) {
        return new JAXBElement<Integer>(_Width_QNAME, Integer.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", name = "Message")
    public JAXBElement<String> createMessage(String value) {
        return new JAXBElement<String>(_Message_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MapEntry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", name = "MapEntry")
    public JAXBElement<MapEntry> createMapEntry(MapEntry value) {
        return new JAXBElement<MapEntry>(_MapEntry_QNAME, MapEntry.class, null, value);
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
