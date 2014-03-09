package org.smpte.st2071.mdcd;

public class DiscoveryException extends Exception
{
    private static final long serialVersionUID = 201403061425L;
    
    
    public DiscoveryException()
    {
        super();
    }
    
    
    public DiscoveryException(String message)
    {
        super(message);
    }
    
    
    public DiscoveryException(Throwable cause)
    {
        super(cause);
    }
    
    
    public DiscoveryException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    
    public DiscoveryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
