package com.syatam.audiotest;

import android.content.Context;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mVolumeControl;
    private AudioManager mAudioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVolumeControl = findViewById(R.id.volume_control);

        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        mVolumeControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* mAudioManager.adjustSuggestedStreamVolume(
                        AudioManager.ADJUST_LOWER,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.FLAG_PLAY_SOUND | AudioManager.FLAG_SHOW_UI); */
                mAudioManager.adjustSuggestedStreamVolume(
                        AudioManager.ADJUST_SAME,
                        AudioManager.USE_DEFAULT_STREAM_TYPE,
                        AudioManager.FLAG_SHOW_UI);
            }
        });
    }
}
