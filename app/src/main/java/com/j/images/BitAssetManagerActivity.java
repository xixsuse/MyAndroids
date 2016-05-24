package com.j.images;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.j.R;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2015/7/27.
 */
public class BitAssetManagerActivity extends Activity {
    String[] images;
    int currentImg = 0;
    AssetManager assetManager;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bitmap_test_layout);

        imageView = (ImageView) findViewById(R.id.bitmapTest_imageView);
        assetManager = getAssets();
        try {
            images = assetManager.list("");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Button button_next = (Button) findViewById(R.id.bitmapTest_button_next);
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputStream inputStream = null;
                try {
                    inputStream = assetManager.open(images[currentImg++]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
//                BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
                imageView.setImageBitmap(BitmapFactory.decodeStream(inputStream));
            }
        });
    }
}
