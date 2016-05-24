package com.j.service.alarmManager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.j.R;

/**
 * Created by Administrator on 2015/8/26.
 */
public class AlarmActivity extends Activity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mediaPlayer = MediaPlayer.create(this, R.raw.alarm);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        new AlertDialog.Builder(this)
                .setTitle("闹钟")
                .setMessage("闹钟响了，go go go")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mediaPlayer.stop();
                        AlarmActivity.this.finish();
                    }
                })
                .show();
    }
}
