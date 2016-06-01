package com.example.administrator.myfirstapplication.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ViewSwitcher;

import com.example.administrator.myfirstapplication.R;
import com.example.administrator.myfirstapplication.view.homework5_drawxin_view;
import com.example.administrator.myfirstapplication.view.homework_tanqiu_moveair_view;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/5/31 0031.
 */
public class homework14_autoplayview_activity extends BaseActivity {
    ViewSwitcher vs;
    Timer t;
    Handler h=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            vs.showNext();
        }
    };
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework14_autoplayview);
        vs= (ViewSwitcher) findViewById(R.id.switcher);
        homework_tanqiu_moveair_view a=new homework_tanqiu_moveair_view(this);
        vs.addView(a);
        homework5_drawxin_view b=new homework5_drawxin_view(this);
        vs.addView(b);

        t=new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                Message m=new Message();
                m.what=1;
                h.sendMessage(m);
            }
        },100,3000);
    }
}
