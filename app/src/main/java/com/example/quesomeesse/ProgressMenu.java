package com.example.quesomeesse;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Objects;

public class ProgressMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Set the activity fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();

        // Create the levels
        ArrayList<Answers> answers = new ArrayList<>();
        answers.add(new Answers("1", "oi amor",R.raw.oiamor));
        answers.add(new Answers("2", "fase 2", R.raw.fase2));
        answers.add(new Answers("3", "fase 3", R.raw.fase3));
        answers.add(new Answers("4", "fase 3", R.raw.fase3));
        answers.add(new Answers("5", "fase 3", R.raw.fase3));
        answers.add(new Answers("6", "fase 3", R.raw.fase3));

        AnswersAdapter adapter = new AnswersAdapter(this, answers);

        // Show the levels in GridView
        GridView gridView = findViewById(R.id.gridView);
        gridView.setAdapter(adapter);

        ImageView backButton = findViewById(R.id.backButtonProgress);
        backButton.setOnClickListener(v -> finish());
    }
}