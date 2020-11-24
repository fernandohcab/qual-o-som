package com.example.quesomeesse;

import java.io.Serializable;

public class Answers implements Serializable {

    // The level selected, the audio to be played and if the level is done or not
    private final int level, audio, state;
    // The expected answer and the 3 other options
    private final String answer, op2, op3, op4;

    public Answers(int currentLevel, String correctAnswer, int audioID, int st, String opt2, String opt3, String opt4){
        this.level = currentLevel;
        this.answer = correctAnswer;
        this.audio = audioID;
        this.state = st;
        this.op2 = opt2;
        this.op3 = opt3;
        this.op4 = opt4;
    }

    public int getLevel(){
        return this.level;
    }

    public String getAnswer(){
        return this.answer;
    }

    public int getAudio(){
        return this.audio;
    }

    public int getState(){
        return this.state;
    }

    public int getImage(){
        if(this.getState() == 1){
            return R.drawable.lock;
        }
        else if(this.getState() == 2){
            return R.mipmap.undone;
        } else if(this.getState() == 3){
            return R.mipmap.done;
        }
        return 0;
    }

    public String getOp2(){
        return this.op2;
    }

    public String getOp3(){
        return this.op3;
    }

    public String getOp4(){
        return this.op4;
    }

}
