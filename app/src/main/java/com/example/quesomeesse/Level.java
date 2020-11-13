package com.example.quesomeesse;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.Serializable;
import java.util.Objects;

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

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();

    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onResume() {
        super.onResume();

        lives.setText("" + prefs.getInt("lives", 0));
        coins.setText("" + prefs.getInt("coins", 0));

        Intent intent = getIntent();
        Answers status = (Answers) intent.getSerializableExtra("state");

        ImageView playSoundButton = findViewById(R.id.playSoundButton);
        MediaPlayer mediaPlayer = MediaPlayer.create(this, status.getAudio());
        playSoundButton.setOnClickListener(v -> {
            if(!mediaPlayer.isPlaying()){
                mediaPlayer.start();
            }
        });

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

            if (text.equals(status.getAnswer())) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("coins", prefs.getInt("coins", 0) + 30);
                editor.putInt(Integer.toString(status.getLevel()), 3);
                editor.putInt(Integer.toString(status.getLevel() + 1), 2);
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
                        if(!isMyServiceRunning(Reload.class)) {
                            startService(new Intent(this, Reload.class));
                        }
                        } else {
                        Toast toast = Toast.makeText(context, "Suas vidas acabaram", duration);
                        toast.show();
                    }
                } catch (NumberFormatException e) {
                    // ver o que fazer aqui
                }
            }
        });

        // Skip the current level
        ImageView skip = findViewById(R.id.nextLevelButton);
        Intent intentSkip = new Intent(this, SkipLevel.class);
        skip.setOnClickListener(v -> {
          /*  if( (prefs.getInt("coins", 0) - 10 > 0) || (prefs.getInt("coins", 0) - 15 > 0) ) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("coins", prefs.getInt("coins", 0) - 15);
                editor.apply();
                coins.setText("" + prefs.getInt("coins", 0));
            }
            else{
                Toast.makeText(getApplicationContext(), "Você não tem mais moedas", Toast.LENGTH_SHORT).show();
            }*/
            startActivity(intentSkip);
        });

        // Show tip button
        ImageView tips = findViewById(R.id.tipButton);
        Intent intentTips = new Intent(this, Tips.class);
        tips.setOnClickListener(v-> startActivity(intentTips));

        // Buy more lives
        ImageView lives = findViewById(R.id.buyLives);
        Intent intentLives = new Intent(this, Lives.class);
        lives.setOnClickListener(v -> startActivity(intentLives));

        // Buy more coins
        ImageView coinsView = findViewById(R.id.coinsButton);
        Intent intentCoins = new Intent(this, Coins.class);
        coinsView.setOnClickListener(v -> startActivity(intentCoins));

    }

    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

}

