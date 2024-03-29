package org.smpte.st2071._2014.query;


/**
* org/smpte/st2071/_2014/query/InvalidQuery.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

public final class InvalidQuery extends org.omg.CORBA.UserException
{
  public org.smpte.st2071._2014.query.Queryable Queryable = null;
  public org.smpte.st2071._2014.query.QueryExpression QueryExpression = null;
  public String message = null;

  public InvalidQuery ()
  {
    super(InvalidQueryHelper.id());
  } // ctor

  public InvalidQuery (org.smpte.st2071._2014.query.Queryable _Queryable, org.smpte.st2071._2014.query.QueryExpression _QueryExpression, String _message)
  {
    super(InvalidQueryHelper.id());
    Queryable = _Queryable;
    QueryExpression = _QueryExpression;
    message = _message;
  } // ctor


  public InvalidQuery (String $reason, org.smpte.st2071._2014.query.Queryable _Queryable, org.smpte.st2071._2014.query.QueryExpression _QueryExpression, String _message)
  {
    super(InvalidQueryHelper.id() + "  " + $reason);
    Queryable = _Queryable;
    QueryExpression = _QueryExpression;
    message = _message;
  } // ctor

} // class InvalidQuery
