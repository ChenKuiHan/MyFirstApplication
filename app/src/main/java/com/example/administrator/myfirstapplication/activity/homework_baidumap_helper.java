package com.example.administrator.myfirstapplication.activity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ChenKuiHan on 2016/6/16 0016.
 */
public class homework_baidumap_helper extends SQLiteOpenHelper {

    public static final String CREATE_STUDENT_TABLE = "create table point(_id integer primary key ,jing decimal,wei integer,time bigint)";

    public homework_baidumap_helper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_STUDENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
