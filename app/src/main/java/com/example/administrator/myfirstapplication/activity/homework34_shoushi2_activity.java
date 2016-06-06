package com.example.administrator.myfirstapplication.activity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ViewSwitcher;

import com.example.administrator.myfirstapplication.R;
import com.example.administrator.myfirstapplication.view.homework5_drawxin_view;
import com.example.administrator.myfirstapplication.view.homework_huaxian_view;
import com.example.administrator.myfirstapplication.view.homework_tanqiu_moveair_view;

/**
 * Created by Administrator on 2016/6/6 0006.
 */
public class homework34_shoushi2_activity extends BaseActivity implements GestureDetector.OnGestureListener{
    ViewSwitcher vs;
    GestureDetector gd;
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework14_autoplayview);
        vs= (ViewSwitcher) findViewById(R.id.switcher);
        homework_tanqiu_moveair_view a=new homework_tanqiu_moveair_view(this);
        vs.addView(a);
        homework5_drawxin_view b=new homework5_drawxin_view(this);
        vs.addView(b);
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
        float x1 = e1.getX();
        float x2 = e2.getX();
        if(x2-x1>=50) {
            vs.showNext();
        }else if(x2-x1<=-50) {
            vs.showPrevious();
        }
        return true;
    }
}
