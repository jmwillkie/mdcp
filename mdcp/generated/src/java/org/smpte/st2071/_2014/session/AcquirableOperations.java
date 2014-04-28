package org.smpte.st2071._2014.session;


/**
* org/smpte/st2071/_2014/session/AcquirableOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

public interface AcquirableOperations 
{

  // UCN = "urn:smpte:ucn:org.smpte.st2071:acquirable_v1.0";
  boolean Acquired ();

  // raises (org::smpte::st2071::_2014::security::SecurityException);
  org.smpte.st2071._2014.session.Session[] AcquiredBy ();

  // raises (org::smpte::st2071::_2014::security::SecurityException);
  org.smpte.st2071._2014.identity.URI acquire (String name) throws org.smpte.st2071._2014.session.NotAcquired, org.smpte.st2071._2014.session.Locked, org.smpte.st2071._2014.session.TooManySessions, org.smpte.st2071._2014.session.NameInUse, org.smpte.st2071._2014.security.SecurityException;
  boolean release (org.smpte.st2071._2014.identity.URI session) throws org.smpte.st2071._2014.session.NotAcquired, org.smpte.st2071._2014.session.Locked, org.smpte.st2071._2014.session.SessionNotFound, org.smpte.st2071._2014.security.SecurityException;
} // interface AcquirableOperations