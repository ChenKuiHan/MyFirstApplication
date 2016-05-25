package com.example.administrator.myfirstapplication.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.administrator.myfirstapplication.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 16-5-13.
 */
public class homework_tanqiu_moveair_view extends View implements View.OnTouchListener {

    Handler h=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if(z==0){
                xx=xx-x;
                yy=yy-y;
            }else if(z==1){
                xx=xx+x;
                yy=yy-y;
            }else if(z==2){
                xx=xx-x;
                yy=yy+y;
            }else{
                xx=xx+x;
                yy=yy+y;
            }
            if(xx<0||xx>1080){
                x=-x;
            }else if(yy<0){
                y=-y;
            }else if(yy>1180&&xx>=cx-150&&xx<=cx+150){
                y=-y;
            }else if(yy>1300){
                t.cancel();
            }
            invalidate();
        }
    };
    float cx=0;
    float ax=0;
    float dx=0;
    float x=(float) (Math.random()*10);
    float y=(float) (Math.random()*10);
    final int z=(int)Math.random()*4;
    float xx=540;
    float yy=540;
    Timer t=new Timer();
    boolean flag=true;
    boolean flag1=true;
    public homework_tanqiu_moveair_view(Context context) {
        super(context);
    }

    public homework_tanqiu_moveair_view(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint p=new Paint();
        p.setColor(Color.RED);
        p.setStrokeWidth(3);

        if(flag){
            flag=false;
            t.schedule(new TimerTask() {
                @Override
                public void run() {
                    Message m=new Message();
                    m.what=1;
                    h.sendMessage(m);
                }
            },100,10);
        }

        canvas.drawCircle(xx,yy,30,p);
        p.setColor(0xff999999);
        canvas.drawRect(cx-150,1200,cx+150,1230,p);
        Bitmap b=BitmapFactory.decodeResource(getResources(), R.drawable.airplane);
        canvas.drawBitmap(b,cx-150,1500,p);
        // canvas.drawText(x+"",500,1500,p);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        ax=event.getX();
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            dx=ax-cx;
        }
        if(event.getAction()==MotionEvent.ACTION_MOVE){

            cx=ax-dx;
            invalidate();
        }

        return true;
    }
}
