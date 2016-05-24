package com.j.ui.listView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import com.j.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2015/8/11.
 */
public class GridView_SimpleAdapter1 extends Activity {
    GridView gridView;
    ImageView imageView;
    int[] images = new int[]{
            R.drawable.bomb5, R.drawable.bomb6, R.drawable.bomb7,
            R.drawable.bomb8, R.drawable.bomb9, R.drawable.bomb10,
            R.drawable.bomb11, R.drawable.bomb12, R.drawable.bomb13,
            R.drawable.bomb14, R.drawable.bomb15, R.drawable.bomb16
    };
    ArrayList<HashMap<String, Object>> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view1);

        gridView = (GridView) findViewById(R.id.gridView1);
        imageView = (ImageView) findViewById(R.id.gridView1_image);

        for (int i = 0; i < images.length; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("image", images[i]);
            list.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(this,
                list,
                R.layout.grid_view1_item,
                new String[]{"image"},
                new int[]{R.id.gridView1_item_image}
        );
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                imageView.setImageResource(images[position]);
            }
        });
    }
}
