package com.j.fragment.news;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.j.R;

/**
 * Created by Administrator on 2015/9/10.
 */
public class NewsContentFragment extends Fragment {
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_content_fragment, container, false);
        return view;
    }

    public void refresh(String title, String content) {
        View visibility_layout = view.findViewById(R.id.visibility_layout);
        visibility_layout.setVisibility(View.VISIBLE);
        TextView titleTextView = (TextView) view.findViewById(R.id.NewsContentFragment_title);
        TextView contentTextView = (TextView) view.findViewById(R.id.NewsContentFragment_content);
        titleTextView.setText(title);
        contentTextView.setText(content);
    }

}
