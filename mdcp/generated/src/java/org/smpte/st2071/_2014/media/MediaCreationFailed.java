package org.smpte.st2071._2014.media;


/**
* org/smpte/st2071/_2014/media/MediaCreationFailed.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

public final class MediaCreationFailed extends org.omg.CORBA.UserException
{
  public org.smpte.st2071._2014.media.Media Media = null;
  public String Message = null;

  public MediaCreationFailed ()
  {
    super(MediaCreationFailedHelper.id());
  } // ctor

  public MediaCreationFailed (org.smpte.st2071._2014.media.Media _Media, String _Message)
  {
    super(MediaCreationFailedHelper.id());
    Media = _Media;
    Message = _Message;
  } // ctor


  public MediaCreationFailed (String $reason, org.smpte.st2071._2014.media.Media _Media, String _Message)
  {
    super(MediaCreationFailedHelper.id() + "  " + $reason);
    Media = _Media;
    Message = _Message;
  } // ctor

} // class MediaCreationFailed