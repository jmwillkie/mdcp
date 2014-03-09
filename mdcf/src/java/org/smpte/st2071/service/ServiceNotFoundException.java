package org.smpte.st2071.service;

public class ServiceNotFoundException extends Exception
{
    private static final long serialVersionUID = 201403091539L;


    public ServiceNotFoundException()
    {
        super();
    }
    
    
    public ServiceNotFoundException(String message)
    {
        super(message);
    }
    
    
    public ServiceNotFoundException(Throwable cause)
    {
        super(cause);
    }
    
    
    public ServiceNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    
    public ServiceNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
