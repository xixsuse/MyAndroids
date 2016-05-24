package com.j.activity;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;

import com.j.R;


/**
 * Created by Administrator on 2015/8/1.
 */
public class TabActivityTest extends TabActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_layout);

        TabHost tabs = getTabHost();

        TabHost.TabSpec tab1 = tabs.newTabSpec("tab1");
        tab1.setIndicator("标签1");
        tab1.setContent(R.id.tab1);
        tabs.addTab(tab1);
        final EditText editText1 = (EditText) findViewById(R.id.tab_editText1);
        Button button1 = (Button) findViewById(R.id.tab_button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setText("tab1");
            }
        });

        TabHost.TabSpec tab2 = tabs.newTabSpec("tab2");
        tab2.setIndicator("标签2");
        tab2.setContent(R.id.tab2);
        tabs.addTab(tab2);
        final EditText editText2 = (EditText) findViewById(R.id.tab_editText2);
        Button button2 = (Button) findViewById(R.id.tab_button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText2.setText("tab2");
            }
        });

        tabs.setCurrentTab(0);
    }
}
