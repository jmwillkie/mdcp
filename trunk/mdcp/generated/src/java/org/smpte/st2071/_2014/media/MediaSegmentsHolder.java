package org.smpte.st2071._2014.media;


/**
* org/smpte/st2071/_2014/media/MediaSegmentsHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

public final class MediaSegmentsHolder implements org.omg.CORBA.portable.Streamable
{
  public org.smpte.st2071._2014.media.MediaSegment value[] = null;

  public MediaSegmentsHolder ()
  {
  }

  public MediaSegmentsHolder (org.smpte.st2071._2014.media.MediaSegment[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = org.smpte.st2071._2014.media.MediaSegmentsHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    org.smpte.st2071._2014.media.MediaSegmentsHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return org.smpte.st2071._2014.media.MediaSegmentsHelper.type ();
  }

}