package com.j.ui.dialog;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.j.R;

import java.util.Calendar;

/**
 * Created by Administrator on 2015/8/14.
 */
public class DateTimePickerDialog extends Activity {
    Button datePicker, timePicker;
    TextView show;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_time_picker_dialog);

        datePicker = (Button) findViewById(R.id.datePickerDialogButton);
        timePicker = (Button) findViewById(R.id.timePickerDialogButton);
        show = (TextView) findViewById(R.id.dateTimePickerDialog_show);
        calendar = Calendar.getInstance();

        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(
                        DateTimePickerDialog.this
                        , new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        show.setText("您选择了" + year + "年" + ++monthOfYear + "月" + dayOfMonth + "日");
                    }
                }
                        , calendar.get(Calendar.YEAR)
                        , calendar.get(Calendar.MONTH)
                        , calendar.get(Calendar.DAY_OF_MONTH)
                ).show();
            }
        });

        timePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(
                        DateTimePickerDialog.this
                        , new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        show.setText("您选择了" + hourOfDay + "时" + minute + "分");
                    }
                }
                        , calendar.get(Calendar.HOUR_OF_DAY)
                        , calendar.get(Calendar.MINUTE)
                        , true
                ).show();
            }
        });
    }
}
