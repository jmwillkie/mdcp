package org.smpte.st2071._2014.query;


/**
* org/smpte/st2071/_2014/query/CONTAINSDefaultFactory.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

public class CONTAINSDefaultFactory implements CONTAINSValueFactory {

  public CONTAINS init (org.smpte.st2071._2014.media.MediaPointer segment)
  {
    return new CONTAINSImpl (segment);
  }

  public java.io.Serializable read_value (org.omg.CORBA_2_3.portable.InputStream is)
  {
    return is.read_value(new CONTAINSImpl ());
  }
}