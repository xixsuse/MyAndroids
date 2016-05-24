package com.j.db_io.file;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.j.R;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2015/8/18.
 */
public class SDFileExplorer extends Activity {
    //保存sd卡的根目录
    String ROOT_DIR;
    //当前目录
    File currentDir;
    //当前目录下的所有文件和子文件夹
    File[] currentFiles;
    //临时目录下的所有文件和子文件夹
    File[] tmpFiles;

    TextView currentDirTextView;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sd_file_explorer);

        currentDirTextView = (TextView) findViewById(R.id.sd_file_explorer_textView);
        listView = (ListView) findViewById(R.id.sd_file_explorer_listView);

        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            currentDir = Environment.getExternalStorageDirectory();
            currentFiles = currentDir.listFiles();
            inflateListView(currentFiles);

            //保存sd卡的根目录
            try {
                ROOT_DIR = currentDir.getCanonicalPath();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (currentFiles[position].isFile()) {
                    return;
                }
                tmpFiles = currentFiles[position].listFiles();
                if (tmpFiles == null || tmpFiles.length == 0) {
                    Toast.makeText(SDFileExplorer.this, "当前路径不可用或目录下没有文件", Toast.LENGTH_SHORT).show();
                } else {
                    currentDir = currentFiles[position];
                    currentFiles = tmpFiles;
                    inflateListView(currentFiles);
                }
            }
        });
    }

    public void inflateListView(File[] files) {
        ArrayList<HashMap<String, Object>> list = new ArrayList<>();
        for (File file : files) {
            HashMap<String, Object> hashMap = new HashMap<>();
            if (file.isDirectory()) {
                hashMap.put("icon", R.drawable.folder);
            } else {
                hashMap.put("icon", R.drawable.file);
            }
            hashMap.put("fileName", file.getName());
            list.add(hashMap);
        }
        SimpleAdapter adapter = new SimpleAdapter(this
                , list
                , R.layout.sd_file_explorer_item
                , new String[]{"icon", "fileName"}
                , new int[]{R.id.sd_file_explorer_item_icon, R.id.sd_file_explorer_item_fileName}
        );
        listView.setAdapter(adapter);
        try {
            currentDirTextView.setText(currentDir.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void toParentDir(View view) {
        try {
            if (!currentDir.getCanonicalPath().equals(ROOT_DIR)) {
                currentDir = currentDir.getParentFile();
                currentFiles = currentDir.listFiles();
                inflateListView(currentFiles);
            } else {
                Toast.makeText(this, "已经到了根目录！", Toast.LENGTH_SHORT).show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
