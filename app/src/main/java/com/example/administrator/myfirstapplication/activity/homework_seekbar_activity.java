package com.example.administrator.myfirstapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;

import com.example.administrator.myfirstapplication.R;

/**
 * Created by Administrator on 16-5-23.
 */
public class homework_seekbar_activity extends Activity {
    ImageView iv;
    ProgressBar pb;
    ProgressBar pb1;
    SeekBar sb;
    RatingBar rb;
    int i;
    Handler h=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            pb.setProgress(msg.what);
            if(i>=100){
                pb1.setVisibility(View.GONE);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homework_seekbar);
        iv= (ImageView) findViewById(R.id.img);
        pb= (ProgressBar) findViewById(R.id.progressBar4);
        pb1= (ProgressBar) findViewById(R.id.progressBar);
        sb= (SeekBar) findViewById(R.id.seekBar);
        rb= (RatingBar) findViewById(R.id.ratingBar);
        i=pb.getProgress();
        (new Thread(){
            @Override
            public void run() {
                super.run();
                while (i<100){
                    try {
                        sleep(1000);
                        i+=5;
                        Message m=new Message();
                        m.what=i;
                        h.sendMessage(m);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                iv.setImageAlpha(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                iv.setImageAlpha((int )rating*255/6);
            }
        });
    }
}
