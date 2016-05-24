package com.j.provider;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.j.R;

import java.util.ArrayList;

import static android.provider.ContactsContract.CommonDataKinds.Email;
import static android.provider.ContactsContract.CommonDataKinds.Phone;
import static android.provider.ContactsContract.CommonDataKinds.StructuredName;
import static android.provider.ContactsContract.Contacts;
import static android.provider.ContactsContract.Data;
import static android.provider.ContactsContract.RawContacts;

/**
 * Created by Administrator on 2015/8/23.
 */
public class ContactProviderActivity extends Activity {
    Button searchButton, addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_provider_main);

        searchButton = (Button) findViewById(R.id.contactProvider_search);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ArrayList<String> names = new ArrayList<>();
                final ArrayList<ArrayList<String>> details = new ArrayList<>();
                Cursor cursor = getContentResolver().query(Contacts.CONTENT_URI, null, null, null, null);
                while (cursor.moveToNext()) {
                    String contactId = cursor.getString(cursor.getColumnIndex(Contacts._ID));
                    String name = cursor.getString(cursor.getColumnIndex(Contacts.DISPLAY_NAME));
                    names.add(name);

                    Cursor phones = getContentResolver().query(Phone.CONTENT_URI,
                            null,
                            Phone.CONTACT_ID + "=" + contactId,
                            null,
                            null
                    );
                    ArrayList<String> detail = new ArrayList<>();
                    while (phones.moveToNext()) {
                        String phoneNumber = phones.getString(phones.getColumnIndex(Phone.NUMBER));
                        detail.add("电话号码：" + phoneNumber);
                    }
                    phones.close();

                    Cursor emails = getContentResolver().query(Email.CONTENT_URI,
                            null,
                            Email.CONTACT_ID + "=" + contactId,
                            null,
                            null
                    );
                    while (emails.moveToNext()) {
                        String email = emails.getColumnName(emails.getColumnIndex(Email.DATA));
                        detail.add("邮箱地址：" + email);
                    }
                    emails.close();
                    details.add(detail);
                }
                cursor.close();

                View resultDialog = getLayoutInflater().inflate(R.layout.contact_provider_result, null);
                ExpandableListView expandableListView = (ExpandableListView) resultDialog.findViewById(R.id.contactProvider_expandableListView);
                ExpandableListAdapter adapter = new BaseExpandableListAdapter() {
                    @Override
                    public int getGroupCount() {
                        return names.size();
                    }

                    @Override
                    public int getChildrenCount(int groupPosition) {
                        return details.get(groupPosition).size();
                    }

                    @Override
                    public Object getGroup(int groupPosition) {
                        return names.get(groupPosition);
                    }

                    @Override
                    public Object getChild(int groupPosition, int childPosition) {
                        return details.get(groupPosition).get(childPosition);
                    }

                    @Override
                    public long getGroupId(int groupPosition) {
                        return groupPosition;
                    }

                    @Override
                    public long getChildId(int groupPosition, int childPosition) {
                        return childPosition;
                    }

                    @Override
                    public boolean hasStableIds() {
                        return true;
                    }

                    @Override
                    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                        TextView textView = getTextView();
                        textView.setText(getGroup(groupPosition).toString());
                        return textView;
                    }

                    @Override
                    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                        TextView textView = getTextView();
                        textView.setText(getChild(groupPosition, childPosition).toString());
                        return textView;
                    }

                    @Override
                    public boolean isChildSelectable(int groupPosition, int childPosition) {
                        return true;
                    }

                    private TextView getTextView() {
                        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                                , ViewGroup.LayoutParams.WRAP_CONTENT);
                        TextView textView = new TextView(ContactProviderActivity.this);
                        textView.setLayoutParams(layoutParams);
                        textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
                        textView.setPadding(36, 0, 0, 0);
                        textView.setTextSize(20);
                        return textView;
                    }

                };

                expandableListView.setAdapter(adapter);
                new AlertDialog.Builder(ContactProviderActivity.this)
                        .setView(resultDialog)
                        .setPositiveButton("确定", null)
                        .show();
            }
        });

        addButton = (Button) findViewById(R.id.contactProvider_add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ((EditText) findViewById(R.id.contactProvider_name)).getText().toString();
                String phone = ((EditText) findViewById(R.id.contactProvider_phone)).getText().toString();
                String email = ((EditText) findViewById(R.id.contactProvider_email)).getText().toString();
                ContentValues contentValues = new ContentValues();
                Uri rawContactUri = getContentResolver().insert(RawContacts.CONTENT_URI, contentValues);
                long rawContactId = ContentUris.parseId(rawContactUri);

                contentValues.clear();
                contentValues.put(Data.RAW_CONTACT_ID, rawContactId);
                contentValues.put(Data.MIMETYPE, StructuredName.CONTENT_ITEM_TYPE);
                contentValues.put(StructuredName.GIVEN_NAME, name);
                getContentResolver().insert(Data.CONTENT_URI, contentValues);

                contentValues.clear();
                contentValues.put(RawContacts.Data.RAW_CONTACT_ID, rawContactId);
                contentValues.put(RawContacts.Data.MIMETYPE, Phone.CONTENT_ITEM_TYPE);
                contentValues.put(Phone.NUMBER, phone);
                contentValues.put(Phone.TYPE, Phone.TYPE_MOBILE);
                getContentResolver().insert(Data.CONTENT_URI, contentValues);

                contentValues.clear();
                contentValues.put(RawContacts.Data.RAW_CONTACT_ID, rawContactId);
                contentValues.put(RawContacts.Data.MIMETYPE, Email.CONTENT_ITEM_TYPE);
                contentValues.put(Email.DATA, email);
                getContentResolver().insert(Data.CONTENT_URI, contentValues);

                Toast.makeText(ContactProviderActivity.this, "添加联系人成功！", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
