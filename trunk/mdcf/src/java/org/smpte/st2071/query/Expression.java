package org.smpte.st2071.query;

import java.io.Serializable;

import org.smpte.st2071.types.Resource;

public abstract class Expression implements Serializable
{
    private static final long serialVersionUID = 201404231541L;
    

    public abstract boolean apply(Resource resource);
}
