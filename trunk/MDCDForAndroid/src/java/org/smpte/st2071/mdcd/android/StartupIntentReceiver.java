package org.smpte.st2071.mdcd.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * @author Steve Posick
 */
public class StartupIntentReceiver extends BroadcastReceiver
{
    public StartupIntentReceiver()
    {
        super();
    }
    
    
    /* (non-Javadoc)
     * @see android.content.BroadcastReceiver#onReceive(android.content.Context, android.content.Intent)
     */
    @Override
    public void onReceive(Context context, Intent intent)
    {
        Log.i(Constants.LOG_TAG, getClass().getSimpleName() + ".onReceive()");
        Intent serviceIntent = new Intent(context, MDCDService.class);
        context.startService(serviceIntent);
    }
}
