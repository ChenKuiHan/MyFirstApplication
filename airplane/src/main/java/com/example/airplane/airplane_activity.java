package com.example.airplane;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

/**
 * Created by Administrator on 16-5-23.
 */
public class airplane_activity extends Activity {
    int width;
    int height;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics m=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(m);
        width=m.widthPixels;
        height=m.heightPixels;
        airplane_view view=new airplane_view(this,width,height);
        setContentView(view);
        view.setOnTouchListener(view);

    }
}
