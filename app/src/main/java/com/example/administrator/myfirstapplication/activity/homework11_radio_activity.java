package com.example.administrator.myfirstapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.administrator.myfirstapplication.R;

/**
 * Created by Administrator on 16-5-17.
 */
public class homework11_radio_activity extends BaseActivity {
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.radio);
        RadioGroup rp1= (RadioGroup) findViewById(R.id.radiogroup1);
        rp1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.male){
                    Toast.makeText(homework11_radio_activity.this, "选择了男", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(homework11_radio_activity.this, "选择了女", Toast.LENGTH_SHORT).show();
                }
            }
        });

        CheckBox cb1= (CheckBox) findViewById(R.id.zhuanke);
        CheckBox cb2= (CheckBox) findViewById(R.id.benke);
        CheckBox cb3= (CheckBox) findViewById(R.id.yanjiusheng);
        cb1.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(homework11_radio_activity.this, "选择了专科", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(homework11_radio_activity.this, "取消选择专科", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cb2.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(homework11_radio_activity.this, "选择了本科", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(homework11_radio_activity.this, "取消选择本科", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cb3.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(homework11_radio_activity.this, "选择了研究生", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(homework11_radio_activity.this, "取消选择研究生", Toast.LENGTH_SHORT).show();
                }
            }
        });
//        RadioGroup rp2= (RadioGroup) findViewById(R.id.radiogroup2);
//        rp2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
//
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if(checkedId==R.id.zhuanke){
//                    Toast.makeText(homework11_radio_activity.this, "选择了专科", Toast.LENGTH_SHORT).show();
//                }else if(checkedId==R.id.zhuanke){
//                    Toast.makeText(homework11_radio_activity.this, "选择了本科", Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(homework11_radio_activity.this, "选择了研究生", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }
    public void send(View view){

        final Button btn = (Button) findViewById(R.id.sendbtn);
        btn.setEnabled(false);
        final Chronometer ch = (Chronometer) findViewById(R.id.chronometer);
        ch.setBase(SystemClock.elapsedRealtime());
        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            private int t = 20;
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if((SystemClock.elapsedRealtime()-chronometer.getBase())>20*1000)
                {
                    btn.setText("发送验证码");
                    btn.setEnabled(true);
                    ch.stop();
                }else{
                    btn.setText("倒计时"+(t--));
                }
            }
        });
        ch.start();
    }
}
