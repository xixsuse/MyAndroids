package com.j.ui.actionBar;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.j.R;


/**
 * Created by Administrator on 2015/8/14.
 */
public class ActionBarTest extends Activity {
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_bar);

        actionBar = getActionBar();
    }

    public void showActionBar(View view) {
        actionBar.show();
    }

    public void hideActionBar(View view) {
        actionBar.hide();
    }


}
