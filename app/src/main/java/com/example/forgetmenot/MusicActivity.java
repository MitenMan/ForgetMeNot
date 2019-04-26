package com.example.forgetmenot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MusicActivity extends AppCompatActivity {

    private ImageView home;
    private ImageView question;     //nav bar objects
    private ImageView game;
    private ImageView music;

    private ArrayList<Music> arrayList;
    private CustomMusicAdapter adapter;     //music player objects
    private ListView songList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        songList = (ListView) findViewById(R.id.songList);
        arrayList = new ArrayList<>();
        arrayList.add(new Music("Lofi 1", "Jinsang", R.raw.lofi1));
        arrayList.add(new Music("Lofi 2", "The Deli", R.raw.lofi2));
        arrayList.add(new Music("Temple of Time", "Nintendo", R.raw.calm));          //List of songs currently playable
        arrayList.add(new Music("Rain", "Ambient Sounds", R.raw.rain));
        arrayList.add(new Music("Eterna Forest", "Nintendo", R.raw.forest));
        arrayList.add(new Music("Waves", "Ambient Sounds", R.raw.waves));

        adapter = new CustomMusicAdapter(this, R.layout.custom_music_item, arrayList);
        songList.setAdapter(adapter);


        home = (ImageView) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override                                                  //Navigation Bar setup
            public void onClick(View v) {
                openHome();
            }
        });             //Navigation

        question = (ImageView) findViewById(R.id.question);
        question.setOnClickListener(new View.OnClickListener() {
            @Override                                                  //Navigation Bar setup
            public void onClick(View v) {
                openQuestion();
            }
        });             //Navigation

        game = (ImageView) findViewById(R.id.game);
        game.setOnClickListener(new View.OnClickListener() {
            @Override                                                  //Navigation Bar setup
            public void onClick(View v) {
                openGame();
            }
        });             //Navigation

        music = (ImageView) findViewById(R.id.music);
        music.setOnClickListener(new View.OnClickListener() {
            @Override                                                  //Navigation Bar setup
            public void onClick(View v) {
                openMusic();
            }
        });             //Navigation

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
