package com.j.service.telephonyManager;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.j.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2015/8/5.
 */
public class TelephonyManagerTest extends Activity {
    ListView listView;
    ArrayList<HashMap<String, String>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telephony_manager);

        listView = (ListView) findViewById(R.id.telephony_manager_listView);
        list = new ArrayList<>();
        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        HashMap<String, String> map = new HashMap<>();
        map.put("name", "设备编号");
        map.put("value", tm.getDeviceId());
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("name", "sim卡的国别");
        map2.put("value", tm.getSimCountryIso());
        list.add(map);
        list.add(map2);
        SimpleAdapter adapter = new SimpleAdapter(TelephonyManagerTest.this,
                list,
                R.layout.telephony_manager_item,
                new String[]{"name", "value"},
                new int[]{R.id.telephony_manager_name, R.id.telephony_manager_value}
        );
        listView.setAdapter(adapter);
    }
}
