package com.example.touch;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //2.创建并实例化MyView的一个对象，并为其添加触摸事件监听器，在重写的触摸方法中根据触摸的位置移动绘制好的圆
        final MyView myView = new MyView(MainActivity.this);
        myView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                myView.X = motionEvent.getX();
                myView.Y = motionEvent.getY();
                myView.invalidate();
                return true;
            }
        });
        //3.把myView添加到布局管理器中
        RelativeLayout relativeLayout = findViewById(R.id.rl);
        relativeLayout.addView(myView);
    }

    //1.创建自定义View，用来绘制图像
    private  class  MyView extends View {

        public float X = 200;
        public float Y = 200;
        Paint paint = new Paint();
        public MyView(Context context) {
            super(context);
        }
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            paint.setColor(Color.RED);
            canvas.drawCircle(X,Y,30,paint);
        }


    }
}
