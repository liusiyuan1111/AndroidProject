package com.example.clickorder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("提示","单击事件执行");
            }
        });

        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
               Toast toast= Toast.makeText(MainActivity.this,"hhhhhhh",Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM,0,0);
                LinearLayout linearLayout = (LinearLayout) toast.getView();
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(R.drawable.ic_launcher_background);
                linearLayout.addView(imageView,0);
                //TextView textView = toast.getView().findViewById(android.R.id.message);
                toast.show();
                return true;
            }
        });
    }
}
