package com.j.ui.listView.extendsArrayAdapter.fruit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.j.R;

import java.util.List;

/**
 * Created by Administrator on 2015/9/9.
 */
public class FruitAdapter extends ArrayAdapter {
    private int resource;

    public FruitAdapter(Context context, int resource, List<Fruit> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit = (Fruit) getItem(position);
        View view;
        //ViewHolder用来缓存控件，避免多次findViewById
        ViewHolder viewHolder;
        //convertView 将之前加载好的layout进行缓存
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resource, null);
            viewHolder = new ViewHolder();
            viewHolder.image = (ImageView) view.findViewById(R.id.fruit_image);
            viewHolder.name = (TextView) view.findViewById(R.id.fruit_name);
            viewHolder.price = (TextView) view.findViewById(R.id.fruit_price);
            //将viewHolder存储在view中
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();

        }

        viewHolder.image.setImageResource(fruit.getImageId());
        viewHolder.name.setText(fruit.getName());
        viewHolder.price.setText(Double.toString(fruit.getPrice()));
        return view;
    }

    class ViewHolder {
        private ImageView image;
        private TextView name;
        private TextView price;
    }

}
