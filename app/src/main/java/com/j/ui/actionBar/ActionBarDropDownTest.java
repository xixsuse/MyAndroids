package com.j.ui.actionBar;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.j.R;


/**
 * Created by Administrator on 2015/8/14.
 */
public class ActionBarDropDownTest extends Activity implements ActionBar.OnNavigationListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_bar_drop_down);

        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        actionBar.setListNavigationCallbacks(
                new ArrayAdapter<>(this
                        , android.R.layout.simple_list_item_1
                        , android.R.id.text1
                        , new String[]{"第一页", "第二页", "第三页"})
                , this
        );
    }

    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        Bundle args = new Bundle();
        args.putInt("section_number", itemPosition + 1);
        Fragment fragment = new MyDropDownFragment();
        fragment.setArguments(args);
        getFragmentManager().beginTransaction()
                .replace(R.id.ActionBarDropDown_container, fragment)
                .commit();
        return true;
    }
}
