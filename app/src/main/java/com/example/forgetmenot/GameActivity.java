package com.example.forgetmenot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView home;
    private ImageView question;         //navigation bar variables
    private ImageView game;
    private ImageView music;

    private TextView wordTv;
    private EditText wordEntered;
    private Button solve, nextWord;  //creating new variables
    private String wordToFind;


       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        home = (ImageView) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override                                                  //Navigation Bar setup
            public void onClick(View v) {
                openHome();
            }
        });         //navigation bar

        question = (ImageView) findViewById(R.id.question);
        question.setOnClickListener(new View.OnClickListener() {
            @Override                                                           //navigation bar
            public void onClick(View v) {
                openQuestion();
            }
        });

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

        wordTv = (TextView) findViewById(R.id.wordTv);
        wordEntered = (EditText) findViewById(R.id.wordEntered);
        solve = (Button) findViewById(R.id.solve);                  //matching variables with XML Ids
        solve.setOnClickListener(this);
        nextWord = (Button) findViewById(R.id.nextWord);
        nextWord.setOnClickListener(this);

        nextWord();

    }

    @Override
    public void onClick(View view){
           if (view == solve){
               solve();
           } else if (view == nextWord){        //setting up the solve and next word buttons
               nextWord();
           }
    }

    private void solve(){
           String w = wordEntered.getText().toString(); //converting the entry by the user into string

           if(wordToFind.equals(w)){
               Toast.makeText(this, "Correct! It was " + wordToFind, Toast.LENGTH_SHORT).show(); //success toast message
               nextWord();
           } else {
               Toast.makeText(this, "Incorrect. Please Try Again.", Toast.LENGTH_SHORT).show(); //mistake toast message
           }
    }

    private void nextWord(){
           wordToFind = AnagramActivity.randomWord();
           String wordShuffled = AnagramActivity.shuffleWord(wordToFind); //shuffle words so they dont follow the same order
           wordTv.setText(wordShuffled);
           wordEntered.setText("");
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

