package org.smpte.st2071._2014.session;


/**
* org/smpte/st2071/_2014/session/_AcquirableStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

public class _AcquirableStub extends org.omg.CORBA.portable.ObjectImpl implements org.smpte.st2071._2014.session.Acquirable
{


  // UCN = "urn:smpte:ucn:org.smpte.st2071:acquirable_v1.0";
  public boolean Acquired ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_get_Acquired", true);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return Acquired (        );
            } finally {
                _releaseReply ($in);
            }
  } // Acquired


  // raises (org::smpte::st2071::_2014::security::SecurityException);
  public org.smpte.st2071._2014.session.Session[] AcquiredBy ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_get_AcquiredBy", true);
                $in = _invoke ($out);
                org.smpte.st2071._2014.session.Session $result[] = org.smpte.st2071._2014.session.SessionsHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return AcquiredBy (        );
            } finally {
                _releaseReply ($in);
            }
  } // AcquiredBy


  // raises (org::smpte::st2071::_2014::security::SecurityException);
  public org.smpte.st2071._2014.identity.URI acquire (String name) throws org.smpte.st2071._2014.session.NotAcquired, org.smpte.st2071._2014.session.Locked, org.smpte.st2071._2014.session.TooManySessions, org.smpte.st2071._2014.session.NameInUse, org.smpte.st2071._2014.security.SecurityException
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("acquire", true);
                $out.write_wstring (name);
                $in = _invoke ($out);
                org.smpte.st2071._2014.identity.URI $result = org.smpte.st2071._2014.identity.URIHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:org/smpte/st2071/_2014/session/NotAcquired:1.0"))
                    throw org.smpte.st2071._2014.session.NotAcquiredHelper.read ($in);
                else if (_id.equals ("IDL:org/smpte/st2071/_2014/session/Locked:1.0"))
                    throw org.smpte.st2071._2014.session.LockedHelper.read ($in);
                else if (_id.equals ("IDL:org/smpte/st2071/_2014/session/TooManySessions:1.0"))
                    throw org.smpte.st2071._2014.session.TooManySessionsHelper.read ($in);
                else if (_id.equals ("IDL:org/smpte/st2071/_2014/session/NameInUse:1.0"))
                    throw org.smpte.st2071._2014.session.NameInUseHelper.read ($in);
                else if (_id.equals ("IDL:org/smpte/st2071/_2014/security/SecurityException:1.0"))
                    throw org.smpte.st2071._2014.security.SecurityExceptionHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return acquire (name        );
            } finally {
                _releaseReply ($in);
            }
  } // acquire

  public boolean release (org.smpte.st2071._2014.identity.URI session) throws org.smpte.st2071._2014.session.NotAcquired, org.smpte.st2071._2014.session.Locked, org.smpte.st2071._2014.session.SessionNotFound, org.smpte.st2071._2014.security.SecurityException
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("release", true);
                org.smpte.st2071._2014.identity.URIHelper.write ($out, session);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:org/smpte/st2071/_2014/session/NotAcquired:1.0"))
                    throw org.smpte.st2071._2014.session.NotAcquiredHelper.read ($in);
                else if (_id.equals ("IDL:org/smpte/st2071/_2014/session/Locked:1.0"))
                    throw org.smpte.st2071._2014.session.LockedHelper.read ($in);
                else if (_id.equals ("IDL:org/smpte/st2071/_2014/session/SessionNotFound:1.0"))
                    throw org.smpte.st2071._2014.session.SessionNotFoundHelper.read ($in);
                else if (_id.equals ("IDL:org/smpte/st2071/_2014/security/SecurityException:1.0"))
                    throw org.smpte.st2071._2014.security.SecurityExceptionHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return release (session        );
            } finally {
                _releaseReply ($in);
            }
  } // release

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:org/smpte/st2071/2014/session/Acquirable:1.0"};

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
} // class _AcquirableStub
