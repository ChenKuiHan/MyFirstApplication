package com.example.administrator.myfirstapplication.activity;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.administrator.myfirstapplication.R;

/**
 * Created by Administrator on 2016/5/27 0027.
 */
public class homework13_listview_activity extends BaseActivity{
    String[] groupname={"1号组","2号组","3号组","4号组","5号组","6号组"};
    String[][]groupinfo={{"第1项","第2项","第3项"},{"第4项","第5项","第6项"},{"第7项","第8项","第9项"},
            {"第10项","第11项","第12项"},{"第13项","第14项","第15项"},{"第16项","第17项","第18项"}};
    @Override
    protected void contectview(Bundle savedInstanceState){
        setContentView(R.layout.homework13);
        ExpandableListAdapter ea=new ExpandableListAdapter() {
            @Override
            public void registerDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public int getGroupCount() {
                return groupname.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return groupinfo[groupPosition].length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return groupname[groupPosition];
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return groupinfo[groupPosition][childPosition];
            }

            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                LayoutInflater li = LayoutInflater.from(homework13_listview_activity.this);
                View v = li.inflate(android.R.layout.simple_list_item_1,null);
                TextView tv = (TextView) v.findViewById(android.R.id.text1);
                tv.setPadding(90,0,0,0);
                tv.setText(groupname[groupPosition]);
                return v;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                TextView tv = new TextView(homework13_listview_activity.this);
                tv.setText(groupinfo[groupPosition][childPosition]);
                return tv;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return false;
            }

            @Override
            public boolean areAllItemsEnabled() {
                return false;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public void onGroupExpanded(int groupPosition) {

            }

            @Override
            public void onGroupCollapsed(int groupPosition) {

            }

            @Override
            public long getCombinedChildId(long groupId, long childId) {
                return childId;
            }

            @Override
            public long getCombinedGroupId(long groupId) {
                return groupId;
            }
        };
        ExpandableListView ev= (ExpandableListView) findViewById(R.id.grouplist);
        ev.setAdapter(ea);
    }
}
