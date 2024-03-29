
package org.smpte_ra.schemas.st2071._2014.device;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.smpte_ra.schemas.st2071._2014.identity.URLs;
import org.smpte_ra.schemas.st2071._2014.types.DateTime;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.smpte_ra.schemas.st2071._2014.device package. 
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

    private final static QName _GetNamespaces_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "getNamespaces");
    private final static QName _UnbindResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "unbindResponse");
    private final static QName _GetURLs_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "getURLs");
    private final static QName _Ancestors_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "ancestors");
    private final static QName _DeviceAlreadyBound_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "DeviceAlreadyBound");
    private final static QName _Parent_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "parent");
    private final static QName _GetCapabilitiesResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "getCapabilitiesResponse");
    private final static QName _GetOnline_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "getOnline");
    private final static QName _DeviceInformations_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "DeviceInformations");
    private final static QName _Search_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "search");
    private final static QName _SearchResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "searchResponse");
    private final static QName _GetAttributesResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "getAttributesResponse");
    private final static QName _Siblings_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "siblings");
    private final static QName _GetCapabilities_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "getCapabilities");
    private final static QName _GetParentDeviceDirectory_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "getParentDeviceDirectory");
    private final static QName _Bind_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "bind");
    private final static QName _Device_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "Device");
    private final static QName _Children_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "children");
    private final static QName _DeviceNotFound_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "DeviceNotFound");
    private final static QName _SiblingsResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "siblingsResponse");
    private final static QName _GetURLsResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "getURLsResponse");
    private final static QName _GetNamespacesResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "getNamespacesResponse");
    private final static QName _URLs_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "URLs");
    private final static QName _SetOnlineResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "setOnlineResponse");
    private final static QName _DeviceNotUnbound_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "DeviceNotUnbound");
    private final static QName _GetName_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "getName");
    private final static QName _ParentUDN_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "ParentUDN");
    private final static QName _UDN_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "UDN");
    private final static QName _ParentResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "parentResponse");
    private final static QName _DeviceException_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "DeviceException");
    private final static QName _BindResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "bindResponse");
    private final static QName _DeviceNotBound_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "DeviceNotBound");
    private final static QName _GetUDN_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "getUDN");
    private final static QName _ChildrenResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "childrenResponse");
    private final static QName _DeviceEvent_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "DeviceEvent");
    private final static QName _GetUDNResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "getUDNResponse");
    private final static QName _Online_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "Online");
    private final static QName _AncestorsResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "ancestorsResponse");
    private final static QName _Lookup_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "lookup");
    private final static QName _GetParentDeviceDirectoryResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "getParentDeviceDirectoryResponse");
    private final static QName _GetOnlineResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "getOnlineResponse");
    private final static QName _ValidTill_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "ValidTill");
    private final static QName _Name_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "Name");
    private final static QName _DeviceInformation_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "DeviceInformation");
    private final static QName _SetOnline_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "setOnline");
    private final static QName _Unbind_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "unbind");
    private final static QName _LookupResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "lookupResponse");
    private final static QName _GetAttributes_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "getAttributes");
    private final static QName _GetNameResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/device", "getNameResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.smpte_ra.schemas.st2071._2014.device
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeviceEvent }
     * 
     */
    public DeviceEvent createDeviceEvent() {
        return new DeviceEvent();
    }

    /**
     * Create an instance of {@link GetUDNResponse }
     * 
     */
    public GetUDNResponse createGetUDNResponse() {
        return new GetUDNResponse();
    }

    /**
     * Create an instance of {@link GetNamespacesResponse }
     * 
     */
    public GetNamespacesResponse createGetNamespacesResponse() {
        return new GetNamespacesResponse();
    }

    /**
     * Create an instance of {@link GetOnline }
     * 
     */
    public GetOnline createGetOnline() {
        return new GetOnline();
    }

    /**
     * Create an instance of {@link Lookup }
     * 
     */
    public Lookup createLookup() {
        return new Lookup();
    }

    /**
     * Create an instance of {@link DeviceInformationsResponse }
     * 
     */
    public DeviceInformationsResponse createDeviceInformationsResponse() {
        return new DeviceInformationsResponse();
    }

    /**
     * Create an instance of {@link SetOnlineResponse }
     * 
     */
    public SetOnlineResponse createSetOnlineResponse() {
        return new SetOnlineResponse();
    }

    /**
     * Create an instance of {@link DeviceInformationResponse }
     * 
     */
    public DeviceInformationResponse createDeviceInformationResponse() {
        return new DeviceInformationResponse();
    }

    /**
     * Create an instance of {@link UDNFilter }
     * 
     */
    public UDNFilter createUDNFilter() {
        return new UDNFilter();
    }

    /**
     * Create an instance of {@link DeviceInformations }
     * 
     */
    public DeviceInformations createDeviceInformations() {
        return new DeviceInformations();
    }

    /**
     * Create an instance of {@link GetNameResponse }
     * 
     */
    public GetNameResponse createGetNameResponse() {
        return new GetNameResponse();
    }

    /**
     * Create an instance of {@link DeviceNotBound }
     * 
     */
    public DeviceNotBound createDeviceNotBound() {
        return new DeviceNotBound();
    }

    /**
     * Create an instance of {@link GetUDN }
     * 
     */
    public GetUDN createGetUDN() {
        return new GetUDN();
    }

    /**
     * Create an instance of {@link DeviceAlreadyBound }
     * 
     */
    public DeviceAlreadyBound createDeviceAlreadyBound() {
        return new DeviceAlreadyBound();
    }

    /**
     * Create an instance of {@link Parent }
     * 
     */
    public Parent createParent() {
        return new Parent();
    }

    /**
     * Create an instance of {@link Unbind }
     * 
     */
    public Unbind createUnbind() {
        return new Unbind();
    }

    /**
     * Create an instance of {@link GetCapabilitiesResponse }
     * 
     */
    public GetCapabilitiesResponse createGetCapabilitiesResponse() {
        return new GetCapabilitiesResponse();
    }

    /**
     * Create an instance of {@link GetURLsResponse }
     * 
     */
    public GetURLsResponse createGetURLsResponse() {
        return new GetURLsResponse();
    }

    /**
     * Create an instance of {@link GetAttributes }
     * 
     */
    public GetAttributes createGetAttributes() {
        return new GetAttributes();
    }

    /**
     * Create an instance of {@link DeviceInformation }
     * 
     */
    public DeviceInformation createDeviceInformation() {
        return new DeviceInformation();
    }

    /**
     * Create an instance of {@link SetOnline }
     * 
     */
    public SetOnline createSetOnline() {
        return new SetOnline();
    }

    /**
     * Create an instance of {@link DeviceNotFound }
     * 
     */
    public DeviceNotFound createDeviceNotFound() {
        return new DeviceNotFound();
    }

    /**
     * Create an instance of {@link DeviceException }
     * 
     */
    public DeviceException createDeviceException() {
        return new DeviceException();
    }

    /**
     * Create an instance of {@link GetURLs }
     * 
     */
    public GetURLs createGetURLs() {
        return new GetURLs();
    }

    /**
     * Create an instance of {@link BindResponse }
     * 
     */
    public BindResponse createBindResponse() {
        return new BindResponse();
    }

    /**
     * Create an instance of {@link Ancestors }
     * 
     */
    public Ancestors createAncestors() {
        return new Ancestors();
    }

    /**
     * Create an instance of {@link GetOnlineResponse }
     * 
     */
    public GetOnlineResponse createGetOnlineResponse() {
        return new GetOnlineResponse();
    }

    /**
     * Create an instance of {@link GetAttributesResponse }
     * 
     */
    public GetAttributesResponse createGetAttributesResponse() {
        return new GetAttributesResponse();
    }

    /**
     * Create an instance of {@link GetCapabilities }
     * 
     */
    public GetCapabilities createGetCapabilities() {
        return new GetCapabilities();
    }

    /**
     * Create an instance of {@link DeviceNotUnbound }
     * 
     */
    public DeviceNotUnbound createDeviceNotUnbound() {
        return new DeviceNotUnbound();
    }

    /**
     * Create an instance of {@link GetName }
     * 
     */
    public GetName createGetName() {
        return new GetName();
    }

    /**
     * Create an instance of {@link GetNamespaces }
     * 
     */
    public GetNamespaces createGetNamespaces() {
        return new GetNamespaces();
    }

    /**
     * Create an instance of {@link UnbindResponse }
     * 
     */
    public UnbindResponse createUnbindResponse() {
        return new UnbindResponse();
    }

    /**
     * Create an instance of {@link Bind }
     * 
     */
    public Bind createBind() {
        return new Bind();
    }

    /**
     * Create an instance of {@link GetParentDeviceDirectory }
     * 
     */
    public GetParentDeviceDirectory createGetParentDeviceDirectory() {
        return new GetParentDeviceDirectory();
    }

    /**
     * Create an instance of {@link DeviceNotFoundFault }
     * 
     */
    public DeviceNotFoundFault createDeviceNotFoundFault() {
        return new DeviceNotFoundFault();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNamespaces }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "getNamespaces")
    public JAXBElement<GetNamespaces> createGetNamespaces(GetNamespaces value) {
        return new JAXBElement<GetNamespaces>(_GetNamespaces_QNAME, GetNamespaces.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnbindResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "unbindResponse")
    public JAXBElement<UnbindResponse> createUnbindResponse(UnbindResponse value) {
        return new JAXBElement<UnbindResponse>(_UnbindResponse_QNAME, UnbindResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetURLs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "getURLs")
    public JAXBElement<GetURLs> createGetURLs(GetURLs value) {
        return new JAXBElement<GetURLs>(_GetURLs_QNAME, GetURLs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ancestors }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "ancestors")
    public JAXBElement<Ancestors> createAncestors(Ancestors value) {
        return new JAXBElement<Ancestors>(_Ancestors_QNAME, Ancestors.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeviceAlreadyBound }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "DeviceAlreadyBound", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", substitutionHeadName = "Exception")
    public JAXBElement<DeviceAlreadyBound> createDeviceAlreadyBound(DeviceAlreadyBound value) {
        return new JAXBElement<DeviceAlreadyBound>(_DeviceAlreadyBound_QNAME, DeviceAlreadyBound.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Parent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "parent")
    public JAXBElement<Parent> createParent(Parent value) {
        return new JAXBElement<Parent>(_Parent_QNAME, Parent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCapabilitiesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "getCapabilitiesResponse")
    public JAXBElement<GetCapabilitiesResponse> createGetCapabilitiesResponse(GetCapabilitiesResponse value) {
        return new JAXBElement<GetCapabilitiesResponse>(_GetCapabilitiesResponse_QNAME, GetCapabilitiesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOnline }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "getOnline")
    public JAXBElement<GetOnline> createGetOnline(GetOnline value) {
        return new JAXBElement<GetOnline>(_GetOnline_QNAME, GetOnline.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeviceInformations }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "DeviceInformations")
    public JAXBElement<DeviceInformations> createDeviceInformations(DeviceInformations value) {
        return new JAXBElement<DeviceInformations>(_DeviceInformations_QNAME, DeviceInformations.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UDNFilter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "search")
    public JAXBElement<UDNFilter> createSearch(UDNFilter value) {
        return new JAXBElement<UDNFilter>(_Search_QNAME, UDNFilter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeviceInformationsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "searchResponse")
    public JAXBElement<DeviceInformationsResponse> createSearchResponse(DeviceInformationsResponse value) {
        return new JAXBElement<DeviceInformationsResponse>(_SearchResponse_QNAME, DeviceInformationsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAttributesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "getAttributesResponse")
    public JAXBElement<GetAttributesResponse> createGetAttributesResponse(GetAttributesResponse value) {
        return new JAXBElement<GetAttributesResponse>(_GetAttributesResponse_QNAME, GetAttributesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UDNFilter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "siblings")
    public JAXBElement<UDNFilter> createSiblings(UDNFilter value) {
        return new JAXBElement<UDNFilter>(_Siblings_QNAME, UDNFilter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCapabilities }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "getCapabilities")
    public JAXBElement<GetCapabilities> createGetCapabilities(GetCapabilities value) {
        return new JAXBElement<GetCapabilities>(_GetCapabilities_QNAME, GetCapabilities.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetParentDeviceDirectory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "getParentDeviceDirectory")
    public JAXBElement<GetParentDeviceDirectory> createGetParentDeviceDirectory(GetParentDeviceDirectory value) {
        return new JAXBElement<GetParentDeviceDirectory>(_GetParentDeviceDirectory_QNAME, GetParentDeviceDirectory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Bind }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "bind")
    public JAXBElement<Bind> createBind(Bind value) {
        return new JAXBElement<Bind>(_Bind_QNAME, Bind.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeviceInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "Device")
    public JAXBElement<DeviceInformation> createDevice(DeviceInformation value) {
        return new JAXBElement<DeviceInformation>(_Device_QNAME, DeviceInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UDNFilter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "children")
    public JAXBElement<UDNFilter> createChildren(UDNFilter value) {
        return new JAXBElement<UDNFilter>(_Children_QNAME, UDNFilter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeviceNotFound }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "DeviceNotFound", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", substitutionHeadName = "Exception")
    public JAXBElement<DeviceNotFound> createDeviceNotFound(DeviceNotFound value) {
        return new JAXBElement<DeviceNotFound>(_DeviceNotFound_QNAME, DeviceNotFound.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeviceInformationsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "siblingsResponse")
    public JAXBElement<DeviceInformationsResponse> createSiblingsResponse(DeviceInformationsResponse value) {
        return new JAXBElement<DeviceInformationsResponse>(_SiblingsResponse_QNAME, DeviceInformationsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetURLsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "getURLsResponse")
    public JAXBElement<GetURLsResponse> createGetURLsResponse(GetURLsResponse value) {
        return new JAXBElement<GetURLsResponse>(_GetURLsResponse_QNAME, GetURLsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNamespacesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "getNamespacesResponse")
    public JAXBElement<GetNamespacesResponse> createGetNamespacesResponse(GetNamespacesResponse value) {
        return new JAXBElement<GetNamespacesResponse>(_GetNamespacesResponse_QNAME, GetNamespacesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link URLs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "URLs")
    public JAXBElement<URLs> createURLs(URLs value) {
        return new JAXBElement<URLs>(_URLs_QNAME, URLs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetOnlineResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "setOnlineResponse")
    public JAXBElement<SetOnlineResponse> createSetOnlineResponse(SetOnlineResponse value) {
        return new JAXBElement<SetOnlineResponse>(_SetOnlineResponse_QNAME, SetOnlineResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeviceNotUnbound }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "DeviceNotUnbound", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", substitutionHeadName = "Exception")
    public JAXBElement<DeviceNotUnbound> createDeviceNotUnbound(DeviceNotUnbound value) {
        return new JAXBElement<DeviceNotUnbound>(_DeviceNotUnbound_QNAME, DeviceNotUnbound.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "getName")
    public JAXBElement<GetName> createGetName(GetName value) {
        return new JAXBElement<GetName>(_GetName_QNAME, GetName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "ParentUDN")
    public JAXBElement<String> createParentUDN(String value) {
        return new JAXBElement<String>(_ParentUDN_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "UDN")
    public JAXBElement<String> createUDN(String value) {
        return new JAXBElement<String>(_UDN_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeviceInformationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "parentResponse")
    public JAXBElement<DeviceInformationResponse> createParentResponse(DeviceInformationResponse value) {
        return new JAXBElement<DeviceInformationResponse>(_ParentResponse_QNAME, DeviceInformationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeviceException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "DeviceException", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", substitutionHeadName = "Exception")
    public JAXBElement<DeviceException> createDeviceException(DeviceException value) {
        return new JAXBElement<DeviceException>(_DeviceException_QNAME, DeviceException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BindResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "bindResponse")
    public JAXBElement<BindResponse> createBindResponse(BindResponse value) {
        return new JAXBElement<BindResponse>(_BindResponse_QNAME, BindResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeviceNotBound }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "DeviceNotBound", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", substitutionHeadName = "Exception")
    public JAXBElement<DeviceNotBound> createDeviceNotBound(DeviceNotBound value) {
        return new JAXBElement<DeviceNotBound>(_DeviceNotBound_QNAME, DeviceNotBound.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUDN }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "getUDN")
    public JAXBElement<GetUDN> createGetUDN(GetUDN value) {
        return new JAXBElement<GetUDN>(_GetUDN_QNAME, GetUDN.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeviceInformationsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "childrenResponse")
    public JAXBElement<DeviceInformationsResponse> createChildrenResponse(DeviceInformationsResponse value) {
        return new JAXBElement<DeviceInformationsResponse>(_ChildrenResponse_QNAME, DeviceInformationsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeviceEvent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "DeviceEvent", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/event", substitutionHeadName = "Event")
    public JAXBElement<DeviceEvent> createDeviceEvent(DeviceEvent value) {
        return new JAXBElement<DeviceEvent>(_DeviceEvent_QNAME, DeviceEvent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUDNResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "getUDNResponse")
    public JAXBElement<GetUDNResponse> createGetUDNResponse(GetUDNResponse value) {
        return new JAXBElement<GetUDNResponse>(_GetUDNResponse_QNAME, GetUDNResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "Online")
    public JAXBElement<Boolean> createOnline(Boolean value) {
        return new JAXBElement<Boolean>(_Online_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeviceInformationsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "ancestorsResponse")
    public JAXBElement<DeviceInformationsResponse> createAncestorsResponse(DeviceInformationsResponse value) {
        return new JAXBElement<DeviceInformationsResponse>(_AncestorsResponse_QNAME, DeviceInformationsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Lookup }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "lookup")
    public JAXBElement<Lookup> createLookup(Lookup value) {
        return new JAXBElement<Lookup>(_Lookup_QNAME, Lookup.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeviceInformationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "getParentDeviceDirectoryResponse")
    public JAXBElement<DeviceInformationResponse> createGetParentDeviceDirectoryResponse(DeviceInformationResponse value) {
        return new JAXBElement<DeviceInformationResponse>(_GetParentDeviceDirectoryResponse_QNAME, DeviceInformationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOnlineResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "getOnlineResponse")
    public JAXBElement<GetOnlineResponse> createGetOnlineResponse(GetOnlineResponse value) {
        return new JAXBElement<GetOnlineResponse>(_GetOnlineResponse_QNAME, GetOnlineResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "ValidTill")
    public JAXBElement<DateTime> createValidTill(DateTime value) {
        return new JAXBElement<DateTime>(_ValidTill_QNAME, DateTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "Name")
    public JAXBElement<String> createName(String value) {
        return new JAXBElement<String>(_Name_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeviceInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "DeviceInformation")
    public JAXBElement<DeviceInformation> createDeviceInformation(DeviceInformation value) {
        return new JAXBElement<DeviceInformation>(_DeviceInformation_QNAME, DeviceInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetOnline }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "setOnline")
    public JAXBElement<SetOnline> createSetOnline(SetOnline value) {
        return new JAXBElement<SetOnline>(_SetOnline_QNAME, SetOnline.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Unbind }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "unbind")
    public JAXBElement<Unbind> createUnbind(Unbind value) {
        return new JAXBElement<Unbind>(_Unbind_QNAME, Unbind.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeviceInformationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "lookupResponse")
    public JAXBElement<DeviceInformationResponse> createLookupResponse(DeviceInformationResponse value) {
        return new JAXBElement<DeviceInformationResponse>(_LookupResponse_QNAME, DeviceInformationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAttributes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "getAttributes")
    public JAXBElement<GetAttributes> createGetAttributes(GetAttributes value) {
        return new JAXBElement<GetAttributes>(_GetAttributes_QNAME, GetAttributes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/device", name = "getNameResponse")
    public JAXBElement<GetNameResponse> createGetNameResponse(GetNameResponse value) {
        return new JAXBElement<GetNameResponse>(_GetNameResponse_QNAME, GetNameResponse.class, null, value);
    }

}
