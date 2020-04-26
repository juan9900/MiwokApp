package com.example.android.miwok;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Word {
    private String defaultTranslation;
    private String miwokWord;

    public Word(String miwokWord, String defaultTranslation) {
        this.miwokWord = miwokWord;
        this.defaultTranslation = defaultTranslation;
    }


    public String getMiwokWord() {
        return miwokWord;
    }

    public String getDefaultTranslation() {
        return defaultTranslation;
    }


}
