package com.j.ui.miscellaneous;

import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.j.R;

import java.util.Calendar;

/**
 * Created by Administrator on 2015/8/13.
 */
public class DatePickerTimePicker extends Activity {
    TextView textView;
    Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH);
    int day = calendar.get(Calendar.DAY_OF_MONTH);
    int hour = calendar.get(Calendar.HOUR_OF_DAY);
    int minute = calendar.get(Calendar.MINUTE);
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_picker_time_picker);

        textView = (TextView) findViewById(R.id.date_time_picker_text);
        DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);

        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                DatePickerTimePicker.this.year = year;
                DatePickerTimePicker.this.month = monthOfYear;
                DatePickerTimePicker.this.day = dayOfMonth;
                showDateTime(year, month, day, hour, minute);
            }
        });

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                DatePickerTimePicker.this.hour = hourOfDay;
                DatePickerTimePicker.this.minute = minute;
                showDateTime(year, month, day, hour, minute);
            }
        });
    }

    public void showDateTime(int year, int month, int day, int hour, int minute) {
        text = "会议时间：" + year + "年" + ++month + "月" + day + "日" + hour + "时" + minute + "分";
        textView.setText(text);
    }
}
