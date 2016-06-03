package com.example.administrator.myfirstapplication.activity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.myfirstapplication.R;
import com.example.administrator.myfirstapplication.bean.homework_db_student_bean;

/**
 * Created by Administrator on 2016/6/3 0003.
 */
public class homework32_db_edit_avtivity extends BaseActivity {
    EditText sid;
    EditText name;
    EditText age;
    Button b1;
    Button b2;
    SQLiteDatabase db;
    homework32_db_helper helper;
    homework_db_student_bean bb;

    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework32_db_edit);
        sid= (EditText) findViewById(R.id.idtext);
        name= (EditText) findViewById(R.id.nametext);
        age= (EditText) findViewById(R.id.agetext);
        b1= (Button) findViewById(R.id.btn1);
        b2= (Button) findViewById(R.id.btn2);
        helper=new homework32_db_helper(this,"student.db",null,1);
        db=helper.getWritableDatabase();
        if(getIntent().getBundleExtra("a")!=null){
            Bundle b=getIntent().getBundleExtra("a");
            bb= (homework_db_student_bean) b.getSerializable("stu");
            b1.setVisibility(View.GONE);
            sid.setText(bb.get_id()+"");
            sid.setEnabled(false);
            name.setText(bb.getName());
            age.setText(bb.getAge()+"");
        }else{
            b2.setVisibility(View.GONE);
        }
    }
    public void newstu(View view){
        ContentValues c = new ContentValues();
        c.put("name",name.getText().toString());
        c.put("age",Integer.parseInt(age.getText().toString()));
        c.put("_id",Integer.parseInt(sid.getText().toString()));
        c.put("pic",R.drawable.icon_11);
        db.insert("student",null,c);
//        String sql="insert into student(_id,name,pic,age) values(?,?,?,?)";
//        db.execSQL(sql,new Object[]{Integer.parseInt(sid.getText().toString()),name.getText().toString(),
//                R.drawable.icon_11,Integer.parseInt(age.getText().toString())});
//        db.execSQL(sql,new Object[]{Integer.parseInt(66,"666",
//                R.drawable.icon_11,55});
        Intent i=new Intent(this,homework32_db_activity.class);
        startActivity(i);
    }
    public void changes(View view){
        ContentValues c = new ContentValues();
        c.put("name",name.getText().toString());
        c.put("age",Integer.parseInt(age.getText().toString()));
        c.put("pic",R.drawable.icon_11);
        db.update("student",c,"_id="+Integer.parseInt(sid.getText().toString()),null);
        Intent i=new Intent(this,homework32_db_activity.class);
        startActivity(i);
    }
}
