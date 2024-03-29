package org.smpte.st2071._2014.session;


/**
* org/smpte/st2071/_2014/session/_LockableStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MDCF.idl
* Thursday, March 20, 2014 1:55:28 PM EDT
*/

public class _LockableStub extends org.omg.CORBA.portable.ObjectImpl implements org.smpte.st2071._2014.session.Lockable
{


  // UCN = "urn:smpte:ucn:org.smpte.st2071:lockable_v1.0";
  public boolean Locked ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_get_Locked", true);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return Locked (        );
            } finally {
                _releaseReply ($in);
            }
  } // Locked


  // raises (org::smpte::st2071::_2014::security::SecurityException);
  public org.smpte.st2071._2014.session.Session LockedBy ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_get_LockedBy", true);
                $in = _invoke ($out);
                org.smpte.st2071._2014.session.Session $result = org.smpte.st2071._2014.session.SessionHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return LockedBy (        );
            } finally {
                _releaseReply ($in);
            }
  } // LockedBy


  // raises (org::smpte::st2071::_2014::security::SecurityException);
  public org.smpte.st2071._2014.identity.URI lock (org.smpte.st2071._2014.identity.URI session, String name) throws org.smpte.st2071._2014.session.SessionNotFound, org.smpte.st2071._2014.session.NotAcquired, org.smpte.st2071._2014.session.NotLocked, org.smpte.st2071._2014.security.SecurityException
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("lock", true);
                org.smpte.st2071._2014.identity.URIHelper.write ($out, session);
                $out.write_wstring (name);
                $in = _invoke ($out);
                org.smpte.st2071._2014.identity.URI $result = org.smpte.st2071._2014.identity.URIHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:org/smpte/st2071/_2014/session/SessionNotFound:1.0"))
                    throw org.smpte.st2071._2014.session.SessionNotFoundHelper.read ($in);
                else if (_id.equals ("IDL:org/smpte/st2071/_2014/session/NotAcquired:1.0"))
                    throw org.smpte.st2071._2014.session.NotAcquiredHelper.read ($in);
                else if (_id.equals ("IDL:org/smpte/st2071/_2014/session/NotLocked:1.0"))
                    throw org.smpte.st2071._2014.session.NotLockedHelper.read ($in);
                else if (_id.equals ("IDL:org/smpte/st2071/_2014/security/SecurityException:1.0"))
                    throw org.smpte.st2071._2014.security.SecurityExceptionHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return lock (session, name        );
            } finally {
                _releaseReply ($in);
            }
  } // lock

  public boolean unlock (org.smpte.st2071._2014.identity.URI lock) throws org.smpte.st2071._2014.session.SessionNotFound, org.smpte.st2071._2014.security.SecurityException
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("unlock", true);
                org.smpte.st2071._2014.identity.URIHelper.write ($out, lock);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:org/smpte/st2071/_2014/session/SessionNotFound:1.0"))
                    throw org.smpte.st2071._2014.session.SessionNotFoundHelper.read ($in);
                else if (_id.equals ("IDL:org/smpte/st2071/_2014/security/SecurityException:1.0"))
                    throw org.smpte.st2071._2014.security.SecurityExceptionHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return unlock (lock        );
            } finally {
                _releaseReply ($in);
            }
  } // unlock

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:org/smpte/st2071/2014/session/Lockable:1.0"};

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
} // class _LockableStub
