package com.j.ui.actionBar;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.j.R;


/**
 * Created by Administrator on 2015/8/14.
 */
public class ActionItemTest extends Activity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_item);

        textView = (TextView) findViewById(R.id.action_item_textView);
        registerForContextMenu(textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.action_bar_menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.isCheckable()) {
            item.setChecked(true);
        }
        switch (item.getItemId()) {
            case R.id.font_10:
                textView.setTextSize(10 * 2);
                break;
            case R.id.font_12:
                textView.setTextSize(12 * 2);
                break;
            case R.id.font_14:
                textView.setTextSize(14 * 2);
                break;
            case R.id.font_16:
                textView.setTextSize(16 * 2);
                break;
            case R.id.font_18:
                textView.setTextSize(18 * 2);
                break;
            case R.id.red_font:
                textView.setTextColor(Color.RED);
                break;
            case R.id.green_font:
                textView.setTextColor(Color.GREEN);
                break;
            case R.id.blue_font:
                textView.setTextColor(Color.BLUE);
                break;
            case R.id.plain_item:
                Toast.makeText(ActionItemTest.this, "您单击了普通菜单", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.action_bar_context, menu);
        menu.setHeaderIcon(R.drawable.tools);
        menu.setHeaderTitle("请选择背景色");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.isCheckable()) {
            item.setChecked(true);
        }
        switch (item.getItemId()) {
            case R.id.red:
                item.setChecked(true);
                textView.setBackgroundColor(Color.RED);
                break;
            case R.id.green:
                item.setChecked(true);
                textView.setBackgroundColor(Color.GREEN);
                break;
            case R.id.blue:
                item.setChecked(true);
                textView.setBackgroundColor(Color.BLUE);
                break;
        }
        return true;
    }
}
