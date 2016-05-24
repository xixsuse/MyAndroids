package com.j.db_io.sqlite;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.j.R;

/**
 * Created by Administrator on 2015/8/19.
 */
public class SqliteTest extends Activity {
    //数据库对象
    SQLiteDatabase sqLiteDatabase;
    //保存执行结果
    Cursor cursor;

    EditText idEditText, titleEditText, contentEditText;
    Button insertButton, queryButton, deleteButton;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlite);

        idEditText = (EditText) findViewById(R.id.sqlite_id_editText);
        titleEditText = (EditText) findViewById(R.id.sqlite_title_editText);
        contentEditText = (EditText) findViewById(R.id.sqlite_content_editText);
        insertButton = (Button) findViewById(R.id.sqlite_insert_button);
        queryButton = (Button) findViewById(R.id.sqlite_query_button);
        deleteButton = (Button) findViewById(R.id.sqlite_delete_button);
        listView = (ListView) findViewById(R.id.sqlite_listview);

        //获取数据库对象
        sqLiteDatabase = SQLiteDatabase.openOrCreateDatabase(this.getFilesDir().toString() + "/jack.db3", null);
        //建表
        sqLiteDatabase.execSQL("create table if not exists news_info" +
                " (_id integer primary key autoincrement, title varchar(50), content varchar(255))");

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqLiteDatabase.execSQL("insert into news_info values(null, ?, ?)"
                        , new String[]{titleEditText.getText().toString(), contentEditText.getText().toString()});
                Toast.makeText(SqliteTest.this, "插入成功！", Toast.LENGTH_LONG).show();
                titleEditText.setText("");
                contentEditText.setText("");
                inflateListView();
            }
        });

        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflateListView();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idEditText.getText().toString();
                if (TextUtils.isEmpty(id)) {
                    Toast.makeText(SqliteTest.this, "请输入要删除的记录的id", Toast.LENGTH_SHORT).show();
                    return;
                }
                sqLiteDatabase.execSQL("delete from news_info where _id = ?"
                        , new Integer[]{Integer.valueOf(id)});
//                sqLiteDatabase.delete("news_info", "_id = ?", new String[]{idEditText.getText().toString()});
                Toast.makeText(SqliteTest.this, "如下记录被删除了：\nid:" + id, Toast.LENGTH_LONG).show();
                idEditText.setText("");
                inflateListView();
            }
        });

        inflateListView();
    }

    //显示表的数据列表
    private void inflateListView() {
        cursor = sqLiteDatabase.rawQuery("select * from news_info", null);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this
                , R.layout.sqlite_item
                , cursor
                , new String[]{"_id", "title", "content"}
                , new int[]{R.id.sqlite_item_id, R.id.sqlite_item_title, R.id.sqlite_item_content}
                , SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
        );
        listView.setAdapter(adapter);
    }
}
