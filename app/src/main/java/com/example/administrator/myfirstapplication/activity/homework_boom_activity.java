package com.example.administrator.myfirstapplication.activity;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.myfirstapplication.R;

/**
 * Created by Administrator on 2016/6/1 0001.
 */
public class homework_boom_activity extends BaseActivity {

    ImageView iv;

    AnimationDrawable ad;

    MediaPlayer music;
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework_boom);

        iv = (ImageView) findViewById(R.id.animIv);
        ad = (AnimationDrawable) iv.getBackground();
    }

    public void play(View view)
    {
        ad.start();
        if(music == null)
        {
            music = MediaPlayer.create(this,R.raw.bomb);
        }
        music.start();
    }

    public void stop(View view)
    {
        ad.stop();
    }
}
