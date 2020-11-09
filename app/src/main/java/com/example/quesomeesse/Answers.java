package com.example.quesomeesse;

import java.io.Serializable;

public class Answers implements Serializable {

    // The level selected
    private final String level;
    // The expected answer
    private final String answer;
    // The audio played
    private final int audio;
    // Done or undone
    private final boolean state;

    public Answers(String currentLevel, String correctAnswer, int audioID, boolean st){
        this.level = currentLevel;
        this.answer = correctAnswer;
        this.audio = audioID;
        this.state = st;
    }

    public String getLevel(){
        return this.level;
    }

    public String getAnswer(){
        return this.answer;
    }

    public int getAudio(){
        return this.audio;
    }

    public boolean getState(){
        return this.state;
    }

    public int getImage(){
        if(this.getState()){
            return R.mipmap.done;
        }
        else{
            return R.mipmap.undone;
        }
    }

}
