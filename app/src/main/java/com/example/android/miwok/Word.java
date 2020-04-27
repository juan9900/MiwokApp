package com.example.android.miwok;

import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Word {
    private String defaultTranslation;
    private String miwokWord;
    private int pictureId;
    private boolean hasImage;



    public Word(String miwokWord, String defaultTranslation, int pictureId) {
        this.miwokWord = miwokWord;
        this.defaultTranslation = defaultTranslation;
        this.pictureId = pictureId;
        this.hasImage = true;
    }

    public Word(String miwokWord, String defaultTranslation) {
        this.miwokWord = miwokWord;
        this.defaultTranslation = defaultTranslation;
        this.hasImage = false;
    }


    public String getMiwokWord() {
        return miwokWord;
    }

    public String getDefaultTranslation() {
        return defaultTranslation;
    }

    public int getPictureId() {
        return pictureId;
    }

    public boolean getHasImage() {
        return hasImage;
    }


}
