package com.example.quesomeesse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

public class Tips extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        SharedPreferences prefs = getSharedPreferences("data", MODE_PRIVATE);

        if((prefs.getInt("coins", 0) - 10 > 0) || (prefs.getInt("coins", 0) - 15 > 0) ) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("coins", prefs.getInt("coins", 0) - 10);
            editor.apply();
            Toast.makeText(getApplicationContext(), "A dica será exibida aqui e custa 10", Toast.LENGTH_LONG).show();
        }
    }
}