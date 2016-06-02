package com.example.administrator.myfirstapplication.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.administrator.myfirstapplication.R;

/**
 * Created by Administrator on 2016/6/2 0002.
 */
public class homework_autologin_activity2 extends BaseActivity {
    CheckBox cb;
    boolean flag=false;
    SharedPreferences sp;

    SharedPreferences.Editor editor;
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework_autologin2);
        sp = getSharedPreferences("login",MODE_PRIVATE);
        editor = sp.edit();
        cb= (CheckBox) findViewById(R.id.checkBox);
        cb.setChecked(sp.getBoolean("auto",false));
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                flag=isChecked;
            }
        });
    }
    public void aaa(View view){
        editor.putBoolean("auto",flag);
        editor.commit();
    }
}
