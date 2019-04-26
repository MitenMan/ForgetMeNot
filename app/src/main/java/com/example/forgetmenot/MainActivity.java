package com.example.forgetmenot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView home;
    private ImageView question;            //navigation bar variables
    private ImageView game;
    private ImageView music;

    TextView place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home = (ImageView) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override                                                  //Navigation Bar setup
            public void onClick(View v) {
                openHome();
            }
        });           //navigation bar

        question = (ImageView) findViewById(R.id.question);
        question.setOnClickListener(new View.OnClickListener() {
            @Override                                                  //Navigation Bar setup
            public void onClick(View v) {
                openQuestion();
            }
        });  //navigation bar

        game = (ImageView) findViewById(R.id.game);
        game.setOnClickListener(new View.OnClickListener() {
            @Override                                                  //Navigation Bar setup
            public void onClick(View v) {
                openGame();
            }
        });           //navigation bar

        music = (ImageView) findViewById(R.id.music);
        music.setOnClickListener(new View.OnClickListener() {
            @Override                                                  //Navigation Bar setup
            public void onClick(View v) {
                openMusic();
            }
        });         //navigation bar

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
