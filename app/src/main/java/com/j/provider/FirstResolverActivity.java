package com.j.provider;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.j.R;

/**
 * Created by Administrator on 2015/8/22.
 */
public class FirstResolverActivity extends Activity {
    ContentResolver resolver;
    Uri uri = Uri.parse("content://com.j.provider.FirstProvider/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_resolver);
        resolver = getContentResolver();
    }

    public void resolver_query(View view) {
        Cursor cursor = resolver.query(uri, null, "query_where", null, null);
        Toast.makeText(this, "远程ContentProvider返回的Cursor为：" + cursor, Toast.LENGTH_SHORT).show();
    }

    public void resolver_insert(View view) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", "9527");
        Uri new_uri = resolver.insert(uri, contentValues);
        Toast.makeText(this, "远程ContentProvider返回的insert()返回值为：" + new_uri, Toast.LENGTH_SHORT).show();
    }

    public void resolver_update(View view) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", "9528");
        int count = resolver.update(uri, contentValues, "update_where", null);
        Toast.makeText(this, "远程ContentProvider返回的更新记录数为：" + count, Toast.LENGTH_SHORT).show();
    }

    public void resolver_delete(View view) {
        int count = resolver.delete(uri, "query_where", null);
        Toast.makeText(this, "远程ContentProvider返回的删除记录数为：" + count, Toast.LENGTH_SHORT).show();
    }

}
