package com.j.service;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by Administrator on 2015/8/25.
 */
public class MyIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        long endTime = System.currentTimeMillis() + 20 * 1000;
        System.out.println("---- onHandleIntent() ----");
        while (System.currentTimeMillis() < endTime) {
            synchronized (this) {
                try {
                    wait(endTime - System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("---- 耗时任务执行完成 ----");
    }
}
