package com.j.contacts;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import com.j.R;
import com.j.service.smsManager.SendSms;


/**
 * Created by Administrator on 2015/7/21.
 */
public class ContactsInAllActivity extends TabActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts_in_all_layout);

        TabHost tabHost = getTabHost();
        tabHost.addTab(tabHost.newTabSpec("tab1")
                .setIndicator("拨号")
                .setContent(new Intent(this, CallRecordActivity.class)));
        tabHost.addTab(tabHost.newTabSpec("tab2")
                .setIndicator("联系人")
                .setContent(new Intent(this, ContactsActivity2.class)));
        tabHost.addTab(tabHost.newTabSpec("tab3")
                .setIndicator("信息")
                .setContent(new Intent(this, SendSms.class)));

    }
}
