package net.posick.mdcdeviceviewer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.posick.ws.soap.SOAPAction;
import net.posick.ws.soap.SOAPBody;
import net.posick.ws.soap.SOAPEnvelope;
import net.posick.ws.soap.SOAPHeader;
import net.posick.ws.xml.XmlElement;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.smpte.mdc4android.Device;
import org.smpte.mdc4android.MDCService;
import org.smpte.mdc4android.TwoKeyedMap;
import org.xbill.DNS.Name;
import org.xbill.mDNS.ServiceInstance;

import android.net.http.AndroidHttpClient;

public class WebServiceUtil
{
    public static final String USER_AGENT = "SMPTE ST2071 Android Client";


    public static List<String> toURLs(ServiceInstance service)
    {
        List<String> urls = new ArrayList<String>();
        
        int port = service.getPort();
        Name hostname = service.getHost();
        String path = (String) service.getTextAttributes().get("path");
        String protocol = (String) service.getTextAttributes().get("proto");
        String portString = (port > 0 && port != 80 ? ":" + port : "");
        
        if (MDCService.MDC_URL_PROTOCOL.equalsIgnoreCase(protocol))
        {
            protocol = "http";
        }
        
        urls.add(protocol + "://" + hostname + portString + path);
        
        return urls;
    }
    

    public static TwoKeyedMap<String, String, Object> callDeviceWebService(List<String> urls) 
    throws ClientProtocolException, IOException
    {
        TwoKeyedMap<String, String, Object> attrs = new TwoKeyedMap<String, String, Object>();
        AndroidHttpClient httpClient = AndroidHttpClient.newInstance(USER_AGENT);
        
        for (String url : urls)
        {
            attrs.put(url, "name", getName(httpClient, url));
        }
        
        return attrs.size() > 0 ? attrs : null;
    }
    
    
    public static String getName(HttpClient httpClient, String url)
    throws ClientProtocolException, IOException
    {
        HttpPost request = new HttpPost(url);
        request.addHeader(SOAPAction.HTTP_HEADER_NAME, Device.SOAP_ACTION_NAME);
        
        SOAPAction action = new SOAPAction(Device.SOAP_ACTION_NAME);
        SOAPHeader header = new SOAPHeader(action);
        XmlElement xml = new XmlElement(new net.posick.ws.xml.Name(new net.posick.ws.xml.Namespace("device", "http://www.smpte-ra.org/schemas/st2071/2014/device"), "getName"));
        SOAPBody body = new SOAPBody(xml);
        SOAPEnvelope envelope = new SOAPEnvelope(header, body);
        
        request.setEntity(new StringEntity(envelope.toString()));
        
        HttpResponse response = httpClient.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode >= 200 && statusCode < 300)
        {
            HttpEntity entity = response.getEntity();
            String raw = EntityUtils.toString(entity);
            envelope = SOAPEnvelope.toSOAPEnvelope(XmlElement.parse(raw));
            body = envelope.getBody();
            List<XmlElement> elements = body.getChildren();
            if (elements != null)
            {
                for (XmlElement element : elements)
                {
                    if (element.getName().getName().equals("getNameResponse"))
                    {
                        CharSequence value = element.getValue();
                        if (value != null)
                        {
                            return value != null ? value.toString() : null;
                        } else if (element.hasChildren())
                        {
                            XmlElement child = element.getFirstChild(); 
                            if (child.getName().getName().equals("String"))
                            {
                                value = child.getValue();
                                return value != null ? value.toString() : null;
                            }
                        }
                    }
                }
            }
        }
        
        return null;
    }
}
