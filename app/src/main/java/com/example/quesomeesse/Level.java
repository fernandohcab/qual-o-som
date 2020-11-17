package com.example.quesomeesse;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.Serializable;
import java.util.Objects;

public class Level extends AppCompatActivity implements View.OnClickListener {

    SharedPreferences prefs;
    TextView lives, coins;
    MediaPlayer mediaPlayer;
    Button b1, b2, b3, b4;
    Answers status;

    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);


        lives = findViewById(R.id.lives);
        coins = findViewById(R.id.coinsQty);
        prefs = getSharedPreferences("data", MODE_PRIVATE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Intent intent = getIntent();
        status = (Answers) intent.getSerializableExtra("state");
        mediaPlayer = MediaPlayer.create(this, status.getAudio());


        b1 = findViewById(R.id.button1);
        b1.setText(status.getAnswer());
        b2 = findViewById(R.id.button2);
        b2.setText(status.getOp2());
        b3 = findViewById(R.id.button3);
        b3.setText(status.getOp3());
        b4 = findViewById(R.id.button4);
        b4.setText(status.getOp4());
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onResume() {
        super.onResume();

        lives.setText("" + prefs.getInt("lives", 0));
        coins.setText("" + prefs.getInt("coins", 0));

        Intent intent = getIntent();

        ImageView playSoundButton = findViewById(R.id.playSoundButton);
        playSoundButton.setOnClickListener(v -> {
            if(!mediaPlayer.isPlaying()){
                mediaPlayer.start();
            }
            else{
                mediaPlayer.pause();
            }
        });


        // Finish the activity and go back to the main menu
        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());

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

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @Override
    public void onClick(View v){
       CharSequence text = "";
        switch (v.getId()){
            case R.id.button1:
                text = b1.getText().toString().toLowerCase().trim();
                break;
            case R.id.button2:
                text = b2.getText().toString().toLowerCase().trim();
                break;
            case R.id.button3:
                text = b3.getText().toString().toLowerCase().trim();
                break;
            case R.id.button4:
                text = b4.getText().toString().toLowerCase().trim();
                break;
            default:
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_SHORT).show();
        }
        Context context = getApplicationContext();
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
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
    }

    @Override
    public void onStop(){
        super.onStop();
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }
}


