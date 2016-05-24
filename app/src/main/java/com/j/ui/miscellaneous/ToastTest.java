package com.j.ui.miscellaneous;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.j.R;


/**
 * Created by Administrator on 2015/8/12.
 */
public class ToastTest extends Activity {
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toast);

        button1 = (Button) findViewById(R.id.toast_button1);
        button2 = (Button) findViewById(R.id.toast_button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ToastTest.this, "简单的提示信息", Toast.LENGTH_SHORT).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = new Toast(ToastTest.this);
                LinearLayout linearLayout = new LinearLayout(ToastTest.this);
                ImageView imageView = new ImageView(ToastTest.this);
                imageView.setImageResource(R.drawable.tools);
                TextView textView = new TextView(ToastTest.this);
                textView.setText("带图片的提示信息");
                textView.setTextSize(20);
                textView.setTextColor(Color.MAGENTA);
                linearLayout.addView(imageView);
                linearLayout.addView(textView);
                toast.setView(linearLayout);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}
