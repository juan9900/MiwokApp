package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words);

        ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("Lutti","One"));
        words.add(new Word("Otiiko","Two"));
        words.add(new Word("Tolookosu","Three"));
        words.add(new Word("Oyyisa","Four"));
        words.add(new Word("Massokka","Five"));
        words.add(new Word("Temmokka","Six"));
        words.add(new Word("Kenekaku","Seven"));
        words.add(new Word("Kawinta","Eight"));
        words.add(new Word("Wo'e","Nine"));
        words.add(new Word("Na'aacha","Ten"));


        WordAdapter wordAdapter = new WordAdapter(this,words);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(wordAdapter);





    }



}
