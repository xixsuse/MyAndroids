package com.j.fragment.news;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.j.R;

/**
 * Created by Administrator on 2015/9/10.
 */
public class NewsContentActivity extends Activity {
    public static void actionStart(Context context, String title, String content) {
        Intent intent = new Intent(context, NewsContentActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("content", content);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.news_content);
        String title = getIntent().getStringExtra("title");
        String content = getIntent().getStringExtra("content");
        NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager().findFragmentById(R.id.NewsContent_fragment);
        newsContentFragment.refresh(title, content);
    }
}
