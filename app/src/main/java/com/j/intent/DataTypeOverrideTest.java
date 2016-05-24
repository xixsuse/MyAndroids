package com.j.intent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.j.R;

/**
 * Created by Administrator on 2015/8/17.
 */
public class DataTypeOverrideTest extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_type_override);
    }

    public void overrideType(View view) {
        Intent intent = new Intent();
        intent.setType("abc/xyz");
        intent.setData(Uri.parse("lee:www.fkjava.org:8888/test"));
        Toast.makeText(this, intent.toString(), Toast.LENGTH_LONG).show();
    }

    public void overrideData(View view) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("lee:www.fkjava.org:8888/test"));
        intent.setType("abc/xyz");
        Toast.makeText(this, intent.toString(), Toast.LENGTH_LONG).show();
    }

    public void DataAndType(View view) {
        Intent intent = new Intent();
        intent.setDataAndType(Uri.parse("lee:www.fkjava.org:8888/test"), "abc/xyz");
        Toast.makeText(this, intent.toString(), Toast.LENGTH_LONG).show();
    }

}
