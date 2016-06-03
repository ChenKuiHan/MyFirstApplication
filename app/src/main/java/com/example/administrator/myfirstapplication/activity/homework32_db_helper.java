package com.example.administrator.myfirstapplication.activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.administrator.myfirstapplication.R;

/**
 * Created by Administrator on 2016/6/3 0003.
 */
public class homework32_db_helper extends SQLiteOpenHelper {

    public static final String CREATE_STUDENT_TABLE = "create table student(_id integer primary key,name varchar(50),pic integer,age integer)";
    public homework32_db_helper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_STUDENT_TABLE);
        ContentValues c = new ContentValues();
        c.put("_id",1);
        c.put("name","悟空");
        c.put("pic",R.drawable.icon_11);
        c.put("age",600);
        db.insert("student",null,c);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
