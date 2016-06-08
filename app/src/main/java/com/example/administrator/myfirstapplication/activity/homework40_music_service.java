package com.example.administrator.myfirstapplication.activity;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by ChenKuiHan on 2016/6/7 0007.
 */
public class homework40_music_service extends Service{
    MediaPlayer mp;
    mybinder m=new mybinder();
    public class mybinder extends Binder{
        public void setvolume(int i){

        }
    }
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        String s=intent.getStringExtra("name");
        mp=MediaPlayer.create(this, Uri.parse(s));
        mp.start();
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.stop();
    }
}
