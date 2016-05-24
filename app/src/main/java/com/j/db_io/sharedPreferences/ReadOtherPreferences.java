package com.j.db_io.sharedPreferences;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import com.j.R;

/**
 * Created by Administrator on 2015/8/18.
 */
public class ReadOtherPreferences extends Activity {
    Context useCount;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_other_preferences);

        try {
            useCount = createPackageContext("com.j", CONTEXT_IGNORE_SECURITY);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        preferences = useCount.getSharedPreferences("count", MODE_WORLD_READABLE);
        Toast.makeText(this, "UseCount程序使用了：" + preferences.getInt("count", 0) + "次"
                , Toast.LENGTH_SHORT).show();
    }
}
