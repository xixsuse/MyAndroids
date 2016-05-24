package com.j.ui.listView.extendsArrayAdapter.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.j.R;

import java.util.List;

/**
 * Created by Administrator on 2015/9/9.
 */
public class MsgAdapter extends ArrayAdapter {
    private int resourceId;

    public MsgAdapter(Context context, int resource, List<Msg> objects) {
        super(context, resource, objects);
        this.resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        Msg msg = (Msg) getItem(position);
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder = new ViewHolder();
            viewHolder.leftLayout = (LinearLayout) view.findViewById(R.id.msgItem_leftLayout);
            viewHolder.rightLayout = (LinearLayout) view.findViewById(R.id.msgItem_rightLayout);
            viewHolder.leftMsg = (TextView) view.findViewById(R.id.msgItem_leftMsg);
            viewHolder.rightMsg = (TextView) view.findViewById(R.id.msgItem_rightMsg);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        if (msg.getType() == Msg.TYPE_RECEIVED) {
            viewHolder.leftLayout.setVisibility(View.VISIBLE);
            viewHolder.rightLayout.setVisibility(View.GONE);
            viewHolder.leftMsg.setText(msg.getContent());
        } else if (msg.getType() == Msg.TYPE_SENT) {
            viewHolder.leftLayout.setVisibility(View.GONE);
            viewHolder.rightLayout.setVisibility(View.VISIBLE);
            viewHolder.rightMsg.setText(msg.getContent());
        }
        return view;
    }

    class ViewHolder {
        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftMsg;
        TextView rightMsg;
    }

}
