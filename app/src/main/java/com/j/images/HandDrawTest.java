package com.j.images;

import android.app.Activity;
import android.graphics.BlurMaskFilter;
import android.graphics.EmbossMaskFilter;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2015/7/27.
 */
public class HandDrawTest extends Activity {
    HandDrawView handDrawView;
    EmbossMaskFilter embossMaskFilter;
    BlurMaskFilter blurMaskFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(this);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        handDrawView = new HandDrawView(this, displayMetrics.widthPixels, displayMetrics.heightPixels);
        linearLayout.addView(handDrawView);
        setContentView(linearLayout);

        embossMaskFilter = new EmbossMaskFilter(new float[]{1.5f, 1.5f, 1.5f}, 0.6f, 6, 4.2f);
        blurMaskFilter = new BlurMaskFilter(8, BlurMaskFilter.Blur.NORMAL);
    }
}
