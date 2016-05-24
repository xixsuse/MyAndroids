package com.j.ui.imageView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.QuickContactBadge;

import com.j.R;


/**
 * Created by Administrator on 2015/8/11.
 */
public class QuickContactBadgeTest extends Activity {
    QuickContactBadge badge;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quick_contact_badge);

        badge = (QuickContactBadge) findViewById(R.id.quickContactBadge);
        editText = (EditText) findViewById(R.id.quickContactBadge_text);
        badge.assignContactFromPhone(String.valueOf(editText.getText()), false);
//        badge.assignContactFromPhone("13922992186", false);
    }
}
