package com.example.quesomeesse;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class Tips extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();

        SharedPreferences prefs = getSharedPreferences("data", MODE_PRIVATE);

        // Buy tip
        ImageView yes = findViewById(R.id.yesButton);
        TextView qty = findViewById(R.id.coinsQty);
        TextView showTip = findViewById(R.id.showTip);
        qty.setText("" + prefs.getInt("coins", 0));
        yes.setOnClickListener(v -> {
            if((prefs.getInt("coins", 0) - 10 >= 0) || (prefs.getInt("coins", 0) - 15 >= 0) ) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("coins", prefs.getInt("coins", 0) - 10);
                editor.apply();
                qty.setText("" + prefs.getInt("coins", 0));
                showTip.setText("A dica será mostrada aqui");
            }
            else{
                Toast.makeText(getApplicationContext(), "Você não tem moedas o suficiente", Toast.LENGTH_LONG).show();
            }
        });

        // Go back button
        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(v -> finish());

        // Do not buy
        ImageView no = findViewById(R.id.noButton);
        no.setOnClickListener(v -> finish());
    }
}