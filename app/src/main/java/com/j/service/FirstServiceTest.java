package com.j.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.j.R;


/**
 * Created by Administrator on 2015/8/5.
 */
public class FirstServiceTest extends Activity {
    public static final String ACTION = "com.j.service.FirstService";
    public final String TAG = getClass().getSimpleName();
    Button start;
    Button stop;
    Button startPendingIntent;
    Button stopPendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_service);

        start = (Button) findViewById(R.id.FirstService_start);
        stop = (Button) findViewById(R.id.FirstService_stop);
        startPendingIntent = (Button) findViewById(R.id.FirstService_startPendingIntent);
        stopPendingIntent = (Button) findViewById(R.id.FirstService_stopPendingIntent);

        final Intent intent = new Intent();
        intent.setAction(ACTION);
        intent.setPackage(getPackageName());

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick start");
                startService(intent);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick stop");
                stopService(intent);
            }
        });

        final Intent pendingIntent = new Intent(FirstServiceTest.this, FirstService.class);

        startPendingIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick startPendingIntent");
                startService(pendingIntent);
            }
        });

        stopPendingIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick stopPendingIntent");
                stopService(pendingIntent);
            }
        });

    }

}
