package com.example.administrator.myfirstapplication.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myfirstapplication.R;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/6 0006.
 */
public class homework_filebrowser_activity extends BaseActivity {
    ListView listView;
    TextView textView;
    File currentParent;
    File[] currentFiles;
    Button parent;
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework_filebrowser);
        listView = (ListView) findViewById(R.id.list);
        textView = (TextView) findViewById(R.id.path);
        parent = (Button) findViewById(R.id.parent);
        File root = new File("/mnt/sdcard/");
        if (root.exists()) {
            currentParent = root;
            currentFiles = root.listFiles();
            inflateListView(currentFiles);
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (currentFiles[position].isFile()){
                    String name=currentFiles[position].getName();
                    String path=currentFiles[position].getPath();
                    File f=new File(path);
                    Intent i=new Intent();
                    i.setAction(Intent.ACTION_VIEW);
                    i.setDataAndType(Uri.fromFile(f),getMIMEType(name));
                    startActivity(i);
                    return;
                }
                File[] tmp = currentFiles[position].listFiles();
                if (tmp == null || tmp.length == 0) {
                    Toast.makeText(homework_filebrowser_activity.this, "当前路径不可访问或该路径下没有文件", Toast.LENGTH_SHORT).show();
                } else {
                    currentParent = currentFiles[position];
                    currentFiles = tmp;
                    inflateListView(currentFiles);
                }
            }
        });
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View source) {
                try {
                    if (!currentParent.getCanonicalPath().equals("/mnt/sdcard")) {
                        currentParent = currentParent.getParentFile();
                        currentFiles = currentParent.listFiles();
                        inflateListView(currentFiles);
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
    private void inflateListView(File[] files) {
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < files.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            if (files[i].isDirectory()) {
                listItem.put("icon", R.drawable.folder);
            } else {
                listItem.put("icon", R.drawable.file);
            }
            listItem.put("fileName", files[i].getName());
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems, R.layout.homework_filebrowser_items
                , new String[]{ "icon", "fileName" }, new int[]{R.id.icon, R.id.file_name });
        listView.setAdapter(simpleAdapter);
        try {
            textView.setText("当前路径为：" + currentParent.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String getMIMEType(String name) {
        String houzui=name.substring(name.lastIndexOf("."));
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
