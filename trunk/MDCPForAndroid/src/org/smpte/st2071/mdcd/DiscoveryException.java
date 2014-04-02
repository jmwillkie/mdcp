package org.smpte.st2071.mdcd;

import android.os.RemoteException;

public class DiscoveryException extends RemoteException
{
    private static final long serialVersionUID = 201403061425L;
    
    private String message;
    
    public DiscoveryException()
    {
        super();
    }


    public DiscoveryException(String message)
    {
        this.message = message;
    }


    @Override
    public String getMessage()
    {
        return message;
    }


    @Override
    public String getLocalizedMessage()
    {
        return message;
    }


    @Override
    public String toString()
    {
        String msg = getMessage();
        String name = getClass().getName();
        if (msg == null) {
            return name;
        }
        return name + ": " + msg;
    }
}
