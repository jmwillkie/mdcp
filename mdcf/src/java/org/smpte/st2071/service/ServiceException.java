package org.smpte.st2071.service;

public class ServiceException extends Exception
{
    private static final long serialVersionUID = 201403091532L;


    public ServiceException()
    {
        super();
    }
    
    
    public ServiceException(String message)
    {
        super(message);
    }
    
    
    public ServiceException(Throwable cause)
    {
        super(cause);
    }
    
    
    public ServiceException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    
    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
