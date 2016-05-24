package com.j.media;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.j.R;

import java.util.HashMap;

/**
 * Created by Administrator on 2015/8/5.
 */
public class SoundPoolTest extends Activity implements View.OnClickListener {
    Button bomb, shot, arrow;
    SoundPool soundPool;
    HashMap<Integer, Integer> soundMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sound_pool_layout);

        bomb = (Button) findViewById(R.id.sound_pool_button_bomb);
        shot = (Button) findViewById(R.id.sound_pool_button_shot);
        arrow = (Button) findViewById(R.id.sound_pool_button_arrow);

        soundPool = new SoundPool(10, AudioManager.STREAM_SYSTEM, 5);
        soundMap.put(1, soundPool.load(this, R.raw.bomb, 1));
        soundMap.put(2, soundPool.load(this, R.raw.shot, 2));
        soundMap.put(3, soundPool.load(this, R.raw.arrow, 3));
        bomb.setOnClickListener(this);
        shot.setOnClickListener(this);
        arrow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sound_pool_button_bomb:
                soundPool.play(soundMap.get(1), 1, 1, 0, 0, 1);
                break;
            case R.id.sound_pool_button_shot:
                soundPool.play(soundMap.get(2), 1, 1, 0, 0, 1);
                break;
            case R.id.sound_pool_button_arrow:
                soundPool.play(soundMap.get(3), 1, 1, 0, 0, 1);
                break;
        }
    }
}
