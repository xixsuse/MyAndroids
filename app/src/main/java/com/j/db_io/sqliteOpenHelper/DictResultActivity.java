package com.j.db_io.sqliteOpenHelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.j.R;

import java.util.List;
import java.util.Map;

public class DictResultActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dict_popup);

        ListView listView = (ListView) findViewById(R.id.dict_pop_show);
        Intent intent = getIntent();
        // 获取该intent所携带的数据
        Bundle bundle = intent.getExtras();
        // 从Bundle数据包中取出数据
        @SuppressWarnings("unchecked")
        List<Map<String, String>> list = (List<Map<String, String>>) bundle.getSerializable("bundle");
        // 将List封装成SimpleAdapter
        SimpleAdapter adapter = new SimpleAdapter(DictResultActivity.this
                , list
                , R.layout.dict_line, new String[]{"_id", "word", "detail"}
                , new int[]{R.id.dict_line_id, R.id.dict_line_word, R.id.dict_line_detail});
        // 填充ListView
        listView.setAdapter(adapter);
    }

}