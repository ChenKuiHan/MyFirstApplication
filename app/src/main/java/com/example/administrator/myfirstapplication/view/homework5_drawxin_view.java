package com.example.administrator.myfirstapplication.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.administrator.myfirstapplication.bean.homework5_drawxin_bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-5-12.
 */
public class homework5_drawxin_view extends View implements View.OnTouchListener {

    float cx = 200;
    float cy = 200;
    Bitmap b;
    Canvas c;

    public homework5_drawxin_view(Context context) {
        super(context);
        b = Bitmap.createBitmap(1080, 1920, Bitmap.Config.ARGB_8888);
        c = new Canvas();
        c.setBitmap(b);
        Paint p = new Paint();
        p.setColor(0xff00ff00);
        p.setAntiAlias(true);
        p.setStrokeWidth(3);
        int color = (int) (0xff000000 + Math.random() * 0xffffff);
        p.setColor(color);
        for (float x = -2; x <= 2; x = x + 0.01f) {
            float y = (float) Math.sqrt(2 * Math.sqrt(x * x) - x * x);
            float yy = (float) (-2.14 * Math.sqrt(Math.sqrt(2) - Math.sqrt(Math.abs(x))));
            c.drawPoint(x * 100 + 500, -y * 100 + 500, p);
            c.drawPoint(x * 100 + 500, -yy * 100 + 500, p);
        }
        int color1 = (int) (0xff000000 + Math.random() * 0xffffff);
        p.setColor(color1);
        for (float x = -2; x <= 2; x = x + 0.01f) {
            float y = (float) Math.sqrt(2 * Math.sqrt(x * x) - x * x);
            float yy = (float) (-2.14 * Math.sqrt(Math.sqrt(2) - Math.sqrt(Math.abs(x))));
            c.drawPoint(x * 50 + 500, -y * 50 + 500, p);
            c.drawPoint(x * 50 + 500, -yy * 50 + 500, p);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        canvas.drawBitmap(b, 0, 0, p);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        cx = event.getX();
        cy = event.getY();
        Paint p = new Paint();
        p.setColor(0xff00ff00);
        p.setAntiAlias(true);
        p.setStrokeWidth(3);
        int color = (int) (0xff000000 + Math.random() * 0xffffff);
        p.setColor(color);
        for (float x = -2; x <= 2; x = x + 0.01f) {
            float y = (float) Math.sqrt(2 * Math.sqrt(x * x) - x * x);
            float yy = (float) (-2.14 * Math.sqrt(Math.sqrt(2) - Math.sqrt(Math.abs(x))));
            c.drawPoint(x * 100 + cx, -y * 100 + cy, p);
            c.drawPoint(x * 100 + cx, -yy * 100 + cy, p);
        }
        int color1 = (int) (0xff000000 + Math.random() * 0xffffff);
        p.setColor(color1);
        for (float x = -2; x <= 2; x = x + 0.01f) {
            float y = (float) Math.sqrt(2 * Math.sqrt(x * x) - x * x);
            float yy = (float) (-2.14 * Math.sqrt(Math.sqrt(2) - Math.sqrt(Math.abs(x))));
            c.drawPoint(x * 50 + cx, -y * 50 + cy, p);
            c.drawPoint(x * 50 + cx, -yy * 50 + cy, p);
        }
        invalidate();
        return true;
    }
}
