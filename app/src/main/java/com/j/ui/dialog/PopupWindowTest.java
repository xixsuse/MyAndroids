package com.j.ui.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

import com.j.R;


/**
 * Created by Administrator on 2015/8/13.
 */
public class PopupWindowTest extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_window);

        View root = getLayoutInflater().inflate(R.layout.popup_window_show, null);
        final PopupWindow popupWindow = new PopupWindow(root, 400, 500);
        Button button = (Button) findViewById(R.id.popup_window_button_ok);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //popupWindow.showAsDropDown(v);
                popupWindow.showAtLocation(findViewById(R.id.popup_window_button_ok), Gravity.CENTER, 20, 20);
            }
        });

        root.findViewById(R.id.popup_window_show_button_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }
}
