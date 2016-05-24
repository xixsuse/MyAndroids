package com.j.receiver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.j.R;

/**
 * Created by Administrator on 2015/8/27.
 */
public class MyReceiverTest extends Activity {
    public static final String ACTION = "com.j.receiver.MyReceiver";
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcast_receiver);

        send = (Button) findViewById(R.id.broadcastReceiver_send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(ACTION);
                intent.putExtra("msg", "简单消息");
                sendBroadcast(intent);
            }
        });
    }
}
