package com.j.intent;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.j.R;

/**
 * Created by Administrator on 2015/8/17.
 */
public class ActionAttrTest2 extends Activity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_attr2);

        textView = (TextView) findViewById(R.id.action_attr2_textView);
        textView.setText(getIntent().getAction().toString());
    }
}
