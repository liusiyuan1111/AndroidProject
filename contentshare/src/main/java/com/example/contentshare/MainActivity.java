package com.example.contentshare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void read(View view) {
        Uri uri_user = Uri.parse("content://cn.gdgm.android/user");



        ContentResolver resolver = getContentResolver();


        Cursor cursor = resolver.query(uri_user,new String[]{"id","name"},null,null,null);
        while (cursor.moveToNext()){
            String id = cursor.getString(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            Log.i("查询到的数据","id:"+id+"---name:"+name);
        }
        cursor.close();


        Uri uri_job = Uri.parse("content://cn.gdgm.android/job");
        ContentResolver resolver1 = getContentResolver();
        Cursor cursor1 = resolver1.query(uri_job,new String[]{"id","job"},null,null,null);
        while (cursor1.moveToNext()){
            String id = cursor1.getString(cursor1.getColumnIndex("id"));
            String job = cursor1.getString(cursor1.getColumnIndex("job"));
            Log.i("查询到的数据","id:"+id+"---job:"+job);


        }
        cursor1.close();
    }

}
