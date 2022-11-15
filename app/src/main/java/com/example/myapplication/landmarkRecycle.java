package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class landmarkRecycle extends AppCompatActivity {
    LandmarkAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landmark_recycle);

        //뒤로가기 버튼
        ImageView backbutton = (ImageView)findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(intent);
            }
        });

        TextView mapbutton = (TextView)findViewById(R.id.mapbtn);
        mapbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),NaverMap.class);
                startActivity(intent);
            }
        });

        //리싸이클뷰
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(layoutManager);
        adapter = new LandmarkAdapter();

        adapter.addItem(new LandMark("광화문","혼잡도","광화문(光化門)은 경복궁의 남쪽에 있는 정문이다. ‘임금의 큰 덕(德)이 온 나라를 비춘다’는 의미이다"
                ,R.drawable.land5,3f));
        adapter.addItem(new LandMark("숭례문","혼잡도","숭례문(崇禮門)은 조선의 수도였던 서울의 4대문(大門) 중의 하나로 남쪽의 대문이다"
                ,R.drawable.land1,3f));
        adapter.addItem(new LandMark("명동","혼잡도","번화한 명동은 세계적인 패션 브랜드, 고급 백화점, 한국 브랜드 화장품 매장으로 가득한 쇼핑 지역입니다."
                ,R.drawable.land2,4f));
        adapter.addItem(new LandMark("DDP","혼잡도","대한민국 서울특별시 중구에 위치한 복합 문화 공간이다"
                ,R.drawable.land3,5f));
        adapter.addItem(new LandMark("어린이대공원","혼잡도","시민여러분이 함게 가꾸고 즐기는 휴식공간이자 동식물이 행복하게 공존하는 생태공원입니다"
                ,R.drawable.land4,5f));

        recyclerView.setAdapter(adapter);
    }
}