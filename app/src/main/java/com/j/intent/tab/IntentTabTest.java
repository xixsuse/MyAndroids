package com.j.intent.tab;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import com.j.R;

/**
 * Created by Administrator on 2015/8/17.
 */
public class IntentTabTest extends TabActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_tab);

        TabHost tabHost = getTabHost();

        tabHost.addTab(tabHost.newTabSpec("tab1")
                        .setIndicator("已接电话", getResources().getDrawable(R.drawable.ic_launcher))
                        .setContent(new Intent(this, BeCallActivity.class))
        );

        tabHost.addTab(tabHost.newTabSpec("tab2")
                        .setIndicator("呼出电话", getResources().getDrawable(R.drawable.ic_launcher))
                        .setContent(new Intent(this, CalledActivity.class))
        );

        tabHost.addTab(tabHost.newTabSpec("tab3")
                        .setIndicator("未接电话", getResources().getDrawable(R.drawable.ic_launcher))
                        .setContent(new Intent(this, NoCallActivity.class))
        );

    }
}
