package org.smpte.st2071.query;

import org.smpte.st2071.types.Resource;

public class NOT extends Expression
{
    private static final long serialVersionUID = 201404231541L;
    
    private Expression expr;
    
    
    public NOT(Expression expr)
    {
        this.expr = expr;
    }
    

    @Override
    public boolean apply(Resource resource)
    {
        return !expr.apply(resource);
    }
}
