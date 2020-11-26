package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText1,editText2;
        editText1 = findViewById(R.id.edit_1);
        editText2 = findViewById(R.id.edit_2);
        final String str1 = editText1.getText().toString();
        final String str2 = editText2.getText().toString();
        Button button;
        button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(str1.equals(str2)){
                    Toast.makeText(MainActivity.this,"相等",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
