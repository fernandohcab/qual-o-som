package com.example.quesomeesse;

import java.io.Serializable;

public class Answers implements Serializable {

    // The level selected
    private final int level;
    // The expected answer
    private final String answer;
    // The audio played
    private final int audio;
    // Done or undone
    private final int state;

    public Answers(int currentLevel, String correctAnswer, int audioID, int st){
        this.level = currentLevel;
        this.answer = correctAnswer;
        this.audio = audioID;
        this.state = st;
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
            return R.mipmap.heartat;
        }
        else if(this.getState() == 2){
            return R.mipmap.undone;
        } else if(this.getState() == 3){
            return R.mipmap.done;
        }
        return 0;
    }
}
