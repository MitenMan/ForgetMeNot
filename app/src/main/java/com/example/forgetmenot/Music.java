package com.example.forgetmenot;

public class Music {
    private String name;
    private String singer;
    private int song;

    public Music(String name, String singer, int song) {
        this.name = name;
        this.singer = singer;       //setting the variables for the song name, singer and the song file in the resources
        this.song = song;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getSong() {
        return song;
    }

    public void setSong(int song) {
        this.song = song;
    }
}

