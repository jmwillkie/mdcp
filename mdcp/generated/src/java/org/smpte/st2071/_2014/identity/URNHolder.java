package org.smpte.st2071._2014.identity;

/**
* org/smpte/st2071/_2014/identity/URNHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

public final class URNHolder implements org.omg.CORBA.portable.Streamable
{
  public org.smpte.st2071._2014.identity.URN value = null;

  public URNHolder ()
  {
  }

  public URNHolder (org.smpte.st2071._2014.identity.URN initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = org.smpte.st2071._2014.identity.URNHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    org.smpte.st2071._2014.identity.URNHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return org.smpte.st2071._2014.identity.URNHelper.type ();
  }

}