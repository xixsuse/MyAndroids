package com.j.ui.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;

import com.j.R;


/**
 * Created by Administrator on 2015/8/1.
 */
public class PopupWindowTest2 extends Activity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_window2);

        button = (Button) findViewById(R.id.popup_window2_button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = LayoutInflater.from(PopupWindowTest2.this);
                final View view = inflater.inflate(R.layout.popup_window2_item, null);
//                DisplayMetrics displayMetrics = new DisplayMetrics();
//                getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//                int width =  displayMetrics.widthPixels;
//                int height = displayMetrics.heightPixels - 100;
                final PopupWindow popupWindow = new PopupWindow(view,
                        WindowManager.LayoutParams.MATCH_PARENT,
                        WindowManager.LayoutParams.WRAP_CONTENT, true);
                Button button_commit = (Button) view.findViewById(R.id.popup_window2_button_commit);
                button_commit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText editText_username = (EditText) view.findViewById(R.id.popup_window2_username_editText);
                        editText_username.setText("username");
                        EditText editText_password = (EditText) view.findViewById(R.id.popup_window2_password_editText);
                        editText_password.setText("password");
                    }
                });
                Button button_cancel = (Button) view.findViewById(R.id.popup_window2_button_cancel);
                button_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });
                popupWindow.showAtLocation(PopupWindowTest2.this.findViewById(R.id.popup_window2_button1), Gravity.CENTER, 0, 0);
            }
        });
    }
}
