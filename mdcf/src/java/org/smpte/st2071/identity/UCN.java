package org.smpte.st2071.identity;

import java.text.ParseException;

import org.smpte.util.FastCharSequence;

public class UCN extends RN
{
    private static final long serialVersionUID = 201402051137L;

    protected static final String UCN_FORMAT_PREFIX = URN_NAMESPACE + ":ucn";
    
    public static final String FORMAT = UCN_FORMAT_PREFIX + ":[<namespace>]:[<interface name>_v<version>]";
    
    public static final Type TYPE = Type.UCN;

    private CharSequence interfaceName;

    private CharSequence interfaceVersion;
    
    
    protected UCN()
    throws ParseException
    {
        super(Type.UCN);
    }
    
    
    public UCN(CharSequence source)
    throws ParseException
    {
        this(convertToPartsOfType(Type.UCN, source));
    }
    
    
    protected UCN(FastCharSequence... parts)
    throws ParseException
    {
        super(Type.UCN, parts);
        
        if (parts.length > INDEX_INTERFACE)
        {
            FastCharSequence iface = parts[INDEX_INTERFACE];
            if (iface != null && iface.length() > 0)
            {
                int pos;
                if ((pos = iface.lastIndexOf('_')) >= 0 && iface.charAt(pos + 1) == 'v')
                {
                    this.interfaceName = iface.subSequence(0, pos); 
                    this.interfaceVersion = iface.subSequence(pos + 2, iface.length());
                    this.isNamespace = interfaceName == null || interfaceName.length() == 0;
                } else
                {
                    throw new ParseException("UCN must be in the format \"" + FORMAT + "\".", parts[INDEX_NAMESPACE].getEndPosInSource());
                }
            } else
            {
                isNamespace = true;
            }
        } else
        {
            isNamespace = true;
        }
    }


    public String getInterfaceName()
    {
        return interfaceName.toString();
    }


    public String getInterfaceVersion()
    {
        return interfaceVersion.toString();
    }

    
    @Override
    public String toString()
    {
        if (this.string == null)
        {
            StringBuilder b = new StringBuilder(100);
            
            b.append(URN_NAMESPACE).append(COLON).append(type.toString().toLowerCase()).append(COLON).append(namespace).append(COLON);
            if (interfaceName != null)
            {
                b.append(interfaceName);
                if (interfaceVersion != null)
                {
                    b.append("_v").append(interfaceVersion);
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
