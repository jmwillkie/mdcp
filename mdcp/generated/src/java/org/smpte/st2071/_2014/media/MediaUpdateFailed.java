package org.smpte.st2071._2014.media;


/**
* org/smpte/st2071/_2014/media/MediaUpdateFailed.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

public final class MediaUpdateFailed extends org.omg.CORBA.UserException
{
  public org.smpte.st2071._2014.media.Media Media = null;
  public String Message = null;

  public MediaUpdateFailed ()
  {
    super(MediaUpdateFailedHelper.id());
  } // ctor

  public MediaUpdateFailed (org.smpte.st2071._2014.media.Media _Media, String _Message)
  {
    super(MediaUpdateFailedHelper.id());
    Media = _Media;
    Message = _Message;
  } // ctor


  public MediaUpdateFailed (String $reason, org.smpte.st2071._2014.media.Media _Media, String _Message)
  {
    super(MediaUpdateFailedHelper.id() + "  " + $reason);
    Media = _Media;
    Message = _Message;
  } // ctor

} // class MediaUpdateFailed