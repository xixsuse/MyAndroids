package com.j.provider.dict;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.j.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2015/8/23.
 */
public class DictResolverActivity extends Activity {
    ContentResolver contentResolver;
    Button insertButton, searchButton;
    EditText wordEditText, detailEditText, keyEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dict_resolver_main);
        contentResolver = getContentResolver();

        insertButton = (Button) findViewById(R.id.dictResolver_insert);
        searchButton = (Button) findViewById(R.id.dictResolver_search);
        wordEditText = (EditText) findViewById(R.id.dictResolver_word);
        detailEditText = (EditText) findViewById(R.id.dictResolver_detail);
        keyEditText = (EditText) findViewById(R.id.dictResolver_key);

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word = wordEditText.getText().toString();
                String detail = detailEditText.getText().toString();
                ContentValues contentValues = new ContentValues();
                contentValues.put("word", word);
                contentValues.put("detail", detail);
                contentResolver.insert(Words.Word.DICT_CONTENT_URI, contentValues);
                Toast.makeText(DictResolverActivity.this, "添加单词成功！", Toast.LENGTH_SHORT).show();
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = keyEditText.getText().toString();
                Cursor cursor = contentResolver.query(Words.Word.DICT_CONTENT_URI, null
                        , "word like ? or detail like ?"
                        , new String[]{"%" + key + "%", "%" + key + "%"}
                        , null);
                Bundle bundle = new Bundle();
                bundle.putSerializable("my_bundle", convertCursorToList(cursor));
                Intent intent = new Intent(DictResolverActivity.this, DictResolverResultActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    private ArrayList<HashMap<String, String>> convertCursorToList(Cursor cursor) {
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        while (cursor.moveToFirst()) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(Words.Word._ID, cursor.getString(0));
            hashMap.put(Words.Word.WORD, cursor.getString(1));
            hashMap.put(Words.Word.DETAIL, cursor.getString(2));
            arrayList.add(hashMap);
        }
        return arrayList;
    }

}
