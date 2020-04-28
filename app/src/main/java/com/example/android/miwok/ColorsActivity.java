package com.example.android.miwok;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mp;
    private MediaPlayer.OnCompletionListener mpOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    private AudioManager audioManager;

    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {


            switch (focusChange) {
                case AudioManager.AUDIOFOCUS_GAIN:
                    //Resume playback
                    mp.start();
                    break;
                case AudioManager.AUDIOFOCUS_LOSS:
                    //Stop playback
                    releaseMediaPlayer();
                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                    //Pause playback
                    mp.pause();
                    mp.seekTo(0);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words);


        audioManager = (AudioManager) ColorsActivity.this.getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("Wetetti","Red", R.drawable.color_red, R.raw.color_red));
        words.add(new Word("Chiwiitə","Mustard yellow", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
        words.add(new Word("Topiisə","Dusty yellow", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Word("Chokokki","Green", R.drawable.color_green, R.raw.color_green));
        words.add(new Word("Takaakki","Brown", R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word("Temmokka","Gray", R.drawable.color_gray, R.raw.color_gray));
        words.add(new Word("Kenekaku","Black", R.drawable.color_black, R.raw.color_black));
        words.add(new Word("Kawinta","White", R.drawable.color_white, R.raw.color_white));

        WordAdapter wordAdapter = new WordAdapter(this,words,R.color.colorsBackground);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(wordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word currentWord = words.get(position);


                releaseMediaPlayer();
                // Request audio focus for playback
                int result = audioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // We gained audio focus
                    //Release media player source before creating it
                    releaseMediaPlayer();
                    mp = MediaPlayer.create(ColorsActivity.this, currentWord.getAudioId());
                    //Start reproducing the correct audio
                    mp.start();
                    //Release sources on mediaPlayer after the audio has ended.
                    mp.setOnCompletionListener(mpOnCompletionListener);
                }
            }
        });
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mp != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mp.stop();
            mp.release();
            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mp = null;
            // Abandon audio focus when playback complete
            audioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        releaseMediaPlayer();
    }
}
