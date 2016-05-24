package com.j.ui.imageView;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.j.R;


/**
 * Created by Administrator on 2015/8/11.
 */
public class ImageViewTest extends Activity {
    public static final int ALPHA_STEP = 20;
    public static final int ALPHA_MIN = 0;
    public static final int ALPHA_MAX = 255;
    Button plus;
    Button minus;
    Button next;
    ImageView imageView1;
    ImageView imageView2;
    int[] images = new int[]{
            R.drawable.lijiang,
            R.drawable.qiao,
            R.drawable.shuangta,
            R.drawable.shui,
            R.drawable.xiangbi
    };
    int currentImg = 2;
    int alpha = ALPHA_MAX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_view1);

        plus = (Button) findViewById(R.id.plus_alpha);
        minus = (Button) findViewById(R.id.minus_alpha);
        next = (Button) findViewById(R.id.next);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView1.setImageResource(images[++currentImg % images.length]);
            }
        });

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == plus) {
                    alpha += ALPHA_STEP;
                }
                if (v == minus) {
                    alpha -= ALPHA_STEP;
                }
                if (alpha < ALPHA_MIN) {
                    alpha = ALPHA_MIN;
                }
                if (alpha > ALPHA_MAX) {
                    alpha = ALPHA_MAX;
                }
                imageView1.setImageAlpha(alpha);
            }
        };

        plus.setOnClickListener(listener);
        minus.setOnClickListener(listener);

        imageView1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView1.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
                int bitmapWidth = bitmap.getWidth();
                int bitmapHeight = bitmap.getHeight();
                double scale = bitmapWidth / 320.0;
                int x = (int) (event.getX() * scale);
                int y = (int) (event.getY() * scale);
                if (x + 120 > bitmapWidth) {
                    x = bitmapWidth - 120;
                }
                if (y + 120 > bitmapHeight) {
                    y = bitmapHeight - 120;
                }
                imageView2.setImageBitmap(Bitmap.createBitmap(bitmap, x, y, 120, 120));
                imageView2.setImageAlpha(alpha);
                return false;
            }
        });
    }
}
