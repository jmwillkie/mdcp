package org.smpte.st2071._2014.mode;


/**
* org/smpte/st2071/_2014/mode/InvalidMode.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

public final class InvalidMode extends org.omg.CORBA.UserException
{
  public org.smpte.st2071._2014.mode.Mode Mode = null;
  public String Message = null;

  public InvalidMode ()
  {
    super(InvalidModeHelper.id());
  } // ctor

  public InvalidMode (org.smpte.st2071._2014.mode.Mode _Mode, String _Message)
  {
    super(InvalidModeHelper.id());
    Mode = _Mode;
    Message = _Message;
  } // ctor


  public InvalidMode (String $reason, org.smpte.st2071._2014.mode.Mode _Mode, String _Message)
  {
    super(InvalidModeHelper.id() + "  " + $reason);
    Mode = _Mode;
    Message = _Message;
  } // ctor

} // class InvalidMode
