package org.smpte.st2071.identity;

import java.io.Serializable;
import java.text.ParseException;

/**
 * TODO: implement
 *
 * @author Steve Posick
 */
public class URI implements Serializable
{
    private static final long serialVersionUID = 201404251050L;
    
    protected CharSequence uri;
    
    
    protected URI()
    {
        super();
    }
    
    
    public URI(CharSequence url)
    throws ParseException
    {
        this.uri = url;
    }


    @Override
    public int hashCode()
    {
        return uri.hashCode();
    }


    @Override
    public boolean equals(Object obj)
    {
        return uri.equals(obj);
    }


    @Override
    public String toString()
    {
        return uri.toString();
    }
}
