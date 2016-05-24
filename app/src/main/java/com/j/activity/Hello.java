package com.j.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.j.R;


/**
 * Created by Administrator on 2015/7/30.
 */
public class Hello extends Activity {
    Button buttonDialog;
    Button buttonWriteEditText;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.hello_layout);

        buttonDialog = (Button) findViewById(R.id.hello_button_dialog);
        buttonWriteEditText = (Button) findViewById(R.id.hello_button_writeEditText);
        editText = (EditText) findViewById(R.id.hello_editText);

        buttonDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(Hello.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("information")
                        .setMessage(editText.getText())
                        .show();
            }
        });

        buttonWriteEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("你好！hello android！");
            }
        });
    }
}
