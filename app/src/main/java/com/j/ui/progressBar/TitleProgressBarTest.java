package com.j.ui.progressBar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.j.R;


/**
 * Created by Administrator on 2015/8/12.
 */
public class TitleProgressBarTest extends Activity {
    Button show, hide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_PROGRESS);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.title_progress_bar);

        show = (Button) findViewById(R.id.titleProgressBar_show);
        hide = (Button) findViewById(R.id.titleProgressBar_hide);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setProgressBarIndeterminateVisibility(true);
                setProgressBarVisibility(true);
                setProgress(4500);
            }
        });

        hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setProgressBarIndeterminateVisibility(false);
                setProgressBarVisibility(false);
            }
        });
    }
}
