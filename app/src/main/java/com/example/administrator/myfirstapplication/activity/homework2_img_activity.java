package com.example.administrator.myfirstapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.administrator.myfirstapplication.R;

/**
 * Created by Administrator on 16-5-19.
 */
public class homework2_img_activity extends BaseActivity {


    @Override
    void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework2);
        ImageView iv= (ImageView) findViewById(R.id.img);
        iv.setImageResource(R.drawable.airplane);
    }
}
