package com.example.quesomeesse;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Objects;

public class SkipLevel extends AppCompatActivity {

    SharedPreferences prefs;
    TextView qty;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip_level);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();

        prefs = getSharedPreferences("data", MODE_PRIVATE);
        qty = findViewById(R.id.coinsQty);

        qty.setText("" + prefs.getInt("coins", 0));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onResume(){
        super.onResume();

        // Buy tip
        ImageView yes = findViewById(R.id.yesButton);

        yes.setOnClickListener(v -> {
            if((prefs.getInt("coins", 0) - 10 >= 0) || (prefs.getInt("coins", 0) - 15 >= 0) ) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("coins", prefs.getInt("coins", 0) - 20);
                editor.apply();
                qty.setText("" + prefs.getInt("coins", 0));
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

        // Buy more coins
        ImageView coinsView = findViewById(R.id.buyCoins);
        Intent coinsIntent = new Intent(this, Coins.class);
        coinsView.setOnClickListener(v -> startActivity(coinsIntent));

    }

}