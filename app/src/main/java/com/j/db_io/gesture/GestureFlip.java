package com.j.db_io.gesture;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.j.R;

/**
 * Created by Administrator on 2015/8/21.
 */
public class GestureFlip extends Activity implements GestureDetector.OnGestureListener {
    final int FLIP_DISTANCE = 50;
    GestureDetector gestureDetector;
    ViewFlipper viewFlipper;
    //定义动画数组，为viewFlipper指定动画切换效果
    Animation[] animations = new Animation[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gesture_flip);

        gestureDetector = new GestureDetector(this, this);
        viewFlipper = (ViewFlipper) findViewById(R.id.gestureFlip_viewFlipper);
        viewFlipper.addView(addImageView(R.drawable.java));
        viewFlipper.addView(addImageView(R.drawable.javaee));
        viewFlipper.addView(addImageView(R.drawable.ajax));
        viewFlipper.addView(addImageView(R.drawable.android));
        viewFlipper.addView(addImageView(R.drawable.html));
        viewFlipper.addView(addImageView(R.drawable.swift));
        animations[0] = AnimationUtils.loadAnimation(this, R.anim.left_in);
        animations[1] = AnimationUtils.loadAnimation(this, R.anim.left_out);
        animations[2] = AnimationUtils.loadAnimation(this, R.anim.right_in);
        animations[3] = AnimationUtils.loadAnimation(this, R.anim.right_out);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private View addImageView(int resId) {
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(resId);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        return imageView;
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
        //向左滑
        if (e1.getX() - e2.getX() > FLIP_DISTANCE) {
            viewFlipper.setInAnimation(animations[0]);
            viewFlipper.setOutAnimation(animations[1]);
            viewFlipper.showPrevious();
            return true;
        }
        //向右滑
        if (e2.getX() - e1.getX() > FLIP_DISTANCE) {
            viewFlipper.setInAnimation(animations[2]);
            viewFlipper.setOutAnimation(animations[3]);
            viewFlipper.showNext();
            return true;
        }
        return false;
    }
}
