package org.smpte.st2071._2014.media;


/**
* org/smpte/st2071/_2014/media/MediaAssetDefaultFactory.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

public class MediaAssetDefaultFactory implements org.omg.CORBA.portable.ValueFactory {

  public java.io.Serializable read_value (org.omg.CORBA_2_3.portable.InputStream is)
  {
    return is.read_value(new MediaAssetImpl ());
  }
}
