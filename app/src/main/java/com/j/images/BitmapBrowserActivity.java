package com.j.images;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.j.R;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Administrator on 2015/8/3.
 */
public class BitmapBrowserActivity extends Activity {
    String dirPath = Environment.getExternalStorageDirectory() + "/DCIM/Camera/";
    String photoType = ".jpg";
    TextView textView;
    Button buttonFirst;
    Button buttonPrevious;
    Button buttonNext;
    Button buttonLast;
    ImageView imageView;
    ArrayList<String> photoList;
    int currentPhoto;
    int sumPhoto;
    Bitmap bitmap;
    String fileName;
    String summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bitmap_browser_layout);

        textView = (TextView) findViewById(R.id.bitmap_browser_textView);
        buttonNext = (Button) findViewById(R.id.bitmap_browser_button_next);
        buttonPrevious = (Button) findViewById(R.id.bitmap_browser_button_previous);
        buttonFirst = (Button) findViewById(R.id.bitmap_browser_button_first);
        buttonLast = (Button) findViewById(R.id.bitmap_browser_button_last);
        imageView = (ImageView) findViewById(R.id.bitmap_browser_imageView);

        photoList = getPictures(dirPath);
        currentPhoto = 0;
        sumPhoto = photoList.size();
        fileName = photoList.get(currentPhoto).toString();
        summary = "目录：" + dirPath + "下，共有" + sumPhoto + "张" + photoType + "类型的图片，当前是第"
                + (currentPhoto + 1) + "张，文件名:" + fileName.replace(dirPath, "");
        textView.setText(summary);
        bitmap = BitmapFactory.decodeFile(fileName);
//        bitmap = BitmapFactory.decodeFile("/storage/sdcard1/DCIM/Camera/IMG_20140728_110748.jpg");
        imageView.setImageBitmap(bitmap);
        buttonFirst.setOnClickListener(new MyOnClickListener());
        buttonPrevious.setOnClickListener(new MyOnClickListener());
        buttonNext.setOnClickListener(new MyOnClickListener());
        buttonLast.setOnClickListener(new MyOnClickListener());
        imageView.setOnClickListener(new MyOnClickListener());
    }

    ArrayList<String> getPictures(String dirName) {
        ArrayList<String> list = new ArrayList<>();
        File dir = new File(dirName);
        File[] files = dir.listFiles();
        if (files == null) {
            return null;
        }

        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            if (file.isFile()) {
                String filePath = file.getPath();
                int index = filePath.lastIndexOf(".");
                if (index <= 0) {
                    continue;
                }
                String suffix = filePath.substring(index);
                if (suffix.equalsIgnoreCase(photoType)) {
                    list.add(filePath);
                }
            }
        }
        Collections.sort(list);
        return list;
    }

    class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.bitmap_browser_button_first:
                    currentPhoto = 0;
                    break;
                case R.id.bitmap_browser_button_previous:
                    if (currentPhoto == 0) {
                        currentPhoto = sumPhoto - 1;
                    } else {
                        currentPhoto--;
                    }
                    break;
                case R.id.bitmap_browser_button_next:
                    currentPhoto = ++currentPhoto % sumPhoto;
                    break;
                case R.id.bitmap_browser_button_last:
                    currentPhoto = sumPhoto - 1;
                    break;
                case R.id.bitmap_browser_imageView:
                    currentPhoto = ++currentPhoto % sumPhoto;
                    break;
                default:
                    currentPhoto = 0;
                    break;
            }
            fileName = photoList.get(currentPhoto);
            summary = "目录：" + dirPath + "下，共有" + sumPhoto + "张" + photoType + "类型的图片，当前是第"
                    + (currentPhoto + 1) + "张，文件名:" + fileName.replace(dirPath, "");
            textView.setText(summary);
            bitmap = BitmapFactory.decodeFile(fileName);
            imageView.setImageBitmap(bitmap);
        }
    }
}
