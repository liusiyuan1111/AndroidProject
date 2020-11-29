package com.example.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.view.View;

import androidx.annotation.RequiresApi;

public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //定义画笔
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        //绘制矩形
        canvas.drawRect(100,150,360,300,paint);
        //绘制窗户
        paint.setColor(Color.WHITE);
        canvas.drawCircle(150,200,30,paint);
        canvas.drawCircle(310,200,30,paint);
        //绘制门
        canvas.drawRoundRect(210,230,250,310,10,10,paint);
        //绘制栅栏
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        canvas.drawLine(150,170,150,230,paint);
        canvas.drawLine(120,200,180,200,paint);
        canvas.drawLine(310,170,310,230,paint);
        canvas.drawLine(280,200,340,200,paint);
        //绘制屋檐
        canvas.drawLine(230,50,50,185,paint);
        canvas.drawLine(230,50,410,185,paint);
    }
}
