package com.example.administrator.myfirstapplication.activity;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.administrator.myfirstapplication.R;

import java.io.File;

/**
 * Created by ChenKuiHan on 2016/6/8 0008.
 */
public class homework_videoview_activity extends BaseActivity {
    VideoView vv;
    MediaController mc;
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework_video);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        vv= (VideoView) findViewById(R.id.videoView);
        mc=new MediaController(this);
        File video=new File("/mnt/sdcard/mm.mp4");
        if(video.exists()){
            vv.setVideoPath(video.getAbsolutePath());
            vv.setMediaController(mc);
            mc.setMediaPlayer(vv);
            vv.requestFocus();
        }
    }
}
