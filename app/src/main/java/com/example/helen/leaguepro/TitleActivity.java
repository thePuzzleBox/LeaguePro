package com.example.helen.leaguepro;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;


public class TitleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        getSupportActionBar().setDisplayShowHomeEnabled(true);      // LOL Logo in ActionBar
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final VideoView videoView = findViewById(R.id.intro);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.runes);
        videoView.setVideoURI(uri);
        videoView.start();


        ImageView b = findViewById(R.id.button);
        final MediaPlayer click = MediaPlayer.create(TitleActivity.this, R.raw.mastery4);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                click.start();
                Intent intent = new Intent(TitleActivity.this, LeagueActivity.class);
                startActivity(intent);

            }
        });
    }
}
