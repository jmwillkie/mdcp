package org.smpte.st2071.mdcd;

import java.util.ArrayList;

import org.smpte.st2071.mdcp.Constants;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class NetworkConnectivityReceiver extends BroadcastReceiver
{
    public static final String LOG_TAG = Constants.LOG_TAG + "." + NetworkConnectivityReceiver.class.getSimpleName();
    
    
    @Override
    public void onReceive(Context context, Intent intent)
    {
        ArrayList<Integer> available = new ArrayList<Integer>();
        ArrayList<Integer> connected = new ArrayList<Integer>();
        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        
        if (connMgr != null)
        {
            NetworkInfo[] networkInfos = connMgr.getAllNetworkInfo();
            for (NetworkInfo networkInfo : networkInfos)
            {
                if (networkInfo.isConnected())
                {
                    if (networkInfo.isAvailable())
                    {
                        available.add(networkInfo.getType());
                    }
                    if (networkInfo.isConnected())
                    {
                        connected.add(networkInfo.getType());
                    }
                }
            }
            
            context.startService(new Intent(MDCDService.class.getName()).
                putIntegerArrayListExtra(MDCDService.EXTRA_AVAILABLE_NETWORKS, available).
                putIntegerArrayListExtra(MDCDService.EXTRA_CONNECTED_NETWORKS, connected));
        } else
        {
            Log.e(LOG_TAG, "ConnectivityManager could not be acquired!");
        }
    }
}
