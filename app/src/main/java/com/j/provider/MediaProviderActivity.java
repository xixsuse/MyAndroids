package com.j.provider;

import android.app.Activity;
import android.app.AlertDialog;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.j.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.provider.MediaStore.Images;

/**
 * Created by Administrator on 2015/8/4.
 */
public class MediaProviderActivity extends Activity {
    Button button_show;
    ListView listView;
    ArrayList<String> fullNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media_provider);

        button_show = (Button) findViewById(R.id.mediaProvider_button_show);
        listView = (ListView) findViewById(R.id.mediaProvider_listView);

        button_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = getContentResolver().query(Images.Media.EXTERNAL_CONTENT_URI,
                        null, null, null, null);
                List<HashMap<String, Object>> list = new ArrayList<>();
                while (cursor.moveToNext()) {
                    HashMap<String, Object> map = new HashMap<>();
                    String shortName = cursor.getString(cursor.getColumnIndex(Images.Media.DISPLAY_NAME));
                    String desc = cursor.getString(cursor.getColumnIndex(Images.Media.DESCRIPTION));
                    byte[] data = cursor.getBlob(cursor.getColumnIndex(Images.Media.DATA));
                    String fullName = new String(data, 0, data.length - 1);
//                    fullName = data.toString();
                    fullNames.add(fullName);
                    map.put("name", shortName);
                    map.put("desc", desc);
                    list.add(map);
                }

                SimpleAdapter adapter = new SimpleAdapter(MediaProviderActivity.this,
                        list, R.layout.media_provider_item,
                        new String[]{"name", "desc"},
                        new int[]{R.id.mediaProviderItem_name, R.id.mediaProviderItem_desc}
                );
                listView.setAdapter(adapter);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                View dialog = getLayoutInflater().inflate(R.layout.media_provider_dialog, null);
                ImageView imageView = (ImageView) dialog.findViewById(R.id.mediaProviderDialog_imageView);
                imageView.setImageBitmap(BitmapFactory.decodeFile(fullNames.get(position)));
//                imageView.setImageBitmap(BitmapFactory.decodeFile("/storage/sdcard1/DCIM/Camera/IMG_20140728_110748.jpg"));
//                imageView.setImageResource(R.drawable.car);
                new AlertDialog.Builder(MediaProviderActivity.this)
                        .setView(dialog).setPositiveButton("确定", null).show();
            }
        });
    }
}
