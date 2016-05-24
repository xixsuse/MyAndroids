package com.j.ui.textViews;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

import com.j.R;


/**
 * Created by Administrator on 2015/7/20.
 * 计时器
 */
public class ChronometerTest extends Activity {
    Chronometer chronometer;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chronometer_layout);

        chronometer = (Chronometer) findViewById(R.id.chronometer);
        button = (Button) findViewById(R.id.button_chronometer);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                button.setEnabled(false);
            }
        });

        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if (SystemClock.elapsedRealtime() - chronometer.getBase() > 5 * 1000) {
                    chronometer.stop();
                    button.setEnabled(true);
                    Toast.makeText(getApplicationContext(), "时间到~~", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
