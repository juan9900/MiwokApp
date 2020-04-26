package com.example.android.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(@NonNull Context context, @NonNull ArrayList<Word> Word) {
        super(context, 0, Word);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_list,parent,false);
        }

        //Get the Word located in this position in the list
        Word currentWord = getItem(position);

        //Find the textView for the english word in the item_list.xml
        TextView englishWord = listItemView.findViewById(R.id.englishWord);
        //Set the text to the english word
        englishWord.setText(currentWord.getDefaultTranslation());

        //Find the textView for the miwok word in the item_list.xml
        TextView miwokWord = listItemView.findViewById(R.id.miwokWord);
        //Set the text to the miwok word
        miwokWord.setText(currentWord.getMiwokWord());


        return listItemView;
    }
}
