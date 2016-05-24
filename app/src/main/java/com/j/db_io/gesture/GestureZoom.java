package com.j.db_io.gesture;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

import com.j.R;

/**
 * Created by Administrator on 2015/8/21.
 */
public class GestureZoom extends Activity implements GestureDetector.OnGestureListener {
    final int imageId = R.drawable.gesture_zoom_flower;
    GestureDetector gestureDetector;
    ImageView imageView;
    Matrix matrix;
    Bitmap bitmap;
    int width, height;
    float currentScale = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gesture_zoom);

        gestureDetector = new GestureDetector(this, this);
        imageView = (ImageView) findViewById(R.id.gestureZoom_show);
        matrix = new Matrix();
        bitmap = BitmapFactory.decodeResource(getResources(), imageId);
        width = bitmap.getWidth();
        height = bitmap.getHeight();
        imageView.setImageBitmap(BitmapFactory.decodeResource(getResources(), imageId));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        velocityX = velocityX > 4000 ? 4000 : velocityX;
        velocityX = velocityX < -4000 ? -4000 : velocityX;
        currentScale += currentScale * velocityX / 4000.0f;
        currentScale = currentScale > 0.01 ? currentScale : 0.01f;
        matrix.reset();
        matrix.setScale(currentScale, currentScale, 160, 200);
        BitmapDrawable tmp = (BitmapDrawable) imageView.getDrawable();
        //如果图片还未回收，强制回收
        if (!tmp.getBitmap().isRecycled()) {
            tmp.getBitmap().recycle();
        }
        //根据原始位图和Matrix创建新图片
        Bitmap bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        imageView.setImageBitmap(bitmap2);
        return true;
    }
}
