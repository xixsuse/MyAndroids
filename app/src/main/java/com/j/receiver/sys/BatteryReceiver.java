package com.j.receiver.sys;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * 手机电量提醒
 */
public class BatteryReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        int current = bundle.getInt("level");
        int total = bundle.getInt("scale");
        if (current * 100 / total > 60) {
            Toast.makeText(context, "电量充足", Toast.LENGTH_LONG).show();
        }
    }
}
