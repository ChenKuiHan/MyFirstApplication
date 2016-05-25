package com.example.administrator.myfirstapplication.activity;

import android.app.Activity;
import android.os.Bundle;

import com.example.administrator.myfirstapplication.view.homework5_drawxin_view;

/**
 * Created by Administrator on 16-5-12.
 */
public class homework5_drawxin_activity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        homework5_drawxin_view d=new homework5_drawxin_view(this);
        d.setOnTouchListener(d);

        setContentView(d);
    }
}
