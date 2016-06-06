package com.example.administrator.myfirstapplication.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;


import com.example.administrator.myfirstapplication.R;

/**
 * Created by eternl on 2016/6/5.
 */
public class homework33_shoushi_activity extends BaseActivity implements GestureDetector.OnGestureListener{
    ImageView iv;
    int[] img={R.drawable.icon_11,R.drawable.icon_37,R.drawable.icon_28,R.drawable.icon_30,R.drawable.icon_33};
    int index=0;
    Bitmap bitmap;
    float currentScale=1;
    int width,height;
    Matrix matrix;
    GestureDetector gd;
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework33);
        iv= (ImageView) findViewById(R.id.imagev);
        matrix=new Matrix();
        bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.icon_11);
        width= bitmap.getWidth();
        height=bitmap.getHeight();
        iv.setImageBitmap(bitmap);
//        iv.setImageResource(img[index]);
        gd=new GestureDetector(this,this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gd.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        currentScale=velocityX/4000+1;
        if (e1.getX()-e2.getX()>0){
            currentScale=currentScale-1;
        }
        matrix.reset();
        matrix.setScale(currentScale, currentScale);

        Bitmap bitmap2 = Bitmap.createBitmap(bitmap, 0, 0
                , width, height, matrix, true);
        iv.setImageBitmap(bitmap2);
        return true;
//        float x1 = e1.getX();
//        float x2 = e2.getX();
//        if(x2-x1>=50)
//        {
//            if(index>0)
//            {
//                iv.setImageResource(img[--index]);
//            }
//        }else if(x2-x1<=-50)
//        {
//            if(index<img.length-1)
//            {
//                iv.setImageResource(img[++index]);
//            }
//        }
//        return true;
    }
}
