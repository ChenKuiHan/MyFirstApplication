package com.example.administrator.myfirstapplication.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.myfirstapplication.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/6/2 0002.
 */
public class homework_autologin_activity extends BaseActivity {
    EditText name;
    EditText pwd;
    CheckBox auto;
    Button btn;
    String un="admin";
    String pw="123";
    boolean flag=false;
    SharedPreferences sp;

    SharedPreferences.Editor editor;
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework_autologin);
        name= (EditText) findViewById(R.id.name);
        pwd= (EditText) findViewById(R.id.pwd);
        auto= (CheckBox) findViewById(R.id.autologin);
        auto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                flag=isChecked;
            }
        });
        btn= (Button) findViewById(R.id.btn);
        sp = getSharedPreferences("login",MODE_PRIVATE);
        editor = sp.edit();
        boolean b = sp.getBoolean("auto",false);
        if(b){
            Intent i=new Intent(this,homework_autologin_activity2.class);
            startActivity(i);
        }
    }
    public void login(View view){

        if(name.getText().toString().equals(un)&&pwd.getText().toString().equals(pw)){
            editor.putBoolean("auto",flag);
            editor.commit();
            Intent i=new Intent(this,homework_autologin_activity2.class);
            startActivity(i);

        }else{
            Toast.makeText(homework_autologin_activity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
        }
    }
}
