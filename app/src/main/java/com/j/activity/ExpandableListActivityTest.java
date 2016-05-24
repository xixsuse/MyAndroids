package com.j.activity;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.j.R;

public class ExpandableListActivityTest extends ExpandableListActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ExpandableListAdapter adapter = new BaseExpandableListAdapter() {
            int[] logos = new int[]
                    {
                            R.drawable.p,
                            R.drawable.z,
                            R.drawable.t
                    };
            private String[] armTypes = new String[]
                    {"神族兵种", "虫族兵种", "人族兵种"};
            private String[][] arms = new String[][]
                    {
                            {"狂战士", "龙骑士", "黑暗圣堂", "电兵"},
                            {"小狗", "刺蛇", "飞龙", "自爆飞机"},
                            {"机枪兵", "护士MM", "幽灵"}
                    };

            //获取指定组位置、指定子列表项处的子列表项数据
            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return arms[groupPosition][childPosition];
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return arms[groupPosition].length;
            }

            private TextView getTextView() {
                AbsListView.LayoutParams params = new AbsListView.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, 64);
                TextView textView = new TextView(ExpandableListActivityTest.this);
                textView.setLayoutParams(params);
                textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.START);
                textView.setPadding(36, 0, 0, 0);
                textView.setTextSize(15);
                return textView;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition,
                                     boolean isLastChild, View convertView, ViewGroup parent) {
                TextView textView = getTextView();
                textView.setText(getChild(groupPosition, childPosition).toString());
                return textView;
            }

            //获取指定组位置处的组数据
            @Override
            public Object getGroup(int groupPosition) {
                return armTypes[groupPosition];
            }

            @Override
            public int getGroupCount() {
                return armTypes.length;
            }

            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            //该方法决定每个组选项的外观
            @Override
            public View getGroupView(int groupPosition, boolean isExpanded,
                                     View convertView, ViewGroup parent) {
                LinearLayout layout = new LinearLayout(ExpandableListActivityTest.this);
                layout.setOrientation(LinearLayout.HORIZONTAL);
                ImageView imageView = new ImageView(ExpandableListActivityTest.this);
                imageView.setImageResource(logos[groupPosition]);
                layout.addView(imageView);
                TextView textView = getTextView();
                textView.setText(getGroup(groupPosition).toString());
                layout.addView(textView);
                return layout;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
            }

            @Override
            public boolean hasStableIds() {
                return true;
            }
        };

        setListAdapter(adapter);
    }
}

