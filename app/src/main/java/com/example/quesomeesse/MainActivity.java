package com.example.quesomeesse;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // enable fullscreen mode
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        // Go to the configuration activity
            Intent configurationIntent = new Intent(this, Configuration.class);
            ImageView configuration = findViewById(R.id.config);
            configuration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(configurationIntent);
            }
        });

            ImageView noAds = findViewById(R.id.noAd);
            noAds.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String appPackageName = "com.robtopx.geometryjump";
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                    } catch (android.content.ActivityNotFoundException anfe) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                    }
                }
            });

            ImageView share = findViewById(R.id.shareButton);
            share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent shareIntent = new Intent(Intent.ACTION_SEND);
                        shareIntent.setType("text/plain");
                        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Que som é esse?");

                       // Colocar alguma frase de efeito
                        String shareMessage= "\nOi meu amor\n\n";
                        shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + "com.robtopx.geometryjump" +"\n\n";
                        shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                        startActivity(Intent.createChooser(shareIntent, "Compartilhe com os amigos"));
                    } catch(Exception e) {
                        //e.toString();
                    }
                }
            });

        ImageButton startGame = findViewById(R.id.startGame);
        Intent intent = new Intent(this, ProgressMenu.class);
        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}