package com.example.administrator.myfirstapplication.activity;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.example.administrator.myfirstapplication.R;

/**
 * Created by Administrator on 2016/6/1 0001.
 */
public class homework_boom_activity extends BaseActivity {

    ImageView iv;
    ImageView iv2;
    AnimationDrawable ad;

    MediaPlayer music;
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework_boom);

        iv = (ImageView) findViewById(R.id.animIv);
        iv2= (ImageView) findViewById(R.id.image11);
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

    public void start(View view){
        Animation a= new AlphaAnimation(1,0.2f);
        Animation b=new RotateAnimation(0,1800);
        AnimationSet as=new AnimationSet(true);
        as.addAnimation(a);
        as.addAnimation(b);
        as.setDuration(3000);
        iv2.startAnimation(as);
    }
}
