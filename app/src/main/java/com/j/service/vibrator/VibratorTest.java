package com.j.service.vibrator;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.j.R;

/**
 * Created by Administrator on 2015/8/26.
 */
public class VibratorTest extends Activity {
    Vibrator vibrator;
    Button vibrate, cancel;
    EditText seconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vibrator);

        vibrate = (Button) findViewById(R.id.vibrator_vibrate);
        cancel = (Button) findViewById(R.id.vibrator_cancel);
        seconds = (EditText) findViewById(R.id.vibrator_seconds);

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        vibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(seconds.getText().toString());
                vibrator.vibrate(i * 1000);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.cancel();
            }
        });
    }
}
