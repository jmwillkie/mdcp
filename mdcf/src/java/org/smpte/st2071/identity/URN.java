package org.smpte.st2071.identity;

import java.text.ParseException;

/**
 * TODO: implement
 *
 * @author Steve Posick
 */
public class URN extends URI
{
    private static final long serialVersionUID = 201404251050L;
    
    protected static final String URN_SCHEME = "urn";
    
    protected URN()
    {
        super();
    }
    
    
    public URN(CharSequence urn)
    throws ParseException
    {
        super(urn);
        CharSequence start = urn.subSequence(0, 3);
        if (!start.toString().equalsIgnoreCase(URN_SCHEME))
        {
            throw new ParseException(urn.toString(), 0);
        }
    }
}
