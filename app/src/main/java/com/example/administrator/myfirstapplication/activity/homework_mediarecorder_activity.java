package com.example.administrator.myfirstapplication.activity;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.administrator.myfirstapplication.R;

import java.io.File;

/**
 * Created by ChenKuiHan on 2016/6/8 0008.
 */
public class homework_mediarecorder_activity extends BaseActivity {
    MediaRecorder recorder;

    File file;
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework_media);
    }
    public void record(View view)
    {
        file = new File("/mnt/sdcard/sound.amr");
        try{
            recorder = new MediaRecorder();
            recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            recorder.setOutputFile(file.getAbsolutePath());

            recorder.prepare();
            recorder.start();
        }catch(Exception e){

        }
    }

    public void stop(View view)
    {
        if(file != null && file.exists())
        {
            recorder.stop();
            recorder.release();
            recorder = null;
            file = null;
        }
        MediaPlayer mp;
        mp=MediaPlayer.create(this, Uri.parse("/mnt/sdcard/sound.amr"));
        mp.start();
    }

    @Override
    protected void onDestroy() {
        if(file != null && file.exists())
        {
            recorder.stop();
            recorder.release();
            recorder = null;
            file = null;
        }
        super.onDestroy();
    }
}
