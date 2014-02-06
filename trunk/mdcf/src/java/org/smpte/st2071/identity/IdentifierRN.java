package org.smpte.st2071.identity;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.smpte.util.FastCharSequence;

public class IdentifierRN extends RN
{
    private static final long serialVersionUID = 201402051137L;
    
    protected static final String IDENTITYRN_FORMAT_PREFIX = URN_NAMESPACE + ":(udn | umn | usn)";
    
    public static final String FORMAT = IDENTITYRN_FORMAT_PREFIX + ":[<namespace>]:[*(<name>=<value>)]";
    
    protected CharSequence attributeText;
    
    protected List<CharSequence> keys = new ArrayList<>();
    
    protected Map<CharSequence, CharSequence> attributes = new HashMap<>();
    
    
    protected IdentifierRN()
    {
        super();
    }
    
    
    protected IdentifierRN(Type type)
    throws ParseException
    {
        super(type);
    }
    
    
    protected IdentifierRN(Type type, CharSequence... parts)
    throws ParseException
    {
        this(type, convertParts(parts));
    }
    
    
    protected IdentifierRN(Type type, FastCharSequence... parts)
    throws ParseException
    {
        super(type, parts);
        
        if (parts.length > INDEX_ATTRIBUTES)
        {
            FastCharSequence attrText = parts[INDEX_ATTRIBUTES];
            if (attrText != null && attrText.length() > 0)
            {
                this.attributeText = parts[INDEX_ATTRIBUTES];
                final FastCharSequence[] attributes = attrText.split(";,");
                for (FastCharSequence attribute : attributes)
                {
                    CharSequence key;
                    CharSequence value;
                    int equalsPos = attribute.indexOf('=');
                    if (equalsPos >= 0)
                    {
                        key = attribute.subSequence(0, equalsPos);
                        value = attribute.subSequence(equalsPos + 1, attribute.length());
                    } else
                    {
                        key = attribute;
                        value = null;
                    }
                    this.keys.add(key);
                    this.attributes.put(key, value);
                }
                
                this.isNamespace = attrText == null || attrText.length() == 0;
            } else
            {
                isNamespace = true;
            }
        } else
        {
            isNamespace = true;
        }
    }


    public String getAttributeText()
    {
        return attributeText.toString();
    }


    public CharSequence[] getAttributeKeys()
    {
        Set<CharSequence> keys = attributes.keySet();
        return keys.toArray(new CharSequence[keys.size()]);
    }


    public CharSequence getAttribute(String key)
    {
        return attributes.get(key);
    }
    
    
    public String toString()
    {
        if (this.string == null)
        {
            StringBuilder b = new StringBuilder(50);
            
            b.append(URN_NAMESPACE).append(COLON).append(type.toString().toLowerCase()).append(COLON).append(namespace).append(COLON);
            if (attributes.size() > 0)
            {
                if (keys.size() > 0)
                {
                    for (CharSequence key : this.keys)
                    {
                        b.append(key);
                        CharSequence value = attributes.get(key);
                        if (value != null)
                        {
                            b.append("=").append(value);
                        }
                        b.append(';');
                    }
                    b.setLength(b.length() - 1);;
                }
            }
            
            if (isNamespaceName())
            {
                b.append(" [").append(type.toString()).append(isRootNamespaceName() ? " Root" : "").append(" ").append("Namespace Name").append("]");
            }
            
            this.string = b.toString();
        }
        
        return this.string;
    }
}
