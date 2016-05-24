package com.j.db_io.file;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.j.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by Administrator on 2015/8/18.
 */
public class FileTest extends Activity {
    String FILE_NAME = "file_test.xml";
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.file_test);

        editText = (EditText) findViewById(R.id.file_test_editText);
    }

    public void readFile(View view) {
        try {
            FileInputStream fileInputStream = openFileInput(FILE_NAME);
            byte[] buff = new byte[1024];
            int hasRead;
            StringBuilder stringBuilder = new StringBuilder("");
            while ((hasRead = fileInputStream.read(buff)) > 0) {
                stringBuilder.append(new String(buff, 0, hasRead));
            }
            fileInputStream.close();
            editText.setText(stringBuilder.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void appendFile(View view) {
        try {
            FileOutputStream fileOutputStream = openFileOutput(FILE_NAME, MODE_APPEND);
            PrintStream printStream = new PrintStream(fileOutputStream);
            printStream.println(editText.getText());
            editText.setText("");
            printStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteFile(View view) {
        deleteFile(FILE_NAME);
        editText.setText("");
    }
}
