package com.j.intent;

import android.app.Activity;
import android.content.ComponentName;
import android.os.Bundle;
import android.widget.TextView;

import com.j.R;

/**
 * Created by Administrator on 2015/8/17.
 */
public class ComponentAttrTest2 extends Activity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.component_attr2);

        ComponentName componentName = getIntent().getComponent();
        textView = (TextView) findViewById(R.id.component_attr2_textView);
        textView.setText("Component\nPackageName：" + componentName.getPackageName()
                        + "\nClassName：" + componentName.getClassName()
                        + "\nShortClassName：" + componentName.getShortClassName()
        );
    }

}
