package com.example.administrator.myfirstapplication.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.administrator.myfirstapplication.R;

/**
 * Created by eternl on 2016/5/29.
 */
public class homework_Spinner_activity extends BaseActivity {
    String[] ss={"java","c#","c++","html","js"};
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework_spinner);
        Spinner s= (Spinner) findViewById(R.id.spinner);
        ArrayAdapter aa=new ArrayAdapter(this,android.R.layout.simple_list_item_1,ss);
        s.setAdapter(aa);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String t="你选择的是"+ss[position];
                Toast.makeText(homework_Spinner_activity.this,t , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
