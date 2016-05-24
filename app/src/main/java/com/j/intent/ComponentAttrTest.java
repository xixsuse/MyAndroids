package com.j.intent;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.j.R;

/**
 * Created by Administrator on 2015/8/17.
 */
public class ComponentAttrTest extends Activity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.component_attr);
        button = (Button) findViewById(R.id.component_attr_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComponentName componentName = new ComponentName(ComponentAttrTest.this
                        , ComponentAttrTest2.class);
                Intent intent = new Intent();
                intent.setComponent(componentName);

                //上面三行等同如下语句：
                Intent intent1 = new Intent(ComponentAttrTest.this, ComponentAttrTest2.class);

                startActivity(intent);
            }
        });

    }

}
