
package org.smpte_ra.schemas.st2071._2014.media;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.smpte_ra.schemas.st2071._2014.types.DateTime;
import org.smpte_ra.schemas.st2071._2014.types.FramedTime;
import org.smpte_ra.schemas.st2071._2014.types.Map;
import org.smpte_ra.schemas.st2071._2014.types.OFFSETTYPE;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.smpte_ra.schemas.st2071._2014.media package. 
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

    private final static QName _MediaInstance_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "MediaInstance");
    private final static QName _Size_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "Size");
    private final static QName _CreateResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "createResponse");
    private final static QName _TrackType_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "TrackType");
    private final static QName _LookupAsset_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "lookupAsset");
    private final static QName _LookupResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "lookupResponse");
    private final static QName _InpointOffset_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "InpointOffset");
    private final static QName _MediaFile_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "MediaFile");
    private final static QName _MaterialAsset_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "MaterialAsset");
    private final static QName _Created_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "Created");
    private final static QName _MediaUpdateFailed_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "MediaUpdateFailed");
    private final static QName _Name_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "Name");
    private final static QName _Location_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "Location");
    private final static QName _MediaContainer_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "MediaContainer");
    private final static QName _List_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "list");
    private final static QName _OutpointOffset_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "OutpointOffset");
    private final static QName _Composition_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "Composition");
    private final static QName _Modified_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "Modified");
    private final static QName _Lookup_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "lookup");
    private final static QName _ListResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "listResponse");
    private final static QName _Metadata_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "Metadata");
    private final static QName _Create_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "create");
    private final static QName _MediaBundle_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "MediaBundle");
    private final static QName _Delete_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "delete");
    private final static QName _MediaNotFound_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "MediaNotFound");
    private final static QName _MediaPointers_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "MediaPointers");
    private final static QName _LookupURLs_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "lookupURLs");
    private final static QName _MediaEvent_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "MediaEvent");
    private final static QName _LookupURLsResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "lookupURLsResponse");
    private final static QName _MediaPointer_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "MediaPointer");
    private final static QName _MediaAsset_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "MediaAsset");
    private final static QName _Source_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "Source");
    private final static QName _Outpoint_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "Outpoint");
    private final static QName _MediaList_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "MediaList");
    private final static QName _Media_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "Media");
    private final static QName _Duration_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "Duration");
    private final static QName _UpdateResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "updateResponse");
    private final static QName _LookupAssetResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "lookupAssetResponse");
    private final static QName _GetMediaContainer_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "getMediaContainer");
    private final static QName _MediaCreationFailed_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "MediaCreationFailed");
    private final static QName _Update_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "update");
    private final static QName _OffsetType_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "OffsetType");
    private final static QName _DeleteResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "deleteResponse");
    private final static QName _SearchResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "searchResponse");
    private final static QName _MediaDeletionFailed_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "MediaDeletionFailed");
    private final static QName _Search_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "search");
    private final static QName _MIMEType_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "MIMEType");
    private final static QName _Format_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "Format");
    private final static QName _MediaSegment_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "MediaSegment");
    private final static QName _MediaSegments_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "MediaSegments");
    private final static QName _Inpoint_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "Inpoint");
    private final static QName _GetMediaContainerResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "getMediaContainerResponse");
    private final static QName _Track_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "Track");
    private final static QName _TrackName_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/media", "TrackName");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.smpte_ra.schemas.st2071._2014.media
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MediaPointer }
     * 
     */
    public MediaPointer createMediaPointer() {
        return new MediaPointer();
    }

    /**
     * Create an instance of {@link UMNParameter }
     * 
     */
    public UMNParameter createUMNParameter() {
        return new UMNParameter();
    }

    /**
     * Create an instance of {@link UMNFilter }
     * 
     */
    public UMNFilter createUMNFilter() {
        return new UMNFilter();
    }

    /**
     * Create an instance of {@link MediaResponse }
     * 
     */
    public MediaResponse createMediaResponse() {
        return new MediaResponse();
    }

    /**
     * Create an instance of {@link MediaDeletionFailed }
     * 
     */
    public MediaDeletionFailed createMediaDeletionFailed() {
        return new MediaDeletionFailed();
    }

    /**
     * Create an instance of {@link MediaEvent }
     * 
     */
    public MediaEvent createMediaEvent() {
        return new MediaEvent();
    }

    /**
     * Create an instance of {@link MediaSegments }
     * 
     */
    public MediaSegments createMediaSegments() {
        return new MediaSegments();
    }

    /**
     * Create an instance of {@link LookupURLsResponse }
     * 
     */
    public LookupURLsResponse createLookupURLsResponse() {
        return new LookupURLsResponse();
    }

    /**
     * Create an instance of {@link MediaInstance }
     * 
     */
    public MediaInstance createMediaInstance() {
        return new MediaInstance();
    }

    /**
     * Create an instance of {@link Media }
     * 
     */
    public Media createMedia() {
        return new Media();
    }

    /**
     * Create an instance of {@link MediaFile }
     * 
     */
    public MediaFile createMediaFile() {
        return new MediaFile();
    }

    /**
     * Create an instance of {@link MediaList }
     * 
     */
    public MediaList createMediaList() {
        return new MediaList();
    }

    /**
     * Create an instance of {@link MediaBundle }
     * 
     */
    public MediaBundle createMediaBundle() {
        return new MediaBundle();
    }

    /**
     * Create an instance of {@link Create }
     * 
     */
    public Create createCreate() {
        return new Create();
    }

    /**
     * Create an instance of {@link MediaSegment }
     * 
     */
    public MediaSegment createMediaSegment() {
        return new MediaSegment();
    }

    /**
     * Create an instance of {@link MediaListResponse }
     * 
     */
    public MediaListResponse createMediaListResponse() {
        return new MediaListResponse();
    }

    /**
     * Create an instance of {@link MediaAsset }
     * 
     */
    public MediaAsset createMediaAsset() {
        return new MediaAsset();
    }

    /**
     * Create an instance of {@link Update }
     * 
     */
    public Update createUpdate() {
        return new Update();
    }

    /**
     * Create an instance of {@link MediaCreationFailed }
     * 
     */
    public MediaCreationFailed createMediaCreationFailed() {
        return new MediaCreationFailed();
    }

    /**
     * Create an instance of {@link MediaUpdateFailed }
     * 
     */
    public MediaUpdateFailed createMediaUpdateFailed() {
        return new MediaUpdateFailed();
    }

    /**
     * Create an instance of {@link GetMediaContainer }
     * 
     */
    public GetMediaContainer createGetMediaContainer() {
        return new GetMediaContainer();
    }

    /**
     * Create an instance of {@link MediaPointers }
     * 
     */
    public MediaPointers createMediaPointers() {
        return new MediaPointers();
    }

    /**
     * Create an instance of {@link GetMediaContainerResponse }
     * 
     */
    public GetMediaContainerResponse createGetMediaContainerResponse() {
        return new GetMediaContainerResponse();
    }

    /**
     * Create an instance of {@link LookupAssetResponse }
     * 
     */
    public LookupAssetResponse createLookupAssetResponse() {
        return new LookupAssetResponse();
    }

    /**
     * Create an instance of {@link MediaNotFound }
     * 
     */
    public MediaNotFound createMediaNotFound() {
        return new MediaNotFound();
    }

    /**
     * Create an instance of {@link MaterialAsset }
     * 
     */
    public MaterialAsset createMaterialAsset() {
        return new MaterialAsset();
    }

    /**
     * Create an instance of {@link MediaContainer }
     * 
     */
    public MediaContainer createMediaContainer() {
        return new MediaContainer();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MediaInstance }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "MediaInstance", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", substitutionHeadName = "Media")
    public JAXBElement<MediaInstance> createMediaInstance(MediaInstance value) {
        return new JAXBElement<MediaInstance>(_MediaInstance_QNAME, MediaInstance.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "Size")
    public JAXBElement<BigInteger> createSize(BigInteger value) {
        return new JAXBElement<BigInteger>(_Size_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MediaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "createResponse")
    public JAXBElement<MediaResponse> createCreateResponse(MediaResponse value) {
        return new JAXBElement<MediaResponse>(_CreateResponse_QNAME, MediaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TRACKTYPE }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "TrackType")
    public JAXBElement<TRACKTYPE> createTrackType(TRACKTYPE value) {
        return new JAXBElement<TRACKTYPE>(_TrackType_QNAME, TRACKTYPE.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UMNParameter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "lookupAsset")
    public JAXBElement<UMNParameter> createLookupAsset(UMNParameter value) {
        return new JAXBElement<UMNParameter>(_LookupAsset_QNAME, UMNParameter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MediaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "lookupResponse")
    public JAXBElement<MediaResponse> createLookupResponse(MediaResponse value) {
        return new JAXBElement<MediaResponse>(_LookupResponse_QNAME, MediaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "InpointOffset")
    public JAXBElement<BigInteger> createInpointOffset(BigInteger value) {
        return new JAXBElement<BigInteger>(_InpointOffset_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MediaFile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "MediaFile", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", substitutionHeadName = "Media")
    public JAXBElement<MediaFile> createMediaFile(MediaFile value) {
        return new JAXBElement<MediaFile>(_MediaFile_QNAME, MediaFile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MaterialAsset }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "MaterialAsset", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", substitutionHeadName = "Media")
    public JAXBElement<MaterialAsset> createMaterialAsset(MaterialAsset value) {
        return new JAXBElement<MaterialAsset>(_MaterialAsset_QNAME, MaterialAsset.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "Created")
    public JAXBElement<DateTime> createCreated(DateTime value) {
        return new JAXBElement<DateTime>(_Created_QNAME, DateTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MediaUpdateFailed }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "MediaUpdateFailed", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", substitutionHeadName = "Exception")
    public JAXBElement<MediaUpdateFailed> createMediaUpdateFailed(MediaUpdateFailed value) {
        return new JAXBElement<MediaUpdateFailed>(_MediaUpdateFailed_QNAME, MediaUpdateFailed.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "Name")
    public JAXBElement<String> createName(String value) {
        return new JAXBElement<String>(_Name_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "Location")
    public JAXBElement<String> createLocation(String value) {
        return new JAXBElement<String>(_Location_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MediaContainer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "MediaContainer", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", substitutionHeadName = "Media")
    public JAXBElement<MediaContainer> createMediaContainer(MediaContainer value) {
        return new JAXBElement<MediaContainer>(_MediaContainer_QNAME, MediaContainer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UMNFilter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "list")
    public JAXBElement<UMNFilter> createList(UMNFilter value) {
        return new JAXBElement<UMNFilter>(_List_QNAME, UMNFilter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "OutpointOffset")
    public JAXBElement<BigInteger> createOutpointOffset(BigInteger value) {
        return new JAXBElement<BigInteger>(_OutpointOffset_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MediaSegments }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "Composition")
    public JAXBElement<MediaSegments> createComposition(MediaSegments value) {
        return new JAXBElement<MediaSegments>(_Composition_QNAME, MediaSegments.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "Modified")
    public JAXBElement<DateTime> createModified(DateTime value) {
        return new JAXBElement<DateTime>(_Modified_QNAME, DateTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UMNParameter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "lookup")
    public JAXBElement<UMNParameter> createLookup(UMNParameter value) {
        return new JAXBElement<UMNParameter>(_Lookup_QNAME, UMNParameter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MediaListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "listResponse")
    public JAXBElement<MediaListResponse> createListResponse(MediaListResponse value) {
        return new JAXBElement<MediaListResponse>(_ListResponse_QNAME, MediaListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Map }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "Metadata")
    public JAXBElement<Map> createMetadata(Map value) {
        return new JAXBElement<Map>(_Metadata_QNAME, Map.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Create }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "create")
    public JAXBElement<Create> createCreate(Create value) {
        return new JAXBElement<Create>(_Create_QNAME, Create.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MediaBundle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "MediaBundle", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", substitutionHeadName = "Media")
    public JAXBElement<MediaBundle> createMediaBundle(MediaBundle value) {
        return new JAXBElement<MediaBundle>(_MediaBundle_QNAME, MediaBundle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UMNParameter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "delete")
    public JAXBElement<UMNParameter> createDelete(UMNParameter value) {
        return new JAXBElement<UMNParameter>(_Delete_QNAME, UMNParameter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MediaNotFound }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "MediaNotFound", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", substitutionHeadName = "Exception")
    public JAXBElement<MediaNotFound> createMediaNotFound(MediaNotFound value) {
        return new JAXBElement<MediaNotFound>(_MediaNotFound_QNAME, MediaNotFound.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MediaPointers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "MediaPointers")
    public JAXBElement<MediaPointers> createMediaPointers(MediaPointers value) {
        return new JAXBElement<MediaPointers>(_MediaPointers_QNAME, MediaPointers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UMNParameter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "lookupURLs")
    public JAXBElement<UMNParameter> createLookupURLs(UMNParameter value) {
        return new JAXBElement<UMNParameter>(_LookupURLs_QNAME, UMNParameter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MediaEvent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "MediaEvent", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/event", substitutionHeadName = "Event")
    public JAXBElement<MediaEvent> createMediaEvent(MediaEvent value) {
        return new JAXBElement<MediaEvent>(_MediaEvent_QNAME, MediaEvent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LookupURLsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "lookupURLsResponse")
    public JAXBElement<LookupURLsResponse> createLookupURLsResponse(LookupURLsResponse value) {
        return new JAXBElement<LookupURLsResponse>(_LookupURLsResponse_QNAME, LookupURLsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MediaPointer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "MediaPointer")
    public JAXBElement<MediaPointer> createMediaPointer(MediaPointer value) {
        return new JAXBElement<MediaPointer>(_MediaPointer_QNAME, MediaPointer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MediaAsset }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "MediaAsset", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", substitutionHeadName = "Media")
    public JAXBElement<MediaAsset> createMediaAsset(MediaAsset value) {
        return new JAXBElement<MediaAsset>(_MediaAsset_QNAME, MediaAsset.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "Source")
    public JAXBElement<String> createSource(String value) {
        return new JAXBElement<String>(_Source_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "Outpoint")
    public JAXBElement<DateTime> createOutpoint(DateTime value) {
        return new JAXBElement<DateTime>(_Outpoint_QNAME, DateTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MediaList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "MediaList")
    public JAXBElement<MediaList> createMediaList(MediaList value) {
        return new JAXBElement<MediaList>(_MediaList_QNAME, MediaList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Media }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "Media")
    public JAXBElement<Media> createMedia(Media value) {
        return new JAXBElement<Media>(_Media_QNAME, Media.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FramedTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "Duration")
    public JAXBElement<FramedTime> createDuration(FramedTime value) {
        return new JAXBElement<FramedTime>(_Duration_QNAME, FramedTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MediaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "updateResponse")
    public JAXBElement<MediaResponse> createUpdateResponse(MediaResponse value) {
        return new JAXBElement<MediaResponse>(_UpdateResponse_QNAME, MediaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LookupAssetResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "lookupAssetResponse")
    public JAXBElement<LookupAssetResponse> createLookupAssetResponse(LookupAssetResponse value) {
        return new JAXBElement<LookupAssetResponse>(_LookupAssetResponse_QNAME, LookupAssetResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMediaContainer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "getMediaContainer")
    public JAXBElement<GetMediaContainer> createGetMediaContainer(GetMediaContainer value) {
        return new JAXBElement<GetMediaContainer>(_GetMediaContainer_QNAME, GetMediaContainer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MediaCreationFailed }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "MediaCreationFailed", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", substitutionHeadName = "Exception")
    public JAXBElement<MediaCreationFailed> createMediaCreationFailed(MediaCreationFailed value) {
        return new JAXBElement<MediaCreationFailed>(_MediaCreationFailed_QNAME, MediaCreationFailed.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Update }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "update")
    public JAXBElement<Update> createUpdate(Update value) {
        return new JAXBElement<Update>(_Update_QNAME, Update.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OFFSETTYPE }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "OffsetType")
    public JAXBElement<OFFSETTYPE> createOffsetType(OFFSETTYPE value) {
        return new JAXBElement<OFFSETTYPE>(_OffsetType_QNAME, OFFSETTYPE.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MediaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "deleteResponse")
    public JAXBElement<MediaResponse> createDeleteResponse(MediaResponse value) {
        return new JAXBElement<MediaResponse>(_DeleteResponse_QNAME, MediaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MediaListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "searchResponse")
    public JAXBElement<MediaListResponse> createSearchResponse(MediaListResponse value) {
        return new JAXBElement<MediaListResponse>(_SearchResponse_QNAME, MediaListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MediaDeletionFailed }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "MediaDeletionFailed", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", substitutionHeadName = "Exception")
    public JAXBElement<MediaDeletionFailed> createMediaDeletionFailed(MediaDeletionFailed value) {
        return new JAXBElement<MediaDeletionFailed>(_MediaDeletionFailed_QNAME, MediaDeletionFailed.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UMNFilter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "search")
    public JAXBElement<UMNFilter> createSearch(UMNFilter value) {
        return new JAXBElement<UMNFilter>(_Search_QNAME, UMNFilter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "MIMEType")
    public JAXBElement<String> createMIMEType(String value) {
        return new JAXBElement<String>(_MIMEType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "Format")
    public JAXBElement<String> createFormat(String value) {
        return new JAXBElement<String>(_Format_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MediaSegment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "MediaSegment", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", substitutionHeadName = "Media")
    public JAXBElement<MediaSegment> createMediaSegment(MediaSegment value) {
        return new JAXBElement<MediaSegment>(_MediaSegment_QNAME, MediaSegment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MediaSegments }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "MediaSegments")
    public JAXBElement<MediaSegments> createMediaSegments(MediaSegments value) {
        return new JAXBElement<MediaSegments>(_MediaSegments_QNAME, MediaSegments.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "Inpoint")
    public JAXBElement<DateTime> createInpoint(DateTime value) {
        return new JAXBElement<DateTime>(_Inpoint_QNAME, DateTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMediaContainerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "getMediaContainerResponse")
    public JAXBElement<GetMediaContainerResponse> createGetMediaContainerResponse(GetMediaContainerResponse value) {
        return new JAXBElement<GetMediaContainerResponse>(_GetMediaContainerResponse_QNAME, GetMediaContainerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "Track")
    public JAXBElement<Integer> createTrack(Integer value) {
        return new JAXBElement<Integer>(_Track_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/media", name = "TrackName")
    public JAXBElement<String> createTrackName(String value) {
        return new JAXBElement<String>(_TrackName_QNAME, String.class, null, value);
    }

}
