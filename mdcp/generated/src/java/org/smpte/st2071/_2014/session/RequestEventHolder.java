package org.smpte.st2071._2014.session;

/**
* org/smpte/st2071/_2014/session/RequestEventHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/


/*
     * Valid Event Type Values
     *     'RequestAcquire' : Indicates that a client or device is requesting the specified 
     *                        session.
     *     'RequestLock'    : Indicates that a client or device is requesting an exclusive lock
     *                        of the device.
     *     'Approved'       : Indicates that the request was approved.
     *     'Denied'         : Indicates that the request was denied.
     *     'SessionTaken'   : Indicates that the specified session was taken by the system or
     *                        an administrator.
     *     'LockTaken'      : Indicates that the lock for the specified session was taken by the 
     *                        system or an administrator.
     */
public final class RequestEventHolder implements org.omg.CORBA.portable.Streamable
{
  public org.smpte.st2071._2014.session.RequestEvent value = null;

  public RequestEventHolder ()
  {
  }

  public RequestEventHolder (org.smpte.st2071._2014.session.RequestEvent initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = org.smpte.st2071._2014.session.RequestEventHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    org.smpte.st2071._2014.session.RequestEventHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return org.smpte.st2071._2014.session.RequestEventHelper.type ();
  }

}