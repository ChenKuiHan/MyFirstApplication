package com.example.administrator.myfirstapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

import com.example.administrator.myfirstapplication.R;

/**
 * Created by Administrator on 16-5-19.
 */
public class homework3_phoneinfo_activity extends BaseActivity {
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework3);
        TextView tv= (TextView) findViewById(R.id.text);
        DisplayMetrics m=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(m);
        int w=m.widthPixels;
        int h=m.heightPixels;
        float density=m.density;
        int densitydpi=m.densityDpi;
        tv.setText("宽："+w+"\n高："+h+"\n屏幕密度："+density+"\nDPI："+densitydpi);
    }
}
