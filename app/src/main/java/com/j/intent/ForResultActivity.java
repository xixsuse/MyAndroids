package com.j.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.j.R;


public class ForResultActivity extends Activity {
    TextView name;
    TextView phoneNumber;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.for_result_activity);

        phoneNumber = (TextView) findViewById(R.id.ForResult_PhoneNumber);
        name = (TextView) findViewById(R.id.ForResult_Name);
        button = (Button) findViewById(R.id.ForResult_Back);

        Intent intent_src = getIntent();
        Person person = (Person) intent_src.getSerializableExtra("person");
        phoneNumber.setText(person.getPhoneNumber());
        name.setText(intent_src.getStringExtra("name"));

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("data_return", "Hello IntentsTest");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return", "Hello IntentsTest onBackPressed");
        setResult(RESULT_OK, intent);
        finish();
    }
}
