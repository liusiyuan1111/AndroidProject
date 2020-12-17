package com.example.content;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        //数据库：上下文，数据库名，cursor对象，版本
        super(context, "content.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建两个表格，用户表和职业表
        String sql_user = "create table user (id integer primary key autoincrement,name varchar(200)) ";
        db.execSQL(sql_user);
        String sql_job = "create table job (id integer primary key autoincrement,job varchar(200)) ";
        db.execSQL(sql_job);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
