package org.smpte.st2071._2014.types;


/**
* org/smpte/st2071/_2014/types/MapEntry.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

public abstract class MapEntry implements org.omg.CORBA.portable.StreamableValue
{
  private static String[] _truncatable_ids = {
    org.smpte.st2071._2014.types.MapEntryHelper.id ()
  };

  public String[] _truncatable_ids() {
    return _truncatable_ids;
  }

  public abstract String key ();

  public abstract org.smpte.st2071._2014.types.DATA_TYPE type ();

  public abstract org.omg.CORBA.Any value ();

  public void _read (org.omg.CORBA.portable.InputStream istream)
  {
  }

  public void _write (org.omg.CORBA.portable.OutputStream ostream)
  {
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return org.smpte.st2071._2014.types.MapEntryHelper.type ();
  }
} // class MapEntry
