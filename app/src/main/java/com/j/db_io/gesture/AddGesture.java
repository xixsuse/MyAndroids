package com.j.db_io.gesture;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.j.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2015/8/22.
 */
public class AddGesture extends Activity {
    GestureLibrary gestureLibrary;
    GestureOverlayView gestureOverlayView;
    Button showButton;
    View saveDialog;
    EditText gestureName;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_gesture);

        gestureLibrary = GestureLibraries.fromPrivateFile(AddGesture.this, "mygestures");
        if (gestureLibrary.load()) {
            Toast.makeText(this, "装载手势成功！", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "装载手势失败！", Toast.LENGTH_SHORT).show();
        }

        showButton = (Button) findViewById(R.id.addGesture_showButton);
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<HashMap<String, Object>> list = new ArrayList<>();
                for (String gestureEntry : gestureLibrary.getGestureEntries()) {
                    for (Gesture gesture : gestureLibrary.getGestures(gestureEntry)) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        hashMap.put("name", gestureEntry);
//                        hashMap.put("gesture", gesture.toBitmap(128, 128, 1, Color.RED));
                        hashMap.put("gesture", R.drawable.contacts_tiger);
                        list.add(hashMap);
                    }

                }

                SimpleAdapter adapter = new SimpleAdapter(AddGesture.this
                        , list
                        , R.layout.add_gesture_show_item
                        , new String[]{"name", "gesture"}
                        , new int[]{R.id.addGesture_show_gestureName, R.id.addGesture_show_gestureImage}
                );
                new AlertDialog.Builder(AddGesture.this)
                        .setAdapter(adapter, null)
                        .setPositiveButton("确认", null)
                        .show();
            }
        });

        gestureOverlayView = (GestureOverlayView) findViewById(R.id.addGesture_gestureOverlayView);
        gestureOverlayView.addOnGesturePerformedListener(new GestureOverlayView.OnGesturePerformedListener() {
            @Override
            public void onGesturePerformed(GestureOverlayView overlay, final Gesture gesture) {
                saveDialog = getLayoutInflater().inflate(R.layout.add_gesture_save, null);
                imageView = (ImageView) saveDialog.findViewById(R.id.addGesture_save_imageView);
                gestureName = (EditText) saveDialog.findViewById(R.id.addGesture_add_gestureName);
                Bitmap bitmap = gesture.toBitmap(128, 128, 10, 0xffff0000);
                imageView.setImageBitmap(bitmap);

                new AlertDialog.Builder(AddGesture.this)
                        .setView(saveDialog)
                        .setNegativeButton("取消", null)
                        .setPositiveButton("保存", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                gestureLibrary.addGesture(gestureName.getText().toString(), gesture);
                                gestureLibrary.save();
                            }
                        })
                        .show();
            }
        });

    }

}
