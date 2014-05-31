package org.smpte.st2071._2014.session;


/**
* org/smpte/st2071/_2014/session/LockableOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

public interface LockableOperations 
{

  // UCN = "urn:smpte:ucn:org.smpte.st2071:lockable_v1.0";
  boolean Locked ();

  // raises (org::smpte::st2071::_2014::security::SecurityException);
  org.smpte.st2071._2014.session.Session LockedBy ();

  // raises (org::smpte::st2071::_2014::security::SecurityException);
  org.smpte.st2071._2014.identity.URI lock (org.smpte.st2071._2014.identity.URI session, String name) throws org.smpte.st2071._2014.session.SessionNotFound, org.smpte.st2071._2014.session.NotAcquired, org.smpte.st2071._2014.session.NotLocked, org.smpte.st2071._2014.security.SecurityException;
  boolean unlock (org.smpte.st2071._2014.identity.URI lock) throws org.smpte.st2071._2014.session.SessionNotFound, org.smpte.st2071._2014.security.SecurityException;
} // interface LockableOperations