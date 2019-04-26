package com.example.forgetmenot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {

    private ImageView home;
    private ImageView question;
    private ImageView game;
    private ImageView music;

    Button b_continue;
    TextView tv_question;       //creating new variables
    EditText et_answer;

    List<Item> questions;
    int curQuestion = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        home = (ImageView) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override                                                  //Navigation Bar setup
            public void onClick(View v) {
                openHome();
            }
        });      //navigation bar

        question = (ImageView) findViewById(R.id.question);
        question.setOnClickListener(new View.OnClickListener() {
            @Override                                                  //Navigation Bar setup
            public void onClick(View v) {
                openQuestion();
            }
        }); //navigation bar

        game = (ImageView) findViewById(R.id.game);
        game.setOnClickListener(new View.OnClickListener() {
            @Override                                                  //Navigation Bar setup
            public void onClick(View v) {
                openGame();
            }
        });         //navigation bar

        music = (ImageView) findViewById(R.id.music);
        music.setOnClickListener(new View.OnClickListener() {
            @Override                                                  //Navigation Bar setup
            public void onClick(View v) {
                openMusic();
            }
        });         //navigation bar

        b_continue = (Button) findViewById(R.id.b_continue);
        tv_question = (TextView) findViewById(R.id.tv_question);    //matching the variables with their counterparts from the XML file
        et_answer = (EditText) findViewById(R.id.et_answer);

        b_continue.setVisibility(View.INVISIBLE);

        questions = new ArrayList<>();
        // add all questions and answers to the game
        for(int i = 0; i < QuestionDatabase.questions.length; i++){
            questions.add(new Item(QuestionDatabase.questions[i], QuestionDatabase.answers[i]));
        }
        // shuffle the questions
        Collections.shuffle(questions);

        tv_question.setText(questions.get(curQuestion).getQuestion());


        et_answer.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //check if the answer is correct
                if(et_answer.getText().toString().equalsIgnoreCase(questions.get(curQuestion).getAnswer())){
                    b_continue.setVisibility(View.VISIBLE); //making the button visible if the answer is correct
                } else {
                    b_continue.setVisibility(View.INVISIBLE); //otherwise button stays invisible

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        b_continue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (curQuestion < QuestionDatabase.questions.length - 1) {
                    curQuestion++;
                    tv_question.setText(questions.get(curQuestion).getQuestion());
                    b_continue.setVisibility(View.INVISIBLE);
                    et_answer.setText("");
                    Toast.makeText(QuestionActivity.this, "Correct Answer!", Toast.LENGTH_SHORT).show();    //success message if answer is correct
                } else {
                    //no more questions
                    Toast.makeText(QuestionActivity.this, "Congratulations, you won!", Toast.LENGTH_SHORT).show(); //success message if all questions answered correctly
                    finish();
                }

            }
        });

    }

    public void openHome() {
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);                                                  //navigation script
    }

    public void openQuestion() {
        Intent intent = new Intent (this, QuestionActivity.class);
        startActivity(intent);                                                  //navigation script
    }

    public void openMusic() {
        Intent intent = new Intent (this, MusicActivity.class);
        startActivity(intent);                                                  //navigation script
    }

    public void openGame() {
        Intent intent = new Intent (this, GameActivity.class);
        startActivity(intent);                                                  //navigation script
    }

}
