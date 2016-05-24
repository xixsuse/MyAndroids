package com.j.ui.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.j.R;

import java.util.Date;

/**
 * Created by Administrator on 2015/7/31.
 */
public class AlertDialogTest2 extends Activity {
    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_dialog2);

        button1 = (Button) findViewById(R.id.alert_dialog2_button);
        button2 = (Button) findViewById(R.id.alert_dialog2_button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogTest2.this);
                builder.setIcon(R.drawable.ic_settings_applications);
                builder.setTitle("测试标题1");
                builder.setMessage(new Date().toString());
                builder.setPositiveButton("button1", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        setTitle("你点击了对话框上的button1");
                    }
                });
                builder.setNeutralButton("button2", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        setTitle("你点击了对话框上的button2");
                    }
                });

                builder.setNegativeButton("button3", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        setTitle("你点击了对话框上的button3");
                    }
                });
                builder.show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = LayoutInflater.from(AlertDialogTest2.this);
                View layout_view = inflater.inflate(R.layout.alert_dialog_button_layout, null);
//                final EditText editText = (EditText) findViewById(R.id.alert_dialog_editText);
                final EditText editText = (EditText) layout_view.findViewById(R.id.alert_dialog_editText);
                final AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogTest2.this);
                builder.setCancelable(false);
                builder.setIcon(R.drawable.ic_settings_applications);
                builder.setTitle("测试标题2");
                builder.setView(layout_view);
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        setTitle(editText.getText());
//                        setTitle("确认了");
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        setTitle("取消了");
                    }
                });
                builder.show();
            }
        });
    }
}
