package com.j.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

/**
 * Created by Administrator on 2015/8/22.
 */
public class FirstProvider extends ContentProvider {
    @Override
    public boolean onCreate() {
        System.out.println("=== onCreate()被调用 ===");
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        System.out.println(uri + "=== query()被调用 ===");
        System.out.println("selection参数为：" + selection);
        return null;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        System.out.println(uri + "=== insert()被调用 ===");
        System.out.println("values参数为：" + values);
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        System.out.println(uri + "=== delete()被调用 ===");
        System.out.println("selection参数为：" + selection);
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        System.out.println(uri + "=== update()被调用 ===");
        System.out.println("values参数为：" + values);
        System.out.println("selection参数为：" + selection);
        return 0;
    }
}
