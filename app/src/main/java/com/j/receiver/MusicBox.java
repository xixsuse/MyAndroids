package com.j.receiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.j.R;

/**
 * Created by Administrator on 2015/8/27.
 */
public class MusicBox extends Activity implements View.OnClickListener {
    //0x11:未播放, 0x12:正在播放， 0x13:暂停播放
    public static final int STATUS_STOP = 0x11;
    public static final int STATUS_PLAY = 0x12;
    public static final int STATUS_PAUSE = 0x13;
    public static final String UPDATE_ACTION = "com.j.receiver.UPDATE_ACTION";
    public static final String CTL_ACTION = "com.j.receiver.CTL_ACTION";
    ActivityReciver activityReciver;
    TextView title;
    TextView anthor;
    ImageButton play;
    ImageButton stop;
    String[] titles = new String[]{"心愿", "约定", "美丽新世界"};
    String[] authors = new String[]{"未知艺术家", "周蕙", "伍佰"};
    int status = STATUS_STOP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_box);

        activityReciver = new ActivityReciver();
        title = (TextView) findViewById(R.id.musicBox_title);
        anthor = (TextView) findViewById(R.id.musicBox_anthor);
        play = (ImageButton) findViewById(R.id.musicBox_play);
        stop = (ImageButton) findViewById(R.id.musicBox_stop);

        play.setOnClickListener(this);
        stop.setOnClickListener(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(UPDATE_ACTION);
        registerReceiver(activityReciver, intentFilter);
        Intent intent = new Intent(this, MusicService.class);
        startService(intent);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(CTL_ACTION);
        switch (v.getId()) {
            case R.id.musicBox_play:
                intent.putExtra("control", 1);
                break;
            case R.id.musicBox_stop:
                intent.putExtra("control", 2);
                break;
        }
        sendBroadcast(intent);
    }

    class ActivityReciver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            int update = intent.getIntExtra("update", -1);
            int current = intent.getIntExtra("current", -1);
            if (current >= 0) {
                title.setText(titles[current]);
                anthor.setText(authors[current]);
            }
            switch (update) {
                case STATUS_STOP:
                    play.setImageResource(R.drawable.play);
                    status = STATUS_STOP;
                    break;
                case STATUS_PLAY:
                    play.setImageResource(R.drawable.pause);
                    status = STATUS_PLAY;
                    break;
                case STATUS_PAUSE:
                    play.setImageResource(R.drawable.play);
                    status = STATUS_PAUSE;
                    break;

            }
        }
    }

}
