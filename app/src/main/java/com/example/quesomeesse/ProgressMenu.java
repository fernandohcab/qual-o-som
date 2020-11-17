package com.example.quesomeesse;

import androidx.appcompat.app.AppCompatActivity;
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
            answers.add(new Answers(1, "oi amor", R.raw.oiamor, prefs.getInt("1", 0), "oi moza", "oi mozona", "eae menó"));
            answers.add(new Answers(2, "fase 2", R.raw.fase2, prefs.getInt("2", 0),"faze 2", "sei nao", "coe mo"));
            answers.add(new Answers(3, "fase 3", R.raw.fase3, prefs.getInt("3", 0),"faze 3", "gostou mo", "fala que sim"));

        }

        else if(Locale.getDefault().getDisplayLanguage().toLowerCase().equals("english")){
            answers.add(new Answers(1, "hello honey", R.raw.oiamor, prefs.getInt("1", 0),"hello female", "i don't know", "airon now"));
            answers.add(new Answers(2, "phase 2", R.raw.fase2, prefs.getInt("2", 0),"faze 2", "sei nao", "coe mo"));
            answers.add(new Answers(3, "phase 3", R.raw.fase3, prefs.getInt("3", 0),"faze 2", "sei nao", "coe mo"));
        }

        else if(Locale.getDefault().getDisplayLanguage().toLowerCase().equals("español")){
            answers.add(new Answers(1, "hola amor", R.raw.oiamor, prefs.getInt("1", 0),"hola mujer", "sei nao", "coe mo"));
            answers.add(new Answers(2, "fase 2", R.raw.fase2, prefs.getInt("2", 0),"faze 2", "sei nao", "coe mo"));
            answers.add(new Answers(3, "fase 3", R.raw.fase3, prefs.getInt("3", 0),"faze 2", "sei nao", "coe mo"));
        }
        AnswersAdapter adapter = new AnswersAdapter(this, answers);

        // Show the levels in GridView
        GridView gridView = findViewById(R.id.gridView);
        gridView.setAdapter(adapter);

    }

}