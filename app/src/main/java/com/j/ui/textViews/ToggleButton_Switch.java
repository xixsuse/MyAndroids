package com.j.ui.textViews;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.ToggleButton;

import com.j.R;


/**
 * Created by Administrator on 2015/8/10.
 */
public class ToggleButton_Switch extends Activity {
    ToggleButton toggleButton;
    LinearLayout toggleButtonLinearLayout;
    Switch switchButton;
    LinearLayout switchLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toggle_button_switch);

        toggleButton = (ToggleButton) findViewById(R.id.toggleButton1);
        toggleButtonLinearLayout = (LinearLayout) findViewById(R.id.toggleButton_linearLayout);
        switchButton = (Switch) findViewById(R.id.switch1);
        switchLinearLayout = (LinearLayout) findViewById(R.id.switch_linearLayout);

        if (toggleButton.isChecked()) {
            toggleButtonLinearLayout.setOrientation(LinearLayout.VERTICAL);
        } else {
            toggleButtonLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        }

        if (switchButton.isChecked()) {
            switchLinearLayout.setOrientation(LinearLayout.VERTICAL);
        } else {
            switchLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        }

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toggleButtonLinearLayout.setOrientation(LinearLayout.VERTICAL);
                } else {
                    toggleButtonLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
                }
            }
        });

        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    switchLinearLayout.setOrientation(LinearLayout.VERTICAL);
                } else {
                    switchLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
                }
            }
        });
    }
}
