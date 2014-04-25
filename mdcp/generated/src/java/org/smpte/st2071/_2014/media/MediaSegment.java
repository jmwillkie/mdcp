package org.smpte.st2071._2014.media;


/**
* org/smpte/st2071/_2014/media/MediaSegment.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

public abstract class MediaSegment implements org.omg.CORBA.portable.StreamableValue, org.smpte.st2071._2014.media.MediaPointerOperations, org.smpte.st2071._2014.media.MediaOperations
{
  private static String[] _truncatable_ids = {
    org.smpte.st2071._2014.media.MediaSegmentHelper.id ()
  };

  public String[] _truncatable_ids() {
    return _truncatable_ids;
  }

  public abstract org.smpte.st2071._2014.types.DateTime Inpoint ();

  public abstract org.smpte.st2071._2014.types.DateTime Outpoint ();

  public abstract org.smpte.st2071._2014.identity.URI Format ();

  public abstract String TrackName ();

  public abstract org.smpte.st2071._2014.media.TRACK_TYPE TrackType ();

  public void _read (org.omg.CORBA.portable.InputStream istream)
  {
  }

  public void _write (org.omg.CORBA.portable.OutputStream ostream)
  {
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return org.smpte.st2071._2014.media.MediaSegmentHelper.type ();
  }
} // class MediaSegment
