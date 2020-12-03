package com.example.drawpath;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(35);
        //创建路径
        Path path = new Path();
        path.addCircle(150,100,50, Path.Direction.CCW); //绘制圆形路径（逆时针）
        //canvas.drawPath(path,paint);  //绘制路径

        canvas.drawTextOnPath("******************",path,0,10,paint);
    }
}
