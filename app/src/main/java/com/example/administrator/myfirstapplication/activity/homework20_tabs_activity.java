package com.example.administrator.myfirstapplication.activity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

import com.example.administrator.myfirstapplication.R;

/**
 * Created by eternl on 2016/6/5.
 */
public class homework20_tabs_activity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homework20_tabs);
        TabHost host = getTabHost();

        TabHost.TabSpec tab1 = host.newTabSpec("tab1").setIndicator("欢迎").setContent(R.id.tab1);
        host.addTab(tab1);

        TabHost.TabSpec tab2 = host.newTabSpec("tab2").setIndicator("我的图片").setContent(R.id.tab2);
        host.addTab(tab2);

        TabHost.TabSpec tab3 = host.newTabSpec("tab3").setIndicator("我的图片2").setContent(R.id.tab3);
        host.addTab(tab3);
    }
}
