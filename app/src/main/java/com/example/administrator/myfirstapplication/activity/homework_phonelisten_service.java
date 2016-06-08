package com.example.administrator.myfirstapplication.activity;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;

/**
 * Created by ChenKuiHan on 2016/6/8 0008.
 */
public class homework_phonelisten_service extends Service {

    TelephonyManager tm;

    @Override
    public void onCreate() {
        super.onCreate();
        tm= (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        PhoneStateListener p=new PhoneStateListener(){
            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                super.onCallStateChanged(state, incomingNumber);
                if(state==TelephonyManager.CALL_STATE_RINGING){
                    Toast.makeText(homework_phonelisten_service.this, incomingNumber, Toast.LENGTH_SHORT).show();
                }
            }
        };
        tm.listen(p,PhoneStateListener.LISTEN_CALL_STATE);
        return null;
    }
}
