package com.j.ui.textViews;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.j.R;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Administrator on 2015/8/8.
 */
public class RadioButton_CheckBox extends Activity {
    Button buttonMale;
    Button buttonFemale;
    TextView textViewGender;
    TextView textViewColors;
    RadioGroup radioGroup;
    String genderText;
    CheckBox checkBoxRed;
    CheckBox checkBoxBlue;
    CheckBox checkBoxGreen;
    ArrayList<String> colors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radiobutton_checkbox);

        buttonMale = (Button) findViewById(R.id.radiobutton_checkbox_male);
        buttonFemale = (Button) findViewById(R.id.radiobutton_checkbox_female);
        textViewGender = (TextView) findViewById(R.id.radiobutton_checkbox_gender);
        textViewColors = (TextView) findViewById(R.id.radiobutton_checkbox_colors);
        radioGroup = (RadioGroup) findViewById(R.id.radiobutton_checkbox_radioGroup);
        colors = new ArrayList<>();
        checkBoxRed = (CheckBox) findViewById(R.id.radiobutton_checkbox_red);
        checkBoxBlue = (CheckBox) findViewById(R.id.radiobutton_checkbox_blue);
        checkBoxGreen = (CheckBox) findViewById(R.id.radiobutton_checkbox_green);
        genderText = radioGroup.getCheckedRadioButtonId() == R.id.radiobutton_checkbox_male ? "男" : "女";
        textViewGender.setText(genderText);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                genderText = checkedId == R.id.radiobutton_checkbox_male ? "男" : "女";
                textViewGender.setText(genderText);
            }
        });

        colors.clear();
        if (checkBoxRed.isChecked()) {
            colors.add("红");
        }
        if (checkBoxBlue.isChecked()) {
            colors.add("蓝");
        }
        if (checkBoxGreen.isChecked()) {
            colors.add("绿");
        }
        Collections.sort(colors);
        textViewColors.setText(colors.toString());
        checkBoxRed.setOnCheckedChangeListener(new CheckBoxListener());
        checkBoxBlue.setOnCheckedChangeListener(new CheckBoxListener());
        checkBoxGreen.setOnCheckedChangeListener(new CheckBoxListener());
    }

    class CheckBoxListener implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()) {
                case R.id.radiobutton_checkbox_red:
                    if (isChecked) {
                        colors.add("红");
                    } else {
                        colors.remove("红");
                    }
                    break;
                case R.id.radiobutton_checkbox_blue:
                    if (isChecked) {
                        colors.add("蓝");
                    } else {
                        colors.remove("蓝");
                    }
                    break;
                case R.id.radiobutton_checkbox_green:
                    if (isChecked) {
                        colors.add("绿");
                    } else {
                        colors.remove("绿");
                    }
                    break;
                default:
                    break;
            }
            Collections.sort(colors);
            textViewColors.setText(colors.toString());
        }
    }

}
