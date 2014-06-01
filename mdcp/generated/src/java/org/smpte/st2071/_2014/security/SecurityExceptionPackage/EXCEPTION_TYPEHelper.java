package org.smpte.st2071._2014.security.SecurityExceptionPackage;


/**
* org/smpte/st2071/_2014/security/SecurityExceptionPackage/EXCEPTION_TYPEHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

abstract public class EXCEPTION_TYPEHelper
{
  private static String  _id = "IDL:org/smpte/st2071/2014/security/SecurityException/EXCEPTION_TYPE:1.0";

  public static void insert (org.omg.CORBA.Any a, org.smpte.st2071._2014.security.SecurityExceptionPackage.EXCEPTION_TYPE that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static org.smpte.st2071._2014.security.SecurityExceptionPackage.EXCEPTION_TYPE extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_enum_tc (org.smpte.st2071._2014.security.SecurityExceptionPackage.EXCEPTION_TYPEHelper.id (), "EXCEPTION_TYPE", new String[] { "AUTHENTICATION", "AUTHORIZATION", "SECURITY_LAYER"} );
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static org.smpte.st2071._2014.security.SecurityExceptionPackage.EXCEPTION_TYPE read (org.omg.CORBA.portable.InputStream istream)
  {
    return org.smpte.st2071._2014.security.SecurityExceptionPackage.EXCEPTION_TYPE.from_int (istream.read_long ());
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, org.smpte.st2071._2014.security.SecurityExceptionPackage.EXCEPTION_TYPE value)
  {
    ostream.write_long (value.value ());
  }

}