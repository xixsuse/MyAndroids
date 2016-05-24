package com.j.intent;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.j.R;

/**
 * Created by Administrator on 2015/8/17.
 */
public class ActionCategoryAttrTest2 extends Activity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_category_attr2);

        textView = (TextView) findViewById(R.id.action_category_attr2_textView);
        textView.setText("action：\n" + getIntent().getAction()
                        + "\ncategory：\n" + getIntent().getCategories()
        );
    }
}
