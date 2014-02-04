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
[System.Web.Services.WebServiceBinding(Name="StatusSupportPort", Namespace="http://www.smpte-ra.org/schemas/st2071/2014/event")]
[System.Diagnostics.DebuggerStepThroughAttribute()]
[System.ComponentModel.DesignerCategoryAttribute("code")]
[System.Xml.Serialization.XmlIncludeAttribute(typeof(Event))]
public class StatusSupportHTTPBinding : System.Web.Services.Protocols.SoapHttpClientProtocol {
    
    public StatusSupportHTTPBinding() {
        this.Url = "http://localhost:8088/StatusSupport";
    }
    
    [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://www.smpte-ra.org/schemas/st2071/2014/event/StatusSupport/Status", ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Bare, Use=System.Web.Services.Description.SoapBindingUse.Literal)]
    [return: System.Xml.Serialization.XmlElementAttribute("getStatusResponse", Namespace="http://www.smpte-ra.org/schemas/st2071/2014/event")]
    public getStatusResponse getStatus([System.Xml.Serialization.XmlElementAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/event")] getStatus getStatus) {
        object[] results = this.Invoke("getStatus", new object[] {
                    getStatus});
        return ((getStatusResponse)(results[0]));
    }
    
    public System.IAsyncResult BegingetStatus(getStatus getStatus, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("getStatus", new object[] {
                    getStatus}, callback, asyncState);
    }
    
    public getStatusResponse EndgetStatus(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((getStatusResponse)(results[0]));
    }
}

/// <remarks/>
[System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/event")]
[System.Xml.Serialization.XmlRootAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/event")]
public class getStatus {
}

/// <remarks/>
[System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/event")]
[System.Xml.Serialization.XmlRootAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/event")]
public class getStatusResponse {
    
    /// <remarks/>
    public StatusEvent StatusEvent;
}

/// <remarks/>
[System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/event")]
[System.Xml.Serialization.XmlRootAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/event")]
public class StatusEvent : Event {
    
    /// <remarks/>
    public bool Ready;
    
    /// <remarks/>
    [System.Xml.Serialization.XmlElementAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/types")]
    public STATUS STATUS;
    
    /// <remarks/>
    public string Message;
}

/// <remarks/>
[System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/types")]
[System.Xml.Serialization.XmlRootAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/types")]
public enum STATUS {
    
    /// <remarks/>
    OK,
    
    /// <remarks/>
    WARNING,
    
    /// <remarks/>
    ERROR,
}

/// <remarks/>
[System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/event")]
[System.Xml.Serialization.XmlRootAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/event")]
[System.Xml.Serialization.XmlIncludeAttribute(typeof(StatusEvent))]
public class Event {
    
    /// <remarks/>
    public string Type;
    
    /// <remarks/>
    [System.Xml.Serialization.XmlElementAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/identity", DataType="anyURI")]
    public string RN;
    
    /// <remarks/>
    public DateTime EventTime;
}

/// <remarks/>
[System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/types")]
[System.Xml.Serialization.XmlRootAttribute("EventTime", Namespace="http://www.smpte-ra.org/schemas/st2071/2014/event")]
[System.Xml.Serialization.XmlIncludeAttribute(typeof(FramedTime))]
public class DateTime {
    
    /// <remarks/>
    [System.Xml.Serialization.XmlElementAttribute(DataType="date")]
    public System.DateTime Date;
    
    /// <remarks/>
    [System.Xml.Serialization.XmlElementAttribute(DataType="integer")]
    public string Hour;
    
    /// <remarks/>
    [System.Xml.Serialization.XmlElementAttribute(DataType="integer")]
    public string Minute;
    
    /// <remarks/>
    [System.Xml.Serialization.XmlElementAttribute(DataType="integer")]
    public string Second;
    
    /// <remarks/>
    [System.Xml.Serialization.XmlElementAttribute(DataType="integer")]
    public string Microsecond;
    
    /// <remarks/>
    public System.UInt64 MicrosFromEpoch;
}

/// <remarks/>
[System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/types")]
public class FramedTime : DateTime {
    
    /// <remarks/>
    public System.UInt64 Frame;
    
    /// <remarks/>
    public System.UInt64 FrameRate;
    
    /// <remarks/>
    public System.UInt64 Scale;
    
    /// <remarks/>
    public System.UInt64 TotalFrames;
}

/// <remarks/>
[System.Web.Services.WebServiceBinding(Name="EventerPort", Namespace="http://www.smpte-ra.org/schemas/st2071/2014/event")]
[System.Diagnostics.DebuggerStepThroughAttribute()]
[System.ComponentModel.DesignerCategoryAttribute("code")]
[System.Xml.Serialization.XmlIncludeAttribute(typeof(Event))]
public class EventerHTTPBinding : System.Web.Services.Protocols.SoapHttpClientProtocol {
    
    public EventerHTTPBinding() {
        this.Url = "http://localhost:8088/Eventer";
    }
    
    [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://www.smpte-ra.org/schemas/st2071/2014/eventer/poll", ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Bare, Use=System.Web.Services.Description.SoapBindingUse.Literal)]
    [return: System.Xml.Serialization.XmlElementAttribute("pollResponse", Namespace="http://www.smpte-ra.org/schemas/st2071/2014/event")]
    public pollResponse poll([System.Xml.Serialization.XmlElementAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/event")] URIParameter poll) {
        object[] results = this.Invoke("poll", new object[] {
                    poll});
        return ((pollResponse)(results[0]));
    }
    
    public System.IAsyncResult Beginpoll(URIParameter poll, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("poll", new object[] {
                    poll}, callback, asyncState);
    }
    
    public pollResponse Endpoll(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((pollResponse)(results[0]));
    }
}

/// <remarks/>
[System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/event")]
[System.Xml.Serialization.XmlRootAttribute("unregistered", Namespace="http://www.smpte-ra.org/schemas/st2071/2014/event")]
public class URIParameter {
    
    /// <remarks/>
    [System.Xml.Serialization.XmlElementAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/identity", DataType="anyURI")]
    public string URI;
}

/// <remarks/>
[System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/event")]
[System.Xml.Serialization.XmlRootAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/event")]
public class pollResponse {
    
    /// <remarks/>
    public Event Event;
}

/// <remarks/>
[System.Web.Services.WebServiceBinding(Name="EventBroadcasterPort", Namespace="http://www.smpte-ra.org/schemas/st2071/2014/event")]
[System.Diagnostics.DebuggerStepThroughAttribute()]
[System.ComponentModel.DesignerCategoryAttribute("code")]
[System.Xml.Serialization.XmlIncludeAttribute(typeof(Event))]
public class EventBroadcasterHTTPBinding : System.Web.Services.Protocols.SoapHttpClientProtocol {
    
    public EventBroadcasterHTTPBinding() {
        this.Url = "http://localhost:8088/EventBroadcaster";
    }
    
    [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://www.smpte-ra.org/schemas/st2071/2014/eventBroadcaster/registerCallback", ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Bare, Use=System.Web.Services.Description.SoapBindingUse.Literal)]
    [return: System.Xml.Serialization.XmlElementAttribute("registerCallbackResponse", Namespace="http://www.smpte-ra.org/schemas/st2071/2014/event")]
    public registerCallbackResponse registerCallback([System.Xml.Serialization.XmlElementAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/event")] URIParameter registerCallback) {
        object[] results = this.Invoke("registerCallback", new object[] {
                    registerCallback});
        return ((registerCallbackResponse)(results[0]));
    }
    
    public System.IAsyncResult BeginregisterCallback(URIParameter registerCallback, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("registerCallback", new object[] {
                    registerCallback}, callback, asyncState);
    }
    
    public registerCallbackResponse EndregisterCallback(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((registerCallbackResponse)(results[0]));
    }
    
    [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://www.smpte-ra.org/schemas/st2071/2014/eventBroadcaster/unregisterCallback", ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Bare, Use=System.Web.Services.Description.SoapBindingUse.Literal)]
    [return: System.Xml.Serialization.XmlElementAttribute("unregisterCallbackResponse", Namespace="http://www.smpte-ra.org/schemas/st2071/2014/event")]
    public unregisterCallbackResponse unregisterCallback([System.Xml.Serialization.XmlElementAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/event")] URIParameter unregisterCallback) {
        object[] results = this.Invoke("unregisterCallback", new object[] {
                    unregisterCallback});
        return ((unregisterCallbackResponse)(results[0]));
    }
    
    public System.IAsyncResult BeginunregisterCallback(URIParameter unregisterCallback, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("unregisterCallback", new object[] {
                    unregisterCallback}, callback, asyncState);
    }
    
    public unregisterCallbackResponse EndunregisterCallback(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((unregisterCallbackResponse)(results[0]));
    }
}

/// <remarks/>
[System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/event")]
[System.Xml.Serialization.XmlRootAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/event")]
public class registerCallbackResponse {
    
    /// <remarks/>
    [System.Xml.Serialization.XmlElementAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/types")]
    public bool Boolean;
}

/// <remarks/>
[System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/event")]
[System.Xml.Serialization.XmlRootAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/event")]
public class unregisterCallbackResponse {
    
    /// <remarks/>
    [System.Xml.Serialization.XmlElementAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/types")]
    public bool Boolean;
}

/// <remarks/>
[System.Web.Services.WebServiceBinding(Name="CallbackHandlerPort", Namespace="http://www.smpte-ra.org/schemas/st2071/2014/event")]
[System.Diagnostics.DebuggerStepThroughAttribute()]
[System.ComponentModel.DesignerCategoryAttribute("code")]
[System.Xml.Serialization.XmlIncludeAttribute(typeof(Event))]
public class CallbackHandlerHTTPBinding : System.Web.Services.Protocols.SoapHttpClientProtocol {
    
    public CallbackHandlerHTTPBinding() {
        this.Url = "http://localhost:8088/CallbackHandler";
    }
    
    [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://www.smpte-ra.org/schemas/st2071/2014/event/CallbackHandler/callback", ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Bare, OneWay=true, Use=System.Web.Services.Description.SoapBindingUse.Literal)]
    public void callback([System.Xml.Serialization.XmlElementAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/event")] callback callback) {
        this.Invoke("callback", new object[] {
                    callback});
    }
    
    public System.IAsyncResult Begincallback(callback callback, System.AsyncCallback callback1, object asyncState) {
        return this.BeginInvoke("callback", new object[] {
                    callback}, callback1, asyncState);
    }
    
    public void Endcallback(System.IAsyncResult asyncResult) {
        this.EndInvoke(asyncResult);
    }
    
    [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://www.smpte-ra.org/schemas/st2071/2014/event/CallbackHandler/registered", ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Bare, OneWay=true, Use=System.Web.Services.Description.SoapBindingUse.Literal)]
    public void registered([System.Xml.Serialization.XmlElementAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/event")] URIParameter registered) {
        this.Invoke("registered", new object[] {
                    registered});
    }
    
    public System.IAsyncResult Beginregistered(URIParameter registered, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("registered", new object[] {
                    registered}, callback, asyncState);
    }
    
    public void Endregistered(System.IAsyncResult asyncResult) {
        this.EndInvoke(asyncResult);
    }
    
    [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://www.smpte-ra.org/schemas/st2071/2014/event/CallbackHandler/unregistered", ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Bare, OneWay=true, Use=System.Web.Services.Description.SoapBindingUse.Literal)]
    public void unregistered([System.Xml.Serialization.XmlElementAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/event")] URIParameter unregistered) {
        this.Invoke("unregistered", new object[] {
                    unregistered});
    }
    
    public System.IAsyncResult Beginunregistered(URIParameter unregistered, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("unregistered", new object[] {
                    unregistered}, callback, asyncState);
    }
    
    public void Endunregistered(System.IAsyncResult asyncResult) {
        this.EndInvoke(asyncResult);
    }
}

/// <remarks/>
[System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/event")]
[System.Xml.Serialization.XmlRootAttribute(Namespace="http://www.smpte-ra.org/schemas/st2071/2014/event")]
public class callback {
    
    /// <remarks/>
    public Event Event;
}
