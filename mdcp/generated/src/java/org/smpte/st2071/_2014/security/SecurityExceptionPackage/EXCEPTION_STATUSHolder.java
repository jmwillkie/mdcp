package org.smpte.st2071._2014.security.SecurityExceptionPackage;

/**
* org/smpte/st2071/_2014/security/SecurityExceptionPackage/EXCEPTION_STATUSHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

public final class EXCEPTION_STATUSHolder implements org.omg.CORBA.portable.Streamable
{
  public org.smpte.st2071._2014.security.SecurityExceptionPackage.EXCEPTION_STATUS value = null;

  public EXCEPTION_STATUSHolder ()
  {
  }

  public EXCEPTION_STATUSHolder (org.smpte.st2071._2014.security.SecurityExceptionPackage.EXCEPTION_STATUS initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = org.smpte.st2071._2014.security.SecurityExceptionPackage.EXCEPTION_STATUSHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    org.smpte.st2071._2014.security.SecurityExceptionPackage.EXCEPTION_STATUSHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return org.smpte.st2071._2014.security.SecurityExceptionPackage.EXCEPTION_STATUSHelper.type ();
  }

}
