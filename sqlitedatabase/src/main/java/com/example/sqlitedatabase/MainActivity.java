package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    //创建数据库
    public void createSQL(View view) {

        sqlite db = new sqlite(MainActivity.this,"data",null,1);
        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();
        sqLiteDatabase.close();

    }

    public void upgrade(View view) {
        sqlite db_upgrade = new sqlite(MainActivity.this,"data",null,2);
        SQLiteDatabase sqLiteDatabase_upgrade = db_upgrade.getWritableDatabase();
        sqLiteDatabase_upgrade.close();
    }

    public void insert(View view) {
        sqlite insert = new sqlite(MainActivity.this,"data",null,2);
        SQLiteDatabase sqLite_insert = insert.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id",1);
        values.put("name","li");
        sqLite_insert.insert("user",null,values);
        sqLite_insert.close();
    }

    public void query(View view) {
        sqlite query = new sqlite(MainActivity.this,"data",null,2);
        SQLiteDatabase sqLite_query = query.getWritableDatabase();
        Cursor cursor = sqLite_query.query("user",new String[]{"id","name"},"id=?",new String[]{"2"},null,null,null);
        String id = null;
        String name = null;
        while (cursor.moveToNext()){
            id = cursor.getString(cursor.getColumnIndex("id"));
            name = cursor.getString(cursor.getColumnIndex("name"));
            Log.i("查询到的数据：","id:"+id+"   name:"+name);
        }
        sqLite_query.close();
    }

    public void delete(View view) {
        sqlite delete = new sqlite(MainActivity.this,"data",null,2);
        SQLiteDatabase sqLite_delete = delete.getReadableDatabase();
        deleteDatabase("data");
    }

    public void update(View view) {
        sqlite update = new sqlite(MainActivity.this,"data",null,2);
        SQLiteDatabase sqLite_update = update.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name","Ming");
        sqLite_update.update("user",values,"id=?",new String[]{"1"});
        sqLite_update.close();

    }
}
