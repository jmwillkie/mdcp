package org.smpte.st2071._2014.identity;


/**
* org/smpte/st2071/_2014/identity/UMNsHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

abstract public class UMNsHelper
{
  private static String  _id = "IDL:org/smpte/st2071/2014/identity/UMNs:1.0";

  public static void insert (org.omg.CORBA.Any a, org.smpte.st2071._2014.identity.UMN[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static org.smpte.st2071._2014.identity.UMN[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.smpte.st2071._2014.identity.UMNHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (org.smpte.st2071._2014.identity.UMNsHelper.id (), "UMNs", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static org.smpte.st2071._2014.identity.UMN[] read (org.omg.CORBA.portable.InputStream istream)
  {
    org.smpte.st2071._2014.identity.UMN value[] = null;
    int _len0 = istream.read_long ();
    value = new org.smpte.st2071._2014.identity.UMN[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = org.smpte.st2071._2014.identity.UMNHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, org.smpte.st2071._2014.identity.UMN[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      org.smpte.st2071._2014.identity.UMNHelper.write (ostream, value[_i0]);
  }

}
