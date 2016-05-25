package com.example.administrator.myfirstapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.myfirstapplication.R;
import com.example.administrator.myfirstapplication.bean.homework_api_guishu_bean;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by eternal on 2016/5/21.
 */
public class homework_api_guishu_activity extends Activity{
    EditText et;
    String s;
    TextView tv;
    Handler h=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Bundle b=msg.getData();
            String result=b.get("ss").toString();
            Gson g=new Gson();
            homework_api_guishu_bean gs=g.fromJson(result,homework_api_guishu_bean.class);
            if(gs.getRetMsg().equals("success")){
                tv.setText(gs.getRetData().getProvince()+""+gs.getRetData().getCity()+""+gs.getRetData().getSupplier());
            }else{
                tv.setText(gs.getRetMsg());
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homework_guishu);
        et= (EditText) findViewById(R.id.input);
        tv= (TextView) findViewById(R.id.textView2);
    }
    public void chakan(View view){
        s=et.getText().toString();
        (new Thread(){
            @Override
            public void run() {
                String httpUrl = "http://apis.baidu.com/apistore/mobilenumber/mobilenumber";
                String httpArg = "phone="+s;
                BufferedReader reader = null;
                String result = null;
                StringBuffer sbf = new StringBuffer();
                httpUrl = httpUrl + "?" + httpArg;
                try {
                    URL url = new URL(httpUrl);
                    HttpURLConnection connection = (HttpURLConnection) url
                            .openConnection();
                    connection.setRequestMethod("GET");
                    // 填入apikey到HTTP header
                    connection.setRequestProperty("apikey",  "4383014a2e3615a560e13c94b40816e8");
                    connection.connect();
                    InputStream is = connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                    String strRead = null;
                    while ((strRead = reader.readLine()) != null) {
                        sbf.append(strRead);
                        sbf.append("\r\n");
                    }
                    reader.close();
                    result = sbf.toString();
                    Message m=new Message();
                    Bundle b=new Bundle();
                    b.putString("ss",result);
                    m.setData(b);
                    h.sendMessage(m);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }
}
