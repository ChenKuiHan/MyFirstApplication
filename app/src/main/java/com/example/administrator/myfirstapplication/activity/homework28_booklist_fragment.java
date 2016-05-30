package com.example.administrator.myfirstapplication.activity;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.administrator.myfirstapplication.bean.homework28_book_bean;

/**
 * Created by Administrator on 2016/5/30 0030.
 */
public class homework28_booklist_fragment extends ListFragment {
    Callback callback;
    public interface Callback
    {
        public void onItemSelected(Integer id);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter aa=new ArrayAdapter(getActivity(),android.R.layout.simple_expandable_list_item_1,android.R.id.text1, homework28_book_bean.ITEMS);
        setListAdapter(aa);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity ac = (Activity) context;
        if(!(ac instanceof Callback))
        {
            throw new RuntimeException("没有实现Callback接口");
        }
        callback = (Callback) context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(!(activity instanceof Callback))
        {
            throw new RuntimeException("没有实现Callback接口");
        }
        callback = (Callback) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback=null;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        homework28_book_bean.Book book=homework28_book_bean.ITEM_MAP.get(position);
        callback.onItemSelected(book.id);
    }
}
