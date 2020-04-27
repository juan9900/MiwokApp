package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("әpә", "Father", R.drawable.family_father));
        words.add(new Word("әṭa", "Mother", R.drawable.family_mother));
        words.add(new Word("angsi", "Son", R.drawable.family_son));
        words.add(new Word("tune", "Daughter", R.drawable.family_daughter));
        words.add(new Word("taachi", "Older brother", R.drawable.family_older_brother));
        words.add(new Word("chalitti", "Younger brother", R.drawable.family_younger_brother));
        words.add(new Word("teṭe", "Older sister", R.drawable.family_older_sister));
        words.add(new Word("kolliti", "Younger sister", R.drawable.family_younger_sister));
        words.add(new Word("ama", "Grandmother", R.drawable.family_grandmother));
        words.add(new Word("paapa", "Grandfather", R.drawable.family_grandfather));


        WordAdapter adapter = new WordAdapter(this, words,R.color.familyBackground);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }

}

