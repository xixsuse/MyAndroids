package com.j.ui.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.j.R;


/**
 * Created by Administrator on 2015/8/10.
 */
public class LinearLayoutActivity extends Activity {
    Button buttonHorizontal;
    Button buttonVertical;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_layout);

        buttonHorizontal = (Button) findViewById(R.id.linearLayoutHorizontalButton);
        buttonVertical = (Button) findViewById(R.id.linearLayoutVerticalButton);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayoutOrientation);

        buttonHorizontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            }
        });
        buttonVertical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setOrientation(LinearLayout.VERTICAL);
            }
        });
    }
}
