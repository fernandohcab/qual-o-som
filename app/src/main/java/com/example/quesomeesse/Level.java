package com.example.quesomeesse;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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

    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
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
            TextView updateLives = findViewById(R.id.lives);

            if (text.equals(intent.getExtras().getString("answer"))) {
                Toast toast = Toast.makeText(context, "Resposta correta", duration);
                toast.show();
                finish();
            } else {
                try {
                    int numOfLives = Integer.parseInt(updateLives.getText().toString());
                    if (numOfLives > 0) {
                        numOfLives -= 1;
                        updateLives.setText(Integer.toString(numOfLives));
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