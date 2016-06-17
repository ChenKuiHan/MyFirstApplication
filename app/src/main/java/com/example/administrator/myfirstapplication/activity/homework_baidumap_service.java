package com.example.administrator.myfirstapplication.activity;

import android.Manifest;
import android.app.Service;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;

import com.example.administrator.myfirstapplication.R;

/**
 * Created by ChenKuiHan on 2016/6/16 0016.
 */
public class homework_baidumap_service extends Service {

    LocationManager lm;
    SQLiteDatabase db;
    homework_baidumap_helper helper;
    LocationListener listener;

    @Override
    public void onCreate() {
        super.onCreate();
        helper = new homework_baidumap_helper(this, "point.db", null, 1);
        db = helper.getWritableDatabase();
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Location l = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        record(l);
        listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                record(location);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {
                if (ActivityCompat.checkSelfPermission(homework_baidumap_service.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(homework_baidumap_service.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                    return;
                }
                Location l = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                record(l);
            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, listener);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void record(Location location) {
        if (location != null) {
            ContentValues c = new ContentValues();
            c.put("jing", location.getLongitude());
            c.put("wei", location.getLatitude());
            c.put("time", System.currentTimeMillis());
            db.insert("point", null, c);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        lm.removeUpdates(listener);
    }
}
