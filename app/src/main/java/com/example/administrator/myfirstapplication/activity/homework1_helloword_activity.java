package com.example.administrator.myfirstapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.myfirstapplication.R;
import java.text.SimpleDateFormat;
import java.util.Date;

public class homework1_helloword_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeText(View view ) throws InterruptedException {
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String date=sdf.format(d);

        TextView tv= (TextView) findViewById(R.id.txt);
        tv.setText(date);
    }
}
