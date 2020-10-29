package com.example.quesomeesse;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Level extends AppCompatActivity {

    SharedPreferences prefs;
    TextView lives, coins;

    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        lives = findViewById(R.id.lives);
        coins = findViewById(R.id.coinsQty);
        prefs = getSharedPreferences("data", MODE_PRIVATE);
        lives.setText("" + prefs.getInt("lives", 0));
        coins.setText("" + prefs.getInt("coins", 0));

        Intent intent = getIntent();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        ImageView playSoundButton = findViewById(R.id.playSoundButton);
        MediaPlayer mediaPlayer = MediaPlayer.create(this, intent.getExtras().getInt("audio"));
        playSoundButton.setOnClickListener(v -> mediaPlayer.start());

        // Finish the activity and go back to the main menu
        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());

        // Send the answer
        Button sendAnswer = findViewById(R.id.send);
        sendAnswer.setOnClickListener(v -> {
            EditText answer = findViewById(R.id.answer);
            Context context = getApplicationContext();
            CharSequence text = answer.getText().toString().toLowerCase().trim();
            int duration = Toast.LENGTH_SHORT;

            if (text.equals(intent.getExtras().getString("answer"))) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("coins", prefs.getInt("coins", 0) + 30);
                editor.apply();
                coins.setText("" + prefs.getInt("coins", 0));
                Toast toast = Toast.makeText(context, "Resposta correta", duration);
                toast.show();
                finish();
            } else {
                try {
                    int numOfLives = Integer.parseInt(lives.getText().toString());
                    if (numOfLives > 0) {
                        numOfLives -= 1;
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("lives", numOfLives);
                        editor.apply();
                        lives.setText("" + prefs.getInt("lives", 0));
                        Toast toast = Toast.makeText(context, "Resposta incorreta", duration);
                        toast.show();
                    } else {
                        Toast toast = Toast.makeText(context, "Suas vidas acabaram", duration);
                        toast.show();
                    }
                } catch (NumberFormatException e) {
                    //int numOfLives = Integer.parseInt(tv.getText().toString());
                    //  numOfLives -= 1;
                    //tv.setText(Integer.toString(numOfLives));
                }
            }
        });

        // Skip the current level
        ImageView skip = findViewById(R.id.nextLevelButton);
        skip.setOnClickListener(v -> {
            if( (prefs.getInt("coins", 0) - 10 > 0) || (prefs.getInt("coins", 0) - 15 > 0) ) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("coins", prefs.getInt("coins", 0) - 15);
                editor.apply();
                coins.setText("" + prefs.getInt("coins", 0));
            }
            else{
                Toast.makeText(getApplicationContext(), "Você não tem mais moedas", Toast.LENGTH_SHORT).show();
            }
        });

        // Show tip button
        ImageView tips = findViewById(R.id.tipButton);
        Intent intentTips = new Intent(this, Tips.class);
        tips.setOnClickListener(v-> startActivity(intentTips));
    }
}

/* estudar esse código
* private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };
*
* */