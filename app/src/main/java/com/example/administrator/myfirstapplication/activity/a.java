package com.example.administrator.myfirstapplication.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.SpeechRecognizer;
import android.view.View;

import com.example.administrator.myfirstapplication.R;

public class a extends Activity {
    private SpeechRecognizer speechRecognizer;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homework36_yuyin);
    }
    public void playsound(View view){
        Intent intent = new Intent();
        intent.setAction("com.baidu.action.RECOGNIZE_SPEECH");
        startActivityForResult(intent, 1);
    }
}