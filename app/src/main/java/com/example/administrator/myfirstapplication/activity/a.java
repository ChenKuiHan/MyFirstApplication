package com.example.administrator.myfirstapplication.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.myfirstapplication.R;

import java.util.ArrayList;


public class a extends Activity {
    EditText numbers, content;
    Button send;
    SmsManager sManager;
    // 记录需要群发的号码列表
    ArrayList<String> sendList = new ArrayList<String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homework38_smssend);
        sManager = SmsManager.getDefault();
        numbers = (EditText) findViewById(R.id.numbers);
        content = (EditText) findViewById(R.id.content);
        send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                for (String number : sendList) {
                    PendingIntent pi = PendingIntent.getActivity(
                            a.this, 0, new Intent(), 0);
                    sManager.sendTextMessage(number, null, content
                            .getText().toString(), pi, null);
                }
                Toast.makeText(a.this, "短信群发完成"
                        , Toast.LENGTH_SHORT).show();
            }
        });
    }
}

