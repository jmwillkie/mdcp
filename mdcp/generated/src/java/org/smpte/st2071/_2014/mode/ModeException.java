package org.smpte.st2071._2014.mode;


/**
* org/smpte/st2071/_2014/mode/ModeException.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

public final class ModeException extends org.omg.CORBA.UserException
{
  public org.smpte.st2071._2014.mode.Mode Mode = null;
  public String Message = null;

  public ModeException ()
  {
    super(ModeExceptionHelper.id());
  } // ctor

  public ModeException (org.smpte.st2071._2014.mode.Mode _Mode, String _Message)
  {
    super(ModeExceptionHelper.id());
    Mode = _Mode;
    Message = _Message;
  } // ctor


  public ModeException (String $reason, org.smpte.st2071._2014.mode.Mode _Mode, String _Message)
  {
    super(ModeExceptionHelper.id() + "  " + $reason);
    Mode = _Mode;
    Message = _Message;
  } // ctor

} // class ModeException
