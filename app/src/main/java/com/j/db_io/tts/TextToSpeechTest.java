package com.j.db_io.tts;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.j.R;

import java.io.IOException;
import java.util.Locale;

/**
 * Created by Administrator on 2015/8/21.
 */
public class TextToSpeechTest extends Activity {
    TextToSpeech tts;
    EditText editText;
    Button speechButton, saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_to_speech);

        editText = (EditText) findViewById(R.id.tts_editText);
        speechButton = (Button) findViewById(R.id.tts_speech_button);
        saveButton = (Button) findViewById(R.id.tts_save_button);

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = tts.setLanguage(Locale.US);
                    if (result != TextToSpeech.LANG_COUNTRY_AVAILABLE && result != TextToSpeech.LANG_AVAILABLE) {
                        Toast.makeText(TextToSpeechTest.this, "TTS暂不支持此种语言的朗读", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        speechButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts.speak(editText.getText().toString(), TextToSpeech.QUEUE_ADD, null);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String path;
//                    path = Environment.getExternalStorageDirectory().getCanonicalPath();
//                path = "/storage/sdcard1";
                try {
                    path = getFilesDir().getCanonicalPath();
                    tts.synthesizeToFile(editText.getText().toString(), null, path + "/tts.wav");
                    Toast.makeText(TextToSpeechTest.this, "保存声音成功！" + path + "/tts.wav", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
