package com.example.contentprovider;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Data {
    private SQLite sqLite;
    public Data(Context context){
        sqLite = new SQLite(context);
    }
    public long add(String name,String number){
        SQLiteDatabase db = sqLite.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("number",number);
        long id = db.insert("person",null,values);
        db.close();
        return id;
    }
}
