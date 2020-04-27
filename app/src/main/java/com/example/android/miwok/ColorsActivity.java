package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words);

        ArrayList<Word> words = new ArrayList<>();

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
    }



}
