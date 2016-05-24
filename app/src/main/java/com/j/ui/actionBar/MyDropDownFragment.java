package com.j.ui.actionBar;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/8/14.
 */
public class MyDropDownFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setGravity(Gravity.CENTER);
        Bundle args = getArguments();
        textView.setText(args.getInt("section_number") + "");
        textView.setTextSize(20);
        textView.setTextColor(Color.RED);
        return textView;
    }
}
