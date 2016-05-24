package com.j.ui.hello;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Date;

/**
 * Created by Administrator on 2015/7/19.
 */
public class PureJavaUIActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        setContentView(layout);

        layout.setOrientation(LinearLayout.VERTICAL);
        final TextView textView = new TextView(this);
        textView.setText("测试。。。");
        Button button = new Button(this);
        button.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        button.setText("单击我");
        layout.addView(textView);
        layout.addView(button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(new Date() + "\n杨跃明爱林蕴诗！");
            }
        });
    }
}
