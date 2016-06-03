package com.example.administrator.myfirstapplication.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.administrator.myfirstapplication.R;
import com.example.administrator.myfirstapplication.bean.homework_db_student_bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/3 0003.
 */
public class homework32_db_activity extends BaseActivity {

    ListView lv;
    homework32_db_helper helper;
    Cursor c;
    List<homework_db_student_bean> list=new ArrayList<homework_db_student_bean>();
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework32_db);
        lv= (ListView) findViewById(R.id.dblistview);
        helper=new homework32_db_helper(this,"student.db",null,1);
        c = helper.getReadableDatabase().query("student",null,null,null,null,null,null);
        while (c.moveToNext()){
            homework_db_student_bean b=new homework_db_student_bean();
            b.set_id(c.getInt(c.getColumnIndex("_id")));
            b.setName(c.getString(c.getColumnIndex("name")));
            b.setAge(c.getInt(c.getColumnIndex("age")));
            b.setPic(c.getInt(c.getColumnIndex("pic")));
            list.add(b);
        }
        SimpleCursorAdapter aca = new SimpleCursorAdapter(this,R.layout.homework32_db_listviewitems,c,
                new String[]{"name","pic","age"},new int[]{R.id.studName,R.id.studPic,R.id.studAge},0);

        lv.setAdapter(aca);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                homework_db_student_bean bb=new homework_db_student_bean();
                bb=list.get(position);
                Intent i=new Intent(homework32_db_activity.this,homework32_db_edit_avtivity.class);
                Bundle b=new Bundle();
                b.putSerializable("stu",bb);
                i.putExtra("a",b);
                startActivity(i);
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder ad=new AlertDialog.Builder(homework32_db_activity.this);
                ad.setItems(R.array.a, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AlertDialog.Builder a=new AlertDialog.Builder(homework32_db_activity.this);
                        a.setTitle("删除");
                        a.setMessage("确认删除吗");
                        a.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        a.setPositiveButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        a.create().show();
                    }
                });
                ad.create().show();
                return true;
            }
        });
    }
    public void add(View view){
        Intent i=new Intent(this,homework32_db_edit_avtivity.class);
        startActivity(i);
    }
}
