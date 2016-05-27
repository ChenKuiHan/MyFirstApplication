package com.example.administrator.myfirstapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Contacts;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.myfirstapplication.R;

/**
 * Created by eternl on 2016/5/21.
 */
public class homework_gotoTEL_activity extends BaseActivity {
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework_gototel);
        ImageView iv= (ImageView) findViewById(R.id.imageView2);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                intent.setAction(Intent.ACTION_VIEW);

                intent.setData(Contacts.People.CONTENT_URI);

                startActivity(intent);
            }
        });
    }
}
