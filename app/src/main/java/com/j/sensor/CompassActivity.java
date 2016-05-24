package com.j.sensor;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.j.R;


public class CompassActivity extends Activity implements SensorEventListener {
    // 定义显示指南针的图片
    ImageView imageView;
    // 记录指南针图片转过的角度
    float currentDegree = 0f;
    // 定义Sensor管理器
    SensorManager sensorManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compass);
        // 获取界面中显示指南针的图片
        imageView = (ImageView) findViewById(R.id.compassImage);
        // 获取传感器管理服务
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 为系统的方向传感器注册监听器
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
                SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        // 取消注册
        sensorManager.unregisterListener(this);
        super.onPause();
    }

    @Override
    protected void onStop() {
        // 取消注册
        sensorManager.unregisterListener(this);
        super.onStop();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        // 获取触发event的传感器类型
        int sensorType = event.sensor.getType();
        switch (sensorType) {
            case Sensor.TYPE_ORIENTATION:
                // 获取绕Z轴转过的角度
                float degree = event.values[0];
                // 创建旋转动画（反向转过degree度）
                RotateAnimation rotateAnimation = new RotateAnimation(currentDegree,
                        -degree, Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
                // 设置动画的持续时间
                rotateAnimation.setDuration(200);
                // 运行动画
                imageView.startAnimation(rotateAnimation);
                currentDegree = -degree;
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}
