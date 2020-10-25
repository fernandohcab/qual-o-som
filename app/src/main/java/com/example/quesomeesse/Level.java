package com.example.quesomeesse;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Level extends AppCompatActivity{

    private String expectedAnswer;
    private int audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        Intent intent = getIntent();

        this.expectedAnswer = intent.getExtras().getString("answer");
        this.audio = intent.getExtras().getInt("audio");

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        ImageView playSoundButton = findViewById(R.id.playSoundButton);
        playSoundButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                reproduceSound(v);
            }
        });

        // Finish the activity and go back to the main menu
        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });
    }

    // See if the inserted text is correct
    @SuppressLint("SetTextI18n")
    public void validation(View view){
        EditText answer = findViewById(R.id.answer);
        Context context = getApplicationContext();
        CharSequence text = answer.getText().toString().toLowerCase().trim();
        int duration = Toast.LENGTH_SHORT;

        if(text.equals(this.expectedAnswer)) {
            Toast toast = Toast.makeText(context, "Resposta correta", duration);
            toast.show();
            finish();
        }else{
            TextView tv = findViewById(R.id.lives);
            tv.setText("10");
            try {
                int numOfLives = Integer.parseInt(tv.getText().toString());
                if(numOfLives > 0) {
                    numOfLives -= 1;
                    tv.setText(Integer.toString(numOfLives));
                    Toast toast = Toast.makeText(context, "Resposta incorreta", duration);
                    toast.show();
                }
                else{
                    Toast toast = Toast.makeText(context, "Suas vidas acabaram", duration);
                    toast.show();
                }
            }
            catch (NumberFormatException e)
            {
                int numOfLives = Integer.parseInt(tv.getText().toString());
                numOfLives -= 1;
                tv.setText(Integer.toString(numOfLives));
            }

        }
    }

    public void reproduceSound(View view){
        MediaPlayer mediaPlayer = MediaPlayer.create(this, this.audio);
        mediaPlayer.start();
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