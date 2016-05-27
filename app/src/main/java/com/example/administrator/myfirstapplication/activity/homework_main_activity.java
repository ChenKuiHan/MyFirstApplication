package com.example.administrator.myfirstapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.administrator.myfirstapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/26 0026.
 */
public class homework_main_activity extends Activity {
    ListView lv;
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homework_main);
        list = new ArrayList<>();
        lv = (ListView) findViewById(R.id.homeworklist);
        list.add("holloword");
        list.add("放个图片");
        list.add("手机屏幕信息");
        list.add("图片轮循");
        list.add("画心");
        list.add("表格布局登录");
        list.add("仿qq");
        list.add("输入电话号");
        list.add("霓虹灯闪烁");
        list.add("十字图片");
        list.add("仿qq2");
        list.add("搜索");
        list.add("单选复选/验证码按钮");
        list.add("图片改变透明度");
        list.add("api查菜谱");
        list.add("api查归属地");
        list.add("dailog多选");
        list.add("转到通讯录");
        list.add("bar");
        list.add("弹球");
        list.add("自动改变语言");


        ArrayAdapter<String> aa = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, list);
        lv.setAdapter(aa);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent i = new Intent(homework_main_activity.this, homework1_helloword_activity.class);
                        startActivity(i);
                        break;
                    case 1:
                        Intent i1 = new Intent(homework_main_activity.this, homework2_img_activity.class);
                        startActivity(i1);
                        break;
                    case 2:
                        Intent i2 = new Intent(homework_main_activity.this, homework3_phoneinfo_activity.class);
                        startActivity(i2);
                        break;
                    case 3:
                        Intent i3 = new Intent(homework_main_activity.this, homework4_imgchange_activity.class);
                        startActivity(i3);
                        break;
                    case 4:
                        Intent i4 = new Intent(homework_main_activity.this, homework5_drawxin_activity.class);
                        startActivity(i4);
                        break;
                    case 5:
                        Intent i5 = new Intent(homework_main_activity.this, homework6_login_activity.class);
                        startActivity(i5);
                        break;
                    case 6:
                        Intent i6 = new Intent(homework_main_activity.this, homework6_qq_activity.class);
                        startActivity(i6);
                        break;
                    case 7:
                        Intent i7 = new Intent(homework_main_activity.this, homework6_tel_activity.class);
                        startActivity(i7);
                        break;
                    case 8:
                        Intent i8 = new Intent(homework_main_activity.this, homework7_nihong_activity.class);
                        startActivity(i8);
                        break;
                    case 9:
                        Intent i9 = new Intent(homework_main_activity.this, homework8_shizi_activity.class);
                        startActivity(i9);
                        break;
                    case 10:
                        Intent i10 = new Intent(homework_main_activity.this, homework10_qq_activity.class);
                        startActivity(i10);
                        break;
                    case 11:
                        Intent i11 = new Intent(homework_main_activity.this, homework10_sousuo_activity.class);
                        startActivity(i11);
                        break;
                    case 12:
                        Intent i12 = new Intent(homework_main_activity.this, homework11_radio_activity.class);
                        startActivity(i12);
                        break;
                    case 13:
                        Intent i13 = new Intent(homework_main_activity.this, homework15_imgchangealpha_activity.class);
                        startActivity(i13);
                        break;
                    case 14:
                        Intent i14 = new Intent(homework_main_activity.this, homework_api_caipu_activity.class);
                        startActivity(i14);
                        break;
                    case 15:
                        Intent i15 = new Intent(homework_main_activity.this, homework_api_guishu_activity.class);
                        startActivity(i15);
                        break;
                    case 16:
                        Intent i16 = new Intent(homework_main_activity.this, homework_duoxuan_activity.class);
                        startActivity(i16);
                        break;
                    case 17:
                        Intent i17 = new Intent(homework_main_activity.this, homework_gotoTEL_activity.class);
                        startActivity(i17);
                        break;
                    case 18:
                        Intent i18 = new Intent(homework_main_activity.this, homework_seekbar_activity.class);
                        startActivity(i18);
                        break;
                    case 19:
                        Intent i19 = new Intent(homework_main_activity.this, homework_tanqiu_moveair_activity.class);
                        startActivity(i19);
                        break;
                    case 20:
                        Intent i20 = new Intent(homework_main_activity.this, homework_autochangelanguange_activity.class);
                        startActivity(i20);
                        break;
                }
            }
        });
    }
}
