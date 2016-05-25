package com.example.administrator.myfirstapplication.activity;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Administrator on 16-5-13.
 */
public class homework_tanqiu_moveair_activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.example.administrator.myfirstapplication.view.homework_tanqiu_moveair_view a=new com.example.administrator.myfirstapplication.view.homework_tanqiu_moveair_view(this);
        a.setOnTouchListener(a);
        setContentView(a);
    }
}
