package com.example.administrator.myfirstapplication.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.administrator.myfirstapplication.R;

/**
 * Created by Administrator on 2016/6/6 0006.
 */
public class homework35_diyshoushi_activity extends BaseActivity {
    GestureOverlayView gestureView;
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework35_diyshoushi);
        gestureView = (GestureOverlayView) findViewById(R.id.gestureView);
        gestureView.setGestureColor(Color.GREEN);
        gestureView.setGestureStrokeWidth(5);
        gestureView.addOnGesturePerformedListener(new GestureOverlayView.OnGesturePerformedListener() {
            @Override
            public void onGesturePerformed(GestureOverlayView overlay, final Gesture gesture) {
                View view = getLayoutInflater().inflate(R.layout.homework35_diyshoushi_dialog,null);
                ImageView iv = (ImageView) view.findViewById(R.id.gestureImg);
                final EditText txt = (EditText) view.findViewById(R.id.gestureName);

                Bitmap bitmap = gesture.toBitmap(128,128,15,Color.BLUE);
                iv.setImageBitmap(bitmap);

                new AlertDialog.Builder(homework35_diyshoushi_activity.this)
                        .setView(view)
                        .setPositiveButton("保存手势", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                GestureLibrary gestlib = GestureLibraries.fromPrivateFile(homework35_diyshoushi_activity.this,"mygestures");
                                gestlib.addGesture(txt.getText().toString(),gesture);
                                gestlib.save();
                            }
                        })
                        .setNegativeButton("取消",null)
                        .create().show();
            }
        });
    }
    public void check(View view){
        Intent i=new Intent(this,homework35_diyshoushi_activity2.class);
        startActivity(i);
    }
}
