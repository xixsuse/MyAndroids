package com.j.db_io.sharedPreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.j.R;

/**
 * Created by Administrator on 2015/8/18.
 */
public class SharedPreferencesActivity extends Activity {
    Button read, write;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shared_preferences);

        sharedPreferences = getSharedPreferences("test1", MODE_WORLD_READABLE);
        editor = sharedPreferences.edit();
        read = (Button) findViewById(R.id.shared_preferences_read);
        write = (Button) findViewById(R.id.shared_preferences_write);

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = sharedPreferences.getString("name", null);
                int age = sharedPreferences.getInt("age", 0);
                Toast.makeText(SharedPreferencesActivity.this, name + ":" + age, Toast.LENGTH_SHORT).show();
            }
        });

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("name", "jack");
                editor.putInt("age", (int) (Math.random() * 100));
                editor.commit();
            }
        });
    }
}
