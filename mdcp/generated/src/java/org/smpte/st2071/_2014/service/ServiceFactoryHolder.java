package org.smpte.st2071._2014.service;

/**
* org/smpte/st2071/_2014/service/ServiceFactoryHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

public final class ServiceFactoryHolder implements org.omg.CORBA.portable.Streamable
{
  public org.smpte.st2071._2014.service.ServiceFactory value = null;

  public ServiceFactoryHolder ()
  {
  }

  public ServiceFactoryHolder (org.smpte.st2071._2014.service.ServiceFactory initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = org.smpte.st2071._2014.service.ServiceFactoryHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    org.smpte.st2071._2014.service.ServiceFactoryHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return org.smpte.st2071._2014.service.ServiceFactoryHelper.type ();
  }

}
