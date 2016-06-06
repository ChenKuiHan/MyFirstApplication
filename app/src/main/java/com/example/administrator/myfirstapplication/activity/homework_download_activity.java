package com.example.administrator.myfirstapplication.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.myfirstapplication.R;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2016/6/2 0002.
 */
public class homework_download_activity extends BaseActivity {
    EditText s;
    EditText ss;
    File sdcard;

    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework_download);
        s = (EditText) findViewById(R.id.text);
        ss= (EditText) findViewById(R.id.name);
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            sdcard = Environment.getExternalStorageDirectory();
        }
    }

    public void download(View view) {
        String u1 = "http://img4.imgtn.bdimg.com/it/u=2981245480,1562730640&fm=11&gp=0.jpg";
        String u=s.getText().toString();
        String name=ss.getText().toString();
        if(u.equals("")){
            Toast.makeText(homework_download_activity.this, "地址不能为空", Toast.LENGTH_SHORT).show();
        }else if(name.equals("")){
            Toast.makeText(homework_download_activity.this, "文件名不能为空", Toast.LENGTH_SHORT).show();
        }else{
            String houzui=u.substring(u.lastIndexOf("."));
            URL url= null;
            try {
                url = new URL(u);
            } catch (MalformedURLException e) {
                Toast.makeText(homework_download_activity.this, "非法url", Toast.LENGTH_SHORT).show();
            }
            MyTask t = new MyTask(this,houzui,name);
            t.execute(url);
        }

    }
    class MyTask extends AsyncTask<URL,Integer,String>
    {
        Context ctx;
        String houzui;
        String name;
        public MyTask(Context ctx,String houzui,String name)
        {
            this.ctx = ctx;
            this.houzui=houzui;
            this.name=name;
        }
        ProgressDialog pd;
        int progressNum = 0;
        @Override
        protected String doInBackground(URL... params) {
            try{
                URLConnection con = params[0].openConnection();
                int contentLength = con.getContentLength();
                InputStream is = con.getInputStream();
                byte[] bs = new byte[1024*10];
                int len;
                OutputStream os = new FileOutputStream("/mnt/sdcard/"+name+houzui);
                while ((len = is.read(bs)) != -1) {
                    os.write(bs, 0, len);
                }
                os.close();
                is.close();
            }catch (Exception e){

            }
            return "ok";
        }

        @Override
        protected void onPreExecute() {
            pd = new ProgressDialog(ctx);
            pd.setTitle("下载进度");
            pd.setMessage("正在下载！");
            pd.setMax(500);
            pd.setCancelable(false);
            pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pd.setIndeterminate(false);
            pd.show();
        }

        @Override
        protected void onPostExecute(String s) {
            pd.dismiss();
            Toast.makeText(homework_download_activity.this, "完成", Toast.LENGTH_SHORT).show();
            Intent i=new Intent();
            File f=new File("/mnt/sdcard/"+name+houzui);
            i.setAction(Intent.ACTION_VIEW);
            i.setDataAndType(Uri.fromFile(f), getMIMEType(houzui));
            try {
                startActivity(i);
            }catch (Exception e){
                Toast.makeText(homework_download_activity.this, "没有对应的打开程序", Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            pd.setProgress(values[0]);
        }

        private String getMIMEType(String houzui) {
            String type="";
            String[][] MIME_MapTable={{".html","text/html"},{".jpg","image/jpeg" },{".mp3","audio/mp3"},{".png","image/png"},
                    {".xml","text/xml" }};
            String end=houzui;
            for(int i=0;i<MIME_MapTable.length;i++){ //MIME_MapTable??在这里你一定有疑问，这个MIME_MapTable是什么？
                if(end.equals(MIME_MapTable[i][0]))
                    type = MIME_MapTable[i][1];
            }
            return type;
        }
    }
}
