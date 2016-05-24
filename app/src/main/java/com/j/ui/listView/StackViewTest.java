package com.j.ui.listView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.StackView;

import com.j.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2015/8/12.
 */
public class StackViewTest extends Activity {
    StackView stackView;
    int[] images = new int[]{
            R.drawable.bomb5, R.drawable.bomb6, R.drawable.bomb7, R.drawable.bomb8,
            R.drawable.bomb9, R.drawable.bomb10, R.drawable.bomb11, R.drawable.bomb12,
            R.drawable.bomb13, R.drawable.bomb14, R.drawable.bomb15, R.drawable.bomb16,
    };
    ArrayList<HashMap<String, Object>> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stack_view);
        stackView = (StackView) findViewById(R.id.stackView);

        arrayList = new ArrayList<>();
        for (int imageId : images) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("image", imageId);
            arrayList.add(hashMap);
        }

        SimpleAdapter adapter = new SimpleAdapter(this
                , arrayList
                , R.layout.stack_view_item
                , new String[]{"image"}
                , new int[]{R.id.stackViewImage}
        );

        stackView.setAdapter(adapter);
    }

    public void previous(View view) {
        stackView.showPrevious();
    }

    public void next(View view) {
        stackView.showNext();
    }
}
