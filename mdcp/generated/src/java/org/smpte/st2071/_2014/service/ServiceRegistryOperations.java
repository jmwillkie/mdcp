package org.smpte.st2071._2014.service;


/**
* org/smpte/st2071/_2014/service/ServiceRegistryOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

public interface ServiceRegistryOperations 
{

  // UCN = "urn:smpte:ucn:org.smpte.st2071:service_registry_v1.0";
  org.smpte.st2071._2014.service.ServiceInformation lookup (org.smpte.st2071._2014.identity.USN usn) throws org.smpte.st2071._2014.service.ServiceException, org.smpte.st2071._2014.security.SecurityException;
  org.smpte.st2071._2014.service.ServiceInformation[] search (org.smpte.st2071._2014.query.QueryExpression query) throws org.smpte.st2071._2014.service.ServiceException, org.smpte.st2071._2014.security.SecurityException;
} // interface ServiceRegistryOperations