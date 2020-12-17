package com.example.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;


public class MyProvider extends ContentProvider {

    private Context mcontext;
    DBHelper dbHelper = null;
    SQLiteDatabase db = null;
    //设置contentProvider的唯一标识
    public static final String AUTHOHORITY = "cn.gdgm.android";
    public static final int User_Code = 1;
    public static final int Job_Code = 2;
    //在contentProvider中注册URI，UriMatcher
    private static final UriMatcher mathcer = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        //初始化
        mathcer.addURI(AUTHOHORITY,"user",User_Code);
        mathcer.addURI(AUTHOHORITY,"job",Job_Code);
        //若URI的资源路径是cn.gdgm.android/user,则返回User_Code
        //若URI的资源路径是cn.gdgm.android/job,则返回Job_Code
    }

    //初始化ContentProvider
    @Override
    public boolean onCreate() {
        mcontext = getContext();
        //在ContentProvider创建时，对数据库进行初始化
        dbHelper = new DBHelper(getContext());
        db = dbHelper.getWritableDatabase();
        //初始化两个表的数据，先清空，再添加数据
        db.execSQL("delete from user");
        db.execSQL("insert into user values(1,'LiMing');");
        db.execSQL("insert into user values(2,'Kobe');");
        db.execSQL("insert into user values(3,'bryant');");

        db.execSQL("delete from job");
        db.execSQL("insert into job values(1,'python');");
        db.execSQL("insert into job values(2,'Java');");
        db.execSQL("insert into job values(3,'C#');");

        return true;
    }


    @Override
    public Cursor query( Uri uri,  String[] projection,  String selection,  String[] selectionArgs,  String sortOrder) {
        String table = getTableName(uri);

        return db.query(table,projection,selection,selectionArgs,null,null,sortOrder,null);
    }


    @Override
    public String getType( Uri uri) {
        return null;
    }

    //添加数据
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        //根据URI匹配URI_CODE，从而匹配ContentProvider中相应的表名
        //自定义获取uri的方法
        String table = getTableName(uri);
        //向表i中添加数据
        db.insert(table,null,values);
        //当URI的contentProvider数据发生变化时，通知外界
        mcontext.getContentResolver().notifyChange(uri,null);
        return uri;
    }
    //根据URI匹配URI_CODE，从而匹配ContentProvider中相应的表名
    private String getTableName(Uri uri) {
        String tablename = null;
        switch (mathcer.match(uri)){
            case User_Code:
                tablename = "user";
                break;
            case Job_Code:
                tablename = "job";
                break;
        }
        return tablename;
    }

    @Override
    public int delete( Uri uri,  String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values,  String selection,  String[] selectionArgs) {
        return 0;
    }


}
