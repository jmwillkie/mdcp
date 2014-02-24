'------------------------------------------------------------------------------
' <autogenerated>
'     This code was generated by a tool.
'     Mono Runtime Version: 1.1.4322.2032
'
'     Changes to this file may cause incorrect behavior and will be lost if 
'     the code is regenerated.
' </autogenerated>
'------------------------------------------------------------------------------

Option Explicit On
Option Strict On


'
' This source code was auto-generated by Mono Web Services Description Language Utility
'

'''<remarks/>
<System.Web.Services.WebServiceBinding(Name:="AuthorizerPort", Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/security"),  _
 System.Diagnostics.DebuggerStepThroughAttribute(),  _
 System.ComponentModel.DesignerCategoryAttribute("code")>  _
Public Class AuthorizerHTTPBinding
    Inherits System.Web.Services.Protocols.SoapHttpClientProtocol
    
    Public Sub New()
        MyBase.New
        Me.Url = "http://localhost:8088/Authorizer"
    End Sub
    
    <System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://www.smpte-ra.org/schemas/st2071/2014/security/Authorizer/Mechanisms", ParameterStyle:=System.Web.Services.Protocols.SoapParameterStyle.Bare, Use:=System.Web.Services.Description.SoapBindingUse.Literal)>  _
    Public Function getMechanisms(<System.Xml.Serialization.XmlElementAttribute(Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/security")> ByVal getMechanisms As getMechanisms) As <System.Xml.Serialization.XmlElementAttribute("getMechanismsResponse", Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/security")> getMechanismsResponse
        Dim results As Object() = Me.Invoke("getMechanisms", New Object() {getMechanisms})
        Return CType(results(0), getMechanismsResponse)
    End Function
    
    Public Function BegingetMechanisms(ByVal getMechanisms As getMechanisms, ByVal callback As System.AsyncCallback, ByVal asyncState As Object) As System.IAsyncResult
        Return Me.BeginInvoke("getMechanisms", New Object() {getMechanisms}, callback, asyncState)
    End Function
    
    Public Function EndgetMechanisms(ByVal asyncResult As System.IAsyncResult) As getMechanismsResponse
        Dim results As Object() = Me.EndInvoke(asyncResult)
        Return CType(results(0), getMechanismsResponse)
    End Function
    
    <System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://www.smpte-ra.org/schemas/st2071/2014/security/Authorizer/authorize", ParameterStyle:=System.Web.Services.Protocols.SoapParameterStyle.Bare, Use:=System.Web.Services.Description.SoapBindingUse.Literal)>  _
    Public Function authorize(<System.Xml.Serialization.XmlElementAttribute(Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/security")> ByVal authorize As authorize) As <System.Xml.Serialization.XmlElementAttribute("authorizeResponse", Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/security")> authorizeResponse
        Dim results As Object() = Me.Invoke("authorize", New Object() {authorize})
        Return CType(results(0), authorizeResponse)
    End Function
    
    Public Function Beginauthorize(ByVal authorize As authorize, ByVal callback As System.AsyncCallback, ByVal asyncState As Object) As System.IAsyncResult
        Return Me.BeginInvoke("authorize", New Object() {authorize}, callback, asyncState)
    End Function
    
    Public Function Endauthorize(ByVal asyncResult As System.IAsyncResult) As authorizeResponse
        Dim results As Object() = Me.EndInvoke(asyncResult)
        Return CType(results(0), authorizeResponse)
    End Function
End Class

'''<remarks/>
<System.Xml.Serialization.XmlTypeAttribute(Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/security"),  _
 System.Xml.Serialization.XmlRootAttribute(Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/security")>  _
Public Class getMechanisms
End Class

'''<remarks/>
<System.Xml.Serialization.XmlTypeAttribute(Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/security"),  _
 System.Xml.Serialization.XmlRootAttribute(Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/security")>  _
Public Class getMechanismsResponse
    
    '''<remarks/>
    <System.Xml.Serialization.XmlArrayItem(ElementName:="Mechanism", IsNullable:=false)>  _
    Public Mechanisms As String()
End Class

'''<remarks/>
<System.Xml.Serialization.XmlTypeAttribute(Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/security"),  _
 System.Xml.Serialization.XmlRootAttribute(Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/security")>  _
Public Class authorize
    
    '''<remarks/>
    Public Subject As Subject
    
    '''<remarks/>
    <System.Xml.Serialization.XmlElementAttribute(Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/identity", DataType:="anyURI")>  _
    Public URI As String
End Class

'''<remarks/>
<System.Xml.Serialization.XmlTypeAttribute(Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/security"),  _
 System.Xml.Serialization.XmlRootAttribute(Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/security")>  _
Public Class Subject
    
    '''<remarks/>
    Public Name As String
    
    '''<remarks/>
    <System.Xml.Serialization.XmlArrayItem(IsNullable:=false)>  _
    Public Principals As Principal()
End Class

'''<remarks/>
<System.Xml.Serialization.XmlTypeAttribute(Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/security"),  _
 System.Xml.Serialization.XmlRootAttribute(Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/security")>  _
Public Class Principal
    
    '''<remarks/>
    Public Realm As String
    
    '''<remarks/>
    Public Identifier As String
    
    '''<remarks/>
    <System.Xml.Serialization.XmlArrayItem(IsNullable:=false)>  _
    Public Roles As Principal()
    
    '''<remarks/>
    <System.Xml.Serialization.XmlArrayItem(IsNullable:=false)>  _
    Public Tokens As SecurityToken()
End Class

'''<remarks/>
<System.Xml.Serialization.XmlTypeAttribute(Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/security"),  _
 System.Xml.Serialization.XmlRootAttribute(Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/security")>  _
Public Class SecurityToken
    
    '''<remarks/>
    Public Mechanism As String
    
    '''<remarks/>
    Public Data As Byte()
    
    '''<remarks/>
    Public ValidTill As DateTime
End Class

'''<remarks/>
<System.Xml.Serialization.XmlTypeAttribute(Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/types"),  _
 System.Xml.Serialization.XmlRootAttribute("ValidTill", Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/security"),  _
 System.Xml.Serialization.XmlIncludeAttribute(GetType(FramedTime))>  _
Public Class DateTime
    
    '''<remarks/>
    <System.Xml.Serialization.XmlElementAttribute(DataType:="date")>  _
    Public [Date] As Date
    
    '''<remarks/>
    <System.Xml.Serialization.XmlElementAttribute(DataType:="integer")>  _
    Public Hour As String
    
    '''<remarks/>
    <System.Xml.Serialization.XmlElementAttribute(DataType:="integer")>  _
    Public Minute As String
    
    '''<remarks/>
    <System.Xml.Serialization.XmlElementAttribute(DataType:="integer")>  _
    Public Second As String
    
    '''<remarks/>
    <System.Xml.Serialization.XmlElementAttribute(DataType:="integer")>  _
    Public Microsecond As String
    
    '''<remarks/>
    Public MicrosFromEpoch As System.UInt64
End Class

'''<remarks/>
<System.Xml.Serialization.XmlTypeAttribute(Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/types")>  _
Public Class FramedTime
    Inherits DateTime
    
    '''<remarks/>
    Public Frame As System.UInt64
    
    '''<remarks/>
    Public FrameRate As System.UInt64
    
    '''<remarks/>
    Public Scale As System.UInt64
    
    '''<remarks/>
    Public TotalFrames As System.UInt64
End Class

'''<remarks/>
<System.Xml.Serialization.XmlTypeAttribute(Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/security"),  _
 System.Xml.Serialization.XmlRootAttribute(Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/security")>  _
Public Class authorizeResponse
    
    '''<remarks/>
    Public Subject As Subject
End Class

'''<remarks/>
<System.Web.Services.WebServiceBinding(Name:="AuthenticatorPort", Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/security"),  _
 System.Diagnostics.DebuggerStepThroughAttribute(),  _
 System.ComponentModel.DesignerCategoryAttribute("code")>  _
Public Class AuthenticatorHTTPBinding
    Inherits System.Web.Services.Protocols.SoapHttpClientProtocol
    
    Public Sub New()
        MyBase.New
        Me.Url = "http://localhost:8088/Authenticator"
    End Sub
    
    <System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://www.smpte-ra.org/schemas/st2071/2014/security/Authenticator/Mechanisms", ParameterStyle:=System.Web.Services.Protocols.SoapParameterStyle.Bare, Use:=System.Web.Services.Description.SoapBindingUse.Literal)>  _
    Public Function getMechanisms(<System.Xml.Serialization.XmlElementAttribute(Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/security")> ByVal getMechanisms As getMechanisms) As <System.Xml.Serialization.XmlElementAttribute("getMechanismsResponse", Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/security")> getMechanismsResponse
        Dim results As Object() = Me.Invoke("getMechanisms", New Object() {getMechanisms})
        Return CType(results(0), getMechanismsResponse)
    End Function
    
    Public Function BegingetMechanisms(ByVal getMechanisms As getMechanisms, ByVal callback As System.AsyncCallback, ByVal asyncState As Object) As System.IAsyncResult
        Return Me.BeginInvoke("getMechanisms", New Object() {getMechanisms}, callback, asyncState)
    End Function
    
    Public Function EndgetMechanisms(ByVal asyncResult As System.IAsyncResult) As getMechanismsResponse
        Dim results As Object() = Me.EndInvoke(asyncResult)
        Return CType(results(0), getMechanismsResponse)
    End Function
    
    <System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://www.smpte-ra.org/schemas/st2071/2014/security/Authenticator/authenticate", ParameterStyle:=System.Web.Services.Protocols.SoapParameterStyle.Bare, Use:=System.Web.Services.Description.SoapBindingUse.Literal)>  _
    Public Function authenticate(<System.Xml.Serialization.XmlElementAttribute(Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/security")> ByVal authenticate As authenticate) As <System.Xml.Serialization.XmlElementAttribute("authenticateResponse", Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/security")> authenticateResponse
        Dim results As Object() = Me.Invoke("authenticate", New Object() {authenticate})
        Return CType(results(0), authenticateResponse)
    End Function
    
    Public Function Beginauthenticate(ByVal authenticate As authenticate, ByVal callback As System.AsyncCallback, ByVal asyncState As Object) As System.IAsyncResult
        Return Me.BeginInvoke("authenticate", New Object() {authenticate}, callback, asyncState)
    End Function
    
    Public Function Endauthenticate(ByVal asyncResult As System.IAsyncResult) As authenticateResponse
        Dim results As Object() = Me.EndInvoke(asyncResult)
        Return CType(results(0), authenticateResponse)
    End Function
    
    <System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://www.smpte-ra.org/schemas/st2071/2014/security/Authenticator/logout", ParameterStyle:=System.Web.Services.Protocols.SoapParameterStyle.Bare, Use:=System.Web.Services.Description.SoapBindingUse.Literal)>  _
    Public Function logout(<System.Xml.Serialization.XmlElementAttribute(Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/security")> ByVal logout As logout) As <System.Xml.Serialization.XmlElementAttribute("logoutResponse", Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/security")> logoutResponse
        Dim results As Object() = Me.Invoke("logout", New Object() {logout})
        Return CType(results(0), logoutResponse)
    End Function
    
    Public Function Beginlogout(ByVal logout As logout, ByVal callback As System.AsyncCallback, ByVal asyncState As Object) As System.IAsyncResult
        Return Me.BeginInvoke("logout", New Object() {logout}, callback, asyncState)
    End Function
    
    Public Function Endlogout(ByVal asyncResult As System.IAsyncResult) As logoutResponse
        Dim results As Object() = Me.EndInvoke(asyncResult)
        Return CType(results(0), logoutResponse)
    End Function
End Class

'''<remarks/>
<System.Xml.Serialization.XmlTypeAttribute(Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/security"),  _
 System.Xml.Serialization.XmlRootAttribute(Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/security")>  _
Public Class authenticate
    
    '''<remarks/>
    Public Subject As Subject
End Class

'''<remarks/>
<System.Xml.Serialization.XmlTypeAttribute(Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/security"),  _
 System.Xml.Serialization.XmlRootAttribute(Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/security")>  _
Public Class authenticateResponse
    
    '''<remarks/>
    Public Subject As Subject
End Class

'''<remarks/>
<System.Xml.Serialization.XmlTypeAttribute(Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/security"),  _
 System.Xml.Serialization.XmlRootAttribute(Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/security")>  _
Public Class logout
    
    '''<remarks/>
    Public Subject As Subject
End Class

'''<remarks/>
<System.Xml.Serialization.XmlTypeAttribute(Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/security"),  _
 System.Xml.Serialization.XmlRootAttribute(Namespace:="http://www.smpte-ra.org/schemas/st2071/2014/security")>  _
Public Class logoutResponse
    
    '''<remarks/>
    Public Subject As Subject
End Class