package org.smpte.st2071._2014.service;


/**
* org/smpte/st2071/_2014/service/_ServiceStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

public class _ServiceStub extends org.omg.CORBA.portable.ObjectImpl implements org.smpte.st2071._2014.service.Service
{


  // UCN = "urn:smpte:ucn:org.smpte.st2071:service_v1.0";
  public org.smpte.st2071._2014.identity.USN USN ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_get_USN", true);
                $in = _invoke ($out);
                org.smpte.st2071._2014.identity.USN $result = org.smpte.st2071._2014.identity.USNHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return USN (        );
            } finally {
                _releaseReply ($in);
            }
  } // USN


  // raises (org::smpte::st2071::_2014::security::SecurityException);
  public org.smpte.st2071._2014.service.ServiceTemplate Type ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_get_Type", true);
                $in = _invoke ($out);
                org.smpte.st2071._2014.service.ServiceTemplate $result = org.smpte.st2071._2014.service.ServiceTemplateHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return Type (        );
            } finally {
                _releaseReply ($in);
            }
  } // Type


  // raises (org::smpte::st2071::_2014::security::SecurityException);
  public org.smpte.st2071._2014.identity.URL[] URLs ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_get_URLs", true);
                $in = _invoke ($out);
                org.smpte.st2071._2014.identity.URL $result[] = org.smpte.st2071._2014.identity.URLsHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return URLs (        );
            } finally {
                _releaseReply ($in);
            }
  } // URLs


  // raises (org::smpte::st2071::_2014::security::SecurityException);
  public org.smpte.st2071._2014.types.Map Attributes ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_get_Attributes", true);
                $in = _invoke ($out);
                org.smpte.st2071._2014.types.Map $result = org.smpte.st2071._2014.types.MapHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return Attributes (        );
            } finally {
                _releaseReply ($in);
            }
  } // Attributes


  // raises (org::smpte::st2071::_2014::security::SecurityException);
  public org.smpte.st2071._2014.types.Capability[] Capabilities ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_get_Capabilities", true);
                $in = _invoke ($out);
                org.smpte.st2071._2014.types.Capability $result[] = org.smpte.st2071._2014.types.CapabilitiesHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return Capabilities (        );
            } finally {
                _releaseReply ($in);
            }
  } // Capabilities

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:org/smpte/st2071/2014/service/Service:1.0", 
    "IDL:org/smpte/st2071/2014/query/Queryable:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _ServiceStub
