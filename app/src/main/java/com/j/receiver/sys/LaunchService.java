package com.j.receiver.sys;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 开机自动运行的service
 */
public class LaunchService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("LaunchService:" + new Date());
            }
        }, 0, 1000);
    }
}
