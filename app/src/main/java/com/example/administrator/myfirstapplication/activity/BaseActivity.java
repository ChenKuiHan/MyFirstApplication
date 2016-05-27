package com.example.administrator.myfirstapplication.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.administrator.myfirstapplication.R;

/**
 * Created by Administrator on 2016/5/26 0026.
 */
abstract public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar= new Toolbar(this);
//        setContentView(R.layout.baseactivity);
//        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("My App");
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(0xff999999);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.normal_btn:
                        AlertDialog.Builder b=new AlertDialog.Builder(BaseActivity.this);
                        b.setTitle("about");
                        b.setIcon(R.drawable.icon_11);
                        b.setMessage("create by ChenKuiHan");
                        b.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Toast.makeText(BaseActivity.this, "", Toast.LENGTH_SHORT).show();
                            }
                        });
                        b.create().show();
                        break;
                }
                return true;
            }
        });
        contectview(savedInstanceState);
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inf = new MenuInflater(this);
        inf.inflate(R.menu.base,menu);
        return super.onCreateOptionsMenu(menu);
    }

    abstract void contectview(Bundle savedInstanceState);

}
