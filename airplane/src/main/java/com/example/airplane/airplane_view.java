package com.example.airplane;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-5-23.
 */
public class airplane_view extends View implements View.OnTouchListener {

    float cx;
    float cy;
    float ax;
    float ay;
    float dx;
    float dy;
    Bitmap airplane;
    Bitmap bullet;
    boolean flag = true;
    boolean flag2 = true;
    List<bullet_bean> list = new ArrayList<bullet_bean>();

    Handler h = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (list.size() != 0) {
                for (int i = 0; i < list.size(); i++) {
                    float y = list.get(i).getY();
                    list.get(i).setY(y - 20);
                    if (y < 0) {
                        list.remove(list.get(i));
                    }
                }
            }
            invalidate();
        }
    };
    Handler h1 = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };

    public airplane_view(Context context, int width, int height) {
        super(context);
        airplane = BitmapFactory.decodeResource(getResources(), R.drawable.plane);

        bullet = BitmapFactory.decodeResource(getResources(), R.drawable.bullet_04);
//        airplane.setWidth(50);
//        airplane.setHeight(50);
        cx = width / 2 - airplane.getWidth() / 2;
        cy = height;

    }

    public airplane_view(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        canvas.drawBitmap(airplane, cx, cy, p);

        if (flag) {
            flag = false;
            (new Thread() {
                @Override
                public void run() {
                    super.run();
                    while (cy > 1500) {
                        try {
                            sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        cy -= 5;
                        Message m = new Message();
                        m.what = 1;
                        h.sendMessage(m);
                    }
                    (new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            while (true) {
                                bullet_bean bb = new bullet_bean();
                                bb.setX(cx + (airplane.getWidth() - bullet.getWidth()) + 20);
                                bb.setY(cy - 50);
                                list.add(bb);
                                try {
                                    sleep(60);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }).start();
                }
            }).start();
        }
        for (int i = 0; i < list.size(); i++) {
            canvas.drawBitmap(bullet, list.get(i).getX(), list.get(i).getY(), p);
        }


    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        ax = event.getX();
        ay = event.getY();
        if (flag2) {
            flag2 = false;
            (new Thread() {
                @Override
                public void run() {
                    super.run();
                    while (true) {
                        Message m = new Message();
                        m.what = 1;
                        h.sendMessage(m);
                        try {
                            sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            dx = ax - cx;
            dy = ay - cy;
        }
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            cx = ax - dx;
            cy = ay - dy;
        }
        return true;
    }
}
