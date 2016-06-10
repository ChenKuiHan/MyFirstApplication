package com.example.administrator.myfirstapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myfirstapplication.R;
import com.example.administrator.myfirstapplication.weibo.AccessTokenKeeper;
import com.example.administrator.myfirstapplication.weibo.widget.LoginoutButton;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;

/**
 * Created by eternl on 2016/6/9.
 */
public class homework_sdk_weibo_main_activity extends BaseActivity {
    public static final String APP_KEY  = "3256363975";
    public static final String REDIRECT_URL = "http://www.sina.com";
    public static final String SCOPE =
            "email,direct_messages_read,direct_messages_write,"
                    + "friendships_groups_read,friendships_groups_write,statuses_to_me_read,"
                    + "follow_app_official_microblog," + "invitation_write";

    AuthListener mLoginListener = new AuthListener();
    LogOutRequestListener mLogoutListener = new LogOutRequestListener();
    TextView result;
    LoginoutButton loginbtn;
    AuthInfo mAuthInfo;
    Button btn;
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework_weibo_main);
        mAuthInfo = new AuthInfo(this, APP_KEY, REDIRECT_URL, SCOPE);
        result= (TextView) findViewById(R.id.result);
        loginbtn= (LoginoutButton) findViewById(R.id.loginbtn);
        loginbtn.setWeiboAuthInfo(mAuthInfo, mLoginListener);
        loginbtn.setLogoutListener(mLogoutListener);
        btn= (Button) findViewById(R.id.shareweibo);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(homework_sdk_weibo_main_activity.this,homework_sdk_weibo_share_activity.class);
                startActivity(i);
            }
        });
    }

    private class AuthListener implements WeiboAuthListener {
        @Override
        public void onComplete(Bundle values) {
            Oauth2AccessToken accessToken = Oauth2AccessToken.parseAccessToken(values);
            if (accessToken != null && accessToken.isSessionValid()) {
                String date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(
                        new java.util.Date(accessToken.getExpiresTime()));
                String format = getString(R.string.weibosdk_demo_token_to_string_format_1);
                result.setText(String.format(format, accessToken.getToken(), date));

                AccessTokenKeeper.writeAccessToken(getApplicationContext(), accessToken);
            }
        }

        @Override
        public void onWeiboException(WeiboException e) {
            Toast.makeText(homework_sdk_weibo_main_activity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel() {
            Toast.makeText(homework_sdk_weibo_main_activity.this,
                    R.string.weibosdk_demo_toast_auth_canceled, Toast.LENGTH_LONG).show();
        }
    }

    private class LogOutRequestListener implements RequestListener {
        @Override
        public void onComplete(String response) {
            if (!TextUtils.isEmpty(response)) {
                try {
                    JSONObject obj = new JSONObject(response);
                    String value = obj.getString("result");

                    if ("true".equalsIgnoreCase(value)) {
                        AccessTokenKeeper.clear(homework_sdk_weibo_main_activity.this);
                        result.setText(R.string.weibosdk_demo_logout_success);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void onWeiboException(WeiboException e) {
            result.setText(R.string.weibosdk_demo_logout_failed);
        }
    }
}
