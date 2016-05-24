package com.j.service.audioManager;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.j.R;

/**
 * Created by Administrator on 2015/8/26.
 */
public class AudioManagerTest extends Activity {
    AudioManager am;
    Button play, up, down;
    ToggleButton mute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audio_manager);

        am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        play = (Button) findViewById(R.id.audioManager_play);
        up = (Button) findViewById(R.id.audioManager_up);
        down = (Button) findViewById(R.id.audioManager_down);
        mute = (ToggleButton) findViewById(R.id.audioManager_toggleButton);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(AudioManagerTest.this, R.raw.earth);
                mediaPlayer.setLooping(true);
                mediaPlayer.start();
            }
        });

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                am.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
            }
        });

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                am.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
            }
        });

        mute.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                am.setStreamMute(AudioManager.STREAM_MUSIC, isChecked);
            }
        });

    }
}
