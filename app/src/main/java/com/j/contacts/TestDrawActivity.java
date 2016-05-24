package com.j.contacts;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.j.R;


/**
 * Created by Administrator on 2015/8/1.
 */
public class TestDrawActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.test_draw_layout);

        final ImageView imageView = (ImageView) findViewById(R.id.test_draw_image1);
        Button button0 = (Button) findViewById(R.id.test_draw_button0);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.car);
            }
        });
        Button button1 = (Button) findViewById(R.id.test_draw_button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_settings_applications);
                imageView.setImageBitmap(bitmap);
            }
        });
        Button button2 = (Button) findViewById(R.id.test_draw_button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap_image = BitmapFactory.decodeResource(getResources(), R.drawable.ic_settings_display);
                Bitmap bitmap_canvas = Bitmap.createBitmap(300, 300, Bitmap.Config.ARGB_8888);

                Canvas canvas2 = new Canvas(bitmap_canvas);
                Paint paint2 = new Paint();
                canvas2.drawText("写字。。。", 50, 50, paint2);
                canvas2.drawBitmap(bitmap_image, 60, 60, paint2);
                imageView.setImageBitmap(bitmap_canvas);
            }
        });
        final Button button3 = (Button) findViewById(R.id.test_draw_button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap3 = Bitmap.createBitmap(button3.getWidth(), button3.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas3 = new Canvas(bitmap3);
                Paint paint3 = new Paint();
                paint3.setTextSize(40);
                paint3.setColor(Color.RED);
                canvas3.drawText("写字。。。", 30, 30, paint3);
                Drawable drawable3 = new BitmapDrawable(getResources(), bitmap3);
                button3.setBackground(drawable3);
            }
        });
    }
}
