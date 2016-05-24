package com.j.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Administrator on 2015/8/27.
 */
public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "接收到的intent的action：" + intent.getAction()
                + "\n收到的消息：" + intent.getStringExtra("msg"), Toast.LENGTH_LONG).show();
    }
}
