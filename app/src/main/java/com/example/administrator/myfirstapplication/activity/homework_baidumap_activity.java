package com.example.administrator.myfirstapplication.activity;

import android.Manifest;
import android.app.Activity;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.CoordinateConverter;
import com.example.administrator.myfirstapplication.R;
import com.example.administrator.myfirstapplication.bean.homework_db_student_bean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ChenKuiHan on 2016/6/16 0016.
 */
public class homework_baidumap_activity extends Activity {
    @BindView(R.id.bmapView)
    MapView mMapView;
    BaiduMap mBaiduMap;
    LocationManager lm;
    SQLiteDatabase db;
    homework_baidumap_helper helper;
    Cursor c;
    Intent i1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homework_baidumap);

        i1= new Intent(homework_baidumap_activity.this, homework_baidumap_service.class);
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location l = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        helper = new homework_baidumap_helper(this, "point.db", null, 1);
        db = helper.getWritableDatabase();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        mBaiduMap = mMapView.getMap();
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        updateView(l);
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                updateView(location);
            }
            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {}
            @Override
            public void onProviderEnabled(String provider) {
                if (ActivityCompat.checkSelfPermission(homework_baidumap_activity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(homework_baidumap_activity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                Location l = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                updateView(l);
            }
            @Override
            public void onProviderDisabled(String provider) {}
        });
        Intent i = new Intent(this, homework_baidumap_service.class);
        startService(i);
    }
    @OnClick(R.id.startrecord)
    public void startRecord(View view){
        startService(i1);
    }
    @OnClick(R.id.stoprecord)
    public void stopRecord(View view){
        stopService(i1);
    }
    @OnClick(R.id.cleanrecord)
    public void cleanRecord(View view){
        db.delete("point", null, null);
        Location l = null;
        updateView(l);
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
        mMapView.onDestroy();
    }
    public void updateView(Location l) {
        OverlayOptions option;
        mBaiduMap.clear();
        if (l != null) {
            LatLng point = new LatLng(l.getLatitude(), l.getLongitude());
            CoordinateConverter converter = new CoordinateConverter();
            converter.from(CoordinateConverter.CoordType.GPS);
            converter.coord(point);
            LatLng desLatLng = converter.convert();
            MapStatus mMapStatus = new MapStatus.Builder()
                    .target(desLatLng)
                    .zoom(18)
                    .build();
            MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
            mBaiduMap.setMapStatus(mMapStatusUpdate);
            BitmapDescriptor bitmap = BitmapDescriptorFactory
                    .fromResource(R.drawable.bullet_04);
            option = new MarkerOptions()
                    .position(desLatLng)
                    .icon(bitmap);

            mBaiduMap.addOverlay(option);
        }
        List<Integer> colors = new ArrayList<>();
        colors.add(Color.BLUE);
        List<LatLng> points = new ArrayList<LatLng>();
        List<Integer> index = new ArrayList<Integer>();

        c = helper.getReadableDatabase().query("point", null, null, null, null, null, "time");
        while (c.moveToNext()) {
            LatLng point1 = new LatLng(c.getDouble(c.getColumnIndex("wei")), c.getDouble(c.getColumnIndex("jing")));
            CoordinateConverter converter = new CoordinateConverter();
            converter.from(CoordinateConverter.CoordType.GPS);
            converter.coord(point1);
            LatLng desLatLng = converter.convert();
            points.add(desLatLng);
            index.add(0);
        }
        if (!(points.size() < 2)) {
            OverlayOptions ooPolyline = new PolylineOptions().width(10)
                    .colorsValues(colors).points(points);
            Polyline mPolyline = (Polyline) mBaiduMap.addOverlay(ooPolyline);
        }
    }
}
