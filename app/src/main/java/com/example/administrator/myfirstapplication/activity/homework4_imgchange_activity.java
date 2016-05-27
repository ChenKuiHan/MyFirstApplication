package com.example.administrator.myfirstapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.myfirstapplication.R;

/**
 * Created by Administrator on 16-5-19.
 */
public class homework4_imgchange_activity extends BaseActivity {
    ImageView iv;
    int index=1;
    int[] i={R.drawable.icon_11,R.drawable.icon_28,R.drawable.icon_30,R.drawable.icon_33,R.drawable.icon_37};
    @Override
    protected void contectview(Bundle savedInstanceState) {

        setContentView(R.layout.homework4);
        iv= (ImageView) findViewById(R.id.img);
        iv.setImageResource(i[0]);
    }
    public void change(View view){
        iv.setImageResource(i[index%5]);
        index++;
    }
}
