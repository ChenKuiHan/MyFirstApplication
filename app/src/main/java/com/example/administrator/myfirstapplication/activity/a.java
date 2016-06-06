package com.example.administrator.myfirstapplication.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.SpeechRecognizer;
import android.view.View;

import com.example.administrator.myfirstapplication.R;

public class a extends Activity implements RecognitionListener {
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

    @Override
    public void onReadyForSpeech(Bundle params) {

    }

    @Override
    public void onBeginningOfSpeech() {

    }

    @Override
    public void onRmsChanged(float rmsdB) {

    }

    @Override
    public void onBufferReceived(byte[] buffer) {

    }

    @Override
    public void onEndOfSpeech() {

    }

    @Override
    public void onError(int error) {

    }

    @Override
    public void onResults(Bundle results) {

    }

    @Override
    public void onPartialResults(Bundle partialResults) {

    }

    @Override
    public void onEvent(int eventType, Bundle params) {

    }

}