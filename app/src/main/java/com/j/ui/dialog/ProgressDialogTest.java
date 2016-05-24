package com.j.ui.dialog;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.j.R;


/**
 * Created by Administrator on 2015/8/14.
 */
public class ProgressDialogTest extends Activity {
    final int MESSAGE_ID = 0x124;
    int dataIndex = 0;
    int MAX_DATA = 50;
    int[] data = new int[MAX_DATA];
    int MAX_PROGRESS = 100;
    int progress = 0;
    ProgressDialog dialog;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
//                super.handleMessage(msg);
            if (msg.what == MESSAGE_ID) {
                dialog.setProgress(progress);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_dialog);
    }

    public void showSpinner(View view) {
        ProgressDialog.show(ProgressDialogTest.this, "进度条的标题", "进度条的内容", false, true);
    }

    public void showIndeterminate(View view) {
        ProgressDialog dialog1 = new ProgressDialog(this);
        dialog1.setIcon(R.drawable.ic_launcher);
        dialog1.setTitle("任务执行中");
        dialog1.setMessage("任务执行中，请稍后");
        dialog1.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog1.setCancelable(true);
        dialog1.setIndeterminate(true);
        dialog1.show();
    }

    public void showProgress(View view) {
        progress = 0;
        dataIndex = 0;
        dialog = new ProgressDialog(ProgressDialogTest.this);
        dialog.setIcon(R.drawable.ic_launcher);
        dialog.setTitle("任务执行中");
        dialog.setMessage("任务执行中，请稍后");
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setCancelable(true);
        dialog.setIndeterminate(false);
        dialog.setMax(MAX_PROGRESS);
        dialog.show();

//        System.out.println("progress:Thread*************************************************************" + progress);

        new Thread() {
            public void run() {
                while (progress < MAX_PROGRESS) {
                    progress = MAX_PROGRESS * doWork() / MAX_DATA;
//                  System.out.println("progress:" + progress);
//                  progress++;
                    handler.sendEmptyMessage(MESSAGE_ID);
                }
                if (progress >= MAX_PROGRESS) {
//                  Toast.makeText(ProgressDialogTest.this, "恭喜发财！", Toast.LENGTH_SHORT);
                    dialog.dismiss();
                }
            }

            ;
        }.start();
    }

    public int doWork() {
        data[dataIndex++] = (int) (Math.random() * 100);
//        System.out.println("doWork*************************************************************" + dataIndex);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return dataIndex;
    }

    ;
}
