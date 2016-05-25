package com.example.administrator.myfirstapplication.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.myfirstapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-5-25.
 */
public class homework_duoxuan_activity extends Activity{
    String[] s=new String[]{"语","数","外","物","化"};
    boolean[] bb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homework_duoxuan);
    }
    public void show(View view){
        bb=new boolean[]{true,false,false,false,false};

        AlertDialog.Builder b=new AlertDialog.Builder(this);
        b.setTitle("多选测试");
        b.setIcon(R.drawable.icon_11);
        b.setMultiChoiceItems(s, new boolean[]{true, false, false, false, false}, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if(isChecked){
                    bb[which]=true;
                }else{
                    bb[which]=false;
                }
            }
        });
        b.setNegativeButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                List<String> l=new ArrayList<String>();
                for(int i=0;i<bb.length;i++){
                    if(bb[i]){
                        l.add(s[i]);
                    }
                }
                String a="";
                for(String aa:l){
                    a=a+aa;
                }
                Toast.makeText(homework_duoxuan_activity.this, "选择了"+a, Toast.LENGTH_SHORT).show();
            }
        });
        b.setPositiveButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        b.create().show();

    }
}
