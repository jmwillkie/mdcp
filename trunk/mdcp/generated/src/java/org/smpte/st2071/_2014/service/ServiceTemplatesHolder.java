package org.smpte.st2071._2014.service;


/**
* org/smpte/st2071/_2014/service/ServiceTemplatesHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

public final class ServiceTemplatesHolder implements org.omg.CORBA.portable.Streamable
{
  public org.smpte.st2071._2014.service.ServiceTemplate value[] = null;

  public ServiceTemplatesHolder ()
  {
  }

  public ServiceTemplatesHolder (org.smpte.st2071._2014.service.ServiceTemplate[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = org.smpte.st2071._2014.service.ServiceTemplatesHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    org.smpte.st2071._2014.service.ServiceTemplatesHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return org.smpte.st2071._2014.service.ServiceTemplatesHelper.type ();
  }

}