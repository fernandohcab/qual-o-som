package com.example.quesomeesse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Objects;

public class LoginCount extends AppCompatActivity {
    public int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_count);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();

        TextView start = findViewById(R.id.relogio);
        start.setOnClickListener(v -> new CountDownTimer(5000, 1000){
            public void onTick(long millisUntilFinished){
                start.setText(String.valueOf(counter));
                counter++;
            }
            public  void onFinish(){
                start.setText("FINISH!!");
            }
        }.start());

    }
}