package com.example.quesomeesse;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class AnswersAdapter extends ArrayAdapter<Answers> {

    public AnswersAdapter(Activity context, ArrayList<Answers> answers){
        super(context, 0, answers);
    }

    @SuppressLint("SetTextI18n")
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Answers currentAnswer = getItem(position);
        RelativeLayout chooseLevel= listItemView.findViewById(R.id.singleLevel);
        TextView levelNumber = listItemView.findViewById(R.id.levelNumber);
        ImageView imageLevel = listItemView.findViewById(R.id.singleImage);
        imageLevel.setImageResource(currentAnswer.getImage());
        levelNumber.setText("" + currentAnswer.getLevel());
        chooseLevel.setOnClickListener(v -> {
            if(currentAnswer.getImage() == R.mipmap.undone || currentAnswer.getImage() == R.mipmap.done) {
                Intent intent = new Intent(v.getContext(), Level.class);
                intent.putExtra("state", currentAnswer);
                v.getContext().startActivity(intent);
            }
        });


        return listItemView;
    }

}
