package com.example.administrator.myfirstapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.example.administrator.myfirstapplication.view.homework_huaxian_view;

/**
 * Created by Administrator on 2016/6/1 0001.
 */
public class homework_huaxian_activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homework_huaxian_view h=new homework_huaxian_view(this);
        h.setOnTouchListener(h);
        setContentView(h);
    }
}
