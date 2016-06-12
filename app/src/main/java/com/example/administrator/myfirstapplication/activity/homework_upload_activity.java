package com.example.administrator.myfirstapplication.activity;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.myfirstapplication.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ChenKuiHan on 2016/6/12 0012.
 */
public class homework_upload_activity extends BaseActivity {
    EditText sid;
    EditText sname;
    EditText birth;
    Button choose;
    Button upload;
    ImageView ivv;
    Uri uri;
    Bitmap bitmap;
    File file;
    String filename;
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework_upload);
        sid= (EditText) findViewById(R.id.sid);
        sname= (EditText) findViewById(R.id.sname);
        birth= (EditText) findViewById(R.id.sbirth);
        choose= (Button) findViewById(R.id.choose);
        upload= (Button) findViewById(R.id.upload);
        ivv= (ImageView) findViewById(R.id.image123);
        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1);
            }
        });
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.1.188:8080")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                homework_upload_interface gpi=retrofit.create(homework_upload_interface.class);
                RequestBody re=RequestBody.create(MediaType.parse("multipart/form-data"),file);
                Call<Map<String,String>> c= gpi.upload(sid.getText().toString(),sname.getText().toString(),birth.getText().toString(),
                        filename,re);
                c.enqueue(new Callback<Map<String, String>>() {
                    @Override
                    public void onResponse(Call<Map<String, String>> call, Response<Map<String, String>> response) {
                        if(response!=null){
                            Toast.makeText(homework_upload_activity.this, "成功", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Map<String, String>> call, Throwable t) {
                        Toast.makeText(homework_upload_activity.this, t.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            uri = data.getData();
            ContentResolver cr = this.getContentResolver();
            try {
                bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                ivv.setImageBitmap(bitmap);
                Cursor cc=cr.query(uri, null,null,null,null);
                cc.moveToFirst();
                int i=cc.getColumnIndex(MediaStore.Images.Media.DATA);
                String path=cc.getString(i);
               // filename=cc.getString(cc.getColumnIndex("_display_name"));

                //sid.setText(path);
                file=new File(path);
                filename=file.getName();
               // file=new File("/mnt/sdcard/杂项/1444627614.jpg");
            } catch (FileNotFoundException e) {

            }
        }
    }
}
