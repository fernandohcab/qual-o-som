package com.example.quesomeesse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

public class ProgressMenu extends AppCompatActivity {

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Set the activity fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();

        // Go back to main menu
        ImageView backButton = findViewById(R.id.backButtonProgress);
        backButton.setOnClickListener(v -> finish());

        prefs = getSharedPreferences("data", MODE_PRIVATE);

    }

    @Override
    public void onResume(){
        super.onResume();

        // Create the levels
        ArrayList<Answers> answers = new ArrayList<>();
        if(Locale.getDefault().getDisplayLanguage().toLowerCase().equals("português")) {
            answers.add(new Answers("1", "oi amor", R.raw.oiamor, prefs.getBoolean("1", false)));
            answers.add(new Answers("2", "fase 2", R.raw.fase2, prefs.getBoolean("2", false)));
            answers.add(new Answers("3", "fase 3", R.raw.fase3, prefs.getBoolean("3", false)));
            answers.add(new Answers("4", "fase 3", R.raw.fase3, prefs.getBoolean("4", false)));
            answers.add(new Answers("5", "fase 3", R.raw.fase3, prefs.getBoolean("5", false)));
            answers.add(new Answers("6", "fase 3", R.raw.fase3, prefs.getBoolean("6", false)));

        } else if(Locale.getDefault().getDisplayLanguage().toLowerCase().equals("english")){
            answers.add(new Answers("1", "hello honey", R.raw.oiamor, prefs.getBoolean("1", false)));
            answers.add(new Answers("2", "phase 2", R.raw.fase2, prefs.getBoolean("2", false)));
            answers.add(new Answers("3", "phase 3", R.raw.fase3, prefs.getBoolean("3", false)));
            answers.add(new Answers("4", "phase 3", R.raw.fase3, prefs.getBoolean("4", false)));
            answers.add(new Answers("5", "phase 3", R.raw.fase3, prefs.getBoolean("5", false)));
            answers.add(new Answers("6", "phase 3", R.raw.fase3, prefs.getBoolean("6", false)));
        } else if(Locale.getDefault().getDisplayLanguage().toLowerCase().equals("español")){
            answers.add(new Answers("1", "hola amor", R.raw.oiamor, prefs.getBoolean("1", false)));
            answers.add(new Answers("2", "fase 2", R.raw.fase2, prefs.getBoolean("2", false)));
            answers.add(new Answers("3", "fase 3", R.raw.fase3, prefs.getBoolean("3", false)));
            answers.add(new Answers("4", "fase 3", R.raw.fase3, prefs.getBoolean("4", false)));
            answers.add(new Answers("5", "fase 3", R.raw.fase3, prefs.getBoolean("5", false)));
            answers.add(new Answers("6", "fase 3", R.raw.fase3, prefs.getBoolean("6", false)));
        }
        AnswersAdapter adapter = new AnswersAdapter(this, answers);

        // Show the levels in GridView
        GridView gridView = findViewById(R.id.gridView);
        gridView.setAdapter(adapter);

    }

}