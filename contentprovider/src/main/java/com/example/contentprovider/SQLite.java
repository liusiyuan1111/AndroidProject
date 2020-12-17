package com.example.contentprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

    public class SQLite extends SQLiteOpenHelper {
        private static final String TAG = "PersonSQLiteOpenHelper";
        Context mcontext;
        //1.数据库创建的方法（包括上下文，数据库名称，查询结果，数据库版本）
    public SQLite(@Nullable Context context) {
        super(context, "person.db", null, 3);
        mcontext = context;
    }
        //2.数据库第一次创建
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table person (id integer primary key autoincrement, name varchar(20), number varchar(20))");

    }
        //3.数据库版本更新
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG,"数据库更新");
    }
}
