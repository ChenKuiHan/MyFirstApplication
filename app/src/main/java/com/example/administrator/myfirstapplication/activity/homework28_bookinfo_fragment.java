package com.example.administrator.myfirstapplication.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.myfirstapplication.R;
import com.example.administrator.myfirstapplication.bean.homework28_book_bean;

/**
 * Created by Administrator on 2016/5/30 0030.
 */
public class homework28_bookinfo_fragment extends Fragment {
    homework28_book_bean.Book book;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments().containsKey("item_id")){
            book=homework28_book_bean.ITEM_MAP.get(getArguments().getInt("item_id"));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.homework28_bookinfo,container,false);
        if(book!=null){
            TextView title = (TextView) view.findViewById(R.id.book_title);
            TextView desc = (TextView) view.findViewById(R.id.book_desc);

            title.setText(book.title);
            desc.setText(book.desc);
        }
        return view;
    }
}
