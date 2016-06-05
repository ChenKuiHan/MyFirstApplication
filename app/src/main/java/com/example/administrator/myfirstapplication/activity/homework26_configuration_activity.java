package com.example.administrator.myfirstapplication.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.example.administrator.myfirstapplication.R;

/**
 * Created by eternl on 2016/6/5.
 */
public class homework26_configuration_activity extends BaseActivity {
    GridView gv;
    String[] s={"第1项","第2项","第3项","第4项","第5项","第6项","第7项","第8项","第9项","第10项"};
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework26_configuration);
        gv= (GridView) findViewById(R.id.gridView2);
        ArrayAdapter aa=new ArrayAdapter(this,android.R.layout.simple_list_item_1,s);
        gv.setAdapter(aa);
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE){
            gv.setNumColumns(4);
        }else{
            gv.setNumColumns(3);
        }
    }
}
