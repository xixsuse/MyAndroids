package com.j.contacts;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.j.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2015/7/22.
 */
public class SmsRecordActivity extends Activity {
    ListView listView = null;
    List<HashMap<String, Object>> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sms_record_layout);

        listView = (ListView) findViewById(R.id.smsRecord_listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(Telephony.Sms.CONTENT_URI,
                new String[]{},
                null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {

            }
            cursor.close();
        }

        SimpleAdapter adapter = new SimpleAdapter(this, list,
                R.layout.sms_record_adapter_item,
                new String[]{"name", "number", "time", "content"},
                new int[]{R.id.sms_name, R.id.sms_number, R.id.sms_time, R.id.sms_content});

        listView.setAdapter(adapter);

    }
}
