package org.smpte.st2071._2014.media;


/**
* org/smpte/st2071/_2014/media/MediaListHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

public final class MediaListHolder implements org.omg.CORBA.portable.Streamable
{
  public org.smpte.st2071._2014.media.Media value[] = null;

  public MediaListHolder ()
  {
  }

  public MediaListHolder (org.smpte.st2071._2014.media.Media[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = org.smpte.st2071._2014.media.MediaListHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    org.smpte.st2071._2014.media.MediaListHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return org.smpte.st2071._2014.media.MediaListHelper.type ();
  }

}
