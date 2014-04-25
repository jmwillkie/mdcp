package org.smpte.st2071._2014.session;


/**
* org/smpte/st2071/_2014/session/NotLocked.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

public final class NotLocked extends org.omg.CORBA.UserException
{
  public org.smpte.st2071._2014.identity.RN RN = null;
  public String Message = null;

  public NotLocked ()
  {
    super(NotLockedHelper.id());
  } // ctor

  public NotLocked (org.smpte.st2071._2014.identity.RN _RN, String _Message)
  {
    super(NotLockedHelper.id());
    RN = _RN;
    Message = _Message;
  } // ctor


  public NotLocked (String $reason, org.smpte.st2071._2014.identity.RN _RN, String _Message)
  {
    super(NotLockedHelper.id() + "  " + $reason);
    RN = _RN;
    Message = _Message;
  } // ctor

} // class NotLocked
