package com.j.contacts;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.Photo;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.j.R;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

//public class ContactsActivity extends ListActivity {
public class ContactsActivity extends Activity {
    //联系人信息数组
    private static final String[] contactsInfo = new String[]{
            Phone.DISPLAY_NAME, Phone.NUMBER, Photo.PHOTO_ID, Phone.CONTACT_ID};
    //用户名
    private static final int DISPLAY_NAME_INDEX = 0;
    //手机号码
    private static final int PHONES_NUMBER_INDEX = 1;

    ListView listView = null;
    //用于arraylist和arrayadapter
    ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts_layout);

        listView = (ListView) findViewById(R.id.contacts_listView);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent_call = new Intent(Intent.ACTION_CALL,
                        Uri.parse("tel:" + arrayList.get(position).split(":")[1]));
                startActivity(intent_call);
            }
        });

        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(Phone.CONTENT_URI, contactsInfo, null, null, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                String displayName = cursor.getString(DISPLAY_NAME_INDEX);
                String phoneNumber = cursor.getString(PHONES_NUMBER_INDEX);
                if (TextUtils.isEmpty(phoneNumber)) {
                    continue;
                }
                arrayList.add(displayName + ":" + phoneNumber);
            }
            cursor.close();
        }
        //中文排序
        Comparator comparator = Collator.getInstance(Locale.CHINA);
        Collections.sort(arrayList, comparator);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.contacts_list_textview, arrayList);
        listView.setAdapter(adapter);
    }
}
