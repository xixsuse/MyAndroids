package com.j.service.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

import aidl.ICat;

/**
 * Created by Administrator on 2015/8/25.
 */
public class AIDLService extends Service {
    Timer timer = new Timer();
    CATBinder catBinder;
    String color;
    double weight;
    String[] colors = {"红色", "黄色", "黑色"};
    double[] weights = {2.3, 3.1, 1.58};

    @Override
    public void onCreate() {
        super.onCreate();
        catBinder = new CATBinder();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                int rand = (int) (Math.random() * 3);
                color = colors[rand];
                weight = weights[rand];
                System.out.println("--------------" + rand);
            }
        }, 0, 800);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return catBinder;
    }

    @Override
    public void onDestroy() {
//        super.onDestroy();
        timer.cancel();
    }

    class CATBinder extends ICat.Stub {

        @Override
        public String getColor() throws RemoteException {
            return color;
        }

        @Override
        public double getWeight() throws RemoteException {
            return weight;
        }
    }
}
