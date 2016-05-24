package com.j.intent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.j.R;

/**
 * Created by Administrator on 2015/8/17.
 */
public class ActionDataTest extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_data);
    }

    public void openWebSite_ActionData(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.baidu.com"));
        startActivity(intent);
    }

    public void openContact_ActionData(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_EDIT);
        intent.setData(Uri.parse("content://com.android.contacts/contacts/1"));
        startActivity(intent);
    }

    public void openCall_ActionData(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:13800138000"));
        startActivity(intent);
    }

}
