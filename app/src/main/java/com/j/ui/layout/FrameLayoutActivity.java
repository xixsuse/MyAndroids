package com.j.ui.layout;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.j.R;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by Administrator on 2015/7/20.
 */
public class FrameLayoutActivity extends Activity {
    int currentColor = 0;
    int[] colors = new int[]{
            R.color.color1,
            R.color.color2,
            R.color.color3,
            R.color.color4,
            R.color.color5,
            R.color.color6
    };
    int[] names = new int[]{
            R.id.frame_textview1,
            R.id.frame_textview2,
            R.id.frame_textview3,
            R.id.frame_textview4,
            R.id.frame_textview5,
            R.id.frame_textview6
    };
    int count = names.length;
    TextView[] textViews = new TextView[count];

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0x123) {
                for (int i = 0; i < count; i++) {
                    textViews[i].setBackgroundResource(colors[(i + currentColor) % count]);
                }
                currentColor++;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_layout);
        for (int i = 0; i < count; i++) {
            textViews[i] = (TextView) findViewById(names[i]);
        }
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0x123);
            }
        }, 0, 200);
    }

}
