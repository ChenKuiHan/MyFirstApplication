package com.example.administrator.myfirstapplication.activity;

import com.example.administrator.myfirstapplication.bean.homework_gupiao_bean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by ChenKuiHan on 2016/6/12 0012.
 */
public interface homework_gupiao_interface {
    @GET("/apistore/stockservice/hkstock")
    Call<homework_gupiao_bean> getgpInfo(@Header("apikey") String apikey, @Query("stockid") String stockid, @Query("list") String list);
}
