
package org.smpte_ra.schemas.st2071._2014.event;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.smpte_ra.schemas.st2071._2014.types.DateTime;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.smpte_ra.schemas.st2071._2014.event package. 
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

    private final static QName _Event_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/event", "Event");
    private final static QName _Ready_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/event", "Ready");
    private final static QName _Timeout_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/event", "Timeout");
    private final static QName _EventTime_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/event", "EventTime");
    private final static QName _Type_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/event", "Type");
    private final static QName _RegisterCallbackResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/event", "registerCallbackResponse");
    private final static QName _UnregisterCallbackResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/event", "unregisterCallbackResponse");
    private final static QName _Callback_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/event", "callback");
    private final static QName _Message_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/event", "Message");
    private final static QName _HeartbeatResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/event", "heartbeatResponse");
    private final static QName _Heartbeat_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/event", "heartbeat");
    private final static QName _GetStatus_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/event", "getStatus");
    private final static QName _PollResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/event", "pollResponse");
    private final static QName _Poll_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/event", "poll");
    private final static QName _Registered_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/event", "registered");
    private final static QName _Unregistered_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/event", "unregistered");
    private final static QName _StatusEvent_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/event", "StatusEvent");
    private final static QName _RegisterCallback_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/event", "registerCallback");
    private final static QName _UnregisterCallback_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/event", "unregisterCallback");
    private final static QName _GetStatusResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/event", "getStatusResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.smpte_ra.schemas.st2071._2014.event
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetStatus }
     * 
     */
    public GetStatus createGetStatus() {
        return new GetStatus();
    }

    /**
     * Create an instance of {@link GetStatusResponse }
     * 
     */
    public GetStatusResponse createGetStatusResponse() {
        return new GetStatusResponse();
    }

    /**
     * Create an instance of {@link Event }
     * 
     */
    public Event createEvent() {
        return new Event();
    }

    /**
     * Create an instance of {@link URIParameter }
     * 
     */
    public URIParameter createURIParameter() {
        return new URIParameter();
    }

    /**
     * Create an instance of {@link UnregisterCallbackResponse }
     * 
     */
    public UnregisterCallbackResponse createUnregisterCallbackResponse() {
        return new UnregisterCallbackResponse();
    }

    /**
     * Create an instance of {@link StatusEvent }
     * 
     */
    public StatusEvent createStatusEvent() {
        return new StatusEvent();
    }

    /**
     * Create an instance of {@link HeartbeatResponse }
     * 
     */
    public HeartbeatResponse createHeartbeatResponse() {
        return new HeartbeatResponse();
    }

    /**
     * Create an instance of {@link RegisterCallbackResponse }
     * 
     */
    public RegisterCallbackResponse createRegisterCallbackResponse() {
        return new RegisterCallbackResponse();
    }

    /**
     * Create an instance of {@link UDNParameter }
     * 
     */
    public UDNParameter createUDNParameter() {
        return new UDNParameter();
    }

    /**
     * Create an instance of {@link Callback }
     * 
     */
    public Callback createCallback() {
        return new Callback();
    }

    /**
     * Create an instance of {@link PollResponse }
     * 
     */
    public PollResponse createPollResponse() {
        return new PollResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Event }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/event", name = "Event")
    public JAXBElement<Event> createEvent(Event value) {
        return new JAXBElement<Event>(_Event_QNAME, Event.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/event", name = "Ready")
    public JAXBElement<Boolean> createReady(Boolean value) {
        return new JAXBElement<Boolean>(_Ready_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/event", name = "Timeout")
    public JAXBElement<Long> createTimeout(Long value) {
        return new JAXBElement<Long>(_Timeout_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/event", name = "EventTime")
    public JAXBElement<DateTime> createEventTime(DateTime value) {
        return new JAXBElement<DateTime>(_EventTime_QNAME, DateTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/event", name = "Type")
    public JAXBElement<String> createType(String value) {
        return new JAXBElement<String>(_Type_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterCallbackResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/event", name = "registerCallbackResponse")
    public JAXBElement<RegisterCallbackResponse> createRegisterCallbackResponse(RegisterCallbackResponse value) {
        return new JAXBElement<RegisterCallbackResponse>(_RegisterCallbackResponse_QNAME, RegisterCallbackResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnregisterCallbackResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/event", name = "unregisterCallbackResponse")
    public JAXBElement<UnregisterCallbackResponse> createUnregisterCallbackResponse(UnregisterCallbackResponse value) {
        return new JAXBElement<UnregisterCallbackResponse>(_UnregisterCallbackResponse_QNAME, UnregisterCallbackResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Callback }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/event", name = "callback")
    public JAXBElement<Callback> createCallback(Callback value) {
        return new JAXBElement<Callback>(_Callback_QNAME, Callback.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/event", name = "Message")
    public JAXBElement<String> createMessage(String value) {
        return new JAXBElement<String>(_Message_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HeartbeatResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/event", name = "heartbeatResponse")
    public JAXBElement<HeartbeatResponse> createHeartbeatResponse(HeartbeatResponse value) {
        return new JAXBElement<HeartbeatResponse>(_HeartbeatResponse_QNAME, HeartbeatResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UDNParameter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/event", name = "heartbeat")
    public JAXBElement<UDNParameter> createHeartbeat(UDNParameter value) {
        return new JAXBElement<UDNParameter>(_Heartbeat_QNAME, UDNParameter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/event", name = "getStatus")
    public JAXBElement<GetStatus> createGetStatus(GetStatus value) {
        return new JAXBElement<GetStatus>(_GetStatus_QNAME, GetStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PollResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/event", name = "pollResponse")
    public JAXBElement<PollResponse> createPollResponse(PollResponse value) {
        return new JAXBElement<PollResponse>(_PollResponse_QNAME, PollResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link URIParameter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/event", name = "poll")
    public JAXBElement<URIParameter> createPoll(URIParameter value) {
        return new JAXBElement<URIParameter>(_Poll_QNAME, URIParameter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link URIParameter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/event", name = "registered")
    public JAXBElement<URIParameter> createRegistered(URIParameter value) {
        return new JAXBElement<URIParameter>(_Registered_QNAME, URIParameter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link URIParameter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/event", name = "unregistered")
    public JAXBElement<URIParameter> createUnregistered(URIParameter value) {
        return new JAXBElement<URIParameter>(_Unregistered_QNAME, URIParameter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatusEvent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/event", name = "StatusEvent", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/event", substitutionHeadName = "Event")
    public JAXBElement<StatusEvent> createStatusEvent(StatusEvent value) {
        return new JAXBElement<StatusEvent>(_StatusEvent_QNAME, StatusEvent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link URIParameter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/event", name = "registerCallback")
    public JAXBElement<URIParameter> createRegisterCallback(URIParameter value) {
        return new JAXBElement<URIParameter>(_RegisterCallback_QNAME, URIParameter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link URIParameter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/event", name = "unregisterCallback")
    public JAXBElement<URIParameter> createUnregisterCallback(URIParameter value) {
        return new JAXBElement<URIParameter>(_UnregisterCallback_QNAME, URIParameter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/event", name = "getStatusResponse")
    public JAXBElement<GetStatusResponse> createGetStatusResponse(GetStatusResponse value) {
        return new JAXBElement<GetStatusResponse>(_GetStatusResponse_QNAME, GetStatusResponse.class, null, value);
    }

}
