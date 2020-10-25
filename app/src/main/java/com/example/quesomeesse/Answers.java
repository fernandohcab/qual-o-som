package com.example.quesomeesse;

public class Answers{

    // The level selected
    private final String level;
    // The expected answer
    private final String answer;
    // The audio played
    private final int audio;

    public Answers(String currentLevel, String correctAnswer, int audioID){
        this.level = currentLevel;
        this.answer = correctAnswer;
        this.audio = audioID;
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
}
