package com.j.ui.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.j.R;


/**
 * Created by Administrator on 2015/8/13.
 */
public class DialogThemeTest extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_theme);

        Button button = (Button) findViewById(R.id.dialog_theme_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogThemeTest.this.finish();
            }
        });
    }
}
