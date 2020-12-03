package com.example.anim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
Button btn1,btn2,btn3,btn4,btn5;
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.img);
        final Animation[] animation = new Animation[5];
        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animation[0] = AnimationUtils.loadAnimation(MainActivity.this,R.anim.alpha);
                imageView.startAnimation(animation[0]);
            }
        });
        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animation[1] = AnimationUtils.loadAnimation(MainActivity.this,R.anim.scale);
                imageView.startAnimation(animation[1]);
            }
        });
        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animation[2] = AnimationUtils.loadAnimation(MainActivity.this,R.anim.translate);
                imageView.startAnimation(animation[2]);
            }
        });
        btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animation[3] = AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate);
                imageView.startAnimation(animation[3]);
            }
        });
        btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animation[4] = AnimationUtils.loadAnimation(MainActivity.this,R.anim.set);
                imageView.startAnimation(animation[4]);
            }
        });
    }
}
