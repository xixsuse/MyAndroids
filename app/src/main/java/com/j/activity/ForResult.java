package com.j.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.j.R;

public class ForResult extends Activity {
    Button button;
    EditText city;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_result);

        button = (Button) findViewById(R.id.bn);
        city = (EditText) findViewById(R.id.city);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View source) {
                Intent intent = new Intent(ForResult.this, SelectCityActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    // 重写该方法，该方法以回调的方式来获取指定Activity返回的结果
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        // 当requestCode、resultCode同时为0时，也就是处理特定的结果
        if (requestCode == 0 && resultCode == 0) {
            Bundle bundle = intent.getExtras();
            String resultCity = bundle.getString("city");
            city.setText(resultCity);
        }
    }
}

