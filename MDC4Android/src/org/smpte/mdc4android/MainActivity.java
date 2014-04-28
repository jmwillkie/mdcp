package org.smpte.mdc4android;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.Gravity;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity
{
    public static final String MESSAGE_ERROR_ON_STARTUP = "ErrorOnStartup";
    
    public static final String MESSAGE_DISPLAY_TEXT = "DisplayText";
    
    public static final String EXTRA_TEXT = "Text";
    
    
    private BroadcastReceiver errorReceiver = new BroadcastReceiver()
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            String action = intent.getAction();
            
            if (MESSAGE_ERROR_ON_STARTUP.equals(action))
            {
                String text = intent.getStringExtra(EXTRA_TEXT);
                if (text != null)
                {
                    Toast toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
                finish();
            }
        }
    };
    
    private BroadcastReceiver displayReceiver = new BroadcastReceiver()
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            String action = intent.getAction();
            
            if (MESSAGE_DISPLAY_TEXT.equals(action))
            {
                String text = intent.getStringExtra(EXTRA_TEXT);
                if (text != null)
                {
                    TextView textView = (TextView) findViewById(R.id.textView);
                    textView.setText(textView.getText() + "\n" + text);
                }
            }
        }
    };

    private LocalBroadcastManager localBroadcaster;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        localBroadcaster = LocalBroadcastManager.getInstance(getApplicationContext());
        localBroadcaster.registerReceiver(errorReceiver, new IntentFilter(MESSAGE_ERROR_ON_STARTUP));
        localBroadcaster.registerReceiver(displayReceiver, new IntentFilter(MESSAGE_DISPLAY_TEXT));
    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
