package com.j.intent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.j.R;


public class IntentsTest extends Activity {
    EditText phoneNumber;
    EditText name;
    Button intentButton;
    Button pendingButton;
    Button sysActionButton;
    Button forResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intents);

        phoneNumber = (EditText) findViewById(R.id.Intents_PhoneNumber);
        name = (EditText) findViewById(R.id.Intents_Name);

        intentButton = (Button) findViewById(R.id.Intents_intent);
        pendingButton = (Button) findViewById(R.id.Intents_pending);
        sysActionButton = (Button) findViewById(R.id.Intents_sysAction);
        forResult = (Button) findViewById(R.id.Intents_forResult);

        //显式Intent打开Activity
        intentButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntentsTest.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        //PendingIntent打开Activity
        pendingButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.j.intent.SECOND_ACTIVITY");
                startActivity(intent);
            }
        });

        //PendingIntent打开系统服务
        sysActionButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });

        //startActivityForResult
        forResult.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person = new Person();
                person.setPhoneNumber(phoneNumber.getText().toString());
                Bundle bundle = new Bundle();
                bundle.putSerializable("person", person);

                Intent intent = new Intent(IntentsTest.this, ForResultActivity.class);
                //封装简单数据
                intent.putExtra("name", name.getText().toString());
                //封装对象数据
                intent.putExtras(bundle);

                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    Toast.makeText(IntentsTest.this, data.getStringExtra("data_return"), Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }
}
