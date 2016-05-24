package com.j.ui.listView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.j.R;


/**
 * Created by Administrator on 2015/8/11.
 */
public class SpinnerTest extends Activity {
    Spinner spinner;
    String[] arrays = new String[]{"林蕴诗", "刘佳莹", "刘佳慧"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner);

        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_multiple_choice,
                arrays
        );

        spinner.setAdapter(adapter);
    }
}
