package com.example.helen.leaguepro;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class ChampionActivity extends YouTubeBaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion);

        Intent intent = getIntent();        //     Receives the Intent passed
        int position = intent.getIntExtra("Champion Index", 0);

        Champion[] champions = LeagueActivity.champions;
        final Champion champ = champions[position];


        //  Champion's Dynamic Background

        final VideoView videoView = findViewById(R.id.moving);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+ champ.getBackground());
        videoView.setVideoURI(uri);
        videoView.start();

        videoView.setOnCompletionListener ( new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                videoView.start();
            }
        });

        // Champions's Name, Bio, etc.

        TextView name = findViewById(R.id.champ_name);
        TextView title = findViewById(R.id.champ_title);
        TextView bio = findViewById(R.id.champ_bio);
        final YouTubePlayerView vid = findViewById(R.id.vid);


        name.setText(champ.getName());
        title.setText(champ.getAlias());
        bio.setText(champ.getBio());



        // Plays Champion's unique voiceline onCreate / once GridView is clicked
        // and everything is initialized, not played too early







        final YouTubePlayer.OnInitializedListener onInitializedListener = new YouTubePlayer.OnInitializedListener(){

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                youTubePlayer.loadVideo(champ.getLink());

                youTubePlayer.play();
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };


        vid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vid.initialize("AIzaSyDgbZ4Gc-LHvURUKTT4ZrZ7oa24VLSMhic", onInitializedListener);
            }
        });



    }


}
