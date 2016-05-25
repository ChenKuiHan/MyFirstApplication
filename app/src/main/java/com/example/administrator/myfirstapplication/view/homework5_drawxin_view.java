package com.example.administrator.myfirstapplication.view;

import android.content.Context;
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
public class homework5_drawxin_view extends View implements View.OnTouchListener{

    float cx=200;
    float cy=200;
    List<homework5_drawxin_bean> list=new ArrayList<homework5_drawxin_bean>();
    public homework5_drawxin_view(Context context) {
        super(context);
    }

    public homework5_drawxin_view(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint p = new Paint();
        p.setColor(0xff00ff00);
        p.setAntiAlias(true);
        p.setStrokeWidth(3);

//        Path pp=new Path();
//        pp.moveTo(cx,cy);
//        for(float x=-2;x<2;x=x+0.01f){
//            float y = (float) Math.sqrt(2 * Math.sqrt(x * x) - x * x);
//            float yy = (float) (-2.14 * Math.sqrt(Math.sqrt(2) - Math.sqrt(Math.abs(x))));
//
//        }
        homework5_drawxin_bean ss=new homework5_drawxin_bean();
        ss.setX(200);
        ss.setY(200);
        list.add(ss);
        for (homework5_drawxin_bean s : list) {
            int color=(int)(0xff000000+Math.random()*0xffffff);
            p.setColor(color);
            for (float x = -2; x <= 2; x = x + 0.01f) {
                float y = (float) Math.sqrt(2 * Math.sqrt(x * x) - x * x);
                float yy = (float) (-2.14 * Math.sqrt(Math.sqrt(2) - Math.sqrt(Math.abs(x))));
                canvas.drawPoint(x * 100 + s.getX(), -y * 100 + s.getY(), p);
                canvas.drawPoint(x * 100 + s.getX(), -yy * 100 + s.getY(), p);
            }
            int color1=(int)(0xff000000+Math.random()*0xffffff);
            p.setColor(color1);
            for (float x = -2; x <= 2; x = x + 0.01f) {
                float y = (float) Math.sqrt(2 * Math.sqrt(x * x) - x * x);
                float yy = (float) (-2.14 * Math.sqrt(Math.sqrt(2) - Math.sqrt(Math.abs(x))));
                canvas.drawPoint(x * 50 + s.getX(), -y * 50 + s.getY(), p);
                canvas.drawPoint(x * 50 + s.getX(), -yy * 50 + s.getY(), p);
            }
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        cx = event.getX();
        cy = event.getY();
        homework5_drawxin_bean homework5_drawxin_bean =new homework5_drawxin_bean();
        homework5_drawxin_bean.setX(cx);
        homework5_drawxin_bean.setY(cy);
        list.add(homework5_drawxin_bean);
        invalidate();
        return true;
    }
}
