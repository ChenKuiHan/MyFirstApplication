package com.example.administrator.myfirstapplication.activity;

import android.app.Service;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

import com.example.administrator.myfirstapplication.R;

/**
 * Created by ChenKuiHan on 2016/6/7 0007.
 */
public class homework41_vibrator_activity extends BaseActivity {
    Button b,bb;
    Vibrator v;
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework41_vibrator);
        b= (Button) findViewById(R.id.button4);
        bb= (Button) findViewById(R.id.button5);
        v= (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homework41_vibrator_activity.this.v.vibrate(new long[]{400,600,1000,1200},0);
            }
        });
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homework41_vibrator_activity.this.v.cancel();
            }
        });
    }
}
