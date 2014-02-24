
package org.smpte_ra.schemas.st2071._2014.security;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.smpte_ra.schemas.st2071._2014.types.DateTime;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.smpte_ra.schemas.st2071._2014.security package. 
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

    private final static QName _Allow_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "Allow");
    private final static QName _SecurityTokens_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "SecurityTokens");
    private final static QName _GetMechanismsResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "getMechanismsResponse");
    private final static QName _Tokens_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "Tokens");
    private final static QName _AuthenticateResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "authenticateResponse");
    private final static QName _Status_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "Status");
    private final static QName _Authorize_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "authorize");
    private final static QName _Resource_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "Resource");
    private final static QName _GetMechanisms_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "getMechanisms");
    private final static QName _PERMISSIONTYPE_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "PERMISSION_TYPE");
    private final static QName _Realm_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "Realm");
    private final static QName _EXCEPTIONSTATUS_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "EXCEPTION_STATUS");
    private final static QName _Role_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "Role");
    private final static QName _Subject_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "Subject");
    private final static QName _LogoutResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "logoutResponse");
    private final static QName _Principal_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "Principal");
    private final static QName _AuthorizeResponse_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "authorizeResponse");
    private final static QName _Permissions_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "Permissions");
    private final static QName _SecurityToken_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "SecurityToken");
    private final static QName _Authenticate_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "authenticate");
    private final static QName _Mechanism_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "Mechanism");
    private final static QName _Type_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "Type");
    private final static QName _Name_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "Name");
    private final static QName _EXCEPTIONTYPE_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "EXCEPTION_TYPE");
    private final static QName _ValidTill_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "ValidTill");
    private final static QName _Identifier_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "Identifier");
    private final static QName _Data_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "Data");
    private final static QName _SecurityException_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "SecurityException");
    private final static QName _Parent_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "Parent");
    private final static QName _Roles_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "Roles");
    private final static QName _Mechanisms_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "Mechanisms");
    private final static QName _Principals_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "Principals");
    private final static QName _Logout_QNAME = new QName("http://www.smpte-ra.org/schemas/st2071/2014/security", "logout");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.smpte_ra.schemas.st2071._2014.security
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SecurityException }
     * 
     */
    public SecurityException createSecurityException() {
        return new SecurityException();
    }

    /**
     * Create an instance of {@link Principal }
     * 
     */
    public Principal createPrincipal() {
        return new Principal();
    }

    /**
     * Create an instance of {@link Principals }
     * 
     */
    public Principals createPrincipals() {
        return new Principals();
    }

    /**
     * Create an instance of {@link Mechanisms }
     * 
     */
    public Mechanisms createMechanisms() {
        return new Mechanisms();
    }

    /**
     * Create an instance of {@link Authenticate }
     * 
     */
    public Authenticate createAuthenticate() {
        return new Authenticate();
    }

    /**
     * Create an instance of {@link SecurityTokens }
     * 
     */
    public SecurityTokens createSecurityTokens() {
        return new SecurityTokens();
    }

    /**
     * Create an instance of {@link GetMechanisms }
     * 
     */
    public GetMechanisms createGetMechanisms() {
        return new GetMechanisms();
    }

    /**
     * Create an instance of {@link LogoutResponse }
     * 
     */
    public LogoutResponse createLogoutResponse() {
        return new LogoutResponse();
    }

    /**
     * Create an instance of {@link Role }
     * 
     */
    public Role createRole() {
        return new Role();
    }

    /**
     * Create an instance of {@link Subject }
     * 
     */
    public Subject createSubject() {
        return new Subject();
    }

    /**
     * Create an instance of {@link SecurityToken }
     * 
     */
    public SecurityToken createSecurityToken() {
        return new SecurityToken();
    }

    /**
     * Create an instance of {@link Permissions }
     * 
     */
    public Permissions createPermissions() {
        return new Permissions();
    }

    /**
     * Create an instance of {@link AuthorizeResponse }
     * 
     */
    public AuthorizeResponse createAuthorizeResponse() {
        return new AuthorizeResponse();
    }

    /**
     * Create an instance of {@link Authorize }
     * 
     */
    public Authorize createAuthorize() {
        return new Authorize();
    }

    /**
     * Create an instance of {@link Logout }
     * 
     */
    public Logout createLogout() {
        return new Logout();
    }

    /**
     * Create an instance of {@link AuthenticateResponse }
     * 
     */
    public AuthenticateResponse createAuthenticateResponse() {
        return new AuthenticateResponse();
    }

    /**
     * Create an instance of {@link GetMechanismsResponse }
     * 
     */
    public GetMechanismsResponse createGetMechanismsResponse() {
        return new GetMechanismsResponse();
    }

    /**
     * Create an instance of {@link Permission }
     * 
     */
    public Permission createPermission() {
        return new Permission();
    }

    /**
     * Create an instance of {@link Roles }
     * 
     */
    public Roles createRoles() {
        return new Roles();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", name = "Allow")
    public JAXBElement<Boolean> createAllow(Boolean value) {
        return new JAXBElement<Boolean>(_Allow_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SecurityTokens }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", name = "SecurityTokens")
    public JAXBElement<SecurityTokens> createSecurityTokens(SecurityTokens value) {
        return new JAXBElement<SecurityTokens>(_SecurityTokens_QNAME, SecurityTokens.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMechanismsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", name = "getMechanismsResponse")
    public JAXBElement<GetMechanismsResponse> createGetMechanismsResponse(GetMechanismsResponse value) {
        return new JAXBElement<GetMechanismsResponse>(_GetMechanismsResponse_QNAME, GetMechanismsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SecurityTokens }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", name = "Tokens")
    public JAXBElement<SecurityTokens> createTokens(SecurityTokens value) {
        return new JAXBElement<SecurityTokens>(_Tokens_QNAME, SecurityTokens.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthenticateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", name = "authenticateResponse")
    public JAXBElement<AuthenticateResponse> createAuthenticateResponse(AuthenticateResponse value) {
        return new JAXBElement<AuthenticateResponse>(_AuthenticateResponse_QNAME, AuthenticateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EXCEPTIONSTATUS }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", name = "Status")
    public JAXBElement<EXCEPTIONSTATUS> createStatus(EXCEPTIONSTATUS value) {
        return new JAXBElement<EXCEPTIONSTATUS>(_Status_QNAME, EXCEPTIONSTATUS.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Authorize }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", name = "authorize")
    public JAXBElement<Authorize> createAuthorize(Authorize value) {
        return new JAXBElement<Authorize>(_Authorize_QNAME, Authorize.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", name = "Resource")
    public JAXBElement<String> createResource(String value) {
        return new JAXBElement<String>(_Resource_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMechanisms }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", name = "getMechanisms")
    public JAXBElement<GetMechanisms> createGetMechanisms(GetMechanisms value) {
        return new JAXBElement<GetMechanisms>(_GetMechanisms_QNAME, GetMechanisms.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PERMISSIONTYPE }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", name = "PERMISSION_TYPE")
    public JAXBElement<PERMISSIONTYPE> createPERMISSIONTYPE(PERMISSIONTYPE value) {
        return new JAXBElement<PERMISSIONTYPE>(_PERMISSIONTYPE_QNAME, PERMISSIONTYPE.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", name = "Realm")
    public JAXBElement<String> createRealm(String value) {
        return new JAXBElement<String>(_Realm_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EXCEPTIONSTATUS }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", name = "EXCEPTION_STATUS")
    public JAXBElement<EXCEPTIONSTATUS> createEXCEPTIONSTATUS(EXCEPTIONSTATUS value) {
        return new JAXBElement<EXCEPTIONSTATUS>(_EXCEPTIONSTATUS_QNAME, EXCEPTIONSTATUS.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Principal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", name = "Role")
    public JAXBElement<Principal> createRole(Principal value) {
        return new JAXBElement<Principal>(_Role_QNAME, Principal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Subject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", name = "Subject")
    public JAXBElement<Subject> createSubject(Subject value) {
        return new JAXBElement<Subject>(_Subject_QNAME, Subject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogoutResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", name = "logoutResponse")
    public JAXBElement<LogoutResponse> createLogoutResponse(LogoutResponse value) {
        return new JAXBElement<LogoutResponse>(_LogoutResponse_QNAME, LogoutResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Principal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", name = "Principal")
    public JAXBElement<Principal> createPrincipal(Principal value) {
        return new JAXBElement<Principal>(_Principal_QNAME, Principal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthorizeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", name = "authorizeResponse")
    public JAXBElement<AuthorizeResponse> createAuthorizeResponse(AuthorizeResponse value) {
        return new JAXBElement<AuthorizeResponse>(_AuthorizeResponse_QNAME, AuthorizeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Permissions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", name = "Permissions")
    public JAXBElement<Permissions> createPermissions(Permissions value) {
        return new JAXBElement<Permissions>(_Permissions_QNAME, Permissions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SecurityToken }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", name = "SecurityToken")
    public JAXBElement<SecurityToken> createSecurityToken(SecurityToken value) {
        return new JAXBElement<SecurityToken>(_SecurityToken_QNAME, SecurityToken.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Authenticate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", name = "authenticate")
    public JAXBElement<Authenticate> createAuthenticate(Authenticate value) {
        return new JAXBElement<Authenticate>(_Authenticate_QNAME, Authenticate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", name = "Mechanism")
    public JAXBElement<String> createMechanism(String value) {
        return new JAXBElement<String>(_Mechanism_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EXCEPTIONTYPE }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", name = "Type")
    public JAXBElement<EXCEPTIONTYPE> createType(EXCEPTIONTYPE value) {
        return new JAXBElement<EXCEPTIONTYPE>(_Type_QNAME, EXCEPTIONTYPE.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", name = "Name")
    public JAXBElement<String> createName(String value) {
        return new JAXBElement<String>(_Name_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EXCEPTIONTYPE }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", name = "EXCEPTION_TYPE")
    public JAXBElement<EXCEPTIONTYPE> createEXCEPTIONTYPE(EXCEPTIONTYPE value) {
        return new JAXBElement<EXCEPTIONTYPE>(_EXCEPTIONTYPE_QNAME, EXCEPTIONTYPE.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", name = "ValidTill")
    public JAXBElement<DateTime> createValidTill(DateTime value) {
        return new JAXBElement<DateTime>(_ValidTill_QNAME, DateTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", name = "Identifier")
    public JAXBElement<String> createIdentifier(String value) {
        return new JAXBElement<String>(_Identifier_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", name = "Data")
    public JAXBElement<byte[]> createData(byte[] value) {
        return new JAXBElement<byte[]>(_Data_QNAME, byte[].class, null, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SecurityException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", name = "SecurityException", substitutionHeadNamespace = "http://www.smpte-ra.org/schemas/st2071/2014/types", substitutionHeadName = "Exception")
    public JAXBElement<SecurityException> createSecurityException(SecurityException value) {
        return new JAXBElement<SecurityException>(_SecurityException_QNAME, SecurityException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Role }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", name = "Parent")
    public JAXBElement<Role> createParent(Role value) {
        return new JAXBElement<Role>(_Parent_QNAME, Role.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Principals }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", name = "Roles")
    public JAXBElement<Principals> createRoles(Principals value) {
        return new JAXBElement<Principals>(_Roles_QNAME, Principals.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Mechanisms }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", name = "Mechanisms")
    public JAXBElement<Mechanisms> createMechanisms(Mechanisms value) {
        return new JAXBElement<Mechanisms>(_Mechanisms_QNAME, Mechanisms.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Principals }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", name = "Principals")
    public JAXBElement<Principals> createPrincipals(Principals value) {
        return new JAXBElement<Principals>(_Principals_QNAME, Principals.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Logout }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.smpte-ra.org/schemas/st2071/2014/security", name = "logout")
    public JAXBElement<Logout> createLogout(Logout value) {
        return new JAXBElement<Logout>(_Logout_QNAME, Logout.class, null, value);
    }

}
