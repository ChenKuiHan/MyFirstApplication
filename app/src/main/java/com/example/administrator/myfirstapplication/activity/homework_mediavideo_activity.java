package com.example.administrator.myfirstapplication.activity;

import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.example.administrator.myfirstapplication.R;

import java.io.File;

/**
 * Created by ChenKuiHan on 2016/6/8 0008.
 */
public class homework_mediavideo_activity extends BaseActivity{
    File file;
    MediaRecorder recorder;

    SurfaceView sv;

    boolean running;
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework_media_video);
        sv = (SurfaceView) findViewById(R.id.sView);
        sv.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        sv.getHolder().setFixedSize(320,280);
        sv.getHolder().setKeepScreenOn(true);
    }
    public void record(View view) {
        file = new File("/mnt/sdcard/test.mp4");

        try{
            recorder = new MediaRecorder();
            recorder.reset();
            recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            recorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
            recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
            recorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
            recorder.setVideoEncoder(MediaRecorder.VideoEncoder.MPEG_4_SP);
            recorder.setOrientationHint(90);
//            recorder.setVideoSize(320,280);
            recorder.setVideoFrameRate(4);
            recorder.setOutputFile(file.getAbsolutePath());

            recorder.setPreviewDisplay(sv.getHolder().getSurface());

            recorder.prepare();
            recorder.start();
            running = true;
        }catch(Exception e){

        }
    }

    public void stop(View view) {
        if(running) {
            recorder.stop();
            recorder.release();
            recorder = null;
            file = null;
            running = false;
        }
    }
    public void playvideo(View view){
        Intent i=new Intent(this,homework_videoview_activity.class);
        i.putExtra("path","/mnt/sdcard/test.mp4");
        startActivity(i);
    }
}
