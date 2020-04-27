package com.example.android.miwok;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class WordAdapter extends ArrayAdapter<Word> {

    private int colorBackgroundId;
    private int audioId;

    public WordAdapter(@NonNull Context context, @NonNull ArrayList<Word> Word, int colorBackgroundId) {
        super(context, 0, Word);
        this.colorBackgroundId = colorBackgroundId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_list,parent,false);
        }

        //Set the background color
        listItemView.setBackgroundResource(colorBackgroundId);
        //Get the Word located in this position in the list
        final Word currentWord = getItem(position);

        //Find the textView for the english word in the item_list.xml
        TextView englishWord = listItemView.findViewById(R.id.englishWord);
        //Set the text to the english word
        englishWord.setText(currentWord.getDefaultTranslation());

        //Find the textView for the miwok word in the item_list.xml
        TextView miwokWord = listItemView.findViewById(R.id.miwokWord);
        //Set the text to the miwok word
        miwokWord.setText(currentWord.getMiwokWord());

        //Find the image view for the word and set the correspondent image if there is one
        ImageView imageWord = listItemView.findViewById(R.id.imageWord);
        if(currentWord.getHasImage()){
            imageWord.setImageResource(currentWord.getPictureId());
        }else{
            imageWord.setVisibility(View.GONE);
        }

        final ImageView playBtn = listItemView.findViewById(R.id.playButton);
        playBtn.setOnClickListener(new View.OnClickListener() {
            int audioId = currentWord.getAudioId();
            @Override
            public void onClick(View v) {
                playBtn.setEnabled(false);
                MediaPlayer mp = MediaPlayer.create(getContext(),audioId);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        playBtn.setEnabled(true);
                    }
                });
            }
        });


        return listItemView;
    }





}
