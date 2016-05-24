package com.j.service.aidl;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.j.R;

import aidl.ICat;

/**
 * Created by Administrator on 2015/8/25.
 */
public class AIDLClient extends Activity {
    ICat iCat;
    Button get;
    EditText color, weight;

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iCat = ICat.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            iCat = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aidl_client);

        get = (Button) findViewById(R.id.aidlClient_get);
        color = (EditText) findViewById(R.id.aidlClient_color);
        weight = (EditText) findViewById(R.id.aidlClient_weight);

        Intent intent = new Intent();
        intent.setAction("com.j.service.aidl.AIDL_SERVICE");
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    color.setText("color: " + iCat.getColor());
                    weight.setText("weight: " + iCat.getWeight() + "");
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(serviceConnection);
    }
}
