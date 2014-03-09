
package org.smpte_ra.schemas.st2071._2014.identity;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.smpte_ra.schemas.st2071._2014.identity package. 
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

    private final static QName _URIs_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/identity", "URIs");
    private final static QName _UMNs_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/identity", "UMNs");
    private final static QName _URI_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/identity", "URI");
    private final static QName _URL_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/identity", "URL");
    private final static QName _URN_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/identity", "URN");
    private final static QName _UDNs_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/identity", "UDNs");
    private final static QName _UDN_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/identity", "UDN");
    private final static QName _UCNs_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/identity", "UCNs");
    private final static QName _UCN_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/identity", "UCN");
    private final static QName _USN_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/identity", "USN");
    private final static QName _RN_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/identity", "RN");
    private final static QName _URLs_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/identity", "URLs");
    private final static QName _UMN_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/identity", "UMN");
    private final static QName _URNs_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/identity", "URNs");
    private final static QName _USNs_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/identity", "USNs");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.smpte_ra.schemas.st2071._2014.identity
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link URLs }
     * 
     */
    public URLs createURLs() {
        return new URLs();
    }

    /**
     * Create an instance of {@link USNs }
     * 
     */
    public USNs createUSNs() {
        return new USNs();
    }

    /**
     * Create an instance of {@link URNs }
     * 
     */
    public URNs createURNs() {
        return new URNs();
    }

    /**
     * Create an instance of {@link URIs }
     * 
     */
    public URIs createURIs() {
        return new URIs();
    }

    /**
     * Create an instance of {@link UCNs }
     * 
     */
    public UCNs createUCNs() {
        return new UCNs();
    }

    /**
     * Create an instance of {@link UMNs }
     * 
     */
    public UMNs createUMNs() {
        return new UMNs();
    }

    /**
     * Create an instance of {@link UDNs }
     * 
     */
    public UDNs createUDNs() {
        return new UDNs();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link URIs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity", name = "URIs")
    public JAXBElement<URIs> createURIs(URIs value) {
        return new JAXBElement<URIs>(_URIs_QNAME, URIs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UMNs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity", name = "UMNs")
    public JAXBElement<UMNs> createUMNs(UMNs value) {
        return new JAXBElement<UMNs>(_UMNs_QNAME, UMNs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity", name = "URI")
    public JAXBElement<String> createURI(String value) {
        return new JAXBElement<String>(_URI_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity", name = "URL", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity", substitutionHeadName = "URI")
    public JAXBElement<String> createURL(String value) {
        return new JAXBElement<String>(_URL_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity", name = "URN", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity", substitutionHeadName = "URI")
    public JAXBElement<String> createURN(String value) {
        return new JAXBElement<String>(_URN_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UDNs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity", name = "UDNs")
    public JAXBElement<UDNs> createUDNs(UDNs value) {
        return new JAXBElement<UDNs>(_UDNs_QNAME, UDNs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity", name = "UDN", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity", substitutionHeadName = "RN")
    public JAXBElement<String> createUDN(String value) {
        return new JAXBElement<String>(_UDN_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UCNs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity", name = "UCNs")
    public JAXBElement<UCNs> createUCNs(UCNs value) {
        return new JAXBElement<UCNs>(_UCNs_QNAME, UCNs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity", name = "UCN", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity", substitutionHeadName = "URN")
    public JAXBElement<String> createUCN(String value) {
        return new JAXBElement<String>(_UCN_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity", name = "USN", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity", substitutionHeadName = "RN")
    public JAXBElement<String> createUSN(String value) {
        return new JAXBElement<String>(_USN_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity", name = "RN")
    public JAXBElement<String> createRN(String value) {
        return new JAXBElement<String>(_RN_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link URLs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity", name = "URLs")
    public JAXBElement<URLs> createURLs(URLs value) {
        return new JAXBElement<URLs>(_URLs_QNAME, URLs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity", name = "UMN", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity", substitutionHeadName = "RN")
    public JAXBElement<String> createUMN(String value) {
        return new JAXBElement<String>(_UMN_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link URNs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity", name = "URNs")
    public JAXBElement<URNs> createURNs(URNs value) {
        return new JAXBElement<URNs>(_URNs_QNAME, URNs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link USNs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/identity", name = "USNs")
    public JAXBElement<USNs> createUSNs(USNs value) {
        return new JAXBElement<USNs>(_USNs_QNAME, USNs.class, null, value);
    }

}
