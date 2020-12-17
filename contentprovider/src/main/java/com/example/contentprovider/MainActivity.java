package com.example.contentprovider;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button btn1,btn2;
    private ListView listView;
    private List<Person> personList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        listView = findViewById(R.id.list_item);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data data = new Data(MainActivity.this);
                long number = 123450;
                Random random = new Random();
                for(int i = 0;i<10; i++){
                    data.add("name",Long.toString(number+i));
                }
                Toast.makeText(MainActivity.this,"创建数据成功",Toast.LENGTH_SHORT).show();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPerson();
                listView.setAdapter(new MyAdapter());
            }
        });

    }

    private void getPerson() {
        String url = "content://aa/query";
        Uri uri = Uri.parse(url);
        //获取ContentResolver对象
        ContentResolver contentResolver = getContentResolver();
        //利用ContentResolver对象查询数据得到一个cursor对象
            Cursor cursor = contentResolver.query(uri,null,null,null,null);
        personList = new ArrayList<Person>();
        if(cursor==null){
            return;
        }
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String number = cursor.getString(cursor.getColumnIndex("number"));
            Person person = new Person(id,name,number);
            personList.add(person);
        }
        cursor.close();
    }


    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return personList.size();
        }

        @Override
        public Object getItem(int position) {
            return personList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Person person = personList.get(position);
            View view = View.inflate(MainActivity.this,R.layout.listview,null);
            TextView tv_name =view.findViewById(R.id.tv_name);
            tv_name.setText("姓名:"+person.getName());
            TextView tv_tel = view.findViewById(R.id.tv_tel);
            tv_tel.setText("电话："+person.getNumber());
            return view;
        }
    }
}
