package com.example.administrator.myfirstapplication.activity;

import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
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
    //int[] img={R.drawable.icon_11,R.drawable.icon_37,R.drawable.icon_28,R.drawable.icon_30,R.drawable.icon_33};
    //int index=0;
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
//        velocityX = velocityX > 4000 ? 4000 : velocityX;
//        velocityX = velocityX < -4000 ? -4000 : velocityX;
        currentScale += currentScale * velocityX / 4000.0f;
        currentScale = currentScale > 0.01 ? currentScale: 0.01f;
        currentScale = (e1.getX()-e2.getX())>0?-currentScale:currentScale;
        matrix.reset();
        matrix.setScale(currentScale, currentScale);

//        BitmapDrawable tmp = (BitmapDrawable)
//                iv.getDrawable();
//        if(!tmp.getBitmap().isRecycled()){
//            tmp.getBitmap().recycle();
//        }
        Bitmap bitmap2 = Bitmap.createBitmap(bitmap, 0, 0
                , width, height, matrix, true);
        iv.setImageBitmap(bitmap2);
        return true;
    }
}
