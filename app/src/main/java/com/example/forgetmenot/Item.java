package com.example.forgetmenot;

public class Item {

    private String question, answer;

    public Item(String question, String answer) {
        this.question = question;                   //defining the question and answer variables
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
