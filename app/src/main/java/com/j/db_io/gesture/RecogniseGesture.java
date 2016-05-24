package com.j.db_io.gesture;

import android.app.Activity;
import android.app.AlertDialog;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.j.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/8/22.
 */
public class RecogniseGesture extends Activity {
    GestureLibrary gestureLibrary;
    GestureOverlayView gestureOverlayView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recognise_gesture);

        gestureLibrary = GestureLibraries.fromPrivateFile(this, "mygestures");
        if (gestureLibrary.load()) {
            Toast.makeText(this, "装载手势成功！", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "装载手势失败！", Toast.LENGTH_SHORT).show();
        }

        gestureOverlayView = (GestureOverlayView) findViewById(R.id.recogniseGesture_gestureOverlayView);
        gestureOverlayView.addOnGesturePerformedListener(new GestureOverlayView.OnGesturePerformedListener() {
            @Override
            public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
                ArrayList<Prediction> predictions = gestureLibrary.recognize(gesture);
                ArrayList<String> result = new ArrayList<>();
                for (Prediction prediction : predictions) {
//                    if(prediction.score > 2.0){
                    result.add("与手势【" + prediction.name + "】相识度为：" + prediction.score);
//                    }
                }
                if (result.size() > 0) {
                    ArrayAdapter<Object> adapter = new ArrayAdapter<>(RecogniseGesture.this
                            , android.R.layout.simple_dropdown_item_1line
                            , result.toArray()
                    );
                    new AlertDialog.Builder(RecogniseGesture.this)
                            .setAdapter(adapter, null)
                            .setPositiveButton("确定", null)
                            .show();
                } else {
                    Toast.makeText(RecogniseGesture.this, "匹配手势失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
