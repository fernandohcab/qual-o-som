package com.example.quesomeesse;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Objects;

public class SplashScreen extends AppCompatActivity {

    private final static int SPLASH_SCREEN_TIME_OUT=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();

        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(() -> {
            Intent i=new Intent(SplashScreen.this, MainActivity.class);
            startActivity(i);
            finish();
        }, SPLASH_SCREEN_TIME_OUT);
    }
}
