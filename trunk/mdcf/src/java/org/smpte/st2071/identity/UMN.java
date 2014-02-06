package org.smpte.st2071.identity;

import java.text.ParseException;

import org.smpte.util.FastCharSequence;

public class UMN extends IdentifierRN
{
    private static final long serialVersionUID = 201402051137L;
    
    public static final Type TYPE = Type.UCN;
    
    
    protected UMN()
    throws ParseException
    {
        super(Type.UMN);
    }
    
    
    public UMN(CharSequence source)
    throws ParseException
    {
        this(convertToPartsOfType(Type.UMN, source));
    }
    
    
    protected UMN(FastCharSequence... parts)
    throws ParseException
    {
        super(Type.UMN, parts);
    }
}
