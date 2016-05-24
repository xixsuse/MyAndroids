package com.j.ui.viewAnimator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.ViewSwitcher;

import com.j.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2015/8/12.
 */
public class ImageSwitcherTest extends Activity {
    GridView gridView;
    ImageSwitcher imageSwitcher;
    int[] images = new int[]{
            R.drawable.bomb5, R.drawable.bomb6, R.drawable.bomb7, R.drawable.bomb8,
            R.drawable.bomb9, R.drawable.bomb10, R.drawable.bomb11, R.drawable.bomb12,
            R.drawable.bomb13, R.drawable.bomb14, R.drawable.bomb15, R.drawable.bomb16,
    };
    ArrayList<HashMap<String, Object>> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_switcher);
        gridView = (GridView) findViewById(R.id.imageSwitcher_gridView);
        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        arrayList = new ArrayList<>();

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(ImageSwitcherTest.this);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ImageSwitcher.LayoutParams.MATCH_PARENT
                        , ImageSwitcher.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        });

        for (int image : images) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("image", image);
            arrayList.add(hashMap);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this
                , arrayList
                , R.layout.image_switcher_item
                , new String[]{"image"}
                , new int[]{R.id.imageSwitcher_item_image}
        );
        gridView.setAdapter(simpleAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                imageSwitcher.setImageResource(images[position]);
            }
        });
    }
}
