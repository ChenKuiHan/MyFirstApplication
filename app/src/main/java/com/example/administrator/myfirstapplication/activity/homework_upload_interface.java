package com.example.administrator.myfirstapplication.activity;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by ChenKuiHan on 2016/6/12 0012.
 */
public interface homework_upload_interface {
    @Multipart
    @POST("/Test/fileUpload.do")
    Call<Map<String,String>> upload(@Part("_id")String _id, @Part("sname")String sname,@Part("sbirth")String sbirth,
                                    @Part("fileName")String fileName,@Part("file\"; filename=\"image.jpg\"") RequestBody imgs);
}
