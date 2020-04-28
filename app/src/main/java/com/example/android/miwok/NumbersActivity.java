package com.example.android.miwok;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toolbar;

import java.util.ArrayList;

import static android.media.AudioManager.AUDIOFOCUS_LOSS;
import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT;

public class NumbersActivity extends AppCompatActivity {

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


        audioManager = (AudioManager) NumbersActivity.this.getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("Lutti", "One", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("Otiiko", "Two", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("Tolookosu", "Three", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("Oyyisa", "Four", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("Massokka", "Five", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("Temmokka", "Six", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("Kenekaku", "Seven", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("Kawinta", "Eight", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("Wo'e", "Nine", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("Na'aacha", "Ten", R.drawable.number_ten, R.raw.number_ten));


        final WordAdapter wordAdapter = new WordAdapter(this, words, R.color.numbersBackground);
        final ListView listView = findViewById(R.id.list);
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
                    mp = MediaPlayer.create(NumbersActivity.this, currentWord.getAudioId());
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
