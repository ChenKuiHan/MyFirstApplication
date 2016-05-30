package com.example.administrator.myfirstapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.administrator.myfirstapplication.R;

/**
 * Created by Administrator on 2016/5/30 0030.
 */
public class homework28_pad_activity extends Activity implements homework28_booklist_fragment.Callback{
    boolean flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homework28_layout);
        if(findViewById(R.id.book_detail_container)!=null){
            flag=true;
        }
    }

    @Override
    public void onItemSelected(Integer id) {
        if(flag){
            Bundle b=new Bundle();
            b.putInt("item_id",id);
            homework28_bookinfo_fragment f=new homework28_bookinfo_fragment();
            f.setArguments(b);

            getFragmentManager().beginTransaction().replace(R.id.book_detail_container,f).commit();
        }else{
            Intent i = new Intent(this,homework28_bookinfo_activity.class);
            i.putExtra("item_id",id);
            startActivity(i);
        }
    }
}
