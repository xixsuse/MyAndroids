package com.j.ui.listView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.j.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2015/7/31.
 */
public class GridView_SimpleAdapter2 extends Activity {
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view2);

        gridView = (GridView) findViewById(R.id.gridView2);

        ArrayList<HashMap<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("ItemImage", R.drawable.ic_settings_display);
            map.put("ItemText", "text" + i);
            list.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(this,
                list,
                R.layout.grid_view2_item,
                new String[]{"ItemImage", "ItemText"},
                new int[]{R.id.gridView2_item_imageView, R.id.gridView2_item_textView}
        );
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String, Object> item = (HashMap<String, Object>) parent.getItemAtPosition(position);
                setTitle((CharSequence) item.get("ItemText"));
            }
        });


    }
}
