package org.smpte.st2071._2014.session;

/**
* org/smpte/st2071/_2014/session/LockableHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

public final class LockableHolder implements org.omg.CORBA.portable.Streamable
{
  public org.smpte.st2071._2014.session.Lockable value = null;

  public LockableHolder ()
  {
  }

  public LockableHolder (org.smpte.st2071._2014.session.Lockable initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = org.smpte.st2071._2014.session.LockableHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    org.smpte.st2071._2014.session.LockableHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return org.smpte.st2071._2014.session.LockableHelper.type ();
  }

}
