package org.smpte.st2071.identity;

import java.text.ParseException;

import org.smpte.util.FastCharSequence;

/**
 * TODO: implement
 *
 * @author Steve Posick
 */
public class UDN extends IdentifierRN
{
    private static final long serialVersionUID = 201402051137L;
    
    public static final Type TYPE = Type.UCN;

    
    protected UDN()
    throws ParseException
    {
        super(Type.UDN);
    }
    
    
    public UDN(CharSequence source)
    throws ParseException
    {
        this(convertToPartsOfType(Type.UDN, source));
    }
    
    
    protected UDN(FastCharSequence... parts)
    throws ParseException
    {
        super(Type.UDN, parts);
    }
}
