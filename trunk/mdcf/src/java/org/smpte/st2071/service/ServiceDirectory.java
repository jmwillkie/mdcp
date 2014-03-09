package org.smpte.st2071.service;

import org.smpte.st2071.identity.USN;
import org.smpte.st2071.query.QueryExpression;

public interface ServiceDirectory
{
    public USN[] getNamespaces()
    throws SecurityException;
    
    
    public ServiceInformation lookup(USN usn)
    throws ServiceException, SecurityException;
    
    
    public ServiceInformation[] search(QueryExpression query)
    throws ServiceException, SecurityException;
}
