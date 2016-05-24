package com.j.sensor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import com.j.R;


public class GradienterView extends View {
    // 定义水平仪仪表盘图片
    Bitmap background;
    // 定义水平仪中的气泡图标
    Bitmap bubble;
    // 定义水平仪中气泡的X、Y坐标
    int bubbleX, bubbleY;

    public GradienterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // 获取窗口管理器
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        // 获取屏幕的宽度和高度
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int screenWidth = metrics.widthPixels;
        int half = screenWidth / 2;
        // 创建位图
        background = Bitmap.createBitmap(screenWidth, screenWidth, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(background);

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        // 设置绘制风格：仅填充
        paint.setStyle(Paint.Style.FILL);
        // 创建一个线性渐变来绘制线性渐变
        Shader shader = new LinearGradient(0, screenWidth
                , screenWidth * 0.8f, screenWidth * 0.2f,
                Color.YELLOW, Color.WHITE, Shader.TileMode.MIRROR);
        paint.setShader(shader);
        // 绘制圆形
        canvas.drawCircle(half, half, half, paint);

        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        // 设置绘制风格：仅绘制边框
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(5);  // 设置画笔宽度
        paint2.setColor(Color.BLACK); // 设置画笔颜色
        // 绘制圆形边框
        canvas.drawCircle(half, half, half, paint2);
        // 绘制水平横线
        canvas.drawLine(0, half, screenWidth, half, paint2);
        // 绘制垂直横线
        canvas.drawLine(half, 0, half, screenWidth, paint2);
        paint2.setStrokeWidth(10);  // 设置画笔宽度
        // 设置画笔颜色
        paint2.setColor(Color.RED);
        // 绘制中心的红色“十”字
        canvas.drawLine(half - 30, half, half + 30, half, paint2);
        canvas.drawLine(half, half - 30, half, half + 30, paint2);

        // 加载气泡图片
        bubble = BitmapFactory.decodeResource(getResources(), R.drawable.bubble);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 绘制水平仪表盘图片
        canvas.drawBitmap(background, 0, 0, null);
        // 根据气泡坐标绘制气泡
        canvas.drawBitmap(bubble, bubbleX, bubbleY, null);
    }
}

