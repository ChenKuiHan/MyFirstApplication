package com.example.administrator.myfirstapplication.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.administrator.myfirstapplication.R;

/**
 * Created by eternl on 2016/6/5.
 */
public class homework30_baidu_activity extends BaseActivity {
    EditText et;
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework30);
        et= (EditText) findViewById(R.id.address);

    }
    public void home(View view){
        Intent i=new Intent();
        i.setAction(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_HOME);
        startActivity(i);
    }
    public void go(View view){
        String s=et.getText().toString();
        Intent i=new Intent();
        i.setAction(Intent.ACTION_VIEW);
        i.setData(Uri.parse("http://"+s));
        startActivity(i);
    }
}
