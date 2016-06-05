package com.example.administrator.myfirstapplication.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.administrator.myfirstapplication.R;

/**
 * Created by eternl on 2016/6/5.
 */
public class homework24_call_send_activity extends BaseActivity {
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework24_call_send);
    }
    public void call(View view){
        Intent i=new Intent();
        i.setAction(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:18241224605"));
        startActivity(i);
    }
    public void sendmess(View view){
        Intent i=new Intent();
        i.setAction(Intent.ACTION_SENDTO);
        i.setData(Uri.parse("smsto:18241224605"));
        startActivity(i);
    }
}
