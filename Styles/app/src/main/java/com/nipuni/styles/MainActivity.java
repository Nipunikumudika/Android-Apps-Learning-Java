package com.nipuni.styles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_login;
    Button btn_stop;
    ConstraintLayout cl_play;

    Animation animation_fad_in;
    Animation animation_fad_out;

    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_login = findViewById(R.id.button);
        btn_stop = findViewById(R.id.btn_stop);
        cl_play = findViewById(R.id.cl_play);

        animation_fad_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        animation_fad_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);

        if (player == null){
            player = MediaPlayer.create(getApplicationContext(), R.raw.sound);
            player.start();
        }

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //cl_play.startAnimation(animation_fad_in);
                player.pause();

            }
        });


        cl_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //play music
                if (player == null){
                    player = MediaPlayer.create(getApplicationContext(), R.raw.sound);
                    player.start();
                }
                else {
                    player.start();
                }

            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player != null){
                    player.release();
                    player = null;
                }
            }
        });


    }
}