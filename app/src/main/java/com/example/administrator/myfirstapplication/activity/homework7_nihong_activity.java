package com.example.administrator.myfirstapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.example.administrator.myfirstapplication.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 16-5-16.
 */
public class homework7_nihong_activity extends BaseActivity {

    Handler h=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            for(int i=0;i<5;i++){
                TextView tv=(TextView) findViewById(ids[i]);
                int s=i+index;
                if(s>4){
                    s=s%5;
                }
                tv.setBackgroundColor(colors[s]);
            }
            index++;

        }
    };
    int[] colors = {0xFFFF0000,0xfff436ea,0xff00aaff,0xff00ff6f,0xffffea00};
    int[] ids = {R.id.a1,R.id.a2,R.id.a3,R.id.a4,R.id.a5};
    int index = 0;
    Timer t=new Timer();
    boolean flag=true;
    @Override
    protected void contectview(Bundle savedInstanceState) {
         setContentView(R.layout.homework7nihong);

        if(flag){
            flag=false;
            t.schedule(new TimerTask(){
                @Override
                public void run() {
                    Message m=new Message();
                    m.what=1;
                    h.sendMessage(m);
                }
            },100,1000);
        }

    }
}
