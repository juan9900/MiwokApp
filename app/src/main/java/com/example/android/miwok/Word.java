package com.example.android.miwok;

public class Word {
    private String defaultTranslation;
    private String miwokWord;
    private int pictureId;
    private boolean hasImage;
    private int audioId;




    public Word(String miwokWord, String defaultTranslation, int pictureId, int audioId) {
        this.miwokWord = miwokWord;
        this.defaultTranslation = defaultTranslation;
        this.pictureId = pictureId;
        this.hasImage = true;
        this.audioId = audioId;
    }

    public Word(String miwokWord, String defaultTranslation, int audioId) {
        this.miwokWord = miwokWord;
        this.defaultTranslation = defaultTranslation;
        this.hasImage = false;
        this.audioId = audioId;
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

    public int getAudioId() {
        return audioId;
    }
}
