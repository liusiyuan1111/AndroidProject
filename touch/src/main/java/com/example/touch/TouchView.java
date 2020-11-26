package com.example.touch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class TouchView extends View {
    public float X = 200;
    public float Y = 200;
    Paint paint = new Paint();
    public TouchView(Context context) {

        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        paint.setColor(Color.YELLOW);
        canvas.drawCircle(X,Y,30,paint);
    }
}
