package com.j.provider.dict;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

/**
 * Created by Administrator on 2015/8/22.
 */
public class DictProvider extends ContentProvider {
    private final static int WORDS = 1;
    private final static int WORD = 2;
    private static UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        uriMatcher.addURI(Words.AUTHORITY, "words", WORDS);
        uriMatcher.addURI(Words.AUTHORITY, "word/#", WORD);
    }

    private MyDatabaseHelper myDatabaseHelper;
    private SQLiteDatabase db;

    @Override
    public boolean onCreate() {
        myDatabaseHelper = new MyDatabaseHelper(this.getContext(), "mydict.db3", 1);
        db = myDatabaseHelper.getReadableDatabase();
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        switch (uriMatcher.match(uri)) {
            case WORDS:
                return db.query("dict", projection, selection, selectionArgs, null, null, sortOrder);
            case WORD:
                long id = ContentUris.parseId(uri);
                String whereClause = Words.Word._ID + "=" + id;
                if (selection != null || !"".equals(selection)) {
                    whereClause = whereClause + " and " + selection;
                }
                return db.query("dict", projection, whereClause, selectionArgs, null, null, sortOrder);
            default:
                throw new IllegalArgumentException("未知的Uri" + uri);
        }
    }

    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)) {
            case WORDS:
                return "vnd.android.cursor.dir/com.j.dict";
            case WORD:
                return "vnd.android.cursor.item/com.j.dict";
            default:
                throw new IllegalArgumentException("未知Uri:" + uri);
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        switch (uriMatcher.match(uri)) {
            case WORDS:
                long rowId = db.insert("dict", Words.Word._ID, values);
                if (rowId > 0) {
                    Uri wordUri = ContentUris.withAppendedId(uri, rowId);
                    getContext().getContentResolver().notifyChange(wordUri, null);
                    return wordUri;
                }
                break;
            default:
                throw new IllegalArgumentException("未知Uri:" + uri);
        }
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int num = 0;
        switch (uriMatcher.match(uri)) {
            case WORDS:
                num = db.delete("dict", selection, selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("未知Uri:" + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return num;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        int num = 0;
        switch (uriMatcher.match(uri)) {
            case WORDS:
                num = db.update("dict", values, selection, selectionArgs);
                break;
            case WORD:
                long id = ContentUris.parseId(uri);
                String whereClause = Words.Word._ID + "=" + id;
                if (selection != null && !"".equals(selection)) {
                    whereClause = whereClause + " and " + selection;
                }
                num = db.update("dict", values, whereClause, selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("未知Uri:" + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return num;
    }
}
