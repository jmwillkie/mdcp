package org.smpte.mdc4android.net;

import org.smpte.mdc4android.MDC4Android;
import org.smpte.mdc4android.MDCService;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class NetworkConnectivityReceiver extends BroadcastReceiver
{
    public static final String LOG_TAG = MDC4Android.LOG_TAG + "." + NetworkConnectivityReceiver.class.getSimpleName();
    
    
    @Override
    public void onReceive(Context context, Intent intent)
    {
        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connMgr != null)
        {
            NetworkInfo info = connMgr.getActiveNetworkInfo();
            Log.i(LOG_TAG, "Network Connectivity Changed - " + (info != null ? "Connected to \"" + info.getTypeName() + "/" + info.getSubtypeName() + "\"." : "NOT Connected to any network."));
            context.startService(new Intent(context, MDCService.class));
        } else
        {
            Log.e(LOG_TAG, "ConnectivityManager could not be acquired!");
        }
    }
}
