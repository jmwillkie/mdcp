package org.smpte.st2071.query;

import org.smpte.st2071.types.Resource;

public class AND extends Expression
{
    private static final long serialVersionUID = 201404231541L;

    private Expression[] exprs;


    public AND(Expression... exprs)
    {
        this.exprs = exprs;
    }
    
    
    @Override
    public boolean apply(Resource resource)
    {
        for (Expression expr : exprs)
        {
            if (!expr.apply(resource))
            {
                return false;
            }
        }
        
        return true;
    }
}
