package com.example.administrator.myfirstapplication.activity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;

import com.baidu.tts.client.SpeechError;
import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.SpeechSynthesizerListener;
import com.baidu.tts.client.TtsMode;
import com.example.administrator.myfirstapplication.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by eternl on 2016/6/4.
 */
public class homework36_yuyin_activity extends BaseActivity  implements SpeechSynthesizerListener {
    EditText et;
    private static final String TAG = "MainActivity";
    private SpeechSynthesizer ss;
    private String datfiledir;
    private static final String SPEECH_FEMALE_MODEL_NAME = "bd_etts_speech_female.dat";
    private static final String SPEECH_MALE_MODEL_NAME = "bd_etts_speech_male.dat";
    private static final String TEXT_MODEL_NAME = "bd_etts_text.dat";
    private static final String ENGLISH_SPEECH_FEMALE_MODEL_NAME = "bd_etts_speech_female_en.dat";
    private static final String ENGLISH_SPEECH_MALE_MODEL_NAME = "bd_etts_speech_male_en.dat";
    private static final String ENGLISH_TEXT_MODEL_NAME = "bd_etts_text_en.dat";
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework36_yuyin);
        et= (EditText) findViewById(R.id.texta);
        initsysfile();
        initTts();
    }
    private void initsysfile() {
        if (datfiledir == null) {
            String sdcardPath = Environment.getExternalStorageDirectory().toString();
            datfiledir = sdcardPath + "/" + "yuyintext";
        }
        File file = new File(datfiledir);
        if (!file.exists()) {
            file.mkdirs();
        }
        copyFromAssetsToSdcard(SPEECH_FEMALE_MODEL_NAME, datfiledir + "/" + SPEECH_FEMALE_MODEL_NAME);
        copyFromAssetsToSdcard(SPEECH_MALE_MODEL_NAME, datfiledir + "/" + SPEECH_MALE_MODEL_NAME);
        copyFromAssetsToSdcard(TEXT_MODEL_NAME, datfiledir + "/" + TEXT_MODEL_NAME);
        copyFromAssetsToSdcard("english/" + ENGLISH_SPEECH_FEMALE_MODEL_NAME, datfiledir + "/"
                + ENGLISH_SPEECH_FEMALE_MODEL_NAME);
        copyFromAssetsToSdcard("english/" + ENGLISH_SPEECH_MALE_MODEL_NAME, datfiledir + "/"
                + ENGLISH_SPEECH_MALE_MODEL_NAME);
        copyFromAssetsToSdcard("english/" + ENGLISH_TEXT_MODEL_NAME, datfiledir + "/"
                + ENGLISH_TEXT_MODEL_NAME);
    }
    public void playsound(View view){
        String content = et.getText().toString();
        ss.speak(content);
    }
    private void initTts() {
        ss = SpeechSynthesizer.getInstance();
        ss.setContext(this);
        ss.setSpeechSynthesizerListener(this);
        ss.setParam(SpeechSynthesizer.PARAM_TTS_TEXT_MODEL_FILE, datfiledir + "/" + TEXT_MODEL_NAME);
        ss.setParam(SpeechSynthesizer.PARAM_TTS_SPEECH_MODEL_FILE, datfiledir + "/" + SPEECH_FEMALE_MODEL_NAME);
        ss.setAppId("8220563");
        ss.setApiKey("FKRWRHlsUp1LPIk8bjhHe9YC", "0bfcf0f0a6085a49e6ed58b1d6bfd4f8");
        ss.setParam(SpeechSynthesizer.PARAM_SPEAKER, "3");
        ss.setParam(SpeechSynthesizer.PARAM_MIX_MODE, SpeechSynthesizer.MIX_MODE_DEFAULT);
        ss.initTts(TtsMode.MIX);
        ss.loadEnglishModel(datfiledir + "/" + ENGLISH_TEXT_MODEL_NAME, datfiledir + "/" + ENGLISH_SPEECH_FEMALE_MODEL_NAME);
    }
    @Override
    public void onSynthesizeStart(String s) {

    }

    @Override
    public void onSynthesizeDataArrived(String s, byte[] bytes, int i) {

    }

    @Override
    public void onSynthesizeFinish(String s) {

    }

    @Override
    public void onSpeechStart(String s) {

    }

    @Override
    public void onSpeechProgressChanged(String s, int i) {

    }

    @Override
    public void onSpeechFinish(String s) {

    }

    @Override
    public void onError(String s, SpeechError speechError) {

    }
    public void copyFromAssetsToSdcard(String source, String path) {
        File file = new File(path);
        if (!file.exists()) {
            InputStream is = null;
            FileOutputStream fos = null;
            try {
                is = getResources().getAssets().open(source);
                fos = new FileOutputStream(path);
                byte[] buffer = new byte[1024];
                int size = 0;
                while ((size = is.read(buffer, 0, 1024)) >= 0) {
                    fos.write(buffer, 0, size);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    if (is != null) {
                        is.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
