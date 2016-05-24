package com.j.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2015/8/24.
 */
public class BindService extends Service {
    int count;
    boolean quit;
    MyBinder myBinder = new MyBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("service is binded!");
        return myBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("service is created!");
        new Thread() {
            @Override
            public void run() {
                while (!quit) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count++;
                }
            }
        }.start();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("service is unbind!");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        quit = true;
        System.out.println("service is destroyed!");
    }

    class MyBinder extends Binder {
        public int getCount() {
            return count;
        }
    }
}
