package com.j.ui.actionBar;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.j.R;


/**
 * Created by Administrator on 2015/8/14.
 */
public class ActionBarTabTest extends Activity implements ActionBar.TabListener {
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_bar_tab);

        actionBar = getActionBar();
        //设置导航模式
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        actionBar.addTab(actionBar.newTab().setText("第一页").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("第二页").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("第三页").setTabListener(this));
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        Bundle bundle = new Bundle();
        bundle.putInt("section_number", tab.getPosition() + 1);
        Fragment fragment = new MyTabFragment();
        fragment.setArguments(bundle);
        getFragmentManager().beginTransaction()
                .replace(R.id.ActionBarTab_container, fragment)
                .commit();
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }


}
