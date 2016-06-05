package com.example.administrator.myfirstapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.administrator.myfirstapplication.R;

/**
 * Created by eternl on 2016/6/4.
 */
public class homework19_birthday_activity extends BaseActivity {
    EditText et;
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework19_birthday);
        et= (EditText) findViewById(R.id.editText5);
        if(getIntent().getBundleExtra("date")!=null){
            Bundle b=getIntent().getBundleExtra("date");
            int year=b.getInt("year");
            int month=b.getInt("month")+1;
            int day=b.getInt("day");
            et.setText(year+"年"+month+"月"+day+"日");
        }
    }
    public void birth(View view){
        Intent i=new Intent(this,homework19_birthday_activity2.class);
        startActivity(i);
    }
}
