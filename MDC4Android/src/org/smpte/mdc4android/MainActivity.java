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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity
{
    public static final String MESSAGE_ERROR_ON_STARTUP = "ErrorOnStartup";
    
    public static final String MESSAGE_DISPLAY_TEXT = "DisplayText";
    
    public static final String EXTRA_TEXT = "Text";

    protected static final String MESSAGE_PROGRESS = "Progress";

    protected static final String EXTRA_PROGRESS = "Progress";

    public static final String MESSAGE_SHOW_PROGRESS = "ShowProgress";

    protected static final String EXTRA_SHOW_PROGRESS = null;
    
    
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
                    CharSequence displayedText = textView.getText();
                    if (displayedText.length() > 0)
                    {
                        textView.setText(displayedText + "\n" + text);
                    } else
                    {
                        textView.setText(text);
                    }
                }
            }
        }
    };
    
    private BroadcastReceiver progressReceiver = new BroadcastReceiver()
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            String action = intent.getAction();
            
            if (MESSAGE_PROGRESS.equals(action))
            {
                ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
                if (progressBar != null)
                {
                    if (intent.getBooleanExtra(EXTRA_SHOW_PROGRESS, false))
                    {
                        progressBar.setVisibility(View.VISIBLE);
                    } else
                    {
                        progressBar.setVisibility(View.GONE);
                    }
                    
                    double progress = intent.getDoubleExtra(EXTRA_PROGRESS, Double.NaN);
                    if (progress != Double.NaN)
                    {
                        if (progress < 0)
                        {
                            progressBar.setIndeterminate(true);
                        } else
                        {
                            progressBar.setMax(100);
                            progressBar.setProgress((int) Math.floor(100 * progress));
                        }
                    }
                }
            } else if (MESSAGE_SHOW_PROGRESS.equals(action))
            {
                ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
                if (progressBar != null)
                {
                    if (intent.getBooleanExtra(EXTRA_SHOW_PROGRESS, false))
                    {
                        progressBar.setVisibility(View.VISIBLE);
                    } else
                    {
                        progressBar.setVisibility(View.GONE);
                    }
                }
            }
        }
    };

    private LocalBroadcastManager localBroadcaster;

    private MenuItem stopMenuItem;

    private MenuItem restartMenuItem;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        localBroadcaster = LocalBroadcastManager.getInstance(getApplicationContext());
        localBroadcaster.registerReceiver(errorReceiver, new IntentFilter(MESSAGE_ERROR_ON_STARTUP));
        localBroadcaster.registerReceiver(displayReceiver, new IntentFilter(MESSAGE_DISPLAY_TEXT));
        localBroadcaster.registerReceiver(progressReceiver, new IntentFilter(MESSAGE_PROGRESS));
        
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setMax(100);
        progressBar.bringToFront();
        
        if (savedInstanceState != null)
        {
            CharSequence text = savedInstanceState.getCharSequence(EXTRA_TEXT);
            
            TextView textView = (TextView) findViewById(R.id.textView);
            
            if (text != null)
            {
                textView.setText(text);
            }
        }
        
//        Intent mdcpServiceIntent = new Intent(this, MDCService.class);
//        startService(mdcpServiceIntent);
    }
    
    
    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        TextView textView = (TextView) findViewById(R.id.textView);
        outState.putCharSequence(EXTRA_TEXT, textView.getText());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        stopMenuItem = menu.add(R.string.stop);
        stopMenuItem.setOnMenuItemClickListener(new OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                Intent mdcpServiceIntent = new Intent(MainActivity.this, MDCService.class);
                return stopService(mdcpServiceIntent);
            }
        });
        restartMenuItem = menu.add(R.string.restart);
        restartMenuItem.setOnMenuItemClickListener(new OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                Intent mdcpServiceIntent = new Intent(MainActivity.this, MDCService.class);
                stopService(mdcpServiceIntent);
                return startService(mdcpServiceIntent) != null;
            }
        });
        return true;
    }
    
}
