package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.Account;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button kakaobtn;
    private Button naverbtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //-------------------------KAKAO-------------------------------
        
        // 카카오 로그인 해시값 보기
        Log.d("GET_KEYHASH", getKeyHash());
        
        // 카카오 로그인 버튼
        kakaobtn = (Button) findViewById(R.id.button);
        // 로그인 버튼 클릭시
        kakaobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 카카오톡 설치시 카카오톡 로그인으로
                if(UserApiClient.getInstance().isKakaoTalkLoginAvailable(MainActivity.this)) {
                    login();
                }
                // 카카오톡 미설치시 카카오 로그인 창화면으로 이동
                else {
                    accountLogin();
                }

            }

        });

        //-------------------------KAKAO-------------------------------
        //-------------------------NAVER-------------------------------


        // 네이버 로그인 버튼
        naverbtn = (Button) findViewById(R.id.button2);
        
        naverbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LandmarkList.class);
                startActivity(intent);
            }
        });
        //-------------------------NAVER-------------------------------
    }

    //-------------------------KAKAO-----------------------------------
    private void accountLogin() {
        String TAG = "accountLogin()";
        UserApiClient.getInstance().loginWithKakaoAccount(MainActivity.this,(oAuthToken, error) -> {
            if (error != null) {
                Log.e(TAG, "로그인 실패", error);
            } else if (oAuthToken != null) {
                Log.i(TAG, "로그인 성공(토큰) : " + oAuthToken.getAccessToken());
                getUserInfo();
            }
            return null;
        });

    }

    private void login() {
        String TAG = "login()";
        UserApiClient.getInstance().loginWithKakaoTalk(MainActivity.this,(oAuthToken, error) -> {
            if (error != null) {
                Log.e(TAG, "로그인 실패", error);
            } else if (oAuthToken != null) {
                Log.i(TAG, "로그인 성공(토큰) : " + oAuthToken.getAccessToken());
                getUserInfo();
            }
            return null;
        });
    }

    private void getUserInfo() {
        String TAG = "getUserInfo()";
        UserApiClient.getInstance().me((user, meError) -> {

            if (meError != null) {
                Log.e(TAG, "사용자 정보 요청 실패", meError);
            } else {
                System.out.println("로그인 완료");
                Log.i(TAG, user.toString()); // 사용자 정보 객체로 표시
                {// 구체적 정보
                    Log.i(TAG, "사용자 정보 요청 성공" +
                            "\n회원번호: "+user.getId() +
                            "\n닉네임: "+user.getKakaoAccount().getProfile().getNickname() +
                            "\n이미지: "+user.getKakaoAccount().getProfile().getProfileImageUrl() +
                            "\n이메일: "+user.getKakaoAccount().getEmail());
                }
                Account user1 = user.getKakaoAccount();
                System.out.println("사용자 계정" + user1);
                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(intent);
            }
            return null;
        });
    }

    // 카카오 UI를 가져오는 메소드
    private void updateKakaoLoginUi(){
        UserApiClient.getInstance().me(new Function2<com.kakao.sdk.user.model.User, Throwable, Unit>() {
            @Override
            public Unit invoke(com.kakao.sdk.user.model.User user, Throwable throwable) {
                // 로그인이 되어있으면
                if (user!=null){

                    // 유저의 아이디
                    Log.d(TAG,"invoke: id" + user.getId());
                    // 유저의 어카운트정보에 이메일
                    Log.d(TAG,"invoke: nickname" + user.getKakaoAccount().getEmail());
                    // 유저의 어카운트 정보의 프로파일에 닉네임
                    Log.d(TAG,"invoke: email" + user.getKakaoAccount().getProfile().getNickname());
                    // 유저의 어카운트 정보의 프로파일
                    //Log.d(TAG,"invoke: profile" + user.getKakaoAccount().getProfile());
                    // 유저의 어카운트 파일의 성별
                    Log.d(TAG,"invoke: gerder" + user.getKakaoAccount().getGender());
                    // 유저의 어카운트 정보에 나이
                    Log.d(TAG,"invoke: age" + user.getKakaoAccount().getAgeRange());

                    // 로그인이 정상적으로 이루어졌을때

                    /*nickName.setText(user.getKakaoAccount().getProfile().getNickname());

                    Glide.with(profileImage).load(user.getKakaoAccount().
                            getProfile().getProfileImageUrl()).circleCrop().into(profileImage);
                    kakaobtn.setVisibility(View.GONE);
                    kakaobtn.setVisibility(View.VISIBLE);
                */
                }
                if (throwable != null) {
                    // 로그인이 되어 있지 않다면 위와 반대로
                    /*nickName.setText(null);
                    profileImage.setImageBitmap(null);
                    kakaobtn.setVisibility(View.VISIBLE);
                    kakaobtn.setVisibility(View.GONE);*/

                    Log.w(TAG, "invoke: " + throwable.getLocalizedMessage());
                }
                return null;
            }
        });
    }

    // 카카오 해시값 출력 함수
    public String getKeyHash(){
        try{
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            if(packageInfo == null) return null;
            for(Signature signature: packageInfo.signatures){
                try{
                    MessageDigest md = MessageDigest.getInstance("SHA");
                    md.update(signature.toByteArray());
                    return android.util.Base64.encodeToString(md.digest(), Base64.NO_WRAP);
                }catch (NoSuchAlgorithmException e){
                    Log.w("getKeyHash", "Unable to get MessageDigest. signature="+signature, e);
                }
            }
        }catch(PackageManager.NameNotFoundException e){
            Log.w("getPackageInfo", "Unable to getPackageInfo");
        }
        return null;
    }

}
