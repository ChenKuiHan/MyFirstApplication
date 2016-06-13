package com.example.administrator.myfirstapplication.activity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.example.administrator.myfirstapplication.R;

/**
 * Created by ChenKuiHan on 2016/6/13 0013.
 */
public class homework_zhinanzhen_activity extends BaseActivity implements SensorEventListener{
    ImageView znz;
    float current = 0f;
    SensorManager sm;
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework_zhinanzhen);
        znz= (ImageView) findViewById(R.id.imageView5);
        sm= (SensorManager) getSystemService(SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sm.registerListener(this, sm.getDefaultSensor(Sensor.TYPE_ORIENTATION), SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sm.unregisterListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        sm.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        int sensorType = event.sensor.getType();
        switch (sensorType) {
            case Sensor.TYPE_ORIENTATION:
                float degree = event.values[0];
                RotateAnimation ra = new RotateAnimation(current, -degree, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                ra.setDuration(200);
                znz.startAnimation(ra);
                current = -degree;
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
