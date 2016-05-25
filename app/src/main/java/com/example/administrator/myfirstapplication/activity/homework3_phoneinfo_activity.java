package com.example.administrator.myfirstapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

/**
 * Created by Administrator on 16-5-19.
 */
public class homework3_phoneinfo_activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics m=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(m);
        int w=m.widthPixels;
        int h=m.heightPixels;
        float density=m.density;
        int densitydpi=m.densityDpi;
    }
}
