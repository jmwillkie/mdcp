package org.smpte.st2071._2014.event;


/**
* org/smpte/st2071/_2014/event/EventBroadcasterOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

public interface EventBroadcasterOperations 
{

  // UCN = "urn:smpte:ucn:org.smpte.st2071:event:event_broadcaster_v1.0";
  boolean registerCallback (org.smpte.st2071._2014.identity.URI uri) throws org.smpte.st2071._2014.security.SecurityException;
  boolean unregisterCallback (org.smpte.st2071._2014.identity.URI uri) throws org.smpte.st2071._2014.security.SecurityException;
} // interface EventBroadcasterOperations
