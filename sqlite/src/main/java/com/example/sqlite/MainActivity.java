package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper dbhelper = new DatabaseHelper(MainActivity.this,"test",null,3);
                SQLiteDatabase sqLiteDatabase = dbhelper.getWritableDatabase();

            }
        });


    }

    public void upgrade(View view) {
        DatabaseHelper dbhelper_upgrade = new DatabaseHelper(MainActivity.this,"test",null,3);
        SQLiteDatabase sqLiteDatabase = dbhelper_upgrade.getWritableDatabase();
    }

    public void insert(View view) {
        DatabaseHelper dbhelper_insert = new DatabaseHelper(MainActivity.this,"test",null,3);
        SQLiteDatabase sqLiteDatabase = dbhelper_insert.getWritableDatabase();
        //创建ContentValue对象
        ContentValues values = new ContentValues();
        values.put("id",1);
        values.put("name","LiMing");

        sqLiteDatabase.insert("person",null,values);
    }

    public void query(View view) {
        DatabaseHelper dbhelper_query = new DatabaseHelper(MainActivity.this,"test",null,3);
        SQLiteDatabase sqLiteDatabase = dbhelper_query.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query("person",new String[]{"id","name"},"id=?",new String[]{"1"},null,null,null);
        while (cursor.moveToNext()){
           String id = cursor.getString(cursor.getColumnIndex("id"));
           String name = cursor.getString(cursor.getColumnIndex("name"));
           Log.i("查询的结果：","id:"+id+"-name:"+name);

        }
        sqLiteDatabase.close();

    }

    public void update(View view) {
        DatabaseHelper dbhelper_update = new DatabaseHelper(MainActivity.this,"test",null,3);
        SQLiteDatabase sqLiteDatabase = dbhelper_update.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name","ZhangSan");
        sqLiteDatabase.update("person",values,"id=?",new String[]{"1"});
        sqLiteDatabase.close();
    }

    public void delete(View view) {

    }
}
