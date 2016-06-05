package com.example.administrator.myfirstapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;

import com.example.administrator.myfirstapplication.R;
import com.example.administrator.myfirstapplication.bean.test_bean;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 16-5-24.
 */
public class homework_api_autosearch_chengyu_activity extends Activity {
    ListView lv;
    SearchView sv;
    test_bean tb = new test_bean();
    List<Map<String, Object>> l = new ArrayList<Map<String, Object>>();
    Handler h = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle b = msg.getData();
            String s = b.getString("ss");
            Gson g = new Gson();
            tb = g.fromJson(s, test_bean.class);
            List<test_bean.ResultBean> list = tb.getResult();

            if(list!=null) {
                l.clear();
                for (test_bean.ResultBean rb : list) {
                    Map<String, Object> m = new HashMap<String, Object>();
                    m.put("name", rb.getName());
                    l.add(m);
                }
            }

            SimpleAdapter sa = new SimpleAdapter(homework_api_autosearch_chengyu_activity.this, l, R.layout.homework_autosearch, new String[]{"name"}, new int[]{R.id.text});
            lv.setAdapter(sa);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        lv = (ListView) findViewById(R.id.listView2);
        sv = (SearchView) findViewById(R.id.search);

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.equals("")) {
                    return false;
                }
                search(newText);
                return false;
            }
        });
    }

    public void search(final String text) {
        final String httpUrl="http://apis.baidu.com/avatardata/chengyu/search";
        final String httpArg = "dtype=JSON&keyWord="+text+"&page=1&rows=20";
        final String Url=httpUrl + "?" + httpArg;
        (new Thread() {
            @Override
            public void run() {
                super.run();
                BufferedReader reader = null;
                String result = null;
                StringBuffer sbf = new StringBuffer();

                try {
                    URL url = new URL(Url);
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
