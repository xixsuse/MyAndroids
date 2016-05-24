package com.j.ui.listView;

import android.app.Activity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.j.R;


/**
 * Created by Administrator on 2015/8/11.
 */
public class ExpendableListViewTest extends Activity {
    ExpandableListView expandableListView;
    int[] logos = new int[]{
            R.drawable.p,
            R.drawable.z,
            R.drawable.t
    };
    String[] armTypes = new String[]{"神族兵种", "虫族兵种", "人族兵种"};
    String[][] arms = new String[][]{
            {"狂战士", "龙骑士", "黑暗圣堂", "电兵"},
            {"小狗", "刺蛇", "飞龙", "自爆飞机"},
            {"机枪兵", "护士MM", "幽灵"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expendable_list_view);
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);

        ExpandableListAdapter adapter = new MyExpandableListAdapter();

        expandableListView.setAdapter(adapter);
    }

    class MyExpandableListAdapter implements ExpandableListAdapter {
        public TextView getTextView() {
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            TextView textView = new TextView(ExpendableListViewTest.this);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.START);
            textView.setPadding(36, 0, 0, 0);
//            textView.setTextSize(20);
            return textView;
        }


        @Override
        public void registerDataSetObserver(DataSetObserver observer) {

        }

        @Override
        public void unregisterDataSetObserver(DataSetObserver observer) {

        }

        @Override
        public int getGroupCount() {
            return armTypes.length;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return arms[groupPosition].length;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return armTypes[groupPosition];
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return arms[groupPosition][childPosition];
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded,
                                 View convertView, ViewGroup parent) {
            LinearLayout layout = new LinearLayout(ExpendableListViewTest.this);
            layout.setOrientation(LinearLayout.HORIZONTAL);
            ImageView logo = new ImageView(ExpendableListViewTest.this);
            logo.setImageResource(logos[groupPosition]);
            layout.addView(logo);
            TextView textView = getTextView();
            textView.setText(getGroup(groupPosition).toString());
            layout.addView(textView);
            return layout;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                                 View convertView, ViewGroup parent) {
            TextView textView = getTextView();
            textView.setText(getChild(groupPosition, childPosition).toString());
            return textView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        @Override
        public boolean areAllItemsEnabled() {
            return false;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public void onGroupExpanded(int groupPosition) {

        }

        @Override
        public void onGroupCollapsed(int groupPosition) {

        }

        @Override
        public long getCombinedChildId(long groupId, long childId) {
            return 0;
        }

        @Override
        public long getCombinedGroupId(long groupId) {
            return 0;
        }
    }
}
