package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Region extends AppCompatActivity {
    LandmarkAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region);

        ImageView backbutton = (ImageView)findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(intent);
            }
        });

        Button regionbtn2 = (Button) findViewById(R.id.regionbtn2);
        regionbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Busan.class);
                startActivity(intent);
            }
        });

        //리싸이클뷰
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(layoutManager);
        adapter = new LandmarkAdapter();

        adapter.addItem(new LandMark("경복궁","혼잡도","서울특별시 종로구 사직로 161 (세종로)[3]에 있는 조선시대의 궁궐 중 하나이자 조선의 정궁(법궁)이다"
                ,R.drawable.gyeongbokgung,3f));
        adapter.addItem(new LandMark("광화문","혼잡도","광화문(光化門)은 경복궁의 남쪽에 있는 정문이다. ‘임금의 큰 덕(德)이 온 나라를 비춘다’는 의미이다"
                ,R.drawable.gwanghwamunimg,3f));
        adapter.addItem(new LandMark("남산","혼잡도","남산은 서울특별시 중구와 용산구에 걸쳐 있는 산이다. 높이는 해발 270.85m로서 서울의 중심부에 위치하여 서울의 상징이 되기도 한다."
                ,R.drawable.namsan,5f));
        adapter.addItem(new LandMark("대학로","혼잡도","활기 넘치는 대학로에는 야외 뮤지컬 공연과 연극 공연이 열리는 마로니에 공원 등 예술적 분위기가 풍기는 장소와 학생들이 즐겨 찾는 트렌디한 바와 카페가 공존하고 있습니다"
                ,R.drawable.dehackro,5f));
        adapter.addItem(new LandMark("덕수궁","혼잡도","덕수궁은 서울 중구 정동에 있는 조선과 대한제국의 궁궐로서, 대한민국의 사적 제124호이며 면적은 63,069m²이다."
                ,R.drawable.ducksugung,5f));
        adapter.addItem(new LandMark("동대문","혼잡도","흥인지문(興仁之門)은 조선의 수도인 한양의 4대문(大門) 중의 하나로 동쪽의 대문이다"
                ,R.drawable.dongdemun,3f));
        adapter.addItem(new LandMark("동묘시장","혼잡도","동묘 벼룩시장은 1980년대 말 생겨났으며 명성에 비하면 그 규모가 많이 위축됐지만 지금도 온갖 희귀한 물건들이 모여드는 명소이다"
                ,R.drawable.dongmyo,4f));
        adapter.addItem(new LandMark("명동","혼잡도","번화한 명동은 세계적인 패션 브랜드, 고급 백화점, 한국 브랜드 화장품 매장으로 가득한 쇼핑 지역입니다."
                ,R.drawable.land2,4f));
        adapter.addItem(new LandMark("숭례문","혼잡도","숭례문(崇禮門)은 조선의 수도였던 서울의 4대문(大門) 중의 하나로 남쪽의 대문이다"
                ,R.drawable.land1,3f));
        adapter.addItem(new LandMark("어린이대공원","혼잡도","시민여러분이 함게 가꾸고 즐기는 휴식공간이자 동식물이 행복하게 공존하는 생태공원입니다"
                ,R.drawable.land4,5f));
        adapter.addItem(new LandMark("올림픽공원","혼잡도","1988년 서울 올림픽을 위해 건설되었으며, 현재는 일반적인 종합 공원으로 이용되고 있다"
                ,R.drawable.oylimpic,3f));
        adapter.addItem(new LandMark("롯데타워","혼잡도","지상 123층, 높이 554.5m로 2022년 기준 대한민국 최고층 건물이자 세계에서 5번째로 높은 건물이자 OECD 중에서 가장 높은 건물이다"
                ,R.drawable.lottetower,5f));
        adapter.addItem(new LandMark("창덕궁","혼잡도"," 대한제국시대의 궁궐. 1997년 조선 5대 궁궐 중 유일하게 유네스코 세계유산으로 등재되었다"
                ,R.drawable.changduck,5f));
        adapter.addItem(new LandMark("DDP","혼잡도","서울특별시 중구의 전시장 및 쇼핑몰. 영국의 건축가 자하 하디드가 설계했다. 홈페이지에 따르면 세계 최대 규모의 3차원 비정형 건축물이라고 한다"
                ,R.drawable.land3,5f));
        recyclerView.setAdapter(adapter);
    }
}