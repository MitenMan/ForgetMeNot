package com.example.forgetmenot;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomMusicAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Music> arrayList;
    private MediaPlayer mediaPlayer;
    private Boolean flag = true;

    public CustomMusicAdapter(Context context, int layout, ArrayList<Music> arrayList) {
        this.context = context;
        this.layout = layout;               //variables
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView txtName, txtSinger;    //changing the song and singer name
        ImageView ivPlay, ivStop;       //play and stop buttons
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(layout, null);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.txtName);
            viewHolder.txtSinger = (TextView) convertView.findViewById(R.id.txtSinger);     //matching the variables with the XML IDs
            viewHolder.ivPlay = (ImageView) convertView.findViewById(R.id.ivPlay);
            viewHolder.ivStop = (ImageView) convertView.findViewById(R.id.ivStop);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Music music = arrayList.get(position);

        viewHolder.txtName.setText(music.getName());        //setting the song and singer name in the List View
        viewHolder.txtSinger.setText(music.getSinger());

        // play music
        viewHolder.ivPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag){
                    mediaPlayer = MediaPlayer.create(context, music.getSong());
                    flag = false;
                }
                if(mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    viewHolder.ivPlay.setImageResource(R.drawable.ic_play);  //if music is not playing, play button remains as it is
                } else {
                    mediaPlayer.start();
                    viewHolder.ivPlay.setImageResource(R.drawable.ic_pause);  //play button changes to pause button when music is playing
                }
            }
        });

        // stop
        viewHolder.ivStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!flag) {
                    mediaPlayer.stop();
                    mediaPlayer.release();  //music player function stopped when Stop button is pressed
                    flag = true;
                }
                viewHolder.ivPlay.setImageResource(R.drawable.ic_play);  //changing the pause button back to play if music is stopped
            }
        });

        return convertView;
    }
}
