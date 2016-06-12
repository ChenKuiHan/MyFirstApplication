package com.example.administrator.myfirstapplication.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.myfirstapplication.R;
import com.example.administrator.myfirstapplication.bean.homework_gupiao_bean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ChenKuiHan on 2016/6/12 0012.
 */
public class homework_gupiao_activity extends BaseActivity {
EditText et1;
    TextView tv;
    Button btn;
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework_gupiao);
        et1= (EditText) findViewById(R.id.ID);
        btn= (Button) findViewById(R.id.button9);
        tv= (TextView) findViewById(R.id.info);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://apis.baidu.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                homework_gupiao_interface gpi=retrofit.create(homework_gupiao_interface.class);
                Call<homework_gupiao_bean> c= gpi.getgpInfo("4383014a2e3615a560e13c94b40816e8",et1.getText().toString(),"0");
                c.enqueue(new Callback<homework_gupiao_bean>() {
                    @Override
                    public void onResponse(Call<homework_gupiao_bean> call, Response<homework_gupiao_bean> response) {
                        homework_gupiao_bean gp=response.body();
                        tv.setText("股票名称:"+gp.getRetData().getStockinfo().getName()+"\n"+
                                "股票代码:"+gp.getRetData().getStockinfo().getCode()+"\n"+
                                "日期:"+gp.getRetData().getStockinfo().getDate()+"\n"+
                                "开盘价:"+gp.getRetData().getStockinfo().getOpenningPrice()+"\n"+
                                "昨日收盘价:"+gp.getRetData().getStockinfo().getClosingPrice()+"\n"+
                                "今日最高价:"+gp.getRetData().getStockinfo().getHPrice()+"\n"+
                                "今日最低价:"+gp.getRetData().getStockinfo().getLPrice()+"\n"+
                                "当前价:"+gp.getRetData().getStockinfo().getCurrentPrice()+"\n"+
                                "价格涨幅:"+gp.getRetData().getStockinfo().getGrowth()+"\n"+
                                "价格涨幅比例，单位%:"+gp.getRetData().getStockinfo().getGrowthPercent()+"\n"+
                                "成交量股:"+gp.getRetData().getStockinfo().getDealnumber()+"\n"+
                                "成交金额，单位港币:"+gp.getRetData().getStockinfo().getTurnover()+"\n"+
                                "52周最高价:"+gp.getRetData().getStockinfo().getValue52hPrice()+"\n"+
                                "52周最低价:"+gp.getRetData().getStockinfo().getValue52lPrice());
                    }

                    @Override
                    public void onFailure(Call<homework_gupiao_bean> call, Throwable t) {
                        tv.setText("Name");
                    }
                });
            }
        });
    }
}
