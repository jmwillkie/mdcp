package org.smpte.st2071.service;

import org.smpte.st2071.identity.USN;
import org.smpte.st2071.types.Resource;

public interface Service extends Resource
{
    public USN getUSN();

    
    public ServiceTemplate getType();
}
