package com.j.ui.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TableLayout;
import android.widget.TextView;

import com.j.R;


/**
 * Created by Administrator on 2015/8/13.
 */
public class AlertDialogTest extends Activity {
    TextView textView;
    String[] items = new String[]{"林蕴诗", "杨瑞一", "刘佳莹", "刘佳慧"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_dialog);

        textView = (TextView) findViewById(R.id.alertDialogTextView);
    }

    public void simpleDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("简单对话框")
                .setIcon(R.drawable.ic_launcher)
                .setMessage("对话框的测试内容\n 第三方");
        setPositiveButton(builder);
        setNegativeButton(builder);
        builder.create().show();
    }

    public void simpleListDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("简单列表对话框")
                .setIcon(R.drawable.ic_launcher)
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        textView.setText("您点击了《" + items[which] + "》");
                    }
                });
        setPositiveButton(builder);
        setNegativeButton(builder);
        builder.create().show();
    }

    public void singleChoiceDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("单选列表项对话框")
                .setIcon(R.drawable.ic_launcher)
                .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        textView.setText("您单击了《" + items[which] + "》");
                    }
                });
        setPositiveButton(builder);
        setNegativeButton(builder);
        builder.create().show();
    }

    public void multiChoiceDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("多选列表项对话框")
                .setIcon(R.drawable.ic_launcher)
                .setMultiChoiceItems(items, new boolean[]{false, true, false, true}, null);
        setPositiveButton(builder);
        setNegativeButton(builder);
        builder.create().show();
    }

    public void customListDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("自定义列表项对话框")
                .setIcon(R.drawable.ic_launcher)
                .setAdapter(new ArrayAdapter<>(this, R.layout.alert_dialog_array_item, items), null);
        setPositiveButton(builder);
        setNegativeButton(builder);
        builder.create().show();
    }

    public void customViewDialog(View view) {
        TableLayout layout = (TableLayout) getLayoutInflater().inflate(R.layout.alert_dialog_login, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("自定义view对话框")
                .setIcon(R.drawable.ic_launcher)
                .setView(layout);
        setPositiveButton(builder);
        setNegativeButton(builder);
        builder.create().show();
    }


    public AlertDialog.Builder setPositiveButton(AlertDialog.Builder builder) {
        return builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                textView.setText("单击了【确定】按钮");
            }
        });
    }

    public AlertDialog.Builder setNegativeButton(AlertDialog.Builder builder) {
        return builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                textView.setText("单击了【取消】按钮");
            }
        });
    }


}
