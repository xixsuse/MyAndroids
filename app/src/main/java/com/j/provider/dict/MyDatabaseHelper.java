package com.j.provider.dict;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2015/8/23.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {
    final String CREATE_TABLE_SQL = "create table dict (_id integer primary key autoincrement, word, detail)";

    public MyDatabaseHelper(Context context, String name, int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("onUpgrade called:" + oldVersion + "---->" + newVersion);
    }
}
