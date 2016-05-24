package com.j.fragment.news;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.j.R;

/**
 * Created by Administrator on 2015/9/10.
 */
public class NewsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.news_main);
    }
}
