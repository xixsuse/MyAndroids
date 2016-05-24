package com.j.provider.dict;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.j.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/8/23.
 */
public class DictResolverResultActivity extends Activity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dict_resolver_popup);
        listView = (ListView) findViewById(R.id.dictResolver_listView);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        List<Map<String, String>> list = (List<Map<String, String>>) bundle.getSerializable("my_bundle");
        SimpleAdapter adapter = new SimpleAdapter(
                this
                , list
                , R.layout.dict_resolver_item
                , new String[]{Words.Word._ID, Words.Word.WORD, Words.Word.DETAIL}
                , new int[]{R.id.dictResolverItem_id, R.id.dictResolverItem_word, R.id.dictResolverItem_detail}
        );
        listView.setAdapter(adapter);
    }
}
