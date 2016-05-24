package com.j.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.j.R;
import com.j.intent.ForResultActivity;

/**
 * Created by Administrator on 2015/9/7.
 */
public class LifeCycle extends Activity {
    String TAG = this.getClass().getSimpleName();
    Button startActivity, finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, Thread.currentThread().getStackTrace()[2].getMethodName());
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_life_cycle);

        startActivity = (Button) findViewById(R.id.activityLifeCycle_StartActivity);
        finish = (Button) findViewById(R.id.activityLifeCycle_Finish);

        startActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LifeCycle.this, ForResultActivity.class);
                startActivity(intent);
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LifeCycle.this.finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, Thread.currentThread().getStackTrace()[2].getMethodName());
    }

}
