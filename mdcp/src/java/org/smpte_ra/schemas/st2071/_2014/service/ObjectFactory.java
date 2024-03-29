
package org.smpte_ra.schemas.st2071._2014.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.smpte_ra.schemas.st2071._2014.types.DateTime;
import org.smpte_ra.schemas.st2071._2014.types.Map;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.smpte_ra.schemas.st2071._2014.service package. 
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

    private final static QName _Search_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "search");
    private final static QName _GetCapabilitiesResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "getCapabilitiesResponse");
    private final static QName _GetUSNResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "getUSNResponse");
    private final static QName _GetURLs_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "getURLs");
    private final static QName _CreatedBy_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "CreatedBy");
    private final static QName _UnbindResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "unbindResponse");
    private final static QName _GetNamespaces_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "getNamespaces");
    private final static QName _ServiceException_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "ServiceException");
    private final static QName _ListTemplates_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "listTemplates");
    private final static QName _GetNamespacesResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "getNamespacesResponse");
    private final static QName _GetState_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "getState");
    private final static QName _Attributes_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "Attributes");
    private final static QName _GetURLsResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "getURLsResponse");
    private final static QName _Destroy_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "destroy");
    private final static QName _GetType_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "getType");
    private final static QName _Bind_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "bind");
    private final static QName _State_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "State");
    private final static QName _GetCapabilities_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "getCapabilities");
    private final static QName _GetAttributesResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "getAttributesResponse");
    private final static QName _ServiceInformations_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "ServiceInformations");
    private final static QName _SearchResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "searchResponse");
    private final static QName _ServiceTemplates_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "ServiceTemplates");
    private final static QName _Lookup_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "lookup");
    private final static QName _ServiceInformation_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "ServiceInformation");
    private final static QName _Create_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "create");
    private final static QName _DestroyResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "destroyResponse");
    private final static QName _ServiceNotFound_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "ServiceNotFound");
    private final static QName _BindResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "bindResponse");
    private final static QName _CreateResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "createResponse");
    private final static QName _ListTemplatesResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "listTemplatesResponse");
    private final static QName _GetAttributes_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "getAttributes");
    private final static QName _GetTypeResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "getTypeResponse");
    private final static QName _LookupResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "lookupResponse");
    private final static QName _Unbind_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "unbind");
    private final static QName _GetUSN_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "getUSN");
    private final static QName _GetStateResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "getStateResponse");
    private final static QName _Created_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "Created");
    private final static QName _ServiceTemplate_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "ServiceTemplate");
    private final static QName _Type_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "Type");
    private final static QName _ValidTill_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/service", "ValidTill");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.smpte_ra.schemas.st2071._2014.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetState }
     * 
     */
    public GetState createGetState() {
        return new GetState();
    }

    /**
     * Create an instance of {@link ServiceTemplatesResponse }
     * 
     */
    public ServiceTemplatesResponse createServiceTemplatesResponse() {
        return new ServiceTemplatesResponse();
    }

    /**
     * Create an instance of {@link ServiceInformation }
     * 
     */
    public ServiceInformation createServiceInformation() {
        return new ServiceInformation();
    }

    /**
     * Create an instance of {@link ServiceTemplate }
     * 
     */
    public ServiceTemplate createServiceTemplate() {
        return new ServiceTemplate();
    }

    /**
     * Create an instance of {@link GetNamespacesResponse }
     * 
     */
    public GetNamespacesResponse createGetNamespacesResponse() {
        return new GetNamespacesResponse();
    }

    /**
     * Create an instance of {@link USNRequest }
     * 
     */
    public USNRequest createUSNRequest() {
        return new USNRequest();
    }

    /**
     * Create an instance of {@link Destroy }
     * 
     */
    public Destroy createDestroy() {
        return new Destroy();
    }

    /**
     * Create an instance of {@link GetURLs }
     * 
     */
    public GetURLs createGetURLs() {
        return new GetURLs();
    }

    /**
     * Create an instance of {@link EmptyResponse }
     * 
     */
    public EmptyResponse createEmptyResponse() {
        return new EmptyResponse();
    }

    /**
     * Create an instance of {@link GetType }
     * 
     */
    public GetType createGetType() {
        return new GetType();
    }

    /**
     * Create an instance of {@link QueryRequest }
     * 
     */
    public QueryRequest createQueryRequest() {
        return new QueryRequest();
    }

    /**
     * Create an instance of {@link ServiceTemplates }
     * 
     */
    public ServiceTemplates createServiceTemplates() {
        return new ServiceTemplates();
    }

    /**
     * Create an instance of {@link USNResponse }
     * 
     */
    public USNResponse createUSNResponse() {
        return new USNResponse();
    }

    /**
     * Create an instance of {@link GetStateResponse }
     * 
     */
    public GetStateResponse createGetStateResponse() {
        return new GetStateResponse();
    }

    /**
     * Create an instance of {@link GetUSN }
     * 
     */
    public GetUSN createGetUSN() {
        return new GetUSN();
    }

    /**
     * Create an instance of {@link ServiceException }
     * 
     */
    public ServiceException createServiceException() {
        return new ServiceException();
    }

    /**
     * Create an instance of {@link GetUSNResponse }
     * 
     */
    public GetUSNResponse createGetUSNResponse() {
        return new GetUSNResponse();
    }

    /**
     * Create an instance of {@link ServiceInformationsResponse }
     * 
     */
    public ServiceInformationsResponse createServiceInformationsResponse() {
        return new ServiceInformationsResponse();
    }

    /**
     * Create an instance of {@link ServiceNotFound }
     * 
     */
    public ServiceNotFound createServiceNotFound() {
        return new ServiceNotFound();
    }

    /**
     * Create an instance of {@link ServiceInformations }
     * 
     */
    public ServiceInformations createServiceInformations() {
        return new ServiceInformations();
    }

    /**
     * Create an instance of {@link Create }
     * 
     */
    public Create createCreate() {
        return new Create();
    }

    /**
     * Create an instance of {@link GetCapabilitiesResponse }
     * 
     */
    public GetCapabilitiesResponse createGetCapabilitiesResponse() {
        return new GetCapabilitiesResponse();
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
     * Create an instance of {@link ServiceInformationResponse }
     * 
     */
    public ServiceInformationResponse createServiceInformationResponse() {
        return new ServiceInformationResponse();
    }

    /**
     * Create an instance of {@link GetTypeResponse }
     * 
     */
    public GetTypeResponse createGetTypeResponse() {
        return new GetTypeResponse();
    }

    /**
     * Create an instance of {@link GetURLsResponse }
     * 
     */
    public GetURLsResponse createGetURLsResponse() {
        return new GetURLsResponse();
    }

    /**
     * Create an instance of {@link GetNamespaces }
     * 
     */
    public GetNamespaces createGetNamespaces() {
        return new GetNamespaces();
    }

    /**
     * Create an instance of {@link ServiceInformationRequest }
     * 
     */
    public ServiceInformationRequest createServiceInformationRequest() {
        return new ServiceInformationRequest();
    }

    /**
     * Create an instance of {@link GetAttributes }
     * 
     */
    public GetAttributes createGetAttributes() {
        return new GetAttributes();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "search")
    public JAXBElement<QueryRequest> createSearch(QueryRequest value) {
        return new JAXBElement<QueryRequest>(_Search_QNAME, QueryRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCapabilitiesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "getCapabilitiesResponse")
    public JAXBElement<GetCapabilitiesResponse> createGetCapabilitiesResponse(GetCapabilitiesResponse value) {
        return new JAXBElement<GetCapabilitiesResponse>(_GetCapabilitiesResponse_QNAME, GetCapabilitiesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUSNResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "getUSNResponse")
    public JAXBElement<GetUSNResponse> createGetUSNResponse(GetUSNResponse value) {
        return new JAXBElement<GetUSNResponse>(_GetUSNResponse_QNAME, GetUSNResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetURLs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "getURLs")
    public JAXBElement<GetURLs> createGetURLs(GetURLs value) {
        return new JAXBElement<GetURLs>(_GetURLs_QNAME, GetURLs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "CreatedBy")
    public JAXBElement<String> createCreatedBy(String value) {
        return new JAXBElement<String>(_CreatedBy_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmptyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "unbindResponse")
    public JAXBElement<EmptyResponse> createUnbindResponse(EmptyResponse value) {
        return new JAXBElement<EmptyResponse>(_UnbindResponse_QNAME, EmptyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNamespaces }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "getNamespaces")
    public JAXBElement<GetNamespaces> createGetNamespaces(GetNamespaces value) {
        return new JAXBElement<GetNamespaces>(_GetNamespaces_QNAME, GetNamespaces.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "ServiceException", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", substitutionHeadName = "Exception")
    public JAXBElement<ServiceException> createServiceException(ServiceException value) {
        return new JAXBElement<ServiceException>(_ServiceException_QNAME, ServiceException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "listTemplates")
    public JAXBElement<QueryRequest> createListTemplates(QueryRequest value) {
        return new JAXBElement<QueryRequest>(_ListTemplates_QNAME, QueryRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNamespacesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "getNamespacesResponse")
    public JAXBElement<GetNamespacesResponse> createGetNamespacesResponse(GetNamespacesResponse value) {
        return new JAXBElement<GetNamespacesResponse>(_GetNamespacesResponse_QNAME, GetNamespacesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetState }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "getState")
    public JAXBElement<GetState> createGetState(GetState value) {
        return new JAXBElement<GetState>(_GetState_QNAME, GetState.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Map }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "Attributes")
    public JAXBElement<Map> createAttributes(Map value) {
        return new JAXBElement<Map>(_Attributes_QNAME, Map.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetURLsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "getURLsResponse")
    public JAXBElement<GetURLsResponse> createGetURLsResponse(GetURLsResponse value) {
        return new JAXBElement<GetURLsResponse>(_GetURLsResponse_QNAME, GetURLsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Destroy }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "destroy")
    public JAXBElement<Destroy> createDestroy(Destroy value) {
        return new JAXBElement<Destroy>(_Destroy_QNAME, Destroy.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "getType")
    public JAXBElement<GetType> createGetType(GetType value) {
        return new JAXBElement<GetType>(_GetType_QNAME, GetType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceInformationRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "bind")
    public JAXBElement<ServiceInformationRequest> createBind(ServiceInformationRequest value) {
        return new JAXBElement<ServiceInformationRequest>(_Bind_QNAME, ServiceInformationRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SERVICESTATE }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "State")
    public JAXBElement<SERVICESTATE> createState(SERVICESTATE value) {
        return new JAXBElement<SERVICESTATE>(_State_QNAME, SERVICESTATE.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCapabilities }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "getCapabilities")
    public JAXBElement<GetCapabilities> createGetCapabilities(GetCapabilities value) {
        return new JAXBElement<GetCapabilities>(_GetCapabilities_QNAME, GetCapabilities.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAttributesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "getAttributesResponse")
    public JAXBElement<GetAttributesResponse> createGetAttributesResponse(GetAttributesResponse value) {
        return new JAXBElement<GetAttributesResponse>(_GetAttributesResponse_QNAME, GetAttributesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceInformations }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "ServiceInformations")
    public JAXBElement<ServiceInformations> createServiceInformations(ServiceInformations value) {
        return new JAXBElement<ServiceInformations>(_ServiceInformations_QNAME, ServiceInformations.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceInformationsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "searchResponse")
    public JAXBElement<ServiceInformationsResponse> createSearchResponse(ServiceInformationsResponse value) {
        return new JAXBElement<ServiceInformationsResponse>(_SearchResponse_QNAME, ServiceInformationsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceTemplates }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "ServiceTemplates")
    public JAXBElement<ServiceTemplates> createServiceTemplates(ServiceTemplates value) {
        return new JAXBElement<ServiceTemplates>(_ServiceTemplates_QNAME, ServiceTemplates.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link USNRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "lookup")
    public JAXBElement<USNRequest> createLookup(USNRequest value) {
        return new JAXBElement<USNRequest>(_Lookup_QNAME, USNRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "ServiceInformation")
    public JAXBElement<ServiceInformation> createServiceInformation(ServiceInformation value) {
        return new JAXBElement<ServiceInformation>(_ServiceInformation_QNAME, ServiceInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Create }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "create")
    public JAXBElement<Create> createCreate(Create value) {
        return new JAXBElement<Create>(_Create_QNAME, Create.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmptyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "destroyResponse")
    public JAXBElement<EmptyResponse> createDestroyResponse(EmptyResponse value) {
        return new JAXBElement<EmptyResponse>(_DestroyResponse_QNAME, EmptyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceNotFound }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "ServiceNotFound", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", substitutionHeadName = "Exception")
    public JAXBElement<ServiceNotFound> createServiceNotFound(ServiceNotFound value) {
        return new JAXBElement<ServiceNotFound>(_ServiceNotFound_QNAME, ServiceNotFound.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmptyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "bindResponse")
    public JAXBElement<EmptyResponse> createBindResponse(EmptyResponse value) {
        return new JAXBElement<EmptyResponse>(_BindResponse_QNAME, EmptyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link USNResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "createResponse")
    public JAXBElement<USNResponse> createCreateResponse(USNResponse value) {
        return new JAXBElement<USNResponse>(_CreateResponse_QNAME, USNResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceTemplatesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "listTemplatesResponse")
    public JAXBElement<ServiceTemplatesResponse> createListTemplatesResponse(ServiceTemplatesResponse value) {
        return new JAXBElement<ServiceTemplatesResponse>(_ListTemplatesResponse_QNAME, ServiceTemplatesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAttributes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "getAttributes")
    public JAXBElement<GetAttributes> createGetAttributes(GetAttributes value) {
        return new JAXBElement<GetAttributes>(_GetAttributes_QNAME, GetAttributes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "getTypeResponse")
    public JAXBElement<GetTypeResponse> createGetTypeResponse(GetTypeResponse value) {
        return new JAXBElement<GetTypeResponse>(_GetTypeResponse_QNAME, GetTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceInformationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "lookupResponse")
    public JAXBElement<ServiceInformationResponse> createLookupResponse(ServiceInformationResponse value) {
        return new JAXBElement<ServiceInformationResponse>(_LookupResponse_QNAME, ServiceInformationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link USNRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "unbind")
    public JAXBElement<USNRequest> createUnbind(USNRequest value) {
        return new JAXBElement<USNRequest>(_Unbind_QNAME, USNRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUSN }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "getUSN")
    public JAXBElement<GetUSN> createGetUSN(GetUSN value) {
        return new JAXBElement<GetUSN>(_GetUSN_QNAME, GetUSN.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "getStateResponse")
    public JAXBElement<GetStateResponse> createGetStateResponse(GetStateResponse value) {
        return new JAXBElement<GetStateResponse>(_GetStateResponse_QNAME, GetStateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "Created")
    public JAXBElement<DateTime> createCreated(DateTime value) {
        return new JAXBElement<DateTime>(_Created_QNAME, DateTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceTemplate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "ServiceTemplate")
    public JAXBElement<ServiceTemplate> createServiceTemplate(ServiceTemplate value) {
        return new JAXBElement<ServiceTemplate>(_ServiceTemplate_QNAME, ServiceTemplate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceTemplate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "Type")
    public JAXBElement<ServiceTemplate> createType(ServiceTemplate value) {
        return new JAXBElement<ServiceTemplate>(_Type_QNAME, ServiceTemplate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/service", name = "ValidTill")
    public JAXBElement<DateTime> createValidTill(DateTime value) {
        return new JAXBElement<DateTime>(_ValidTill_QNAME, DateTime.class, null, value);
    }

}
