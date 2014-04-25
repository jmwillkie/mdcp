package org.smpte.st2071._2014.media;


/**
* org/smpte/st2071/_2014/media/MediaEvent.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/


/*
     * Media Events are sent by the Media Directory.
     *
     * Valid Device Type Values
     *     'Created'  : Indicates that a Media has been created.
     *     'Updated'  : Indicates that a Media has been updated.
     *     'Deleted'  : Indicates that a Media has been deleted.
     */
public abstract class MediaEvent implements org.omg.CORBA.portable.StreamableValue, org.smpte.st2071._2014.event.StatusEventOperations
{
  private static String[] _truncatable_ids = {
    org.smpte.st2071._2014.media.MediaEventHelper.id ()
  };

  public String[] _truncatable_ids() {
    return _truncatable_ids;
  }

  public abstract org.smpte.st2071._2014.media.Media Media ();

  public void _read (org.omg.CORBA.portable.InputStream istream)
  {
  }

  public void _write (org.omg.CORBA.portable.OutputStream ostream)
  {
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return org.smpte.st2071._2014.media.MediaEventHelper.type ();
  }
} // class MediaEvent
