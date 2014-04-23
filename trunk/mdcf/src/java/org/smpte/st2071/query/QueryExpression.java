package org.smpte.st2071.query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.smpte.st2071.types.Resource;

public class QueryExpression implements Serializable
{
    private static final long serialVersionUID = 201404021104L;
    
    
    protected Expression expr;
    
    protected PAGE page;
    
    protected SORTBY[] sortBy;
    
    
    protected static class SortComparator<T extends Resource> implements Comparator<T>
    {
        private SORTBY[] sortBy;
        
        
        protected SortComparator(SORTBY[] sortBy)
        {
            this.sortBy = Arrays.copyOf(sortBy, sortBy.length);
        }
        
        @Override
        public int compare(Resource thisResource, Resource thatResource)
        {
            if (sortBy != null && sortBy.length > 0)
            {
                for (SORTBY sort : sortBy)
                {
                    // TODO Compare this and that resource to using QueryExpression.this.sortBy
                    
                }
                return -1;
            } else
            {
                return 0;
            }
        }
    };
    

    public QueryExpression(Expression expr, PAGE page, SORTBY... sortBy)
    {
        this.expr = expr;
        this.sortBy = sortBy;
        this.page = page;
    }
    
    
    /**
     * Tests if the Query Expression equates to TRUE or FALSE when applied to the Resource.
     * 
     * @return Returns TRUE is the Query Expression equates to TRUE when applied to the Resource
     */
    public <T extends Resource> Collection<T> apply(Collection<T> resources)
    {
        List<T> results = new LinkedList<T>();
        for (T resource : resources)
        {
            if (expr.apply(resource))
            {
                results.add(resource);
            }
        }
        return results;
    }
    
    
    /**
     * Sorts the list of Resources in accordance to the sort information provided to the Query Expression.
     * @param resources The list of Resources to sort
     * @return The sorted list of Resources
     */
    public <T extends Resource> List<T> sort(Collection<T> resources)
    {
        List<T> results = new ArrayList<T>(resources.size());
        results.addAll(resources);
        Collections.sort(results, new SortComparator<T>(sortBy));
        return results;
    }
}
