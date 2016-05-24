package com.j.ui.miscellaneous;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

import com.j.R;


/**
 * Created by Administrator on 2015/8/13.
 */
public class TabHostTest extends TabActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_host);

        TabHost tabHost = getTabHost();
        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("tab1")
                .setIndicator("通话记录")
                .setContent(R.id.tabHost_tab1);
        tabHost.addTab(tabSpec1);

        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("tab2")
                .setIndicator("联系人")
                .setContent(R.id.tabHost_tab2);
        tabHost.addTab(tabSpec2);

        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("tab3")
                .setIndicator("信息")
                .setContent(R.id.tabHost_tab3);
        tabHost.addTab(tabSpec3);
    }
}
