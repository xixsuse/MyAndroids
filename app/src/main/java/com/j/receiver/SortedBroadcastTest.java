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
public class SortedBroadcastTest extends Activity {
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sorted_broadcast);

        send = (Button) findViewById(R.id.sortedBoradcast_send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.j.receiver.SORTED_BROADCAST");
                intent.putExtra("msg", "有序消息");
                sendOrderedBroadcast(intent, null);
            }
        });
    }
}
