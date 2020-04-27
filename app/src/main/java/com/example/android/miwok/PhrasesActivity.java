package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words);

        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("minto wuksus", "Where are you going?"));
        words.add(new Word("tinnә oyaase'nә", "What is your name?"));
        words.add(new Word("oyaaset...", "My name is..."));
        words.add(new Word("michәksәs?", "How are you feeling?"));
        words.add(new Word("kuchi achit", "I’m feeling good."));
        words.add(new Word("әәnәs'aa?", "Are you coming?"));
        words.add(new Word("hәә’ әәnәm", "Yes, I’m coming."));
        words.add(new Word("әәnәm", "I’m coming."));
        words.add(new Word("yoowutis", "Let’s go."));
        words.add(new Word("әnni'nem", "Come here."));

        WordAdapter wordAdapter = new WordAdapter(this, words,R.color.phrasesBackground);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(wordAdapter);
    }
}
