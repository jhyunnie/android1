package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kakao.sdk.user.UserApiClient;

public class MypageActivity extends AppCompatActivity {
    private TextView textView18;
    private TextView textView20;
    private ImageView imageView4;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        String TAG = "마이페이지 정보";

        // 주소 가져오기
        textView18 = findViewById(R.id.textView18);
        textView20 = findViewById(R.id.textView20);
        imageView4 = (ImageView) findViewById(R.id.imageView4);

        /*
        UserApiClient.getInstance().me((user, meError) ->{
            System.out.println("마이페이지 이동");
            if (meError != null) {
                Log.e(TAG, "사용자 정보 요청 실패", meError);
            }
            else {
                {
                    Log.i(TAG,
                            "\n닉네임: "+user.getKakaoAccount().getProfile().getNickname() +
                                    "\n이미지: "+user.getKakaoAccount().getProfile().getProfileImageUrl() +
                                    "\n이메일 : " + user.getKakaoAccount().getEmail());

                    textView18.setText(user.getKakaoAccount().getProfile().getNickname());
                    textView20.setText(user.getKakaoAccount().getEmail());
                    String imageUrl = user.getKakaoAccount().getProfile().getProfileImageUrl();
                    //Glide.with(this).load(imageUrl).into(imageView4);
                    Glide.with(this)
                            .load(imageUrl) // 불러올 이미지 url
                            .circleCrop() // 동그랗게 자르기
                            .into(imageView4); // 이미지를 넣을 뷰
                }
            }
            return null;
        });
        */
        ImageView homebtn = (ImageView)findViewById(R.id.imageView15);
        ImageView myregion2 = (ImageView)findViewById(R.id.imageView18);
        ImageView myattraction2 = (ImageView)findViewById(R.id.imageView16);
        ImageView myboard2 = (ImageView)findViewById(R.id.imageView17);

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(intent);
            }
        });
        myregion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Region.class);
                startActivity(intent);
            }
        });
        myattraction2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Attractions.class);
                startActivity(intent);
            }
        });
        myboard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Board.class);
                startActivity(intent);
            }
        });


    }
}