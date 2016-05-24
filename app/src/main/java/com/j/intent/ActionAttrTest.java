package com.j.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.j.R;

/**
 * Created by Administrator on 2015/8/17.
 */
public class ActionAttrTest extends Activity {
    String ACTION_NAME = "com.j.intent.ACTION_ATTR_ACTIVITY2";
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_attr);

        button = (Button) findViewById(R.id.action_attr_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(ACTION_NAME);
                startActivity(intent);
            }
        });

    }
}
