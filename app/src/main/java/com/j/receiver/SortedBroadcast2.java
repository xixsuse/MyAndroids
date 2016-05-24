package com.j.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Administrator on 2015/8/27.
 */
public class SortedBroadcast2 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = getResultExtras(true);
        String first = bundle.getString("first");
        Toast.makeText(context, "第一个broadcastReceiver存入的消息：" + first
                , Toast.LENGTH_LONG).show();
    }
}
