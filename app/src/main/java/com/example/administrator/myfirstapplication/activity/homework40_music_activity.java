package com.example.administrator.myfirstapplication.activity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;

import com.example.administrator.myfirstapplication.R;

/**
 * Created by Administrator on 2016/6/7 0007.
 */
public class homework40_music_activity extends BaseActivity {
    EditText et;
    AudioManager am;
    SeekBar sb;
    int f;
    private ServiceConnection con=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework40_playmusic);
        if(getIntent().getData()!=null){
            Uri u=getIntent().getData();
            Intent i=new Intent(this,homework40_music_service.class);
            i.putExtra("name",u.toString());
            bindService(i,con,BIND_AUTO_CREATE);
        }
        et= (EditText) findViewById(R.id.musicname);
        am= (AudioManager) getSystemService(Service.AUDIO_SERVICE);
        sb= (SeekBar) findViewById(R.id.seekBar2);
        sb.setProgress(am.getStreamVolume(AudioManager.STREAM_MUSIC));
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress>f){
                    am.adjustStreamVolume(AudioManager.STREAM_MUSIC,AudioManager.ADJUST_RAISE,AudioManager.FLAG_SHOW_UI);
                }else{
                    am.adjustStreamVolume(AudioManager.STREAM_MUSIC,AudioManager.ADJUST_LOWER,AudioManager.FLAG_SHOW_UI);
                }
                f=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public void startplay(View view){
        Intent i=new Intent(this,homework40_music_service.class);
        i.putExtra("name","/mnt/sdcard/Music/"+et.getText().toString());
        bindService(i,con,BIND_AUTO_CREATE);
    }
    public void stopplay(View view){
        unbindService(con);
    }
}
