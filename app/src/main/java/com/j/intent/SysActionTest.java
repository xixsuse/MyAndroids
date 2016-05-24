package com.j.intent;

import android.app.Activity;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.j.R;

/**
 * Created by Administrator on 2015/8/17.
 */
public class SysActionTest extends Activity {
    final int PICK_CONTACT = 0;
    TextView nameTextView, phoneTextView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sys_action);

        nameTextView = (TextView) findViewById(R.id.sys_action_name);
        phoneTextView = (TextView) findViewById(R.id.sys_action_phone);
        button = (Button) findViewById(R.id.sys_action_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("vnd.android.cursor.item/phone");
                startActivityForResult(intent, PICK_CONTACT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case PICK_CONTACT:
                if (requestCode == Activity.RESULT_OK) {
                    Uri uri = data.getData();
                    CursorLoader cursorLoader = new CursorLoader(this, uri, null, null, null, null);
                    Cursor cursor = cursorLoader.loadInBackground();
                    if (cursor.moveToFirst()) {
                        String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                        String name = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME));
                        String phoneNumber = "此联系人暂未输入电话号码";
                        Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI
                                , null
                                , ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + contactId
                                , null
                                , null
                        );
                        if (phones.moveToFirst()) {
                            phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        }
                        phones.close();

                        nameTextView.setText(name);
                        phoneTextView.setText(phoneNumber);
                    }
                    cursor.close();
                }
                break;
        }
    }
}
