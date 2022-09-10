package com.pavel.ekivoki.ui.manual.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.pavel.ekivoki.R;
import com.pavel.ekivoki.data.entity.Word;

import java.util.List;

public class WordsAdapter extends ArrayAdapter<Word> {
    private final LayoutInflater layoutInflater;
    private final int resource;
    private List<Word> words;


    public WordsAdapter(@NonNull Context context, int resource, @NonNull List<Word> words) {
        super(context, resource, words);
        this.layoutInflater = LayoutInflater.from(context);
        this.words = words;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = layoutInflater.inflate(resource,parent,false);
        }
        String word = words.get(position).getWord();
        TextView wordTextView = convertView.findViewById(R.id.wordTextView);
        wordTextView.setText(word);
        return convertView;
    }
}
