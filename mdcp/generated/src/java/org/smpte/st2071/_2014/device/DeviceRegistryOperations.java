package org.smpte.st2071._2014.device;


/**
* org/smpte/st2071/_2014/device/DeviceRegistryOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

public interface DeviceRegistryOperations 
{

  // UCN = "urn:smpte:ucn:org.smpte.st2071:device_registry_v1.0";
  void bind (org.smpte.st2071._2014.identity.UDN udn, org.smpte.st2071._2014.identity.UDN parentUDN, org.smpte.st2071._2014.identity.URL[] urls, String name, org.smpte.st2071._2014.types.Capability[] capabilities) throws org.smpte.st2071._2014.device.DeviceNotFound, org.smpte.st2071._2014.device.DeviceNotBound, org.smpte.st2071._2014.device.DeviceAlreadyBound, org.smpte.st2071._2014.security.SecurityException;
  void unbind (org.smpte.st2071._2014.identity.UDN udn) throws org.smpte.st2071._2014.device.DeviceNotFound, org.smpte.st2071._2014.device.DeviceNotUnbound, org.smpte.st2071._2014.security.SecurityException;
  boolean setOnline (org.smpte.st2071._2014.identity.UDN udn, boolean online) throws org.smpte.st2071._2014.device.DeviceNotFound, org.smpte.st2071._2014.security.SecurityException;
} // interface DeviceRegistryOperations