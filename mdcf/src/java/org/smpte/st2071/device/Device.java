package org.smpte.st2071.device;

import org.smpte.st2071.identity.UDN;
import org.smpte.st2071.types.Resource;

public interface Device extends Resource
{
    public UDN getUDN();

    public boolean isOnline();

    public String getName();
}
