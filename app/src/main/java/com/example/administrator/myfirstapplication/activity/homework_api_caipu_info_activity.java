package com.example.administrator.myfirstapplication.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myfirstapplication.R;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * Created by Administrator on 16-5-24.
 */
public class homework_api_caipu_info_activity extends Activity {
    Bitmap bm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homework_api_caipu_info);
        Bundle b=getIntent().getBundleExtra("a");
        Map<String,String> m= (Map<String, String>) b.getSerializable("info");
        ImageView iv= (ImageView) findViewById(R.id.image);
        TextView tv1= (TextView) findViewById(R.id.name);
        TextView tv2= (TextView) findViewById(R.id.info);
        try {
            final URL url = new URL(m.get("img"));

            (new Thread(){
                @Override
                public void run() {
                    try {
                        bm= BitmapFactory.decodeStream(url.openStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            iv.setImageBitmap(bm);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        tv1.setText("食材："+m.get("food"));
        tv2.setText("步骤："+m.get("message"));
    }
}
