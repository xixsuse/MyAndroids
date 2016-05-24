package com.j.ui.progressBar;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

import com.j.R;


/**
 * Created by Administrator on 2015/8/12.
 */
public class ProgressBarTest extends Activity {
    public static final int PROGRESS_MAX = 100;
    public static final int WORK_SIZE = 100;
    public static final int SLEEP_TIME = 200;
    public static final int MESSAGE_WHAT = 0x111;
    ProgressBar bar1, bar2;
    int[] work = new int[WORK_SIZE];
    int workIndex = 0;
    int currentProgress = 0;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
            if (msg.what == MESSAGE_WHAT) {
                bar1.setProgress(currentProgress);
                bar2.setProgress(currentProgress);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_bar);

        bar1 = (ProgressBar) findViewById(R.id.progress_bar1);
        bar2 = (ProgressBar) findViewById(R.id.progress_bar2);

        new Thread() {
            public void run() {
                while (currentProgress < PROGRESS_MAX) {
                    currentProgress = doWork();
                    handler.sendEmptyMessage(MESSAGE_WHAT);
                }
            }
        }.start();
    }

    public int doWork() {
        work[++workIndex] = (int) (Math.random() * 100);
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return workIndex;
    }

}
