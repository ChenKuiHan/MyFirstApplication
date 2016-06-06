package com.example.administrator.myfirstapplication.activity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.administrator.myfirstapplication.R;

/**
 * Created by Administrator on 2016/6/6 0006.
 */
public class homework_contentresolver_activity extends BaseActivity {
    ListView lv;
    Cursor c;
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework_resolver);
        lv= (ListView) findViewById(R.id.listView3);
        Uri u=Uri.parse("content://com.ralph.second/students");
        c=getContentResolver().query(u,null,null,null,null);
        SimpleCursorAdapter aca = new SimpleCursorAdapter(this,R.layout.homework_resolver_item,c,
                new String[]{"name","age"},new int[]{R.id.t1,R.id.t2},0);
        lv.setAdapter(aca);
    }
}
