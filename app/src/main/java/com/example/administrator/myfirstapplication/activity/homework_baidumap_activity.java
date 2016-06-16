package com.example.administrator.myfirstapplication.activity;

import android.Manifest;
import android.app.Activity;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.ActivityCompat;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.CoordinateConverter;
import com.example.administrator.myfirstapplication.R;
import com.example.administrator.myfirstapplication.bean.homework_db_student_bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChenKuiHan on 2016/6/16 0016.
 */
public class homework_baidumap_activity extends Activity {
    MapView mMapView;
    BaiduMap mBaiduMap;
    LocationManager lm;
    SQLiteDatabase db;
    homework_baidumap_helper helper;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homework_baidumap);
        db=helper.getWritableDatabase();
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Location l = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        mMapView = (MapView) findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        updateView(l);
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 10, new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                updateView(location);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {
                if (ActivityCompat.checkSelfPermission(homework_baidumap_activity.this,
                        Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                        && ActivityCompat.checkSelfPermission(homework_baidumap_activity.this,
                        Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                Location l = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                updateView(l);
            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        });
        Intent i=new Intent(this,homework_baidumap_service.class);
        startService(i);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onDestroy();
    }
    public void updateView(Location l) {
        if(l!=null) {
            LatLng point = new LatLng(l.getLatitude(), l.getLongitude());
            CoordinateConverter converter  = new CoordinateConverter();
            converter.from(CoordinateConverter.CoordType.GPS);
            converter.coord(point);
            LatLng desLatLng = converter.convert();

            BitmapDescriptor bitmap = BitmapDescriptorFactory
                    .fromResource(R.drawable.bullet_04);
            OverlayOptions option = new MarkerOptions()
                    .position(desLatLng)
                    .icon(bitmap);
            mBaiduMap.addOverlay(option);
        }else{
            LatLng point = new LatLng(39.963175, 116.400244);
            BitmapDescriptor bitmap = BitmapDescriptorFactory
                    .fromResource(R.drawable.bullet_04);
            OverlayOptions option = new MarkerOptions()
                    .position(point)
                    .icon(bitmap);
            mBaiduMap.addOverlay(option);
        }
        //构造纹理资源
        BitmapDescriptor custom1 = BitmapDescriptorFactory
                .fromResource(R.drawable.arrow);
        List<BitmapDescriptor> customList = new ArrayList<BitmapDescriptor>();
        customList.add(custom1);

        List<LatLng> points = new ArrayList<LatLng>();
        List<Integer> index = new ArrayList<Integer>();

        c = helper.getReadableDatabase().query("student",null,null,null,null,null,null);
        while (c.moveToNext()){
            LatLng point1 = new LatLng(c.getDouble(c.getColumnIndex("wei")), c.getDouble(c.getColumnIndex("jing")));

            points.add(point1);
            index.add(0);
        }

        OverlayOptions ooPolyline = new PolylineOptions().width(15).color(0xAAFF0000).points(points).customTextureList(customList).textureIndex(index);

        mBaiduMap.addOverlay(ooPolyline);
    }
}
