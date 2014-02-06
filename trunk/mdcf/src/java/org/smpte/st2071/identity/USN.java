package org.smpte.st2071.identity;

import java.text.ParseException;

import org.smpte.util.FastCharSequence;

public class USN extends IdentifierRN
{
    private static final long serialVersionUID = 201402051137L;
    
    public static final Type TYPE = Type.UCN;
    
    
    protected USN()
    throws ParseException
    {
        super(Type.USN);
    }
    
    
    public USN(CharSequence source)
    throws ParseException
    {
        this(convertToPartsOfType(Type.USN, source));
    }
    
    
    protected USN(FastCharSequence... parts)
    throws ParseException
    {
        super(Type.USN, parts);
    }
}
