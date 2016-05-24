package com.j.images;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2015/7/27.
 */
public class CanvasView extends View {

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        int viewWidth = getWidth();
        canvas.drawCircle(viewWidth / 10 + 10, viewWidth / 10 + 10, viewWidth / 10, paint);
        canvas.drawRect(10, viewWidth / 5 + 20, viewWidth / 5 + 10, viewWidth * 2 / 5 + 10, paint);
        canvas.drawRect(10, viewWidth * 2 / 5 + 30, viewWidth / 5 + 10, viewWidth / 2 + 30, paint);
        Path path1 = new Path();
        path1.moveTo(10, viewWidth / 9 * 10 + 60);
        path1.lineTo(viewWidth / 5 + 10, viewWidth * 9 / 10 + 60);
        path1.lineTo(viewWidth / 10 + 10, viewWidth * 7 / 10 + 60);
        path1.close();
        canvas.drawPath(path1, paint);
    }
}
