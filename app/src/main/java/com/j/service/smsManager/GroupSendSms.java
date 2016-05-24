package com.j.service.smsManager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.SmsManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.j.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/8/26.
 */
public class GroupSendSms extends Activity {
    SmsManager smsManager;
    Cursor cursor;
    ArrayList<String> sendList = new ArrayList<>();
    Button send, select;
    EditText addrs, content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_send_sms);
        smsManager = SmsManager.getDefault();

        send = (Button) findViewById(R.id.groupSendSms_send);
        select = (Button) findViewById(R.id.groupSendSms_select);
        addrs = (EditText) findViewById(R.id.groupSendSms_addrs);
        content = (EditText) findViewById(R.id.groupSendSms_content);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (String addr : sendList) {
                    PendingIntent intent = PendingIntent.getActivity(GroupSendSms.this, 0, new Intent(), 0);
                    smsManager.sendTextMessage(addr, null, content.getText().toString(), intent, null);
                }
                Toast.makeText(GroupSendSms.this, "短信群发成功！", Toast.LENGTH_LONG).show();
            }
        });

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
                View selectView = getLayoutInflater().inflate(R.layout.group_send_sms_select, null);
                final ListView listView = (ListView) selectView.findViewById(R.id.groupSendSms_listView);
                listView.setAdapter(new BaseAdapter() {
                    @Override
                    public int getCount() {
                        return cursor.getCount();
                    }

                    @Override
                    public Object getItem(int position) {
                        return cursor.moveToPosition(position);
                    }

                    @Override
                    public long getItemId(int position) {
                        return position;
                    }

                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        cursor.moveToPosition(position);
                        CheckBox checkBox = new CheckBox(GroupSendSms.this);
                        String addr = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                                .replace("-", "").replace(" ", "");
                        checkBox.setText(addr);
                        if (isSelected(addr)) {
                            checkBox.setChecked(true);
                        }
                        return checkBox;
                    }
                });
                new AlertDialog.Builder(GroupSendSms.this)
                        .setView(selectView)
                        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                sendList.clear();
                                for (int i = 0; i < listView.getCount(); i++) {
                                    CheckBox checkBox = (CheckBox) listView.getChildAt(i);
                                    if (checkBox.isChecked()) {
                                        sendList.add(checkBox.getText().toString());
                                    }
                                }
                                addrs.setText(sendList.toString());
                            }
                        })
                        .show();
            }
        });

    }

    public boolean isSelected(String addr) {
        for (String s : sendList) {
            if (s.equals(addr)) {
                return true;
            }
        }
        return false;
    }
}
