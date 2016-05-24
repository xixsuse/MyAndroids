package com.j.db_io.file;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;

import com.j.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

/**
 * Created by Administrator on 2015/8/18.
 */
public class SdFileTest extends Activity {
    File SD_CARD_DIR;
    String FILE_NAME = "/crazyit.txt";
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sd_file);

        editText = (EditText) findViewById(R.id.sd_file_editText);
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            SD_CARD_DIR = Environment.getExternalStorageDirectory();
        }
    }

    public void readSdFile(View view) {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            try {
                FileInputStream fileInputStream = new FileInputStream(SD_CARD_DIR.getCanonicalPath() + FILE_NAME);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                StringBuilder stringBuilder = new StringBuilder("");
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                bufferedReader.close();
                editText.setText(stringBuilder.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeSdFile(View view) {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            try {
                File file = new File(SD_CARD_DIR.getCanonicalPath() + FILE_NAME);
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(file.length());
                randomAccessFile.write(editText.getText().toString().getBytes());
                randomAccessFile.close();
                editText.setText("");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
