package com.j.ui.hello;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.j.R;


/**
 * Created by Administrator on 2015/7/20.
 */
public class MixControlUIActivity extends Activity {
    int[] images = new int[]{
            R.drawable.mixview_ajax,
            R.drawable.mixview_html,
            R.drawable.mixview_java,
            R.drawable.mixview_javaee,
            R.drawable.mixview_swift
    };

    int currentImg = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mix_view);

        LinearLayout layout = (LinearLayout) findViewById(R.id.MixView_linearLayout);
        final ImageView imageView = new ImageView(this);
        layout.addView(imageView);
        imageView.setImageResource(images[currentImg]);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(images[++currentImg % images.length]);
            }
        });
    }
}
