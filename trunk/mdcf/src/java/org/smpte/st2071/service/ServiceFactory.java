package org.smpte.st2071.service;

import java.util.Map;

import org.smpte.st2071.identity.USN;
import org.smpte.st2071.query.QueryExpression;

public interface ServiceFactory
{
    public ServiceTemplate[] listTemplates(QueryExpression filter)
    throws ServiceException, SecurityException;
    
    
    public USN create(USN usn, Map<String, Object> parameters)
    throws ServiceException, SecurityException;
    
    
    public USN destroy(USN usn)
    throws ServiceException, SecurityException;
}
