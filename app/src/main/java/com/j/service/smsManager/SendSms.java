package com.j.service.smsManager;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.j.R;


public class SendSms extends Activity {
    SmsManager smsManager;
    EditText phoneNumber;
    EditText content;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sms);
        smsManager = SmsManager.getDefault();

        phoneNumber = (EditText) findViewById(R.id.sms_phoneNumber);
        content = (EditText) findViewById(R.id.sms_content);
        send = (Button) findViewById(R.id.sms_send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PendingIntent pendingIntent = PendingIntent.getActivity(SendSms.this,
                        0, new Intent(), 0);
                smsManager.sendTextMessage(phoneNumber.getText().toString()
                        , null, content.getText().toString(), pendingIntent, null);
                Toast.makeText(SendSms.this, "疯狂的短信发送完成", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
