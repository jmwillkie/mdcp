
/**
* bits128Holder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:25 PM EDT
*/

public final class bits128Holder implements org.omg.CORBA.portable.Streamable
{
  public byte value[] = null;

  public bits128Holder ()
  {
  }

  public bits128Holder (byte[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = bits128Helper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    bits128Helper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return bits128Helper.type ();
  }

}
