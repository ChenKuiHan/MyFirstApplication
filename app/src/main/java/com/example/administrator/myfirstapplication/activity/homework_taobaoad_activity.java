package com.example.administrator.myfirstapplication.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.administrator.myfirstapplication.R;

/**
 * Created by eternl on 2016/5/29.
 */
public class homework_taobaoad_activity extends BaseActivity {
    int[] i={R.drawable.icon_11,R.drawable.icon_28,R.drawable.icon_30,R.drawable.icon_33,R.drawable.icon_37};
    AdapterViewFlipper avf;
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework_taobaoad);
        avf= (AdapterViewFlipper) findViewById(R.id.avf);
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
                ImageView iv=new ImageView(homework_taobaoad_activity.this);
                iv.setImageResource(i[position]);
                return iv;
            }
        };
        avf.setAdapter(b);
        avf.setFlipInterval(1000);
        avf.startFlipping();
    }
    public void last(View view){
        avf.showPrevious();
        avf.stopFlipping();
    }
    public void next(View view){
        avf.showNext();
        avf.stopFlipping();
    }
    public void auto(View view){
        avf.startFlipping();
    }
}
