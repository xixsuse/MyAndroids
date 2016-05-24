package com.j.ui.layout;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.widget.Button;
import android.widget.GridLayout;

import com.j.R;


/**
 * Created by Administrator on 2015/7/20.
 */
public class GridLayoutActivity extends Activity {
    GridLayout layout;
    String[] chars = new String[]{
            "7", "8", "9", "/",
            "4", "5", "6", "X",
            "1", "2", "3", "-",
            ".", "0", "=", "+"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_layout);
        layout = (GridLayout) findViewById(R.id.grid_layout_root);

        //计算button的宽度
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int button_width = metrics.widthPixels / 4;

        for (int i = 0; i < chars.length; i++) {
            Button button = new Button(this);
            button.setText(chars[i]);
            button.setTextSize(40);
            button.setWidth(button_width);
//            button.setBackgroundColor(Color.BLUE);
//            button.setPadding(5 , 35 , 5 , 35);
            GridLayout.Spec rowSpec = GridLayout.spec(i / 4 + 2);
            GridLayout.Spec columnSpec = GridLayout.spec(i % 4);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpec, columnSpec);
            params.setGravity(Gravity.FILL);
            layout.addView(button, params);
        }
    }
}
