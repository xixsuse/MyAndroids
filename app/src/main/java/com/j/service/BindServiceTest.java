package com.j.service;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.j.R;

/**
 * Created by Administrator on 2015/8/24.
 */
public class BindServiceTest extends Activity {
    Button bind, unbind, status;
    BindService.MyBinder myBinder;

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            System.out.println("-- onServiceConnected --");
            myBinder = (BindService.MyBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            System.out.println("-- onServiceDisconnected --");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bind_service);

        bind = (Button) findViewById(R.id.bindService_bind);
        unbind = (Button) findViewById(R.id.bindService_unbind);
        status = (Button) findViewById(R.id.bindService_status);

        final Intent intent = new Intent();
        intent.setAction("com.j.service.BIND_SERVICE");

        bind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindService(intent, serviceConnection, Service.BIND_AUTO_CREATE);
            }
        });

        unbind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(serviceConnection);
            }
        });

        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BindServiceTest.this
                        , "service的conut为：" + myBinder.getCount(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
