package org.smpte.st2071.service;

import org.smpte.st2071.identity.USN;

public interface ServiceRegistry
{
    public void unbind(USN usn)
    throws ServiceNotFoundException, ServiceException, SecurityException;
    
    
    public void bind(ServiceInformation service)
    throws ServiceNotFoundException, ServiceException, SecurityException;
}
