package com.example.quesomeesse;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class AnswersAdapter extends ArrayAdapter<Answers> {

    public AnswersAdapter(Activity context, ArrayList<Answers> answers){
        super(context, 0, answers);
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Answers currentAnswer = getItem(position);
        TextView chooseLevel= listItemView.findViewById(R.id.level);
        chooseLevel.setText(currentAnswer.getLevel());
        chooseLevel.setOnClickListener(v -> {
                Intent intent = new Intent(v.getContext(), Level.class);
                intent.putExtra("level", currentAnswer.getLevel());
                intent.putExtra("answer", currentAnswer.getAnswer());
                intent.putExtra("audio", currentAnswer.getAudio());
                v.getContext().startActivity(intent);
        });

        return listItemView;
    }

}
