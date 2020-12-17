package com.example.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private Context mcontext;
    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, null, version);
        mcontext = context;
    }

    //创建数据库表：
    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建一个名为person的表
        String sql = "create table person (id integer primary key autoincrement,name varchar(64),address varchar(64))";
        db.execSQL(sql);
        Toast.makeText(mcontext,"数据库创建成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Toast.makeText(mcontext,"数据库版本更新为："+newVersion,Toast.LENGTH_SHORT).show();

    }
}
