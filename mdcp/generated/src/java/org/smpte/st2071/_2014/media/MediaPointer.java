package org.smpte.st2071._2014.media;


/**
* org/smpte/st2071/_2014/media/MediaPointer.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

public abstract class MediaPointer implements org.omg.CORBA.portable.StreamableValue
{
  private static String[] _truncatable_ids = {
    org.smpte.st2071._2014.media.MediaPointerHelper.id ()
  };

  public String[] _truncatable_ids() {
    return _truncatable_ids;
  }

  public abstract org.smpte.st2071._2014.identity.UMN Source ();

  public abstract long InpointOffset ();

  public abstract long OutpointOffset ();

  public abstract org.smpte.st2071._2014.types.OFFSET_TYPE OffsetType ();

  public abstract short Track ();

  public void _read (org.omg.CORBA.portable.InputStream istream)
  {
  }

  public void _write (org.omg.CORBA.portable.OutputStream ostream)
  {
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return org.smpte.st2071._2014.media.MediaPointerHelper.type ();
  }
} // class MediaPointer
