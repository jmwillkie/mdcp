package org.smpte.st2071._2014.query;


/**
* org/smpte/st2071/_2014/query/EQUALSValueFactory.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

public interface EQUALSValueFactory extends org.omg.CORBA.portable.ValueFactory
{
  EQUALS init (String field, long number);
  EQUALS init (String field, double number);
  EQUALS init (String field, org.smpte.st2071._2014.types.DateTime time);
  EQUALS init (String field, org.omg.CORBA.Any serializable);
}