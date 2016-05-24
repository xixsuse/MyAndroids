package com.j.ui.listView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.j.R;


/**
 * Created by Administrator on 2015/8/12.
 */
public class AdapterViewFlipperTest extends Activity {
    AdapterViewFlipper flipper;
    int[] images = new int[]{
            R.drawable.shuangzi, R.drawable.shuangyu,
            R.drawable.chunv, R.drawable.tiancheng, R.drawable.tianxie,
            R.drawable.sheshou, R.drawable.juxie, R.drawable.shuiping,
            R.drawable.shizi, R.drawable.baiyang, R.drawable.jinniu,
            R.drawable.mojie
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adapter_view_flipper);
        flipper = (android.widget.AdapterViewFlipper) findViewById(R.id.adapterViewFlipper);
        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return images.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageView = new ImageView(AdapterViewFlipperTest.this);
                imageView.setImageResource(images[position]);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        };
        flipper.setAdapter(adapter);
    }

    public void previous(View view) {
        flipper.stopFlipping();
        flipper.showPrevious();
    }

    public void next(View view) {
        flipper.stopFlipping();
        flipper.showNext();
    }

    public void auto(View view) {
        flipper.startFlipping();
    }

}
