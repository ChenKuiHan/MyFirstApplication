package com.example.administrator.myfirstapplication.activity;

import android.content.Intent;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.example.administrator.myfirstapplication.R;

import java.util.List;

/**
 * Created by Administrator on 2016/6/6 0006.
 */
public class homework35_diyshoushi_activity2 extends BaseActivity {
    GestureOverlayView gestureOverlayView;
    GestureLibrary gestLib;
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework35_diyshoushi2);
        gestLib = GestureLibraries.fromPrivateFile(this,"mygestures");
        if(!gestLib.load()) {
            Toast.makeText(homework35_diyshoushi_activity2.this, "手势库加载失败！", Toast.LENGTH_SHORT).show();
        }

        gestureOverlayView = (GestureOverlayView) findViewById(R.id.gestureView);
        gestureOverlayView.setGestureColor(Color.GREEN);
        gestureOverlayView.setGestureStrokeWidth(5);

        gestureOverlayView.addOnGesturePerformedListener(new GestureOverlayView.OnGesturePerformedListener() {
            @Override
            public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
                boolean flag=false;
                List<Prediction> list = gestLib.recognize(gesture);
                for(Prediction p:list) {
                    if(p.score>2.0) {
                        Toast.makeText(homework35_diyshoushi_activity2.this, "找到匹配手势！"+p.name+"<<<"+p.score, Toast.LENGTH_LONG).show();
                        flag=true;
                        Intent i=new Intent();
                        i.setAction(Intent.ACTION_MAIN);
                        i.addCategory(Intent.CATEGORY_HOME);
                        startActivity(i);
                        break;
                    }
                }
                if(!flag){
                    Toast.makeText(homework35_diyshoushi_activity2.this, "没找到匹配手势！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
