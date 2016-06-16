package com.example.administrator.myfirstapplication.activity;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by ChenKuiHan on 2016/6/16 0016.
 */
public class init extends Application {
    @Override
    public void onCreate() {
        SDKInitializer.initialize(getApplicationContext());
        super.onCreate();
    }
}
