package org.smpte.st2071._2014.security;


/**
* org/smpte/st2071/_2014/security/Principal.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

public abstract class Principal implements org.omg.CORBA.portable.StreamableValue
{
  private static String[] _truncatable_ids = {
    org.smpte.st2071._2014.security.PrincipalHelper.id ()
  };

  public String[] _truncatable_ids() {
    return _truncatable_ids;
  }

  public abstract String Realm ();

  public abstract String Identifier ();

  public abstract org.smpte.st2071._2014.security.Role[] Roles ();

  public abstract org.smpte.st2071._2014.security.SecurityToken[] Tokens ();

  public void _read (org.omg.CORBA.portable.InputStream istream)
  {
  }

  public void _write (org.omg.CORBA.portable.OutputStream ostream)
  {
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return org.smpte.st2071._2014.security.PrincipalHelper.type ();
  }
} // class Principal