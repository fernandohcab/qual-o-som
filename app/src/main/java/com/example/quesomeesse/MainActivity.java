package com.example.quesomeesse;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
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
    }

    // Go to the first level
    public void startGame(View view){
        Intent intent = new Intent(this, ProgressMenu.class);
        startActivity(intent);
    }


}