package com.j.db_io.sharedPreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.j.R;

/**
 * Created by Administrator on 2015/8/17.
 */
public class UseCountActivity extends Activity {
    SharedPreferences preferences;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.use_count);

        preferences = getSharedPreferences("count", MODE_WORLD_READABLE);
        count = preferences.getInt("count", 0);
        Toast.makeText(this, "本程序使用了：" + count + "次", Toast.LENGTH_LONG).show();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("count", ++count);
        editor.commit();
    }
}
