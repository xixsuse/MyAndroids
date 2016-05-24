package com.j.ui.layout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.j.R;


/**
 * Created by Administrator on 2015/7/30.
 */
public class TableLayoutActivity2 extends Activity {
    TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_layout2);

        tableLayout = (TableLayout) findViewById(R.id.tableLayout2);

        for (int i = 1; i < 10; i++) {
            TableRow tableRow = new TableRow(this);
            tableLayout.addView(tableRow);
            for (int j = 1; j <= i; j++) {
                TextView textView = new TextView(this);
                textView.setText("{" + j + "*" + i + "=" + j * i + "}");
                tableRow.addView(textView);
            }
        }
    }
}
