package org.smpte.st2071._2014.identity;


/**
* org/smpte/st2071/_2014/identity/RN.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

public abstract class RN implements org.omg.CORBA.portable.StreamableValue, org.smpte.st2071._2014.identity.URNOperations
{
  private static String[] _truncatable_ids = {
    org.smpte.st2071._2014.identity.RNHelper.id ()
  };

  public String[] _truncatable_ids() {
    return _truncatable_ids;
  }

  public abstract String Scope ();

  public void _read (org.omg.CORBA.portable.InputStream istream)
  {
  }

  public void _write (org.omg.CORBA.portable.OutputStream ostream)
  {
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return org.smpte.st2071._2014.identity.RNHelper.type ();
  }
} // class RN
