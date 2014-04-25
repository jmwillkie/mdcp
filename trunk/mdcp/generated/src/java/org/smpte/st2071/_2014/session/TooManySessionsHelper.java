package org.smpte.st2071._2014.session;


/**
* org/smpte/st2071/_2014/session/TooManySessionsHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

abstract public class TooManySessionsHelper
{
  private static String  _id = "IDL:org/smpte/st2071/2014/session/TooManySessions:1.0";

  public static void insert (org.omg.CORBA.Any a, org.smpte.st2071._2014.session.TooManySessions that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static org.smpte.st2071._2014.session.TooManySessions extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [2];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.smpte.st2071._2014.identity.RNHelper.type ();
          _members0[0] = new org.omg.CORBA.StructMember (
            "RN",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_wstring_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "Message",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_exception_tc (org.smpte.st2071._2014.session.TooManySessionsHelper.id (), "TooManySessions", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static org.smpte.st2071._2014.session.TooManySessions read (org.omg.CORBA.portable.InputStream istream)
  {
    org.smpte.st2071._2014.session.TooManySessions value = new org.smpte.st2071._2014.session.TooManySessions ();
    // read and discard the repository ID
    istream.read_string ();
    value.RN = org.smpte.st2071._2014.identity.RNHelper.read (istream);
    value.Message = istream.read_wstring ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, org.smpte.st2071._2014.session.TooManySessions value)
  {
    // write the repository ID
    ostream.write_string (id ());
    org.smpte.st2071._2014.identity.RNHelper.write (ostream, value.RN);
    ostream.write_wstring (value.Message);
  }

}
