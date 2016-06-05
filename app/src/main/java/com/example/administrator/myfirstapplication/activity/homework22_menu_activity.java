package com.example.administrator.myfirstapplication.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myfirstapplication.R;

/**
 * Created by eternl on 2016/6/5.
 */
public class homework22_menu_activity extends Activity{
    final int MENU1 = 0x111;
    final int MENU2 = 0x112;
    final int MENU3 = 0x113;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homework22);
        txt = (TextView) findViewById(R.id.txt);
        registerForContextMenu(txt);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu submenu = menu.addSubMenu("选择字体大小");
        submenu.add(0,0x111,0,"10号字");
        submenu.add(0,0x112,1,"12号字");
        submenu.add(0,0x113,2,"14号字");
        submenu.add(0,0x114,3,"16号字");

        menu.add(0,1,0,"这是一个菜单项");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case 0x111:
                txt.setTextSize(10 * 2);
                break;
            case 0x112:
                txt.setTextSize(12 * 2);
                break;
            case 0x113:
                txt.setTextSize(14 * 2);
                break;
            case 0x114:
                txt.setTextSize(16 * 2);
                break;
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, MENU1, 0, "红色");
        menu.add(0, MENU2, 0, "绿色");
        menu.add(0, MENU3, 0, "蓝色");
        menu.setGroupCheckable(0, true, true);
        menu.setHeaderIcon(R.drawable.icon_11);
        menu.setHeaderTitle("选择背景色");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case MENU1:
                item.setChecked(true);
                txt.setBackgroundColor(Color.RED);
                break;
            case MENU2:
                item.setChecked(true);
                txt.setBackgroundColor(Color.GREEN);
                break;
            case MENU3:
                item.setChecked(true);
                txt.setBackgroundColor(Color.BLUE);
                break;
        }
        return true;

    }
}
