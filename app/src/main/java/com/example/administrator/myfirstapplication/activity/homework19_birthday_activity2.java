package com.example.administrator.myfirstapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.example.administrator.myfirstapplication.R;

import java.util.Calendar;

/**
 * Created by eternl on 2016/6/4.
 */
public class homework19_birthday_activity2 extends BaseActivity {
    DatePicker dp;
    int year,month,day;
    Bundle b=new Bundle();
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework19_birthday2);
        dp= (DatePicker) findViewById(R.id.datePicker);
        Calendar c=Calendar.getInstance();
        year=c.get(Calendar.YEAR);
        month=c.get(Calendar.MONTH);
        day=c.get(Calendar.DAY_OF_MONTH);
        dp.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                b.putInt("year",year);
                b.putInt("month",monthOfYear);
                b.putInt("day",dayOfMonth);
            }
        });
    }
    public void ok(View view){
        Intent i=new Intent(this,homework19_birthday_activity.class);
        i.putExtra("date",b);
        startActivity(i);
    }
}
