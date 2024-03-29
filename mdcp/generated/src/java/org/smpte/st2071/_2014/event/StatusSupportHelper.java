package org.smpte.st2071._2014.event;


/**
* org/smpte/st2071/_2014/event/StatusSupportHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

abstract public class StatusSupportHelper
{
  private static String  _id = "IDL:org/smpte/st2071/2014/event/StatusSupport:1.0";

  public static void insert (org.omg.CORBA.Any a, org.smpte.st2071._2014.event.StatusSupport that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static org.smpte.st2071._2014.event.StatusSupport extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (org.smpte.st2071._2014.event.StatusSupportHelper.id (), "StatusSupport");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static org.smpte.st2071._2014.event.StatusSupport read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_StatusSupportStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, org.smpte.st2071._2014.event.StatusSupport value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static org.smpte.st2071._2014.event.StatusSupport narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof org.smpte.st2071._2014.event.StatusSupport)
      return (org.smpte.st2071._2014.event.StatusSupport)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      org.smpte.st2071._2014.event._StatusSupportStub stub = new org.smpte.st2071._2014.event._StatusSupportStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static org.smpte.st2071._2014.event.StatusSupport unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof org.smpte.st2071._2014.event.StatusSupport)
      return (org.smpte.st2071._2014.event.StatusSupport)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      org.smpte.st2071._2014.event._StatusSupportStub stub = new org.smpte.st2071._2014.event._StatusSupportStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
