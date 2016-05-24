package com.j.intent.tab;

import android.app.Activity;
import android.os.Bundle;

import com.j.R;

/**
 * Created by Administrator on 2015/8/17.
 */
public class CalledActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.called);
    }
}
