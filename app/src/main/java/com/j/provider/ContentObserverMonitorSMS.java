package com.j.provider;

import android.app.Activity;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.j.R;

/**
 * Created by Administrator on 2015/8/24.
 */
public class ContentObserverMonitorSMS extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monitor_sms);

        getContentResolver().registerContentObserver(Uri.parse("content://sms"), true, new ContentObserver(new Handler()) {
            @Override
            public void onChange(boolean selfChange) {
//                super.onChange(selfChange);
                Cursor cursor = getContentResolver().query(Uri.parse("content://sms/outbox"), null, null, null, null);
                while (cursor.moveToNext()) {
                    StringBuilder sb = new StringBuilder();
//                    sb.append("address=").append(cursor.getString(cursor.getColumnIndex("addrsss")));
                    sb.append("; subjet=").append(cursor.getString(cursor.getColumnIndex("subject")));
                    sb.append("; body=").append(cursor.getString(cursor.getColumnIndex("body")));
                    sb.append("; date=").append(cursor.getString(cursor.getColumnIndex("date")));
                    Toast.makeText(ContentObserverMonitorSMS.this, sb.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
