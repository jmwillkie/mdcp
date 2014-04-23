package org.smpte.st2071.query;

import java.io.Serializable;

public class SORTBY implements Serializable
{
    private static final long serialVersionUID = 201404231541L;
    
    private String field;
    
    private boolean descending = false;
    

    public SORTBY(String field)
    {
        this.field = field;
    }
    
    
    public SORTBY(String field, boolean descending)
    {
        this.field = field;
        this.descending = descending;
    }


    public String getField()
    {
        return field;
    }


    public boolean isDescending()
    {
        return descending;
    }
}
