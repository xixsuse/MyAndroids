package com.j.ui.miscellaneous;

import android.app.Activity;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.j.R;


/**
 * Created by Administrator on 2015/8/13.
 */
public class NumberPickerTest extends Activity {
    NumberPicker numberPickerMin, numberPickerMax;
    TextView textViewMin, textViewMax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number_picker);

        numberPickerMin = (NumberPicker) findViewById(R.id.numberPickerMin);
        numberPickerMax = (NumberPicker) findViewById(R.id.numberPickerMax);
        textViewMin = (TextView) findViewById(R.id.numberPickerMinText);
        textViewMax = (TextView) findViewById(R.id.numberPickerMaxText);

        numberPickerMin.setMinValue(0);
        numberPickerMin.setMaxValue(50);
        numberPickerMin.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                textViewMin.setText("最低价：" + newVal);
            }
        });

        numberPickerMax.setMinValue(50);
        numberPickerMax.setMaxValue(100);
        numberPickerMax.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                textViewMax.setText("最高价：" + newVal);
            }
        });
    }
}
