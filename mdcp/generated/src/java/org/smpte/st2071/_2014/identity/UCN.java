package org.smpte.st2071._2014.identity;

import UnsignedLongsHolder;

/**
* org/smpte/st2071/_2014/identity/UCN.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

public abstract class UCN implements org.omg.CORBA.portable.StreamableValue, org.smpte.st2071._2014.identity.RNOperations
{
  private static String[] _truncatable_ids = {
    org.smpte.st2071._2014.identity.UCNHelper.id ()
  };

  public String[] _truncatable_ids() {
    return _truncatable_ids;
  }

  public abstract String InterfaceNamespace ();

  public abstract String InterfaceName ();

  public abstract int Version ();

  public abstract int[] Revision ();

  public void _read (org.omg.CORBA.portable.InputStream istream)
  {
  }

  public void _write (org.omg.CORBA.portable.OutputStream ostream)
  {
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return org.smpte.st2071._2014.identity.UCNHelper.type ();
  }
} // class UCN
