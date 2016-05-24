package com.j.images;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

import com.j.R;


/**
 * Created by Administrator on 2015/6/23.
 */
public class PlaneActivity extends Activity implements SensorEventListener {
    PlaneView planeView;
    DisplayMetrics displayMetrics;
    SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
                , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        planeView = new PlaneView(this);
        setContentView(planeView);

//        setContentView(R.layout.plane_layout);
        planeView.setBackgroundResource(R.drawable.back);
//        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.plane_linearLayout);
//        linearLayout.addView(planeView);

        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);
        planeView.currentX = displayMetrics.widthPixels / 2;
        planeView.currentY = displayMetrics.heightPixels / 2;

        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sm.registerListener(this,
                sm.getDefaultSensor(Sensor.TYPE_ORIENTATION)
                , sm.SENSOR_DELAY_GAME);
        sm.registerListener(this,
                sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)
                , sm.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        sm.unregisterListener(this);
        super.onPause();
    }

    @Override
    protected void onStop() {
        sm.unregisterListener(this);
        super.onStop();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float[] floats = event.values;
        int sensorType = event.sensor.getType();
        switch (sensorType) {
            case Sensor.TYPE_ORIENTATION:
                planeView.currentX -= floats[2] / 2;
                planeView.currentY -= floats[1] / 2;
                if (planeView.currentX < 0) {
                    planeView.currentX = 0;
                }
                if (planeView.currentX >= displayMetrics.widthPixels - 100) {
                    planeView.currentX = displayMetrics.widthPixels - 100;
                }
                if (planeView.currentY < 0) {
                    planeView.currentY = 0;
                }
                if (planeView.currentY >= displayMetrics.heightPixels - 120) {
                    planeView.currentY = displayMetrics.heightPixels - 120;
                }
                break;
        }
        planeView.invalidate();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}
