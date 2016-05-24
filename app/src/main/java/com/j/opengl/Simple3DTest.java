package com.j.opengl;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;


public class Simple3DTest extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 创建一个GLSurfaceView，用于显示OpenGL绘制的图形
        GLSurfaceView glSurfaceView = new GLSurfaceView(this);
        // 创建GLSurfaceView的内容绘制器
        Simple3DRenderer renderer = new Simple3DRenderer();
        // 为GLSurfaceView设置绘制器
        glSurfaceView.setRenderer(renderer);
        setContentView(glSurfaceView);
    }
}
