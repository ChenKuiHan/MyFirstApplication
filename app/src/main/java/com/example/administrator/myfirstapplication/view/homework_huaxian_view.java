package com.example.administrator.myfirstapplication.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2016/6/1 0001.
 */
public class homework_huaxian_view extends View implements View.OnTouchListener{
    float x;
    float y;
    Bitmap b;
    Canvas c;
    public homework_huaxian_view(Context context) {
        super(context);
        b= Bitmap.createBitmap(1080,1920,Bitmap.Config.ARGB_8888);
        c=new Canvas();
        c.setBitmap(b);
    }

    public homework_huaxian_view(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p=new Paint();
        canvas.drawBitmap(b,0,0,p);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x=event.getX();
        y=event.getY();
        Paint p = new Paint();
        p.setColor(0xff999999);
        p.setStrokeWidth(3);
        p.setAntiAlias(true);
        c.drawCircle(x,y,3,p);
        invalidate();
        return true;
    }
}
