package com.j.ui.viewAnimator;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.j.R;


/**
 * Created by Administrator on 2015/8/12.
 */
public class TextSwitcherTest extends Activity {
    TextSwitcher textSwitcher;
    String[] books = new String[]{
            "1 疯狂的JAVA讲义"
            , "2 疯狂的XML讲义"
            , "3 疯狂的android讲义"
            , "4 疯狂的swift讲义"
    };
    int currentBook = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_switcher);
        textSwitcher = (TextSwitcher) findViewById(R.id.textSwitcher);

        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(TextSwitcherTest.this);
                textView.setTextSize(40);
                textView.setTextColor(Color.MAGENTA);
                return textView;
            }
        });
        nextTextSwitcher(null);

    }

    public void nextTextSwitcher(View view) {
        textSwitcher.setText(books[++currentBook % books.length]);
    }
}
