package org.smpte.st2071._2014.types;


/**
* org/smpte/st2071/_2014/types/DATA_TYPE.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

public class DATA_TYPE implements org.omg.CORBA.portable.IDLEntity
{
  private        int __value;
  private static int __size = 8;
  private static org.smpte.st2071._2014.types.DATA_TYPE[] __array = new org.smpte.st2071._2014.types.DATA_TYPE [__size];

  public static final int __BOOLEAN = 0;
  public static final org.smpte.st2071._2014.types.DATA_TYPE _BOOLEAN = new org.smpte.st2071._2014.types.DATA_TYPE(__BOOLEAN);
  public static final int __STRING = 1;
  public static final org.smpte.st2071._2014.types.DATA_TYPE _STRING = new org.smpte.st2071._2014.types.DATA_TYPE(__STRING);
  public static final int __INTEGER = 2;
  public static final org.smpte.st2071._2014.types.DATA_TYPE _INTEGER = new org.smpte.st2071._2014.types.DATA_TYPE(__INTEGER);
  public static final int __FLOAT = 3;
  public static final org.smpte.st2071._2014.types.DATA_TYPE _FLOAT = new org.smpte.st2071._2014.types.DATA_TYPE(__FLOAT);
  public static final int __DATE_TIME = 4;
  public static final org.smpte.st2071._2014.types.DATA_TYPE _DATE_TIME = new org.smpte.st2071._2014.types.DATA_TYPE(__DATE_TIME);
  public static final int __URI = 5;
  public static final org.smpte.st2071._2014.types.DATA_TYPE _URI = new org.smpte.st2071._2014.types.DATA_TYPE(__URI);
  public static final int __MAP = 6;
  public static final org.smpte.st2071._2014.types.DATA_TYPE _MAP = new org.smpte.st2071._2014.types.DATA_TYPE(__MAP);
  public static final int __BLOB = 7;
  public static final org.smpte.st2071._2014.types.DATA_TYPE _BLOB = new org.smpte.st2071._2014.types.DATA_TYPE(__BLOB);

  public int value ()
  {
    return __value;
  }

  public static org.smpte.st2071._2014.types.DATA_TYPE from_int (int value)
  {
    if (value >= 0 && value < __size)
      return __array[value];
    else
      throw new org.omg.CORBA.BAD_PARAM ();
  }

  protected DATA_TYPE (int value)
  {
    __value = value;
    __array[__value] = this;
  }
} // class DATA_TYPE