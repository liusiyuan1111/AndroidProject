package com.example.event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private long exitTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        class btnClickListener implements View.OnClickListener{

            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"内部类",Toast.LENGTH_LONG).show();
            }
        }

        Button button1 = findViewById(R.id.btn1);
        button1.setOnClickListener(new btnClickListener());
        Button button2 = findViewById(R.id.btn2);
        button2.setOnClickListener(new btnClickListener());

        Button button3 = findViewById(R.id.btn3);
        button3.setOnClickListener(this);

        Button button4 = findViewById(R.id.btn4);


    }
   public void onClick(View view){
       Toast.makeText(MainActivity.this,"Activity",Toast.LENGTH_LONG).show();
   }

    public void MyClick(View view) {
        Toast.makeText(getApplicationContext(),"布局文件",Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Toast.makeText(MainActivity.this,"触摸",Toast.LENGTH_SHORT).show();
        return super.onTouchEvent(event);
    }

    @Override
    //第一步，重写onKeyDown方法拦截用户单击后退按钮退出事件
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == event.KEYCODE_BACK){
            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    //第二步，创建退出方法exit
    //判断按键时间差是否大于2秒，大于则弹出提示框，小于则退出应用
    private void exit() {
        if((System.currentTimeMillis()-exitTime)>2000){
            Toast.makeText(MainActivity.this,"再按一次退出程序",Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        }else {
            finish();
        }

    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Toast.makeText(MainActivity.this,"抬起",Toast.LENGTH_SHORT).show();
        return super.onKeyUp(keyCode, event);
    }
}
