package com.example.administrator.myfirstapplication.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.widget.Button;

import com.example.administrator.myfirstapplication.R;

import java.util.List;

/**
 * Created by Administrator on 2016/5/31 0031.
 */
public class homework_autosaveset_activity extends PreferenceActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        if (hasHeaders()) {
            Button button = new Button(this);
            button.setText("保存设置");
            setListFooter(button);
        }
    }

    @Override
    public void onBuildHeaders(List<Header> target) {
        super.onBuildHeaders(target);
        loadHeadersFromResource(R.xml.header,target);
    }

    @Override
    protected boolean isValidFragment(String fragmentName) {
        return true;
    }

    public static class Prefs1Fragment extends PreferenceFragment
    {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //加载一个布局文件
            addPreferencesFromResource(R.xml.prefs);
        }
    }

    public static class Prefs2Fragment extends PreferenceFragment
    {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //加载一个布局
            addPreferencesFromResource(R.xml.display_prefs);
        }
    }
}
