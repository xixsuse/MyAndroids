package com.j.service.alarmManager;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.j.R;

import java.util.Calendar;

/**
 * Created by Administrator on 2015/8/26.
 */
public class AlarmTest extends Activity {
    Calendar calendar = Calendar.getInstance();
    AlarmManager alarmManager;
    Button alarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_manager);
        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        alarm = (Button) findViewById(R.id.alarmManager_alarm);
        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(AlarmTest.this, 0, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Intent intent = new Intent(AlarmTest.this, AlarmActivity.class);
                        PendingIntent pendingIntent = PendingIntent.getActivity(AlarmTest.this, 0, intent, 0);
                        Calendar calendar2 = Calendar.getInstance();
                        calendar2.setTimeInMillis(System.currentTimeMillis());
                        calendar2.set(Calendar.HOUR, hourOfDay);
                        calendar2.set(Calendar.MINUTE, minute);
                        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar2.getTimeInMillis(), pendingIntent);
                        Toast.makeText(AlarmTest.this, "闹钟设置成功啦", Toast.LENGTH_LONG).show();

                    }
                }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false)
                        .show();
            }
        });
    }
}
