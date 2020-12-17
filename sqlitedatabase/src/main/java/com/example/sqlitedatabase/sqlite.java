package com.example.sqlitedatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class sqlite extends SQLiteOpenHelper {

    private Context mcontext;
    private static Integer Version = 1;
    public sqlite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, null, Version);
        mcontext = context;


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Toast.makeText(mcontext,"创建数据库",Toast.LENGTH_SHORT).show();
        //创建一个user的表
        String sql = "create table user(id int primary key,name varchar(200))";
        //执行SQL语句
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Toast.makeText(mcontext,"更新数据库的版本为："+newVersion,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }
}
