
package org.smpte_ra.schemas.st2071._2014.mode;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.smpte_ra.schemas.st2071._2014.mode package. 
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

    private final static QName _ModeEvent_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/mode", "ModeEvent");
    private final static QName _ChangeModeResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/mode", "changeModeResponse");
    private final static QName _GetActiveModeResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/mode", "getActiveModeResponse");
    private final static QName _GetModesResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/mode", "getModesResponse");
    private final static QName _GetActiveMode_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/mode", "getActiveMode");
    private final static QName _InvalidMode_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/mode", "InvalidMode");
    private final static QName _ModeException_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/mode", "ModeException");
    private final static QName _ActiveMode_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/mode", "ActiveMode");
    private final static QName _ChangeMode_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/mode", "changeMode");
    private final static QName _Name_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/mode", "Name");
    private final static QName _Mode_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/mode", "Mode");
    private final static QName _Modes_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/mode", "Modes");
    private final static QName _GetModes_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/mode", "getModes");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.smpte_ra.schemas.st2071._2014.mode
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ModeEvent }
     * 
     */
    public ModeEvent createModeEvent() {
        return new ModeEvent();
    }

    /**
     * Create an instance of {@link GetModes }
     * 
     */
    public GetModes createGetModes() {
        return new GetModes();
    }

    /**
     * Create an instance of {@link Mode }
     * 
     */
    public Mode createMode() {
        return new Mode();
    }

    /**
     * Create an instance of {@link GetActiveMode }
     * 
     */
    public GetActiveMode createGetActiveMode() {
        return new GetActiveMode();
    }

    /**
     * Create an instance of {@link ModeException }
     * 
     */
    public ModeException createModeException() {
        return new ModeException();
    }

    /**
     * Create an instance of {@link InvalidMode }
     * 
     */
    public InvalidMode createInvalidMode() {
        return new InvalidMode();
    }

    /**
     * Create an instance of {@link GetActiveModeResponse }
     * 
     */
    public GetActiveModeResponse createGetActiveModeResponse() {
        return new GetActiveModeResponse();
    }

    /**
     * Create an instance of {@link ChangeMode }
     * 
     */
    public ChangeMode createChangeMode() {
        return new ChangeMode();
    }

    /**
     * Create an instance of {@link Modes }
     * 
     */
    public Modes createModes() {
        return new Modes();
    }

    /**
     * Create an instance of {@link ChangeModeResponse }
     * 
     */
    public ChangeModeResponse createChangeModeResponse() {
        return new ChangeModeResponse();
    }

    /**
     * Create an instance of {@link GetModesResponse }
     * 
     */
    public GetModesResponse createGetModesResponse() {
        return new GetModesResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModeEvent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/mode", name = "ModeEvent", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/event", substitutionHeadName = "Event")
    public JAXBElement<ModeEvent> createModeEvent(ModeEvent value) {
        return new JAXBElement<ModeEvent>(_ModeEvent_QNAME, ModeEvent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeModeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/mode", name = "changeModeResponse")
    public JAXBElement<ChangeModeResponse> createChangeModeResponse(ChangeModeResponse value) {
        return new JAXBElement<ChangeModeResponse>(_ChangeModeResponse_QNAME, ChangeModeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetActiveModeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/mode", name = "getActiveModeResponse")
    public JAXBElement<GetActiveModeResponse> createGetActiveModeResponse(GetActiveModeResponse value) {
        return new JAXBElement<GetActiveModeResponse>(_GetActiveModeResponse_QNAME, GetActiveModeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetModesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/mode", name = "getModesResponse")
    public JAXBElement<GetModesResponse> createGetModesResponse(GetModesResponse value) {
        return new JAXBElement<GetModesResponse>(_GetModesResponse_QNAME, GetModesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetActiveMode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/mode", name = "getActiveMode")
    public JAXBElement<GetActiveMode> createGetActiveMode(GetActiveMode value) {
        return new JAXBElement<GetActiveMode>(_GetActiveMode_QNAME, GetActiveMode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidMode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/mode", name = "InvalidMode", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", substitutionHeadName = "Exception")
    public JAXBElement<InvalidMode> createInvalidMode(InvalidMode value) {
        return new JAXBElement<InvalidMode>(_InvalidMode_QNAME, InvalidMode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModeException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/mode", name = "ModeException", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", substitutionHeadName = "Exception")
    public JAXBElement<ModeException> createModeException(ModeException value) {
        return new JAXBElement<ModeException>(_ModeException_QNAME, ModeException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Mode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/mode", name = "ActiveMode")
    public JAXBElement<Mode> createActiveMode(Mode value) {
        return new JAXBElement<Mode>(_ActiveMode_QNAME, Mode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeMode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/mode", name = "changeMode")
    public JAXBElement<ChangeMode> createChangeMode(ChangeMode value) {
        return new JAXBElement<ChangeMode>(_ChangeMode_QNAME, ChangeMode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/mode", name = "Name")
    public JAXBElement<String> createName(String value) {
        return new JAXBElement<String>(_Name_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Mode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/mode", name = "Mode")
    public JAXBElement<Mode> createMode(Mode value) {
        return new JAXBElement<Mode>(_Mode_QNAME, Mode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Modes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/mode", name = "Modes")
    public JAXBElement<Modes> createModes(Modes value) {
        return new JAXBElement<Modes>(_Modes_QNAME, Modes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetModes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/mode", name = "getModes")
    public JAXBElement<GetModes> createGetModes(GetModes value) {
        return new JAXBElement<GetModes>(_GetModes_QNAME, GetModes.class, null, value);
    }

}
