package com.j.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Administrator on 2015/8/27.
 */
public class SortedBroadcast1 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "接收到的intent的action为：" + intent.getAction()
                + "\n消息为：" + intent.getStringExtra("msg"), Toast.LENGTH_LONG).show();
        Bundle bundle = new Bundle();
        bundle.putString("first", "第一个broadcastReceiver存入的信息");
        setResultExtras(bundle);
//        abortBroadcast();
    }
}
