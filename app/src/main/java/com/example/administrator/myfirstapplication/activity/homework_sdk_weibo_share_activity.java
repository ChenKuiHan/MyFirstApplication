package com.example.administrator.myfirstapplication.activity;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.myfirstapplication.R;
import com.example.administrator.myfirstapplication.weibo.AccessTokenKeeper;
import com.example.administrator.myfirstapplication.weibo.openapi.StatusesAPI;
import com.example.administrator.myfirstapplication.weibo.openapi.models.ErrorInfo;
import com.example.administrator.myfirstapplication.weibo.openapi.models.Status;
import com.example.administrator.myfirstapplication.weibo.openapi.models.StatusList;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.utils.LogUtil;

import java.io.FileNotFoundException;

/**
 * Created by eternl on 2016/6/9.
 */
public class homework_sdk_weibo_share_activity extends BaseActivity {
    public static final String APP_KEY  = "3256363975";
    EditText et;
    ImageView ivv;
    Button b1;
    Button b2;
    Uri uri;
    Bitmap bitmap;
    StatusesAPI mStatusesAPI;
    Oauth2AccessToken mAccessToken;
    RequestListener mListener = new RequestListener() {
        @Override
        public void onComplete(String response) {
            if (!TextUtils.isEmpty(response)) {
                if (response.startsWith("{\"created_at")) {
                    Toast.makeText(homework_sdk_weibo_share_activity.this, "成功", Toast.LENGTH_SHORT).show();
                }
            }
        }

        @Override
        public void onWeiboException(WeiboException e) {
            ErrorInfo info = ErrorInfo.parse(e.getMessage());
            Toast.makeText(homework_sdk_weibo_share_activity.this, info.toString(), Toast.LENGTH_LONG).show();
        }
    };
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework_weibo_share);
        et= (EditText) findViewById(R.id.editText6);
        ivv= (ImageView) findViewById(R.id.imageView4);
        b1= (Button) findViewById(R.id.button7);
        b2= (Button) findViewById(R.id.button8);
        mAccessToken = AccessTokenKeeper.readAccessToken(this);
        mStatusesAPI = new StatusesAPI(this, APP_KEY, mAccessToken);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message=et.getText().toString();
                if(bitmap==null){
                    mStatusesAPI.update(message, null, null, mListener);
                }else{
                    mStatusesAPI.upload(message, bitmap, null, null, mListener);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            uri = data.getData();
            ContentResolver cr = this.getContentResolver();
            try {
                bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                ivv.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {

            }
        }
    }
}
