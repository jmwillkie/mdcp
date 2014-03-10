package org.smpte.st2071.mdcd.android.test;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.xml.ws.Action;

import android.util.Log;

public class HelloImpl implements Hello
{
    public HelloImpl()
    {
        // TODO Auto-generated constructor stub
    }
    
    
    @Override
    @WebResult(name = "EmptyResponse", targetNamespace = "http://www.posick.net/test", partName = "EmptyResponse")
    @Action(input = "http://www.posick.net/test/Hello/sayHello", output = "http://www.posick.net/test/Hello/UDNResponse")
    @WebMethod(action = "http://www.posick.net/test/Hello/sayHello")
    public void sayHello()
    {
        Log.e(getClass().getName(), "Hello");
    }
}
