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
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected())
            {
                switch (networkInfo.getType())
                {
                    case ConnectivityManager.TYPE_ETHERNET:
                    case ConnectivityManager.TYPE_WIFI:
                        context.startService(new Intent(context, MDCService.class).putExtra(MDCService.EXTRA_CONNECT_TO_NETWORK, true));
                        break;
                    default:
                        context.startService(new Intent(context, MDCService.class).putExtra(MDCService.EXTRA_CONNECT_TO_NETWORK, false));
                        break;
                }
            } else
            {
                context.startService(new Intent(MDCService.class.getName()).putExtra(MDCService.EXTRA_CONNECT_TO_NETWORK, false));
            }
        } else
        {
            Log.e(LOG_TAG, "ConnectivityManager could not be acquired!");
        }
    }
}
