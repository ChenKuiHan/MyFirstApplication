package com.example.administrator.myfirstapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.myfirstapplication.R;

/**
 * Created by eternl on 2016/6/5.
 */
public class homework25_city_activity extends BaseActivity{
    TextView tv;
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework25_city);
        tv= (TextView) findViewById(R.id.text5);
        if(getIntent().getBundleExtra("city")!=null){
            Bundle b=getIntent().getBundleExtra("city");
            tv.setText(b.getString("city"));
        }
    }
    public void choose(View view){
        Intent i=new Intent(this,homework13_listview_activity.class);
        startActivity(i);
    }
}
