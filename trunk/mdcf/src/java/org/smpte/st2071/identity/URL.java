package org.smpte.st2071.identity;

import java.text.ParseException;

/**
 * TODO: implement
 *
 * @author Steve Posick
 */
public class URL extends URI
{
    private static final long serialVersionUID = 201404251050L;
    
    
    public URL(CharSequence url)
    throws ParseException
    {
        super(url);
    }
}
