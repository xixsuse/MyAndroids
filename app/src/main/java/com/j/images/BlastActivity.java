package com.j.images;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.j.R;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2015/7/28.
 */
public class BlastActivity extends Activity {
    BlastView blastView;
    AnimationDrawable animationDrawable;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout frameLayout = new FrameLayout(this);
        setContentView(frameLayout);

        frameLayout.setBackgroundResource(R.drawable.back);
        mediaPlayer = MediaPlayer.create(this, R.raw.bomb);
        blastView = new BlastView(this);
        blastView.setBackgroundResource(R.drawable.blast);
        blastView.setVisibility(View.INVISIBLE);
        animationDrawable = (AnimationDrawable) blastView.getBackground();
        frameLayout.addView(blastView);

        frameLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    animationDrawable.stop();
                    int x = (int) event.getX();
                    int y = (int) event.getY();
                    blastView.setLocate(x - 20, y - 40);
                    blastView.setVisibility(View.VISIBLE);
                    animationDrawable.start();
                    mediaPlayer.start();
                }
                return false;
            }
        });
    }

    class BlastView extends ImageView {
        public BlastView(Context context) {
            super(context);
        }

        public void setLocate(int left, int top) {
            this.setFrame(left, top, left + 40, top + 40);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            try {
                Field field = AnimationDrawable.class.getDeclaredField("mCurFrame");
                field.setAccessible(true);
                int curFrame = field.getInt(animationDrawable);
                if (curFrame == animationDrawable.getNumberOfFrames() - 1) {
                    setVisibility(INVISIBLE);
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
            super.onDraw(canvas);
        }
    }
}
