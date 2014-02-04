
package org.smpte_ra.schemas.st2071._2014.session;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.smpte_ra.schemas.st2071._2014.types.DateTime;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.smpte_ra.schemas.st2071._2014.session package. 
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

    private final static QName _Approve_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "approve");
    private final static QName _RequestNotFound_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "RequestNotFound");
    private final static QName _Release_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "release");
    private final static QName _DenyResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "denyResponse");
    private final static QName _ID_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "ID");
    private final static QName _Request_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "request");
    private final static QName _GetLockedByResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "getLockedByResponse");
    private final static QName _Lock_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "lock");
    private final static QName _Name_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "Name");
    private final static QName _TooManySessions_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "TooManySessions");
    private final static QName _ApproveResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "approveResponse");
    private final static QName _SessionTaken_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "SessionTaken");
    private final static QName _Unlock_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "unlock");
    private final static QName _RequestResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "requestResponse");
    private final static QName _RequestID_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "RequestID");
    private final static QName _UnlockResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "unlockResponse");
    private final static QName _Message_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "Message");
    private final static QName _TakeResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "takeResponse");
    private final static QName _Acquire_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "acquire");
    private final static QName _LockTaken_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "LockTaken");
    private final static QName _GetLockedResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "getLockedResponse");
    private final static QName _SessionNotFound_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "SessionNotFound");
    private final static QName _Locked_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "Locked");
    private final static QName _LockNotFound_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "LockNotFound");
    private final static QName _GetAcquiredByResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "getAcquiredByResponse");
    private final static QName _GetAcquiredResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "getAcquiredResponse");
    private final static QName _ReleaseResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "releaseResponse");
    private final static QName _GetAcquired_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "getAcquired");
    private final static QName _GetAcquiredBy_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "getAcquiredBy");
    private final static QName _Session_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "Session");
    private final static QName _GetLockedBy_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "getLockedBy");
    private final static QName _Take_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "take");
    private final static QName _NotAcquired_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "NotAcquired");
    private final static QName _AcquireResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "acquireResponse");
    private final static QName _GetLocked_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "getLocked");
    private final static QName _Deny_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "deny");
    private final static QName _RequestDenied_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "RequestDenied");
    private final static QName _LockResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "lockResponse");
    private final static QName _SessionEvent_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "SessionEvent");
    private final static QName _Who_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "Who");
    private final static QName _SessionID_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "SessionID");
    private final static QName _NameInUse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "NameInUse");
    private final static QName _LockID_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "LockID");
    private final static QName _Sessions_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "Sessions");
    private final static QName _AcquiredAt_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "AcquiredAt");
    private final static QName _RequestExpired_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "RequestExpired");
    private final static QName _RequestEvent_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "RequestEvent");
    private final static QName _NotLocked_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/session", "NotLocked");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.smpte_ra.schemas.st2071._2014.session
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAcquiredByResponse }
     * 
     */
    public GetAcquiredByResponse createGetAcquiredByResponse() {
        return new GetAcquiredByResponse();
    }

    /**
     * Create an instance of {@link BooleanResponse }
     * 
     */
    public BooleanResponse createBooleanResponse() {
        return new BooleanResponse();
    }

    /**
     * Create an instance of {@link RequestEvent }
     * 
     */
    public RequestEvent createRequestEvent() {
        return new RequestEvent();
    }

    /**
     * Create an instance of {@link URIResponse }
     * 
     */
    public URIResponse createURIResponse() {
        return new URIResponse();
    }

    /**
     * Create an instance of {@link RequestExpired }
     * 
     */
    public RequestExpired createRequestExpired() {
        return new RequestExpired();
    }

    /**
     * Create an instance of {@link LockNotFound }
     * 
     */
    public LockNotFound createLockNotFound() {
        return new LockNotFound();
    }

    /**
     * Create an instance of {@link EmptyResponse }
     * 
     */
    public EmptyResponse createEmptyResponse() {
        return new EmptyResponse();
    }

    /**
     * Create an instance of {@link LockTaken }
     * 
     */
    public LockTaken createLockTaken() {
        return new LockTaken();
    }

    /**
     * Create an instance of {@link Deny }
     * 
     */
    public Deny createDeny() {
        return new Deny();
    }

    /**
     * Create an instance of {@link NotLocked }
     * 
     */
    public NotLocked createNotLocked() {
        return new NotLocked();
    }

    /**
     * Create an instance of {@link Session }
     * 
     */
    public Session createSession() {
        return new Session();
    }

    /**
     * Create an instance of {@link RequestParameters }
     * 
     */
    public RequestParameters createRequestParameters() {
        return new RequestParameters();
    }

    /**
     * Create an instance of {@link SessionEvent }
     * 
     */
    public SessionEvent createSessionEvent() {
        return new SessionEvent();
    }

    /**
     * Create an instance of {@link EmptyRequest }
     * 
     */
    public EmptyRequest createEmptyRequest() {
        return new EmptyRequest();
    }

    /**
     * Create an instance of {@link TooManySessions }
     * 
     */
    public TooManySessions createTooManySessions() {
        return new TooManySessions();
    }

    /**
     * Create an instance of {@link Acquire }
     * 
     */
    public Acquire createAcquire() {
        return new Acquire();
    }

    /**
     * Create an instance of {@link URIRequest }
     * 
     */
    public URIRequest createURIRequest() {
        return new URIRequest();
    }

    /**
     * Create an instance of {@link Lock }
     * 
     */
    public Lock createLock() {
        return new Lock();
    }

    /**
     * Create an instance of {@link RequestDenied }
     * 
     */
    public RequestDenied createRequestDenied() {
        return new RequestDenied();
    }

    /**
     * Create an instance of {@link SessionNotFound }
     * 
     */
    public SessionNotFound createSessionNotFound() {
        return new SessionNotFound();
    }

    /**
     * Create an instance of {@link GetLockedByResponse }
     * 
     */
    public GetLockedByResponse createGetLockedByResponse() {
        return new GetLockedByResponse();
    }

    /**
     * Create an instance of {@link SessionTaken }
     * 
     */
    public SessionTaken createSessionTaken() {
        return new SessionTaken();
    }

    /**
     * Create an instance of {@link NotAcquired }
     * 
     */
    public NotAcquired createNotAcquired() {
        return new NotAcquired();
    }

    /**
     * Create an instance of {@link Sessions }
     * 
     */
    public Sessions createSessions() {
        return new Sessions();
    }

    /**
     * Create an instance of {@link NameInUse }
     * 
     */
    public NameInUse createNameInUse() {
        return new NameInUse();
    }

    /**
     * Create an instance of {@link Locked }
     * 
     */
    public Locked createLocked() {
        return new Locked();
    }

    /**
     * Create an instance of {@link RequestNotFound }
     * 
     */
    public RequestNotFound createRequestNotFound() {
        return new RequestNotFound();
    }

    /**
     * Create an instance of {@link ApproveResponse }
     * 
     */
    public ApproveResponse createApproveResponse() {
        return new ApproveResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link URIRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "approve")
    public JAXBElement<URIRequest> createApprove(URIRequest value) {
        return new JAXBElement<URIRequest>(_Approve_QNAME, URIRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestNotFound }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "RequestNotFound", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", substitutionHeadName = "Exception")
    public JAXBElement<RequestNotFound> createRequestNotFound(RequestNotFound value) {
        return new JAXBElement<RequestNotFound>(_RequestNotFound_QNAME, RequestNotFound.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link URIRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "release")
    public JAXBElement<URIRequest> createRelease(URIRequest value) {
        return new JAXBElement<URIRequest>(_Release_QNAME, URIRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmptyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "denyResponse")
    public JAXBElement<EmptyResponse> createDenyResponse(EmptyResponse value) {
        return new JAXBElement<EmptyResponse>(_DenyResponse_QNAME, EmptyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "ID")
    public JAXBElement<String> createID(String value) {
        return new JAXBElement<String>(_ID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestParameters }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "request")
    public JAXBElement<RequestParameters> createRequest(RequestParameters value) {
        return new JAXBElement<RequestParameters>(_Request_QNAME, RequestParameters.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLockedByResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "getLockedByResponse")
    public JAXBElement<GetLockedByResponse> createGetLockedByResponse(GetLockedByResponse value) {
        return new JAXBElement<GetLockedByResponse>(_GetLockedByResponse_QNAME, GetLockedByResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Lock }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "lock")
    public JAXBElement<Lock> createLock(Lock value) {
        return new JAXBElement<Lock>(_Lock_QNAME, Lock.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "Name")
    public JAXBElement<String> createName(String value) {
        return new JAXBElement<String>(_Name_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TooManySessions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "TooManySessions", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", substitutionHeadName = "Exception")
    public JAXBElement<TooManySessions> createTooManySessions(TooManySessions value) {
        return new JAXBElement<TooManySessions>(_TooManySessions_QNAME, TooManySessions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmptyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "approveResponse")
    public JAXBElement<EmptyResponse> createApproveResponse(EmptyResponse value) {
        return new JAXBElement<EmptyResponse>(_ApproveResponse_QNAME, EmptyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SessionTaken }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "SessionTaken", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", substitutionHeadName = "Exception")
    public JAXBElement<SessionTaken> createSessionTaken(SessionTaken value) {
        return new JAXBElement<SessionTaken>(_SessionTaken_QNAME, SessionTaken.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link URIRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "unlock")
    public JAXBElement<URIRequest> createUnlock(URIRequest value) {
        return new JAXBElement<URIRequest>(_Unlock_QNAME, URIRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link URIResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "requestResponse")
    public JAXBElement<URIResponse> createRequestResponse(URIResponse value) {
        return new JAXBElement<URIResponse>(_RequestResponse_QNAME, URIResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "RequestID")
    public JAXBElement<String> createRequestID(String value) {
        return new JAXBElement<String>(_RequestID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BooleanResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "unlockResponse")
    public JAXBElement<BooleanResponse> createUnlockResponse(BooleanResponse value) {
        return new JAXBElement<BooleanResponse>(_UnlockResponse_QNAME, BooleanResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "Message")
    public JAXBElement<String> createMessage(String value) {
        return new JAXBElement<String>(_Message_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link URIResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "takeResponse")
    public JAXBElement<URIResponse> createTakeResponse(URIResponse value) {
        return new JAXBElement<URIResponse>(_TakeResponse_QNAME, URIResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Acquire }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "acquire")
    public JAXBElement<Acquire> createAcquire(Acquire value) {
        return new JAXBElement<Acquire>(_Acquire_QNAME, Acquire.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockTaken }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "LockTaken", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", substitutionHeadName = "Exception")
    public JAXBElement<LockTaken> createLockTaken(LockTaken value) {
        return new JAXBElement<LockTaken>(_LockTaken_QNAME, LockTaken.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BooleanResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "getLockedResponse")
    public JAXBElement<BooleanResponse> createGetLockedResponse(BooleanResponse value) {
        return new JAXBElement<BooleanResponse>(_GetLockedResponse_QNAME, BooleanResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SessionNotFound }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "SessionNotFound", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", substitutionHeadName = "Exception")
    public JAXBElement<SessionNotFound> createSessionNotFound(SessionNotFound value) {
        return new JAXBElement<SessionNotFound>(_SessionNotFound_QNAME, SessionNotFound.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Locked }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "Locked", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", substitutionHeadName = "Exception")
    public JAXBElement<Locked> createLocked(Locked value) {
        return new JAXBElement<Locked>(_Locked_QNAME, Locked.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockNotFound }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "LockNotFound", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", substitutionHeadName = "Exception")
    public JAXBElement<LockNotFound> createLockNotFound(LockNotFound value) {
        return new JAXBElement<LockNotFound>(_LockNotFound_QNAME, LockNotFound.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAcquiredByResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "getAcquiredByResponse")
    public JAXBElement<GetAcquiredByResponse> createGetAcquiredByResponse(GetAcquiredByResponse value) {
        return new JAXBElement<GetAcquiredByResponse>(_GetAcquiredByResponse_QNAME, GetAcquiredByResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BooleanResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "getAcquiredResponse")
    public JAXBElement<BooleanResponse> createGetAcquiredResponse(BooleanResponse value) {
        return new JAXBElement<BooleanResponse>(_GetAcquiredResponse_QNAME, BooleanResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BooleanResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "releaseResponse")
    public JAXBElement<BooleanResponse> createReleaseResponse(BooleanResponse value) {
        return new JAXBElement<BooleanResponse>(_ReleaseResponse_QNAME, BooleanResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmptyRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "getAcquired")
    public JAXBElement<EmptyRequest> createGetAcquired(EmptyRequest value) {
        return new JAXBElement<EmptyRequest>(_GetAcquired_QNAME, EmptyRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmptyRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "getAcquiredBy")
    public JAXBElement<EmptyRequest> createGetAcquiredBy(EmptyRequest value) {
        return new JAXBElement<EmptyRequest>(_GetAcquiredBy_QNAME, EmptyRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Session }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "Session")
    public JAXBElement<Session> createSession(Session value) {
        return new JAXBElement<Session>(_Session_QNAME, Session.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmptyRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "getLockedBy")
    public JAXBElement<EmptyRequest> createGetLockedBy(EmptyRequest value) {
        return new JAXBElement<EmptyRequest>(_GetLockedBy_QNAME, EmptyRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestParameters }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "take")
    public JAXBElement<RequestParameters> createTake(RequestParameters value) {
        return new JAXBElement<RequestParameters>(_Take_QNAME, RequestParameters.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotAcquired }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "NotAcquired", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", substitutionHeadName = "Exception")
    public JAXBElement<NotAcquired> createNotAcquired(NotAcquired value) {
        return new JAXBElement<NotAcquired>(_NotAcquired_QNAME, NotAcquired.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link URIResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "acquireResponse")
    public JAXBElement<URIResponse> createAcquireResponse(URIResponse value) {
        return new JAXBElement<URIResponse>(_AcquireResponse_QNAME, URIResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmptyRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "getLocked")
    public JAXBElement<EmptyRequest> createGetLocked(EmptyRequest value) {
        return new JAXBElement<EmptyRequest>(_GetLocked_QNAME, EmptyRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Deny }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "deny")
    public JAXBElement<Deny> createDeny(Deny value) {
        return new JAXBElement<Deny>(_Deny_QNAME, Deny.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestDenied }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "RequestDenied", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", substitutionHeadName = "Exception")
    public JAXBElement<RequestDenied> createRequestDenied(RequestDenied value) {
        return new JAXBElement<RequestDenied>(_RequestDenied_QNAME, RequestDenied.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link URIResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "lockResponse")
    public JAXBElement<URIResponse> createLockResponse(URIResponse value) {
        return new JAXBElement<URIResponse>(_LockResponse_QNAME, URIResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SessionEvent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "SessionEvent", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/event", substitutionHeadName = "Event")
    public JAXBElement<SessionEvent> createSessionEvent(SessionEvent value) {
        return new JAXBElement<SessionEvent>(_SessionEvent_QNAME, SessionEvent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "Who")
    public JAXBElement<String> createWho(String value) {
        return new JAXBElement<String>(_Who_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "SessionID")
    public JAXBElement<String> createSessionID(String value) {
        return new JAXBElement<String>(_SessionID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NameInUse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "NameInUse", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", substitutionHeadName = "Exception")
    public JAXBElement<NameInUse> createNameInUse(NameInUse value) {
        return new JAXBElement<NameInUse>(_NameInUse_QNAME, NameInUse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "LockID")
    public JAXBElement<String> createLockID(String value) {
        return new JAXBElement<String>(_LockID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Sessions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "Sessions")
    public JAXBElement<Sessions> createSessions(Sessions value) {
        return new JAXBElement<Sessions>(_Sessions_QNAME, Sessions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "AcquiredAt")
    public JAXBElement<DateTime> createAcquiredAt(DateTime value) {
        return new JAXBElement<DateTime>(_AcquiredAt_QNAME, DateTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestExpired }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "RequestExpired", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", substitutionHeadName = "Exception")
    public JAXBElement<RequestExpired> createRequestExpired(RequestExpired value) {
        return new JAXBElement<RequestExpired>(_RequestExpired_QNAME, RequestExpired.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestEvent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "RequestEvent", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/event", substitutionHeadName = "Event")
    public JAXBElement<RequestEvent> createRequestEvent(RequestEvent value) {
        return new JAXBElement<RequestEvent>(_RequestEvent_QNAME, RequestEvent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotLocked }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/session", name = "NotLocked", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", substitutionHeadName = "Exception")
    public JAXBElement<NotLocked> createNotLocked(NotLocked value) {
        return new JAXBElement<NotLocked>(_NotLocked_QNAME, NotLocked.class, null, value);
    }

}
