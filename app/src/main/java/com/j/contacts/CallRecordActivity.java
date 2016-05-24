package com.j.contacts;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.j.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by Administrator on 2015/7/21.
 */
public class CallRecordActivity extends Activity {
    ListView listView = null;
    //用于simpleadapter
    List<TreeMap<String, Object>> listItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_record_layout);

        listView = (ListView) findViewById(R.id.callRecord_listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent_call = new Intent(Intent.ACTION_CALL,
                        Uri.parse("tel:" + listItems.get(position).get("number").toString()));
                startActivity(intent_call);
            }
        });

        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(CallLog.Calls.CONTENT_URI,
                new String[]{CallLog.Calls.CACHED_NAME, CallLog.Calls.DATE, CallLog.Calls.NUMBER, CallLog.Calls.TYPE},
                null, null, CallLog.Calls.DEFAULT_SORT_ORDER);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String name = cursor.getString(0);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(Long.parseLong(cursor.getString(1)));
                String time = simpleDateFormat.format(date);
//                String time = cursor.getString(1);
                String number = cursor.getString(2);
                String type = getCallTypeName(cursor.getString(3)) + "  ";
                TreeMap<String, Object> item = new TreeMap<>();
                item.put("name", name);
                item.put("time", time);
                item.put("number", number);
                item.put("type", type);
                listItems.add(item);
            }
            cursor.close();
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems,
                R.layout.call_record_adapter_item,
                new String[]{"name", "time", "number", "type"},
                new int[]{R.id.call_name, R.id.call_time, R.id.call_number, R.id.call_type});
        listView.setAdapter(simpleAdapter);

    }

    String getCallTypeName(String type) {
        String typeName = "未知";
        switch (type) {
            case "1":
                typeName = "来电";
                break;
            case "2":
                typeName = "已拨";
                break;
            case "3":
                typeName = "未接";
                break;
            default:
                typeName = "未知";
                break;
        }
        return typeName;
    }

}
