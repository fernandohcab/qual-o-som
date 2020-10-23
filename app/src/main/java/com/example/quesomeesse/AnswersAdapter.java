package com.example.quesomeesse;

import android.app.Activity;
import android.content.Context;
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

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Answers currentAnswer = getItem(position);

        TextView chooseLevel= listItemView.findViewById(R.id.level);

        chooseLevel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }

        });

        //chooseLevel.setText(currentAnswer.getLevel());


        return listItemView;
    }

}
