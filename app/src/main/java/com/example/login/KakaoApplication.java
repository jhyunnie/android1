package com.example.login;

import android.app.Application;

import com.example.myapplication.R;
import com.kakao.sdk.common.KakaoSdk;

public class KakaoApplication extends Application {
    private static KakaoApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        // 네이티브 앱 키로 초기화
        KakaoSdk.init(this, getString(R.string.kakao_app_key));
    }
}
