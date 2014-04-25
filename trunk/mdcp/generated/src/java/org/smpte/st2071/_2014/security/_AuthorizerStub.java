package org.smpte.st2071._2014.security;

import StringsHolder;
import StringsHelper;

/**
* org/smpte/st2071/_2014/security/_AuthorizerStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

public class _AuthorizerStub extends org.omg.CORBA.portable.ObjectImpl implements org.smpte.st2071._2014.security.Authorizer
{


  // UCN = "urn:smpte:ucn:org.smpte.st2071:authorizer_v1.0";
  public String[] Mechanisms ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_get_Mechanisms", true);
                $in = _invoke ($out);
                String $result[] = StringsHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return Mechanisms (        );
            } finally {
                _releaseReply ($in);
            }
  } // Mechanisms

  public org.smpte.st2071._2014.security.Subject authorize (org.smpte.st2071._2014.security.Subject subject, org.smpte.st2071._2014.identity.URI uri) throws org.smpte.st2071._2014.security.SecurityException
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("authorize", true);
                org.smpte.st2071._2014.security.SubjectHelper.write ($out, subject);
                org.smpte.st2071._2014.identity.URIHelper.write ($out, uri);
                $in = _invoke ($out);
                org.smpte.st2071._2014.security.Subject $result = org.smpte.st2071._2014.security.SubjectHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:org/smpte/st2071/_2014/security/SecurityException:1.0"))
                    throw org.smpte.st2071._2014.security.SecurityExceptionHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return authorize (subject, uri        );
            } finally {
                _releaseReply ($in);
            }
  } // authorize

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:org/smpte/st2071/2014/security/Authorizer:1.0"};

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
} // class _AuthorizerStub
