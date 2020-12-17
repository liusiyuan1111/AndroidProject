package com.example.contentprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {


    private static UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
    private static final int INSERT = 1;
    private static final int DELETE = 2;
    private static final int UPDATE = 3;
    private static final int QUERY = 4;
    private static final int QUERYONE = 5;




    static {
        matcher.addURI("aa","insert",INSERT);
        matcher.addURI("aa","delete",DELETE);
        matcher.addURI("aa","update",UPDATE);
        matcher.addURI("aa","query",QUERY);
        matcher.addURI("aa","query/#",QUERYONE);
        matcher.addURI("aa","insert",INSERT);

    }
    private Context context;
    private SQLite sqLite;

    public MyContentProvider() {

    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        if(matcher.match(uri)==DELETE){
            SQLiteDatabase db = sqLite.getWritableDatabase();
            db.delete("person",selection,selectionArgs);
        }else {
            throw new IllegalArgumentException("路径不匹配，不能删除");
        }
        return 0;
    }

    @Override
    public String getType(Uri uri) {
        if (matcher.match(uri) == QUERY) {
            return "vnd.android.cursor.dir/person";
        } else if (matcher.match(uri) == QUERYONE) {
            return "vnd.android.cursor.item/person";
        }
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        if(matcher.match(uri)==INSERT){
            SQLiteDatabase sqlDB = sqLite.getWritableDatabase();
            sqlDB.insert("person",null,values);

        }else {
            throw new IllegalArgumentException("路径不匹配，不能执行插入操作");
        }
        return null;
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        return true;

    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        if(matcher.match(uri)==QUERY){
            SQLiteDatabase db = sqLite.getReadableDatabase();
            Cursor cursor = db.query("person",projection,selection,selectionArgs,null,null,sortOrder);
            return cursor;

        }else if(matcher.match(uri)==QUERYONE){
            long id = ContentUris.parseId(uri);
            SQLiteDatabase db = sqLite.getReadableDatabase();
            Cursor cursor = db.query("person",projection,"id=?",new String[]{id+""},null,null,sortOrder);
            return cursor;
        }else {
            throw new IllegalArgumentException("路径不匹配，不能查询");
        }

    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        if(matcher.match(uri)==UPDATE){
            SQLiteDatabase db = sqLite.getWritableDatabase();
            db.update("person",values,selection,selectionArgs);
        }else {
            throw new IllegalArgumentException("路径不匹配，不能修改");
        }
        return 0;
    }



}

