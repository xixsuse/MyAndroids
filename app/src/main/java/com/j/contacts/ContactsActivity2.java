package com.j.contacts;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.j.R;

import java.text.CollationKey;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

import static android.provider.ContactsContract.CommonDataKinds.Phone;
import static android.provider.ContactsContract.CommonDataKinds.Photo;

/**
 * Created by Administrator on 2015/7/21.
 */
public class ContactsActivity2 extends Activity {
    //联系人信息数组
    private static final String[] contactsInfo = new String[]{
            Phone.DISPLAY_NAME, Phone.NUMBER, Photo.PHOTO_ID, Phone.CONTACT_ID};
    //用户名
    private static final int DISPLAY_NAME_INDEX = 0;
    //手机号码
    private static final int PHONES_NUMBER_INDEX = 1;

    ListView listView = null;
    //用于simpleadapter
//    ArrayList<String> arrayList = new ArrayList<>();
    List<TreeMap<String, Object>> listItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts_layout);

        listView = (ListView) findViewById(R.id.contacts_listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent_call = new Intent(Intent.ACTION_CALL,
                        Uri.parse("tel:" + listItems.get(position).get("number").toString()));
                startActivity(intent_call);
            }
        });

        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(Phone.CONTENT_URI,
                contactsInfo, null, null, contactsInfo[0]);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String name = cursor.getString(DISPLAY_NAME_INDEX);
                String number = cursor.getString(PHONES_NUMBER_INDEX);
//                MyComparator myComparator = new MyComparator();
                TreeMap<String, Object> item = new TreeMap<>();
                item.put("avatar", R.drawable.contacts_tiger);
                item.put("name", name);
                item.put("number", number);
                listItems.add(item);
            }
            cursor.close();
        }

//        Comparator comparator = Collator.getInstance(Locale.CHINA);
//        Collections.sort(listItems, comparator);

        SimpleAdapter adapter = new SimpleAdapter(this, listItems,
                R.layout.contacts_simple_adapter_item,
                new String[]{"avatar", "name", "number"},
                new int[]{R.id.contacts_avatar, R.id.contacts_name, R.id.contacts_number});
        listView.setAdapter(adapter);
    }

    class MyComparator implements Comparator {
        //        Comparator comparator = Collator.getInstance(Locale.CHINA);
        Collator collator = Collator.getInstance(Locale.CHINA);

        @Override
        public int compare(Object lhs, Object rhs) {
            CollationKey key1 = collator.getCollationKey(((TreeMap<String, Object>) lhs).get("name").toString());
            CollationKey key2 = collator.getCollationKey(((TreeMap<String, Object>) rhs).get("name").toString());
            return key1.compareTo(key2);
        }
    }

}
