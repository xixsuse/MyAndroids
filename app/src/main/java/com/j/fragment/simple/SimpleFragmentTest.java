package com.j.fragment.simple;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.j.R;

/**
 * Created by Administrator on 2015/9/10.
 */
public class SimpleFragmentTest extends Activity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_fragment_main);
        button = (Button) findViewById(R.id.SimpleFragmentLeft_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnotherRightFragment fragment = new AnotherRightFragment();
                getFragmentManager().beginTransaction()
                        .replace(R.id.SimpleFragmentRightContainer, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}
