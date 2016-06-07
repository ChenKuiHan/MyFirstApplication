package com.example.administrator.myfirstapplication.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.myfirstapplication.R;

/**
 * Created by ChenKuiHan on 2016/6/7 0007.
 */
public class homework42_alarm_activity extends BaseActivity {
    Button bb;
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework42_alarm);
        bb= (Button) findViewById(R.id.button5);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
