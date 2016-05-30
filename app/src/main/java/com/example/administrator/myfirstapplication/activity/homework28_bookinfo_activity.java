package com.example.administrator.myfirstapplication.activity;

import android.app.Activity;
import android.os.Bundle;

import com.example.administrator.myfirstapplication.R;

/**
 * Created by Administrator on 2016/5/30 0030.
 */
public class homework28_bookinfo_activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homework28_layout2);
        if(savedInstanceState == null)
        {
            homework28_bookinfo_fragment f=new homework28_bookinfo_fragment();
            Bundle b = new Bundle();
            b.putInt("item_id",getIntent().getIntExtra("item_id",0));
            f.setArguments(b);

            getFragmentManager().beginTransaction().replace(R.id.book_detail_container,f).commit();
        }
    }
}
