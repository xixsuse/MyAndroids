package com.j.media;

import android.app.Activity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.j.R;

import java.io.File;

/**
 * Created by Administrator on 2015/8/29.
 */
public class VideoViewTest extends Activity {
    VideoView videoView;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_view);

        videoView = (VideoView) findViewById(R.id.videoView);

        mediaController = new MediaController(this);
        File videoFile = new File("/storage/sdcard1/aa.mp4");
        if (videoFile.exists()) {
            videoView.setVideoPath(videoFile.getAbsolutePath());
            videoView.setMediaController(mediaController);
            videoView.requestFocus();
        }


    }
}
