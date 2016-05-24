package com.j.receiver;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.io.IOException;

/**
 * Created by Administrator on 2015/8/27.
 */
public class MusicService extends Service {
    MusicReceiver musicReceiver;
    AssetManager assetManager;
    MediaPlayer mediaPlayer;
    int status = MusicBox.STATUS_STOP;
    int current = 0;
    String[] musics = new String[]{"wish.mp3", "promise.mp3", "beautiful.mp3"};

    @Override
    public void onCreate() {
        super.onCreate();
        assetManager = getAssets();
        mediaPlayer = new MediaPlayer();
        musicReceiver = new MusicReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MusicBox.CTL_ACTION);
        registerReceiver(musicReceiver, intentFilter);
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                current++;
                if (current >= 3) {
                    current = 0;
                }
                Intent sendIntent = new Intent(MusicBox.UPDATE_ACTION);
                sendIntent.putExtra("current", current);
                sendBroadcast(sendIntent);
                prepareAndPlay(musics[current]);
            }
        });
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void prepareAndPlay(String music) {
        try {
            AssetFileDescriptor assetFileDescriptor = assetManager.openFd(music);
            mediaPlayer.reset();
            mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor()
                    , assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class MusicReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            int control = intent.getIntExtra("control", -1);
            switch (control) {
                case 1:
                    if (status == MusicBox.STATUS_STOP) {
                        prepareAndPlay(musics[current]);
                        status = MusicBox.STATUS_PLAY;
                    } else if (status == MusicBox.STATUS_PLAY) {
                        mediaPlayer.pause();
                        status = MusicBox.STATUS_PAUSE;
                    } else if (status == MusicBox.STATUS_PAUSE) {
                        mediaPlayer.start();
                        status = MusicBox.STATUS_PLAY;
                    }
                    break;
                case 2:
                    if (status == MusicBox.STATUS_PLAY || status == MusicBox.STATUS_PAUSE) {
                        mediaPlayer.stop();
                        status = MusicBox.STATUS_STOP;
                    }
            }
            Intent sendIntent = new Intent(MusicBox.UPDATE_ACTION);
            sendIntent.putExtra("update", status);
            sendIntent.putExtra("current", current);
            sendBroadcast(sendIntent);
        }
    }

}
