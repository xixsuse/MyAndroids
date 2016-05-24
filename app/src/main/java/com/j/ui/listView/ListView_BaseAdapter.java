package com.j.ui.listView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.j.R;


/**
 * Created by Administrator on 2015/7/31.
 */
public class ListView_BaseAdapter extends Activity {
    ListView listView;
    int count = 30;
    String[] titles = new String[count];
    String[] contents = new String[count];
    int[] resIds = new int[count];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_base_adapter);

        for (int i = 0; i < count; i++) {
            titles[i] = "title" + i;
            contents[i] = "contents" + i;
            resIds[i] = R.drawable.ic_settings_display;
        }

        listView = (ListView) findViewById(R.id.baseAdapterListView);
        listView.setAdapter(new ListViewAdapter(titles, contents, resIds));
    }

    class ListViewAdapter extends BaseAdapter {
        View[] itemViews;

        public ListViewAdapter(String[] the_titles, String[] the_contents, int[] the_resIds) {
            itemViews = new View[count];
            for (int i = 0; i < count; i++) {
                itemViews[i] = makeItemView(the_titles[i], the_contents[i], the_resIds[i]);
            }
        }

        View makeItemView(String the_title, String the_content, int the_resId) {
            LayoutInflater inflater = (LayoutInflater) ListView_BaseAdapter.this
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View itemView = inflater.inflate(R.layout.list_view_base_adapter_item, null);
            TextView title = (TextView) itemView.findViewById(R.id.list_view_base_adapter_title);
            TextView content = (TextView) itemView.findViewById(R.id.list_view_base_adapter_content);
            ImageView imageView = (ImageView) itemView.findViewById(R.id.list_view_base_adapter_image);
            title.setText(the_title);
            content.setText(the_content);
            imageView.setImageResource(the_resId);
            return itemView;
        }

        @Override
        public int getCount() {
            return itemViews.length;
        }

        @Override
        public Object getItem(int position) {
            return itemViews[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                return itemViews[position];
            }
            return convertView;
        }
    }

}
