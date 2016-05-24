package com.j.fragment.news;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.j.R;

import java.util.List;

/**
 * Created by Administrator on 2015/9/10.
 */
public class NewsAdapter extends ArrayAdapter {
    int resourceId;

    public NewsAdapter(Activity context, int resource, List objects) {
        super(context, resource, objects);
        this.resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        News news = (News) getItem(position);
        View view;
        if (convertView != null) {
            view = convertView;
        } else {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        }
        TextView textView = (TextView) view.findViewById(R.id.NewsItem_title);
        textView.setText(news.getTitle());
        return view;
    }
}
