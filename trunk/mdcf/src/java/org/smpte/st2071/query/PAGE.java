package org.smpte.st2071.query;

import java.io.Serializable;

public class PAGE implements Serializable
{
    private static final long serialVersionUID = 201404231541L;
    
    protected long pageSize;
    
    protected long offset;
    
    
    public PAGE(long pageSize)
    {
        this.pageSize = pageSize;
    }
    
    
    public PAGE(long pageSize, long offset)
    {
        this.pageSize = pageSize;
        this.offset = offset;
    }


    public long getPageSize()
    {
        return pageSize;
    }


    public long getOffset()
    {
        return offset;
    }
}
