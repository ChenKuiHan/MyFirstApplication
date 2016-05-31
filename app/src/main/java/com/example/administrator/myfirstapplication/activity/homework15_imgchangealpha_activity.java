package com.example.administrator.myfirstapplication.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.administrator.myfirstapplication.R;

/**
 * Created by Administrator on 16-5-18.
 */
public class homework15_imgchangealpha_activity extends BaseActivity {
    int[] i={R.drawable.a,R.drawable.b,R.drawable.c};
    int imgid;
    AdapterViewFlipper avf;
    float alpha=1.0f;
    ImageView iv;
    ImageView iv2;
    Bitmap bm;
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework15);
        avf= (AdapterViewFlipper) findViewById(R.id.avf);
        iv2= (ImageView) findViewById(R.id.big);
        BaseAdapter b=new BaseAdapter() {
            @Override
            public int getCount() {
                return i.length;
            }

            @Override
            public Object getItem(int position) {
                return i[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                iv=new ImageView(homework15_imgchangealpha_activity.this);
                iv.setImageResource(i[position]);
                imgid=i[position];
                return iv;
            }
        };
        avf.setAdapter(b);
        avf.setFlipInterval(1000);
        avf.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Bitmap b= BitmapFactory.decodeResource(getResources(),imgid);
                int x= (int) event.getX();
                int y= (int) event.getY();
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    bm=Bitmap.createBitmap(b,x,y,100,100);
                    iv2.setImageBitmap(bm);
                }
                if(event.getAction() == MotionEvent.ACTION_MOVE){
                    bm=Bitmap.createBitmap(b,x,y,100,100);
                    iv2.setImageBitmap(bm);
                }
                return false;
            }
        });
    }

    public void lastimg(View view){
        avf.showPrevious();
    }
    public void nextimg(View view){
        avf.showNext();
    }
    public void alpha1(View view){
        if(alpha<0.9){
            alpha=alpha+0.1f;
        }else{
            alpha=1.0f;
        }
        avf.setAlpha(alpha);
    }
    public void alpha2(View view){
        if(alpha>0.1){
            alpha=alpha-0.1f;
        }else{
            alpha=0.0f;
        }
        avf.setAlpha(alpha);
    }
}
