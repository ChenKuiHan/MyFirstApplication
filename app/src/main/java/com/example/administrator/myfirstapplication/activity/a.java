package com.example.administrator.myfirstapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.baidu.tts.answer.auth.AuthInfo;
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
 * Created by Administrator on 2016/6/6 0006.
 */
public class a extends Activity implements SpeechSynthesizerListener {
        private static final String TAG = "MainActivity";

        private SpeechSynthesizer mSpeechSynthesizer;//百度语音合成客户端
        private String mSampleDirPath;
        private static final String SAMPLE_DIR_NAME = "baiduTTS";
        private static final String SPEECH_FEMALE_MODEL_NAME = "bd_etts_speech_female.dat";
        private static final String SPEECH_MALE_MODEL_NAME = "bd_etts_speech_male.dat";
        private static final String TEXT_MODEL_NAME = "bd_etts_text.dat";
        private static final String LICENSE_FILE_NAME = "temp_license_2016-04-05";
        private static final String ENGLISH_SPEECH_FEMALE_MODEL_NAME = "bd_etts_speech_female_en.dat";
        private static final String ENGLISH_SPEECH_MALE_MODEL_NAME = "bd_etts_speech_male_en.dat";
        private static final String ENGLISH_TEXT_MODEL_NAME = "bd_etts_text_en.dat";
        private static final String APP_ID = "7957876";//请更换为自己创建的应用
        private static final String API_KEY = "cVN31pILxBhRNdGdlNHyeuyq";//请更换为自己创建的应用
        private static final String SECRET_KEY = "84e6987b56f11e6ee97e02ef25a2b4f0";//请更换为自己创建的应用

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.homework36_yuyin);
            initialEnv();
            initialTts();
            initView();
        }

        @Override
        protected void onDestroy() {
            this.mSpeechSynthesizer.release();//释放资源
            super.onDestroy();
        }

        private EditText edt_content;
        private Button btn_speak;

        private void initView() {
            edt_content = (EditText) findViewById(R.id.texta);
            btn_speak = (Button) findViewById(R.id.playbtn);
            btn_speak.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String content = edt_content.getText().toString();
                    mSpeechSynthesizer.speak(content);
                }
            });
        }

        /**
         * 初始化语音合成客户端并启动
         */
        private void initialTts() {
            //获取语音合成对象实例
            this.mSpeechSynthesizer = SpeechSynthesizer.getInstance();
            //设置Context
            this.mSpeechSynthesizer.setContext(this);
            //设置语音合成状态监听
            this.mSpeechSynthesizer.setSpeechSynthesizerListener(this);
            //文本模型文件路径 (离线引擎使用)
            this.mSpeechSynthesizer.setParam(SpeechSynthesizer.PARAM_TTS_TEXT_MODEL_FILE, mSampleDirPath + "/"
                    + TEXT_MODEL_NAME);
            //声学模型文件路径 (离线引擎使用)
            this.mSpeechSynthesizer.setParam(SpeechSynthesizer.PARAM_TTS_SPEECH_MODEL_FILE, mSampleDirPath + "/"
                    + SPEECH_FEMALE_MODEL_NAME);
            //本地授权文件路径,如未设置将使用默认路径.设置临时授权文件路径，LICENCE_FILE_NAME请替换成临时授权文件的实际路径，
            //仅在使用临时license文件时需要进行设置，如果在[应用管理]中开通了离线授权，
            //不需要设置该参数，建议将该行代码删除（离线引擎）
            this.mSpeechSynthesizer.setParam(SpeechSynthesizer.PARAM_TTS_LICENCE_FILE, mSampleDirPath + "/"
                    + LICENSE_FILE_NAME);
            //请替换为语音开发者平台上注册应用得到的App ID (离线授权)
            this.mSpeechSynthesizer.setAppId(APP_ID);
            // 请替换为语音开发者平台注册应用得到的apikey和secretkey (在线授权)
            this.mSpeechSynthesizer.setApiKey(API_KEY, SECRET_KEY);
            //发音人（在线引擎），可用参数为0,1,2,3。。。
            //（服务器端会动态增加，各值含义参考文档，以文档说明为准。0--普通女声，1--普通男声，2--特别男声，3--情感男声。。。）
            this.mSpeechSynthesizer.setParam(SpeechSynthesizer.PARAM_SPEAKER, "0");
            // 设置Mix模式的合成策略
            this.mSpeechSynthesizer.setParam(SpeechSynthesizer.PARAM_MIX_MODE, SpeechSynthesizer.MIX_MODE_DEFAULT);
            // 授权检测接口(可以不使用，只是验证授权是否成功)
            AuthInfo authInfo = this.mSpeechSynthesizer.auth(TtsMode.MIX);
            if (authInfo.isSuccess()) {
                Log.i(TAG, ">>>auth success.");
            } else {
                String errorMsg = authInfo.getTtsError().getDetailMessage();
                Log.i(TAG, ">>>auth failed errorMsg: " + errorMsg);
            }
            // 引擎初始化tts接口
            mSpeechSynthesizer.initTts(TtsMode.MIX);
            // 加载离线英文资源（提供离线英文合成功能）
            int result =
                    mSpeechSynthesizer.loadEnglishModel(mSampleDirPath + "/" + ENGLISH_TEXT_MODEL_NAME, mSampleDirPath
                            + "/" + ENGLISH_SPEECH_FEMALE_MODEL_NAME);
            Log.i(TAG, ">>>loadEnglishModel result: " + result);
        }

        @Override
        public void onSynthesizeStart(String s) {
            //监听到合成开始
            Log.i(TAG, ">>>onSynthesizeStart()<<< s: " + s);
        }

        @Override
        public void onSynthesizeDataArrived(String s, byte[] bytes, int i) {
            //监听到有合成数据到达
            Log.i(TAG, ">>>onSynthesizeDataArrived()<<< s: " + s);
        }

        @Override
        public void onSynthesizeFinish(String s) {
            //监听到合成结束
            Log.i(TAG, ">>>onSynthesizeFinish()<<< s: " + s);
        }

        @Override
        public void onSpeechStart(String s) {
            //监听到合成并开始播放
            Log.i(TAG, ">>>onSpeechStart()<<< s: " + s);
        }

        @Override
        public void onSpeechProgressChanged(String s, int i) {
            //监听到播放进度有变化
            Log.i(TAG, ">>>onSpeechProgressChanged()<<< s: " + s);
        }

        @Override
        public void onSpeechFinish(String s) {
            //监听到播放结束
            Log.i(TAG, ">>>onSpeechFinish()<<< s: " + s);
        }

        @Override
        public void onError(String s, SpeechError speechError) {
            //监听到出错
            Log.i(TAG, ">>>onError()<<< description: " + speechError.description + ", code: " + speechError.code);
        }

        private void initialEnv() {
            if (mSampleDirPath == null) {
                String sdcardPath = Environment.getExternalStorageDirectory().toString();
                mSampleDirPath = sdcardPath + "/" + SAMPLE_DIR_NAME;
            }
            File file = new File(mSampleDirPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            copyFromAssetsToSdcard(false, SPEECH_FEMALE_MODEL_NAME, mSampleDirPath + "/" + SPEECH_FEMALE_MODEL_NAME);
            copyFromAssetsToSdcard(false, SPEECH_MALE_MODEL_NAME, mSampleDirPath + "/" + SPEECH_MALE_MODEL_NAME);
            copyFromAssetsToSdcard(false, TEXT_MODEL_NAME, mSampleDirPath + "/" + TEXT_MODEL_NAME);
            copyFromAssetsToSdcard(false, LICENSE_FILE_NAME, mSampleDirPath + "/" + LICENSE_FILE_NAME);
            copyFromAssetsToSdcard(false, "english/" + ENGLISH_SPEECH_FEMALE_MODEL_NAME, mSampleDirPath + "/"
                    + ENGLISH_SPEECH_FEMALE_MODEL_NAME);
            copyFromAssetsToSdcard(false, "english/" + ENGLISH_SPEECH_MALE_MODEL_NAME, mSampleDirPath + "/"
                    + ENGLISH_SPEECH_MALE_MODEL_NAME);
            copyFromAssetsToSdcard(false, "english/" + ENGLISH_TEXT_MODEL_NAME, mSampleDirPath + "/"
                    + ENGLISH_TEXT_MODEL_NAME);
        }

        /**
         * 将工程需要的资源文件拷贝到SD卡中使用（授权文件为临时授权文件，请注册正式授权）
         *
         * @param isCover 是否覆盖已存在的目标文件
         * @param source
         * @param dest
         */
        public void copyFromAssetsToSdcard(boolean isCover, String source, String dest) {
            File file = new File(dest);
            if (isCover || (!isCover && !file.exists())) {
                InputStream is = null;
                FileOutputStream fos = null;
                try {
                    is = getResources().getAssets().open(source);
                    String path = dest;
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

