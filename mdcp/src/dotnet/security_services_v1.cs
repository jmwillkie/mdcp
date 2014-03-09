// ------------------------------------------------------------------------------
//  <autogenerated>
//      This code was generated by a tool.
//      Mono Runtime Version: 1.1.4322.2032
// 
//      Changes to this file may cause incorrect behavior and will be lost if 
//      the code is regenerated.
//  </autogenerated>
// ------------------------------------------------------------------------------

// 
// This source code was auto-generated by Mono Web Services Description Language Utility
//


/// <remarks/>
[System.Web.Services.WebServiceBinding(Name="AuthorizerPort", Namespace="http://www.smpte-ra.org/schemas/st2071/2014/security")]
[System.Diagnostics.DebuggerStepThroughAttribute()]
[System.ComponentModel.DesignerCategoryAttribute("code")]
public class AuthorizerHTTPBinding : System.Web.Services.Protocols.SoapHttpClientProtocol {
    
    public AuthorizerHTTPBinding() {
        this.Url = "http://localhost:8088/Authorizer";
    }
    
    [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://www.smpte-ra.org/schemas/st2071/2014/security/Authorizer/Mechanisms", ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Bare, Use=System.Web.Services.Description.SoapBindingUse.Literal)]
    [return: System.Xml.Serialization.XmlElementAttribute("getMechanismsResponse", Namespace="http://www.smpte-ra.org/schemas/st2071/2014/security")]
    public getMechanismsResponse getMechanisms([System.Xml.Serialization.XmlElementAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/security")] getMechanisms getMechanisms) {
        object[] results = this.Invoke("getMechanisms", new object[] {
                    getMechanisms});
        return ((getMechanismsResponse)(results[0]));
    }
    
    public System.IAsyncResult BegingetMechanisms(getMechanisms getMechanisms, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("getMechanisms", new object[] {
                    getMechanisms}, callback, asyncState);
    }
    
    public getMechanismsResponse EndgetMechanisms(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((getMechanismsResponse)(results[0]));
    }
    
    [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://www.smpte-ra.org/schemas/st2071/2014/security/Authorizer/authorize", ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Bare, Use=System.Web.Services.Description.SoapBindingUse.Literal)]
    [return: System.Xml.Serialization.XmlElementAttribute("authorizeResponse", Namespace="http://www.smpte-ra.org/schemas/st2071/2014/security")]
    public authorizeResponse authorize([System.Xml.Serialization.XmlElementAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/security")] authorize authorize) {
        object[] results = this.Invoke("authorize", new object[] {
                    authorize});
        return ((authorizeResponse)(results[0]));
    }
    
    public System.IAsyncResult Beginauthorize(authorize authorize, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("authorize", new object[] {
                    authorize}, callback, asyncState);
    }
    
    public authorizeResponse Endauthorize(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((authorizeResponse)(results[0]));
    }
}

/// <remarks/>
[System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/security")]
[System.Xml.Serialization.XmlRootAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/security")]
public class getMechanisms {
}

/// <remarks/>
[System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/security")]
[System.Xml.Serialization.XmlRootAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/security")]
public class getMechanismsResponse {
    
    /// <remarks/>
    [System.Xml.Serialization.XmlArrayItem(ElementName="Mechanism", IsNullable=false)]
    public string[] Mechanisms;
}

/// <remarks/>
[System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/security")]
[System.Xml.Serialization.XmlRootAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/security")]
public class authorize {
    
    /// <remarks/>
    public Subject Subject;
    
    /// <remarks/>
    [System.Xml.Serialization.XmlElementAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/identity", DataType="anyURI")]
    public string URI;
}

/// <remarks/>
[System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/security")]
[System.Xml.Serialization.XmlRootAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/security")]
public class Subject {
    
    /// <remarks/>
    public string Name;
    
    /// <remarks/>
    [System.Xml.Serialization.XmlArrayItem(IsNullable=false)]
    public Principal[] Principals;
}

/// <remarks/>
[System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/security")]
[System.Xml.Serialization.XmlRootAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/security")]
public class Principal {
    
    /// <remarks/>
    public string Realm;
    
    /// <remarks/>
    public string Identifier;
    
    /// <remarks/>
    [System.Xml.Serialization.XmlArrayItem(IsNullable=false)]
    public Principal[] Roles;
    
    /// <remarks/>
    [System.Xml.Serialization.XmlArrayItem(IsNullable=false)]
    public SecurityToken[] Tokens;
}

/// <remarks/>
[System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/security")]
[System.Xml.Serialization.XmlRootAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/security")]
public class SecurityToken {
    
    /// <remarks/>
    public string Mechanism;
    
    /// <remarks/>
    public System.Byte[] Data;
    
    /// <remarks/>
    public DateTime ValidTill;
}

/// <remarks/>
[System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/types")]
[System.Xml.Serialization.XmlRootAttribute("ValidTill", Namespace="http://www.smpte-ra.org/schemas/st2071/2014/security")]
public class DateTime {
    
    /// <remarks/>
    [System.Xml.Serialization.XmlTextAttribute()]
    public System.DateTime Value;
}

/// <remarks/>
[System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/security")]
[System.Xml.Serialization.XmlRootAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/security")]
public class authorizeResponse {
    
    /// <remarks/>
    public Subject Subject;
}

/// <remarks/>
[System.Web.Services.WebServiceBinding(Name="AuthenticatorPort", Namespace="http://www.smpte-ra.org/schemas/st2071/2014/security")]
[System.Diagnostics.DebuggerStepThroughAttribute()]
[System.ComponentModel.DesignerCategoryAttribute("code")]
public class AuthenticatorHTTPBinding : System.Web.Services.Protocols.SoapHttpClientProtocol {
    
    public AuthenticatorHTTPBinding() {
        this.Url = "http://localhost:8088/Authenticator";
    }
    
    [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://www.smpte-ra.org/schemas/st2071/2014/security/Authenticator/Mechanisms", ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Bare, Use=System.Web.Services.Description.SoapBindingUse.Literal)]
    [return: System.Xml.Serialization.XmlElementAttribute("getMechanismsResponse", Namespace="http://www.smpte-ra.org/schemas/st2071/2014/security")]
    public getMechanismsResponse getMechanisms([System.Xml.Serialization.XmlElementAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/security")] getMechanisms getMechanisms) {
        object[] results = this.Invoke("getMechanisms", new object[] {
                    getMechanisms});
        return ((getMechanismsResponse)(results[0]));
    }
    
    public System.IAsyncResult BegingetMechanisms(getMechanisms getMechanisms, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("getMechanisms", new object[] {
                    getMechanisms}, callback, asyncState);
    }
    
    public getMechanismsResponse EndgetMechanisms(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((getMechanismsResponse)(results[0]));
    }
    
    [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://www.smpte-ra.org/schemas/st2071/2014/security/Authenticator/authenticate", ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Bare, Use=System.Web.Services.Description.SoapBindingUse.Literal)]
    [return: System.Xml.Serialization.XmlElementAttribute("authenticateResponse", Namespace="http://www.smpte-ra.org/schemas/st2071/2014/security")]
    public authenticateResponse authenticate([System.Xml.Serialization.XmlElementAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/security")] authenticate authenticate) {
        object[] results = this.Invoke("authenticate", new object[] {
                    authenticate});
        return ((authenticateResponse)(results[0]));
    }
    
    public System.IAsyncResult Beginauthenticate(authenticate authenticate, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("authenticate", new object[] {
                    authenticate}, callback, asyncState);
    }
    
    public authenticateResponse Endauthenticate(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((authenticateResponse)(results[0]));
    }
    
    [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://www.smpte-ra.org/schemas/st2071/2014/security/Authenticator/logout", ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Bare, Use=System.Web.Services.Description.SoapBindingUse.Literal)]
    [return: System.Xml.Serialization.XmlElementAttribute("logoutResponse", Namespace="http://www.smpte-ra.org/schemas/st2071/2014/security")]
    public logoutResponse logout([System.Xml.Serialization.XmlElementAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/security")] logout logout) {
        object[] results = this.Invoke("logout", new object[] {
                    logout});
        return ((logoutResponse)(results[0]));
    }
    
    public System.IAsyncResult Beginlogout(logout logout, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("logout", new object[] {
                    logout}, callback, asyncState);
    }
    
    public logoutResponse Endlogout(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((logoutResponse)(results[0]));
    }
}

/// <remarks/>
[System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/security")]
[System.Xml.Serialization.XmlRootAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/security")]
public class authenticate {
    
    /// <remarks/>
    public Subject Subject;
}

/// <remarks/>
[System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/security")]
[System.Xml.Serialization.XmlRootAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/security")]
public class authenticateResponse {
    
    /// <remarks/>
    public Subject Subject;
}

/// <remarks/>
[System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/security")]
[System.Xml.Serialization.XmlRootAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/security")]
public class logout {
    
    /// <remarks/>
    public Subject Subject;
}

/// <remarks/>
[System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/security")]
[System.Xml.Serialization.XmlRootAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/security")]
public class logoutResponse {
    
    /// <remarks/>
    public Subject Subject;
}