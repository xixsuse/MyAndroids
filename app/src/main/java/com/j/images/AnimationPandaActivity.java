package com.j.images;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.j.R;


/**
 * Created by Administrator on 2015/7/27.
 */
public class AnimationPandaActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_frame_panda_layout);

        Button paly = (Button) findViewById(R.id.button_play_panda);
        Button stop = (Button) findViewById(R.id.button_stop_panda);
        ImageView imageView = (ImageView) findViewById(R.id.imageView_panda);

        final AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
        paly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationDrawable.start();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationDrawable.stop();
            }
        });
    }

}
