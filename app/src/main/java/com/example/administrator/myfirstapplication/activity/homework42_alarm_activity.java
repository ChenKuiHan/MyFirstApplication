package com.example.administrator.myfirstapplication.activity;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.administrator.myfirstapplication.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by ChenKuiHan on 2016/6/7 0007.
 */
public class homework42_alarm_activity extends BaseActivity {
    Button bb;
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework42_alarm);
        bb= (Button) findViewById(R.id.button6);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c=Calendar.getInstance();
                new TimePickerDialog(homework42_alarm_activity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Intent i=new Intent(homework42_alarm_activity.this,homework40_music_activity.class);
                        PendingIntent pi=PendingIntent.getActivity(homework42_alarm_activity.this,0,i,0);
                        AlarmManager am= (AlarmManager) getSystemService(ALARM_SERVICE);
                        Calendar c=Calendar.getInstance();
                        c.setTimeInMillis(System.currentTimeMillis());
                        c.set(Calendar.HOUR,hourOfDay);
                        c.set(Calendar.MINUTE,minute);
                        am.set(AlarmManager.ELAPSED_REALTIME,c.getTimeInMillis(),pi);
                        Toast.makeText(homework42_alarm_activity.this, c.getTimeInMillis()+"", Toast.LENGTH_SHORT).show();
                    }
                },c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE),false).show();
            }
        });
    }
}
