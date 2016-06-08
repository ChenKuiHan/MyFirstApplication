package com.example.administrator.myfirstapplication.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.myfirstapplication.R;

/**
 * Created by Administrator on 2016/5/26 0026.
 */
public class homework_main_activity extends BaseActivity {
    ListView lv;
    Class[] c = {homework1_helloword_activity.class, homework2_img_activity.class,
            homework3_phoneinfo_activity.class, homework4_imgchange_activity.class,
            homework5_drawxin_activity.class, homework6_login_activity.class,
            homework6_qq_activity.class, homework6_tel_activity.class,
            homework7_nihong_activity.class, homework8_shizi_activity.class,
            homework9_calculator_activity.class, homework10_qq_activity.class,
            homework10_sousuo_activity.class, homework11_radio_activity.class,
            homework_tanqiu_moveair_activity.class, homework_api_caipu_activity.class,
            homework_api_guishu_activity.class, homework13_listview_activity.class,
            homework_Spinner_activity.class, homework_taobaoad_activity.class,
            homework14_autoplayview_activity.class, homework15_imgchangealpha_activity.class,
            homework_api_autosearch_chengyu_activity.class, homework17_gridview_activity.class,
            homework19_birthday_activity.class,homework20_tabs_activity.class,
            homework22_menu_activity.class, homework_duoxuan_activity.class,
            homework_autochangelanguange_activity.class, homework24_call_send_activity.class,
            homework_content_activity.class, homework25_city_activity.class,
            homework26_configuration_activity.class, homework_download_activity.class,
            homework28_pad_activity.class, homework30_baidu_activity.class,
            homework_huaxian_activity.class, homework_boom_activity.class,
            homework_autologin_activity.class, homework32_db_activity.class,
            homework_filebrowser_activity.class, homework33_shoushi_activity.class,
            homework34_shoushi2_activity.class,homework35_diyshoushi_activity.class,
            homework_contentresolver_activity.class,homework_gotoTEL_activity.class,
            homework_seekbar_activity.class, homework36_yuyin_activity.class,
            homework36_yuyin2_activity.class,homework38_smssend_activity.class,
            homework40_music_activity.class,homework41_vibrator_activity.class,
            homework42_alarm_activity.class,homework_videoview_activity.class};

    String[] s = {"作业1：helloworld", "作业2：放个图片", "作业3：手机屏幕信息", "作业4：图片轮循",
            "作业5：画心", "作业6：表格布局登录", "作业6：仿qq", "作业6：输入电话号",
            "作业7：霓虹灯闪烁", "作业8：十字图片", "作业9：计算器", "作业10：仿qq2",
            "作业10：搜索", "作业11&12：单选复选/验证码按钮", "作业12_1：弹球", "作业12_2&13_4&16：api查菜谱，点击进入详情，listview",
            "作业12_2：api查归属地", "作业13：可展开的list", "作业13_2:Spinner", "作业13_3：自动播放图片",
            "作业14：viewswitcher3秒切换", "作业15：图片改变透明度，局部显示", "作业15_2&18：自动查找", "作业17：gridview两列",
            "作业19：生日","作业20：tabs","作业22：menu", "作业23：dailog多选",
            "作业23_3：自动改变语言","作业24：打电话，发短信", "作业24_1：点击获取联系人信息","作业25：expandlistview传参",
            "作业26：屏幕方向对应布局", "作业27：网络下载并打开", "作业28：分辨手机，pad","作业24_2&30：打开百度",
            "作业30_2：画线", "作业30_3：爆炸,补间动画", "作业31：自动登录", "作业32：数据库操作",
            "作业32_1：文件浏览器", "作业33：手势缩放图片", "作业34：左右滑换页","作业35&35_1：自定义手势",
            "作业：resolver","作业：转到通讯录", "作业：bar", "作业36：百度语音合成",
            "作业36：百度语音识别","作业38：短信群发","作业40：播放音乐","作业41：震动",
            "作业42：设置闹钟","作业：放视频"};

    private ServiceConnection con=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void contectview(Bundle savedInstanceState) {
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
        Intent i=new Intent(this,homework_phonelisten_service.class);
        bindService(i,con,BIND_AUTO_CREATE);
        Toast.makeText(homework_main_activity.this, "来电监听已启动", Toast.LENGTH_SHORT).show();
        Toast.makeText(homework_main_activity.this, "短信拦截已启动", Toast.LENGTH_SHORT).show();
    }
}
