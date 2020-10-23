package com.example.quesomeesse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Level extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

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
    public void validation(View view){
        EditText answer = findViewById(R.id.answer);
        Context context = getApplicationContext();
        CharSequence text = answer.getText().toString();
        int duration = Toast.LENGTH_SHORT;

        if(text.equals("oi amor")) {
            Toast toast = Toast.makeText(context, "Resposta correta", duration);
            toast.show();
           // Intent intent = new Intent(this, Level2.class);
            //startActivity(intent);
        }else{
            Toast toast = Toast.makeText(context, "Resposta incorreta", duration);
            toast.show();
        }
    }

    public void reproduceSound(View view){
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.oiamor);
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