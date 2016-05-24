package com.j.ui.listView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.j.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2015/7/30.
 */
public class ListView_SimpleAdapter extends Activity {
    int count = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_simple_adapter);

        ListView listView = (ListView) findViewById(R.id.simpleAdapterListView);

        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("ItemTitle", "this is title " + i);
            hashMap.put("ItemContent", "this is content " + i);
            list.add(hashMap);
        }
        SimpleAdapter adapter = new SimpleAdapter(this,
                list,
                R.layout.list_view_simple_adapter_item,
                new String[]{"ItemTitle", "ItemContent"},
                new int[]{R.id.list_view_simple_adapter_title, R.id.list_view_simple_adapter_content});

        listView.setAdapter(adapter);
    }

}
