package org.smpte.st2071._2014.device;


/**
* org/smpte/st2071/_2014/device/DeviceInformation.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

public abstract class DeviceInformation implements org.omg.CORBA.portable.StreamableValue, org.smpte.st2071._2014.device.DeviceOperations
{
  private static String[] _truncatable_ids = {
    org.smpte.st2071._2014.device.DeviceInformationHelper.id ()
  };

  public String[] _truncatable_ids() {
    return _truncatable_ids;
  }

  public abstract org.smpte.st2071._2014.types.DateTime ValidTill ();

  public void _read (org.omg.CORBA.portable.InputStream istream)
  {
  }

  public void _write (org.omg.CORBA.portable.OutputStream ostream)
  {
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return org.smpte.st2071._2014.device.DeviceInformationHelper.type ();
  }
} // class DeviceInformation
