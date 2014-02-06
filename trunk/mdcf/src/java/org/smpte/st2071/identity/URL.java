package org.smpte.st2071.identity;

import java.text.ParseException;

/**
 * TODO: implement
 *
 * @author Steve Posick
 */
public class URL
{
    protected CharSequence url;
    
    
    public URL(CharSequence url)
    throws ParseException
    {
        this.url = url;
    }


    @Override
    public int hashCode()
    {
        return url.hashCode();
    }


    @Override
    public boolean equals(Object obj)
    {
        return url.equals(obj);
    }


    @Override
    public String toString()
    {
        return url.toString();
    }
}
