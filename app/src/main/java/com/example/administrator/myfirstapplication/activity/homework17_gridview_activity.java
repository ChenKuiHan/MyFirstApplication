package com.example.administrator.myfirstapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myfirstapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/2 0002.
 */
public class homework17_gridview_activity extends Activity {
    GridView gv;
    List<Map<String,String>> list=new ArrayList<Map<String,String>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homework17_gridview);
        gv= (GridView) findViewById(R.id.gridView);
        for(int i=0;i<5;i++){
            Map<String,String> m=new HashMap();
            m.put("pic",R.drawable.icon_11+"");
            m.put("name","sss");
            list.add(m);
        }
        myadapter my=new myadapter();
        gv.setAdapter(my);
    }

    class myadapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater li = LayoutInflater.from(homework17_gridview_activity.this);
            View view = li.inflate(R.layout.homework17_items,null);

            ImageView iv= (ImageView) view.findViewById(R.id.imageView);
            TextView tv= (TextView) view.findViewById(R.id.text123);
            Map<String,String> m=list.get(position);
            iv.setImageResource(Integer.parseInt(m.get("pic")));
            tv.setText(m.get("name"));
            return view;
        }
    }
}
