package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton imageButton1,imageButton2;
        imageButton1 = findViewById(R.id.phone);
        imageButton2 = findViewById(R.id.message);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_phone = new Intent();
                intent_phone.setAction(Intent.ACTION_DIAL);
                intent_phone.setData(Uri.parse("tel:0001111"));
                startActivity(intent_phone);
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_sms = new Intent();
                intent_sms.setAction(Intent.ACTION_SENDTO);
                intent_sms.setData(Uri.parse("smsto:0001111"));
                intent_sms.putExtra("sms_body","欢迎来到广东工贸职业技术学院");
                startActivity(intent_sms);
            }
        });


    }
}
