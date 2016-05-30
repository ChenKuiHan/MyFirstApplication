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
    Class[] c={homework1_helloword_activity.class,homework2_img_activity.class,homework3_phoneinfo_activity.class,homework4_imgchange_activity.class,
            homework5_drawxin_activity.class,homework6_login_activity.class,homework6_qq_activity.class,homework6_tel_activity.class,
            homework7_nihong_activity.class,homework8_shizi_activity.class,homework9_calculator_activity.class,homework10_qq_activity.class,
            homework10_sousuo_activity.class,homework11_radio_activity.class,homework13_listview_activity.class,homework15_imgchangealpha_activity.class,
            homework_api_caipu_activity.class,homework_api_guishu_activity.class,homework_Spinner_activity.class,homework_autoplayview_activity.class,
            homework_duoxuan_activity.class,homework_gotoTEL_activity.class,homework_seekbar_activity.class,homework_tanqiu_moveair_activity.class,
            homework_autochangelanguange_activity.class,homework28_pad_activity.class};
    String[] s={"helloworld","放个图片","手机屏幕信息","图片轮循","画心","表格布局登录","仿qq","输入电话号","霓虹灯闪烁","十字图片","计算器",
            "仿qq2","搜索","单选复选/验证码按钮","可展开的list","图片改变透明度","api查菜谱","api查归属地","Spinner","自动播放view","dailog多选",
            "转到通讯录","bar","弹球","自动改变语言","分辨手机，pad"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homework_main);
        lv = (ListView) findViewById(R.id.homeworklist);

        ArrayAdapter<String> aa = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, s);
        lv.setAdapter(aa);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(homework_main_activity.this, c[position]);
                startActivity(i);
            }
        });
    }
}
