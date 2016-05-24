package com.j.ui.listView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.j.R;


/**
 * Created by Administrator on 2015/8/9.
 */
public class ListView_ArrayAdapter extends Activity {
    ListView listView1;
    ListView listView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_array_adapter);

        listView1 = (ListView) findViewById(R.id.array_adapter_list_view1);
        listView2 = (ListView) findViewById(R.id.array_adapter_list_view2);
        String[] array1 = new String[]{"孙悟空", "猪八戒", "唐僧"};
        String[] array2 = new String[]{"java", "android", "studio"};

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,
                R.layout.list_view_array_adapter_array_item,
                R.id.array_adapter_list_view_checked_item,
                array1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this,
                R.layout.list_view_array_adapter_checked_item,
                R.id.array_adapter_list_view_checked_item,
                array2);

        listView1.setAdapter(adapter1);
        listView2.setAdapter(adapter2);
    }

}
