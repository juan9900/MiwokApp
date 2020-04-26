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

        words.add(new Word("Wetetti","Red"));
        words.add(new Word("Chiwiitə","Mustard yellow"));
        words.add(new Word("Topiisə","Dusty yellow"));
        words.add(new Word("Chokokki","Green"));
        words.add(new Word("Takaakki","Brown"));
        words.add(new Word("Temmokka","Gray"));
        words.add(new Word("Kenekaku","Black"));
        words.add(new Word("Kawinta","White"));

        WordAdapter wordAdapter = new WordAdapter(this,words);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(wordAdapter);
    }



}
