package org.smpte.st2071.mdcd.android.test;

import android.util.Log;

public class HelloImpl implements Hello
{
    public HelloImpl()
    {
    }
    
    
    @Override
    public void sayHello()
    {
        Log.e(getClass().getName(), "Hello");
    }
}
