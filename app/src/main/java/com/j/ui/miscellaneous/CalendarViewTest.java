package com.j.ui.miscellaneous;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

import com.j.R;


/**
 * Created by Administrator on 2015/8/12.
 */
public class CalendarViewTest extends Activity {
    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_view);

        calendarView = (CalendarView) findViewById(R.id.calendarView);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                String text = "您的生日是:" + year + "年" + ++month + "月" + dayOfMonth + "日";
                Toast.makeText(CalendarViewTest.this, text, Toast.LENGTH_LONG).show();
            }
        });

    }
}
