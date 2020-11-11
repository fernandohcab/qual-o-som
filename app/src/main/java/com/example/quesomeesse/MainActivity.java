package com.example.quesomeesse;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    TextView lives, coins;
    SharedPreferences prefs;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // enable fullscreen mode
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();

        lives = findViewById(R.id.lives);
        coins = findViewById(R.id.coinsQty);
        prefs = getSharedPreferences("data", MODE_PRIVATE);

       if(prefs.getInt("lives", 0) < 10){
            startService(new Intent(this, Reload.class));
       }

        if(first_time_check()) {
            int a = 1;
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("lives", 10);
            editor.putInt("coins", 150);
            editor.putString("first", "true");
            editor.putInt("1", 2);
            editor.putInt("2", 1);
            editor.putInt("3", 1);
            editor.putInt("4", 1);
            editor.putInt("5", 1);
            editor.putInt("6", 1);
            editor.apply();
        }

        lives.setText("" + prefs.getInt("lives", 0));
        coins.setText("" + prefs.getInt("coins", 0));

    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onResume() {
        super.onResume();

        lives.setText("" + prefs.getInt("lives", 0));
        coins.setText("" + prefs.getInt("coins", 0));

        // Go to the configuration activity
        Intent configurationIntent = new Intent(this, Configuration.class);
        ImageView configuration = findViewById(R.id.config);
        configuration.setOnClickListener(v -> startActivity(configurationIntent));

        // Buy the premium version
        ImageView noAds = findViewById(R.id.noAd);
        noAds.setOnClickListener(v -> {
            final String appPackageName = "com.robtopx.geometryjump";
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
            } catch (android.content.ActivityNotFoundException anfe) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
            }
        });

        // Share the application
        ImageView share = findViewById(R.id.shareButton);
        share.setOnClickListener(v -> {
            try {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Que som é esse?");
                // Colocar alguma frase de efeito
                String shareMessage = "\nOi meu amor\n\n";
                shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + "com.robtopx.geometryjump" + "\n\n";
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                startActivity(Intent.createChooser(shareIntent, "Compartilhe com os amigos"));
            } catch (Exception e) {
                //e.toString();
            }
        });
        // Go to the progress menu
        ImageView startGame = findViewById(R.id.startGame);
        Intent intent = new Intent(this, ProgressMenu.class);
        startGame.setOnClickListener(v -> startActivity(intent));

        // Check in activity
        ImageView checkIn = findViewById(R.id.checkIn);
        Intent checkIntent = new Intent(this, LoginCount.class);
        checkIn.setOnClickListener(v -> startActivity(checkIntent));

        // Number of lives activity
        ImageView numLives = findViewById(R.id.numOfLives);
        Intent livesIntent = new Intent(this, Lives.class);
        numLives.setOnClickListener(v -> startActivity(livesIntent));

        // Buy more coins
        ImageView coinsView = findViewById(R.id.coinsButton);
        Intent coinsIntent = new Intent(this, Coins.class);
        coinsView.setOnClickListener(v -> startActivity(coinsIntent));

    }

    private boolean first_time_check() {
        prefs = getSharedPreferences("data", MODE_PRIVATE);
        String first = prefs.getString("first", null);
        return first == null;
    }

}