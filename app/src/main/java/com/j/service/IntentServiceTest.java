package com.j.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.j.R;

/**
 * Created by Administrator on 2015/8/25.
 */
public class IntentServiceTest extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_service);
    }

    public void startService(View view) {
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }

    public void startIntentService(View view) {
        Intent intent = new Intent(this, MyIntentService.class);
        startService(intent);
    }

}
