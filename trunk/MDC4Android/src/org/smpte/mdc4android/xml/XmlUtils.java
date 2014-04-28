package org.smpte.mdc4android.xml;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

import net.posick.ws.xml.Name;
import net.posick.ws.xml.XmlElement;

import org.smpte.st2071.types.DATATYPE;
import org.smpte.st2071.types.Map;

import android.util.Base64;

public class XmlUtils
{
    public static XmlElement toAttributes(String namespace, Map attrs)
    {
        SimpleDateFormat format = null;
        XmlElement root = null;
        
        if (attrs != null)
        {
            root = new XmlElement(new net.posick.ws.xml.Name(namespace, "Attributes"));
            
            Set<String> keys = attrs.keySet();
            if (keys != null && keys.size() > 0)
            {
                XmlElement entries = new XmlElement(new net.posick.ws.xml.Name(namespace, "Entries"));
                root.addChild(entries);
                for (String key : keys)
                {
                    DATATYPE type = attrs.getType(key);
                    
                    XmlElement entry = new XmlElement(new net.posick.ws.xml.Name(namespace, "MapEntry"));
                    entry.setAttribute(new net.posick.ws.xml.Name("key"), key);
                    entry.setAttribute(new net.posick.ws.xml.Name("type"), type.value());
                    entries.addChild(entry);
                    
                    Serializable object = attrs.get(key);
                    if (object != null)
                    {
                        switch (type)
                        {
                            case BLOB:
                                entry.setValue(Base64.encodeToString((byte[]) object, Base64.DEFAULT));
                                break;
                            case MAP:
                                root.addChild(toAttributes(namespace, (Map) attrs.get(key)));
                                break;
                            case DATETIME:
                                if (format == null)
                                {
                                    format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);
                                }
                                entry.setValue(format.format((Date) object));
                                break;
                            default:
                                entry.setValue(object.toString());
                                break;
                        }
                    }
                }
            }
        }
        
        return root;
    }
    

    public static XmlElement toURLs(String namespace, String[] urls)
    {
        XmlElement root = null;
        
        if (urls != null)
        {
            root = new XmlElement(new Name(namespace, "URLs"));
            for (String url : urls)
            {
                root.addChild(new XmlElement(new Name(namespace, "URL")).setValue(url));
            }
        }
        
        return root;
    }
}
