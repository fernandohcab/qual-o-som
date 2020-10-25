package com.example.quesomeesse;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class ProgressMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        ArrayList<Answers> answers = new ArrayList<Answers>();

        answers.add(new Answers("Level 1", "oi amor",R.raw.oiamor));
        answers.add(new Answers("Level 2", "fase 2", R.raw.fase2));
        answers.add(new Answers("Level 3", "fase 3", R.raw.fase3));
        answers.add(new Answers("Level 4", "fase 3", R.raw.fase3));
        answers.add(new Answers("Level 5", "fase 3", R.raw.fase3));
        answers.add(new Answers("Level 6", "fase 3", R.raw.fase3));

        AnswersAdapter adapter = new AnswersAdapter(this, answers);

        GridView gridView = findViewById(R.id.gridView);

        gridView.setAdapter(adapter);


    }



}