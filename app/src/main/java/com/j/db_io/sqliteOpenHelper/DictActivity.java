package com.j.db_io.sqliteOpenHelper;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.j.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class DictActivity extends Activity {
    MySQLiteOpenHelper mySQLiteOpenHelper;
    SQLiteDatabase sqLiteDatabase;
    Button insertButton, searchButton, deleteButton;
    EditText wordEditText, detailEditText, _idEditText, keyEditText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dict_main);
        // 创建MyDatabaseHelper对象，指定数据库版本为1，此处使用相对路径即可
        // 数据库文件自动会保存在程序的数据文件夹的databases目录下
        mySQLiteOpenHelper = new MySQLiteOpenHelper(this, "myDict.db3", 1);
        sqLiteDatabase = mySQLiteOpenHelper.getReadableDatabase();

        insertButton = (Button) findViewById(R.id.dict_main_insert);
        searchButton = (Button) findViewById(R.id.dict_main_search);
        deleteButton = (Button) findViewById(R.id.dict_main_delete);
        wordEditText = (EditText) findViewById(R.id.dict_main_word);
        detailEditText = (EditText) findViewById(R.id.dict_main_detail);
        keyEditText = (EditText) findViewById(R.id.dict_main_key);
        _idEditText = (EditText) findViewById(R.id.dict_main_id);

        insertButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View source) {
                // 获取用户输入
                String word = wordEditText.getText().toString();
                String detail = detailEditText.getText().toString();
                // 插入生词记录
                insertData(sqLiteDatabase, word, detail);
                // 显示提示信息
                Toast.makeText(DictActivity.this, "添加生词成功！", Toast.LENGTH_LONG).show();
            }
        });

        deleteButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer _id = Integer.valueOf(_idEditText.getText().toString());
                deleteData(sqLiteDatabase, _id);
                Toast.makeText(DictActivity.this, "删除单词成功！", Toast.LENGTH_LONG).show();
                _idEditText.setText("");
            }
        });

        searchButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View source) {
                // 获取用户输入
                String key = keyEditText.getText().toString();
                // 执行查询
                Cursor cursor = mySQLiteOpenHelper.getReadableDatabase().rawQuery(
                        "select * from dict where word like ? or detail like ?",
                        new String[]{"%" + key + "%", "%" + key + "%"});
                // 创建一个Bundle对象
                Bundle data = new Bundle();
                data.putSerializable("data", convertCursorToList(cursor));
                // 创建一个Intent
                Intent intent = new Intent(DictActivity.this, DictResultActivity.class);
                intent.putExtras(data);

                // 启动Activity
                startActivity(intent);
            }
        });
    }

    //把cursor转换到list中
    protected ArrayList<Map<String, String>> convertCursorToList(Cursor cursor) {
        ArrayList<Map<String, String>> result = new ArrayList<>();
        // 遍历Cursor结果集
        while (cursor.moveToNext()) {
            // 将结果集中的数据存入ArrayList中
            Map<String, String> map = new HashMap<>();
            // 取出查询记录中第1、2、3列的值
            map.put("_id", cursor.getString(0));
            map.put("word", cursor.getString(1));
            map.put("detail", cursor.getString(2));
            result.add(map);
        }
        return result;
    }

    private void insertData(SQLiteDatabase db, String word, String detail) {
        // 执行插入语句
        db.execSQL("insert into dict values(null , ? , ?)", new String[]{word, detail});
    }

    private void deleteData(SQLiteDatabase sqLiteDatabase, Integer _id) {
        //执行删除语句
        sqLiteDatabase.execSQL("delete from dict where _id = ?", new Integer[]{_id});
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // 退出程序时关闭MyDatabaseHelper里的SQLiteDatabase
        if (mySQLiteOpenHelper != null) {
            mySQLiteOpenHelper.close();
        }
    }

}


