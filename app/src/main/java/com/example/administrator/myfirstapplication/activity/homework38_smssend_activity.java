package com.example.administrator.myfirstapplication.activity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.myfirstapplication.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/6/7 0007.
 */
public class homework38_smssend_activity extends BaseActivity {
    EditText numbers, content;
    SmsManager sManager;
    String[] sendList ;
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework38_smssend);
        sManager = SmsManager.getDefault();
        numbers = (EditText) findViewById(R.id.numbers);
        content = (EditText) findViewById(R.id.content);
    }

    public void sendsms(View view){
        String nums=numbers.getText().toString();
        sendList=nums.split(",");
        for (String number : sendList) {
            PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(), 0);
            sManager.sendTextMessage(number, null, content .getText().toString(), pi, null);
        }
        Toast.makeText(this, "短信群发完成" , Toast.LENGTH_SHORT).show();
    }
}
