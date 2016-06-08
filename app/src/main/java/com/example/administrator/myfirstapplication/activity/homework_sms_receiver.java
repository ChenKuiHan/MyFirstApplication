package com.example.administrator.myfirstapplication.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * Created by ChenKuiHan on 2016/6/8 0008.
 */
public class homework_sms_receiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {

            abortBroadcast();
            StringBuilder sb=new StringBuilder();
            Bundle b=intent.getExtras();
            if(b!=null){
                Object[] p= (Object[]) b.get("pdus");
                SmsMessage[] me=new SmsMessage[p.length];
                for(int i=0;i<p.length;i++){
                    me[i]=SmsMessage.createFromPdu((byte[])p[i]);
                }
                for(SmsMessage m:me){
                    sb.append("短信来源");
                    sb.append(m.getDisplayOriginatingAddress());
                    sb.append("\n-------短信内容-------\n");
                    sb.append(m.getDisplayMessageBody());
                }

            Toast.makeText(context, sb.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
