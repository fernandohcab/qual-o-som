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
            answers.add(new Answers(1, "lata de refrigerante", R.raw.lata, prefs.getInt("1", 0), "garrafa", "algum pote", "desodorante"));
            answers.add(new Answers(2, "carro", R.raw.carengine, prefs.getInt("2", 0),"barco", "avião", "trator"));
            answers.add(new Answers(3, "cachorro", R.raw.dog, prefs.getInt("3", 0),"cachoro", "gritos", "gatos"));
            answers.add(new Answers(4, "cortar papel", R.raw.cutpaper, prefs.getInt("4", 0),"arranhar algo", "apontador de lápis", "escrever"));
            answers.add(new Answers(5, "disparo", R.raw.gunshot, prefs.getInt("5", 0),"explosão", "chaves", "porta"));
            answers.add(new Answers(6, "fechar a porta", R.raw.closedoor, prefs.getInt("6", 0),"bilhar", "bater à porta", "derrubar algo"));
            answers.add(new Answers(7, "vaca", R.raw.cow, prefs.getInt("7", 0),"vaiar", "buzina", "grito"));
            answers.add(new Answers(8, "violão", R.raw.guitar, prefs.getInt("8", 0),"flauta", "violino", "harpa"));
            answers.add(new Answers(9, "maçã", R.raw.apple, prefs.getInt("9", 0),"quebrar algo", "esmagar", "embalagem"));
            answers.add(new Answers(10, "aerosol", R.raw.aerosol, prefs.getInt("10", 0),"soprar", "inseto", "chantilly"));
            answers.add(new Answers(11, "escovar os dentes", R.raw.brushingteeth, prefs.getInt("11", 0),"sacudir algo", "tique-taque", "barbear"));
            answers.add(new Answers(12, "micro-ondas", R.raw.microwave, prefs.getInt("12", 0),"lava-louças", "avião", "forno"));
            answers.add(new Answers(13, "abrir a porta", R.raw.openingdoor, prefs.getInt("13", 0),"apitar", "baleia", "arrastar algo"));
            answers.add(new Answers(14, "apontador de lápis", R.raw.pencilsharpening, prefs.getInt("14", 0),"mastigar", "crocante", "moer algo"));
            answers.add(new Answers(15, "colocar cinto de segurança", R.raw.seatbeltairplane, prefs.getInt("15", 0),"telefone tocando", "piano", "metrô"));
        }

        else if(Locale.getDefault().getDisplayLanguage().toLowerCase().equals("english")){
            answers.add(new Answers(1, "can of soda", R.raw.lata, prefs.getInt("1", 0),"bottle", "some pot", "deodorant"));
            answers.add(new Answers(2, "car", R.raw.carengine, prefs.getInt("2", 0),"boat", "airplane", "tractor"));
            answers.add(new Answers(3, "dog", R.raw.dog, prefs.getInt("3", 0),"doug", "screams", "cats"));
            answers.add(new Answers(4, "cut paper", R.raw.cutpaper, prefs.getInt("4", 0),"scratch something", "pencil sharpener", "writing"));
            answers.add(new Answers(5, "gun shot", R.raw.gunshot, prefs.getInt("5", 0),"explosion", "keys", "door"));
            answers.add(new Answers(6, "close the door", R.raw.closedoor, prefs.getInt("6", 0),"pool", "knock the door", "drop something"));
            answers.add(new Answers(7, "cow", R.raw.cow, prefs.getInt("7", 0),"boo", "horn", "scream"));
            answers.add(new Answers(8, "guitar", R.raw.guitar, prefs.getInt("8", 0),"flute", "violin", "harp"));
            answers.add(new Answers(9, "apple", R.raw.apple, prefs.getInt("9", 0),"break something", "smash", "packing"));
            answers.add(new Answers(10, "aerosol", R.raw.aerosol, prefs.getInt("10", 0),"blow", "bug", "chantilly"));
            answers.add(new Answers(11, "brushing teeth", R.raw.brushingteeth, prefs.getInt("11", 0),"shake something", "ticking", "to shave"));
            answers.add(new Answers(12, "microwave", R.raw.microwave, prefs.getInt("12", 0),"dishwasher", "airplane", "oven"));
            answers.add(new Answers(13, "open the door", R.raw.openingdoor, prefs.getInt("13", 0),"whistle", "whale", "drag something"));
            answers.add(new Answers(14, "pencil sharpener", R.raw.pencilsharpening, prefs.getInt("14", 0),"chew", "crunchy", "grind something"));
            answers.add(new Answers(15, "fasten your seat belt", R.raw.seatbeltairplane, prefs.getInt("15", 0),"telephone ringing", "piano", "subway"));
        }

        else if(Locale.getDefault().getDisplayLanguage().toLowerCase().equals("español")){
            answers.add(new Answers(1, "lata de gaseosa", R.raw.lata, prefs.getInt("1", 0),"botella", "algún tarro", "desodorante"));
            answers.add(new Answers(2, "coche", R.raw.carengine, prefs.getInt("2", 0),"bote", "avión", "tractor"));
            answers.add(new Answers(3, "perro", R.raw.dog, prefs.getInt("3", 0),"peros", "gritos", "gatos"));
            answers.add(new Answers(4, "cortar papel", R.raw.cutpaper, prefs.getInt("4", 0),"rascar algo", "apuntador de lápiz", "escribir"));
            answers.add(new Answers(5, "disparo", R.raw.gunshot, prefs.getInt("5", 0),"explosión", "llaves", "puerta"));
            answers.add(new Answers(6, "cerrar la puerta", R.raw.closedoor, prefs.getInt("6", 0),"billar", "tocar la puerta", "soltar algo"));
            answers.add(new Answers(7, "vaca", R.raw.cow, prefs.getInt("7", 0),"abucheo", "bocina", "grito"));
            answers.add(new Answers(8, "guitarra", R.raw.guitar, prefs.getInt("8", 0),"flauta", "violín", "arpa"));
            answers.add(new Answers(9, "manzana", R.raw.apple, prefs.getInt("9", 0),"romper algo", "aplastar", "embalaje"));
            answers.add(new Answers(10, "aerosol", R.raw.aerosol, prefs.getInt("10", 0),"soplar", "insecto", "chantilly"));
            answers.add(new Answers(11, "cepillarse los dientes", R.raw.brushingteeth, prefs.getInt("11", 0),"sacudir algo", "tictac", "afeitar"));
            answers.add(new Answers(12, "microondas", R.raw.microwave, prefs.getInt("12", 0),"lava platos", "avión", "horno"));
            answers.add(new Answers(13, "abrir la puerta", R.raw.openingdoor, prefs.getInt("13", 0),"silbar", "ballena", "arrastar algo"));
            answers.add(new Answers(14, "apuntador de lápiz", R.raw.pencilsharpening, prefs.getInt("14", 0),"masticar", "crujiente", "moler algo"));
            answers.add(new Answers(15, "abrochar el cinturón de seguridad", R.raw.seatbeltairplane, prefs.getInt("15", 0),"teléfono sonando", "piano", "subterraneo"));
        }
        AnswersAdapter adapter = new AnswersAdapter(this, answers);

        // Show the levels in GridView
        GridView gridView = findViewById(R.id.gridView);
        gridView.setAdapter(adapter);

    }

}