package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Region extends AppCompatActivity {
    LandmarkAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<LandMark> rList;
    ImageView sortimg;

    // Retrofit
    private static final String urls = "http://10.0.2.2:5000/";

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

        // Recycle API 적용
        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        LandmarkAPI landmarkAPI = RetrofitClient.getLandmarkAPI();

        Call<List<List<LandMark>>> callRegion = landmarkAPI.getRegionLandmarkInfo();
        callRegion.clone().enqueue(new Callback<List<List<LandMark>>>() {
            @Override
            public void onResponse(Call<List<List<LandMark>>> call, Response<List<List<LandMark>>> response) {
                if (response.isSuccessful()) {
                    List<List<LandMark>> landMarkList = response.body();

                    // 경복궁
                    // 교통량
                    String car = landMarkList.get(0).get(0).getLandcar();
                    String bus = landMarkList.get(0).get(0).getBustest();
                    String truck = landMarkList.get(0).get(0).getLandtruck();
                    String person = landMarkList.get(0).get(0).getLandperson();
                    float f_congestion = Float.parseFloat(landMarkList.get(0).get(0).getLandcongestion()) * 100;
                    int congestion = (int) f_congestion;
                    float rating = 0f;

                    // 레이팅 범위
                    rating = getRating(rating, congestion);

                    //********************************************//
                    adapter = new LandmarkAdapter();
                    LinearLayoutManager layoutManager = new LinearLayoutManager(Region.this,LinearLayoutManager.VERTICAL,false);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(layoutManager);

                    rList = new ArrayList<>();
                    //********************************************//

                    // 시간별 혼잡도
                    int[] landmarkCongestion = new int[11]; // 9~18시
                    for (int i = 1; i <= 10; i++) {
                        landmarkCongestion[i] = (int) (Float.parseFloat(landMarkList.get(0).get(i).getLandcongestion()) * 100);
                    }

                    rList.add(new LandMark("경복궁","혼잡도","서울특별시 종로구 사직로 161 (세종로)[3]에 있는 조선시대의 궁궐 중 하나이자 조선의 정궁(법궁)이다"
                            ,R.drawable.gyeongbokgung,rating,
                            String.valueOf(congestion),car,bus,truck,person,
                            String.valueOf(landmarkCongestion[1]),
                            String.valueOf(landmarkCongestion[2]),
                            String.valueOf(landmarkCongestion[3]),
                            String.valueOf(landmarkCongestion[4]),
                            String.valueOf(landmarkCongestion[5]),
                            String.valueOf(landmarkCongestion[6]),
                            String.valueOf(landmarkCongestion[7]),
                            String.valueOf(landmarkCongestion[8]),
                            String.valueOf(landmarkCongestion[9]),
                            String.valueOf(landmarkCongestion[10])));
                    
                    // 광화문
                    // 교통량
                    car = landMarkList.get(1).get(0).getLandcar();
                    bus = landMarkList.get(1).get(0).getBustest();
                    truck = landMarkList.get(1).get(0).getLandtruck();
                    person = landMarkList.get(1).get(0).getLandperson();
                    f_congestion = Float.parseFloat(landMarkList.get(1).get(0).getLandcongestion()) * 100;
                    congestion = (int) f_congestion;

                    // 레이팅 범위
                    rating = getRating(rating, congestion);

                    // 시간별 혼잡도
                    for (int i = 1; i <= 10; i++) {
                        landmarkCongestion[i] = (int) (Float.parseFloat(landMarkList.get(1).get(i).getLandcongestion()) * 100);
                    }

                    rList.add(new LandMark("광화문","혼잡도","광화문(光化門)은 경복궁의 남쪽에 있는 정문이다. ‘임금의 큰 덕(德)이 온 나라를 비춘다’는 의미이다"
                            ,R.drawable.gwanghwamunimg,rating,
                            String.valueOf(congestion),car,bus,truck,person,
                            String.valueOf(landmarkCongestion[1]),
                            String.valueOf(landmarkCongestion[2]),
                            String.valueOf(landmarkCongestion[3]),
                            String.valueOf(landmarkCongestion[4]),
                            String.valueOf(landmarkCongestion[5]),
                            String.valueOf(landmarkCongestion[6]),
                            String.valueOf(landmarkCongestion[7]),
                            String.valueOf(landmarkCongestion[8]),
                            String.valueOf(landmarkCongestion[9]),
                            String.valueOf(landmarkCongestion[10])));
                    
                    // 남산
                    // 교통량
                    car = landMarkList.get(2).get(0).getLandcar();
                    bus = landMarkList.get(2).get(0).getBustest();
                    truck = landMarkList.get(2).get(0).getLandtruck();
                    person = landMarkList.get(2).get(0).getLandperson();
                    f_congestion = Float.parseFloat(landMarkList.get(2).get(0).getLandcongestion()) * 100;
                    congestion = (int) f_congestion;

                    // 레이팅 범위
                    rating = getRating(rating, congestion);

                    // 시간별 혼잡도
                    for (int i = 1; i <= 10; i++) {
                        landmarkCongestion[i] = (int) (Float.parseFloat(landMarkList.get(2).get(i).getLandcongestion()) * 100);
                    }

                    rList.add(new LandMark("남산","혼잡도","남산은 서울특별시 중구와 용산구에 걸쳐 있는 산이다. 높이는 해발 270.85m로서 서울의 중심부에 위치하여 서울의 상징이 되기도 한다."
                            ,R.drawable.namsan,rating,
                            String.valueOf(congestion),car,bus,truck,person,
                            String.valueOf(landmarkCongestion[1]),
                            String.valueOf(landmarkCongestion[2]),
                            String.valueOf(landmarkCongestion[3]),
                            String.valueOf(landmarkCongestion[4]),
                            String.valueOf(landmarkCongestion[5]),
                            String.valueOf(landmarkCongestion[6]),
                            String.valueOf(landmarkCongestion[7]),
                            String.valueOf(landmarkCongestion[8]),
                            String.valueOf(landmarkCongestion[9]),
                            String.valueOf(landmarkCongestion[10])));
                    
                    // 대학로
                    // 교통량
                    car = landMarkList.get(3).get(0).getLandcar();
                    bus = landMarkList.get(3).get(0).getBustest();
                    truck = landMarkList.get(3).get(0).getLandtruck();
                    person = landMarkList.get(3).get(0).getLandperson();
                    f_congestion = Float.parseFloat(landMarkList.get(3).get(0).getLandcongestion()) * 100;
                    congestion = (int) f_congestion;

                    // 레이팅 범위
                    rating = getRating(rating, congestion);

                    // 시간별 혼잡도
                    for (int i = 1; i <= 10; i++) {
                        landmarkCongestion[i] = (int) (Float.parseFloat(landMarkList.get(3).get(i).getLandcongestion()) * 100);
                    }

                    rList.add(new LandMark("대학로","혼잡도","활기 넘치는 대학로에는 야외 뮤지컬 공연과 연극 공연이 열리는 마로니에 공원 등 예술적 분위기가 풍기는 장소와 학생들이 즐겨 찾는 트렌디한 바와 카페가 공존하고 있습니다"
                            ,R.drawable.dehackro,rating,
                            String.valueOf(congestion),car,bus,truck,person,
                            String.valueOf(landmarkCongestion[1]),
                            String.valueOf(landmarkCongestion[2]),
                            String.valueOf(landmarkCongestion[3]),
                            String.valueOf(landmarkCongestion[4]),
                            String.valueOf(landmarkCongestion[5]),
                            String.valueOf(landmarkCongestion[6]),
                            String.valueOf(landmarkCongestion[7]),
                            String.valueOf(landmarkCongestion[8]),
                            String.valueOf(landmarkCongestion[9]),
                            String.valueOf(landmarkCongestion[10])));
                    
                    // 덕수궁
                    // 교통량
                    car = landMarkList.get(4).get(0).getLandcar();
                    bus = landMarkList.get(4).get(0).getBustest();
                    truck = landMarkList.get(4).get(0).getLandtruck();
                    person = landMarkList.get(4).get(0).getLandperson();
                    f_congestion = Float.parseFloat(landMarkList.get(4).get(0).getLandcongestion()) * 100;
                    congestion = (int) f_congestion;

                    // 레이팅 범위
                    rating = getRating(rating, congestion);

                    // 시간별 혼잡도
                    for (int i = 1; i <= 10; i++) {
                        landmarkCongestion[i] = (int) (Float.parseFloat(landMarkList.get(4).get(i).getLandcongestion()) * 100);
                    }

                    rList.add(new LandMark("덕수궁","혼잡도","덕수궁은 서울 중구 정동에 있는 조선과 대한제국의 궁궐로서, 대한민국의 사적 제124호이며 면적은 63,069m²이다."
                            ,R.drawable.ducksugung,rating,
                            String.valueOf(congestion),car,bus,truck,person,
                            String.valueOf(landmarkCongestion[1]),
                            String.valueOf(landmarkCongestion[2]),
                            String.valueOf(landmarkCongestion[3]),
                            String.valueOf(landmarkCongestion[4]),
                            String.valueOf(landmarkCongestion[5]),
                            String.valueOf(landmarkCongestion[6]),
                            String.valueOf(landmarkCongestion[7]),
                            String.valueOf(landmarkCongestion[8]),
                            String.valueOf(landmarkCongestion[9]),
                            String.valueOf(landmarkCongestion[10])));
                    
                    // 동대문
                    // 교통량
                    car = landMarkList.get(5).get(0).getLandcar();
                    bus = landMarkList.get(5).get(0).getBustest();
                    truck = landMarkList.get(5).get(0).getLandtruck();
                    person = landMarkList.get(5).get(0).getLandperson();
                    f_congestion = Float.parseFloat(landMarkList.get(5).get(0).getLandcongestion()) * 100;
                    congestion = (int) f_congestion;

                    // 레이팅 범위
                    rating = getRating(rating, congestion);

                    // 시간별 혼잡도
                    for (int i = 1; i <= 10; i++) {
                        landmarkCongestion[i] = (int) (Float.parseFloat(landMarkList.get(5).get(i).getLandcongestion()) * 100);
                    }

                    rList.add(new LandMark("동대문","혼잡도","흥인지문(興仁之門)은 조선의 수도인 한양의 4대문(大門) 중의 하나로 동쪽의 대문이다"
                            ,R.drawable.dongdemun,rating,
                            String.valueOf(congestion),car,bus,truck,person,
                            String.valueOf(landmarkCongestion[1]),
                            String.valueOf(landmarkCongestion[2]),
                            String.valueOf(landmarkCongestion[3]),
                            String.valueOf(landmarkCongestion[4]),
                            String.valueOf(landmarkCongestion[5]),
                            String.valueOf(landmarkCongestion[6]),
                            String.valueOf(landmarkCongestion[7]),
                            String.valueOf(landmarkCongestion[8]),
                            String.valueOf(landmarkCongestion[9]),
                            String.valueOf(landmarkCongestion[10])));

                    /*// 동묘시장 : 11/27분 18시 이후에 실행가능
                    // 교통량
                    car = landMarkList.get(6).get(0).getLandcar();
                    bus = landMarkList.get(6).get(0).getBustest();
                    truck = landMarkList.get(6).get(0).getLandtruck();
                    person = landMarkList.get(6).get(0).getLandperson();
                    f_congestion = Float.parseFloat(landMarkList.get(6).get(0).getLandcongestion()) * 100;
                    congestion = (int) f_congestion;

                    // 레이팅 범위
                    rating = getRating(rating, congestion);

                    // 시간별 혼잡도
                    for (int i = 1; i <= 10; i++) {
                        landmarkCongestion[i] = (int) (Float.parseFloat(landMarkList.get(6).get(i).getLandcongestion()) * 100);
                    }

                    rList.add(new LandMark("동묘시장","혼잡도","동묘 벼룩시장은 1980년대 말 생겨났으며 명성에 비하면 그 규모가 많이 위축됐지만 지금도 온갖 희귀한 물건들이 모여드는 명소이다"
                            ,R.drawable.dongmyo,rating,
                            String.valueOf(congestion),car,bus,truck,person,
                            String.valueOf(landmarkCongestion[1]),
                            String.valueOf(landmarkCongestion[2]),
                            String.valueOf(landmarkCongestion[3]),
                            String.valueOf(landmarkCongestion[4]),
                            String.valueOf(landmarkCongestion[5]),
                            String.valueOf(landmarkCongestion[6]),
                            String.valueOf(landmarkCongestion[7]),
                            String.valueOf(landmarkCongestion[8]),
                            String.valueOf(landmarkCongestion[9]),
                            String.valueOf(landmarkCongestion[10])));*/

                    // 명동
                    // 교통량
                    car = landMarkList.get(7).get(0).getLandcar();
                    bus = landMarkList.get(7).get(0).getBustest();
                    truck = landMarkList.get(7).get(0).getLandtruck();
                    person = landMarkList.get(7).get(0).getLandperson();
                    f_congestion = Float.parseFloat(landMarkList.get(7).get(0).getLandcongestion()) * 100;
                    congestion = (int) f_congestion;

                    // 레이팅 범위
                    rating = getRating(rating, congestion);

                    // 시간별 혼잡도
                    for (int i = 1; i <= 10; i++) {
                        landmarkCongestion[i] = (int) (Float.parseFloat(landMarkList.get(7).get(i).getLandcongestion()) * 100);
                    }

                    rList.add(new LandMark("명동","혼잡도","번화한 명동은 세계적인 패션 브랜드, 고급 백화점, 한국 브랜드 화장품 매장으로 가득한 쇼핑 지역입니다."
                            ,R.drawable.land2,rating,
                            String.valueOf(congestion),car,bus,truck,person,
                            String.valueOf(landmarkCongestion[1]),
                            String.valueOf(landmarkCongestion[2]),
                            String.valueOf(landmarkCongestion[3]),
                            String.valueOf(landmarkCongestion[4]),
                            String.valueOf(landmarkCongestion[5]),
                            String.valueOf(landmarkCongestion[6]),
                            String.valueOf(landmarkCongestion[7]),
                            String.valueOf(landmarkCongestion[8]),
                            String.valueOf(landmarkCongestion[9]),
                            String.valueOf(landmarkCongestion[10])));

                    // 숭례문
                    // 교통량
                    car = landMarkList.get(8).get(0).getLandcar();
                    bus = landMarkList.get(8).get(0).getBustest();
                    truck = landMarkList.get(8).get(0).getLandtruck();
                    person = landMarkList.get(8).get(0).getLandperson();
                    f_congestion = Float.parseFloat(landMarkList.get(8).get(0).getLandcongestion()) * 100;
                    congestion = (int) f_congestion;

                    // 레이팅 범위
                    rating = getRating(rating, congestion);

                    // 시간별 혼잡도
                    for (int i = 1; i <= 10; i++) {
                        landmarkCongestion[i] = (int) (Float.parseFloat(landMarkList.get(8).get(i).getLandcongestion()) * 100);
                    }

                    rList.add(new LandMark("숭례문","혼잡도","숭례문(崇禮門)은 조선의 수도였던 서울의 4대문(大門) 중의 하나로 남쪽의 대문이다"
                            ,R.drawable.land1,
                            rating,
                            String.valueOf(congestion),car,bus,truck,person,
                            String.valueOf(landmarkCongestion[1]),
                            String.valueOf(landmarkCongestion[2]),
                            String.valueOf(landmarkCongestion[3]),
                            String.valueOf(landmarkCongestion[4]),
                            String.valueOf(landmarkCongestion[5]),
                            String.valueOf(landmarkCongestion[6]),
                            String.valueOf(landmarkCongestion[7]),
                            String.valueOf(landmarkCongestion[8]),
                            String.valueOf(landmarkCongestion[9]),
                            String.valueOf(landmarkCongestion[10])));

                    // 어린이대공원
                    // 교통량
                    car = landMarkList.get(9).get(0).getLandcar();
                    bus = landMarkList.get(9).get(0).getBustest();
                    truck = landMarkList.get(9).get(0).getLandtruck();
                    person = landMarkList.get(9).get(0).getLandperson();
                    f_congestion = Float.parseFloat(landMarkList.get(9).get(0).getLandcongestion()) * 100;
                    congestion = (int) f_congestion;

                    // 레이팅 범위
                    rating = getRating(rating, congestion);

                    // 시간별 혼잡도
                    for (int i = 1; i <= 10; i++) {
                        landmarkCongestion[i] = (int) (Float.parseFloat(landMarkList.get(9).get(i).getLandcongestion()) * 100);
                    }

                    rList.add(new LandMark("어린이대공원","혼잡도","시민여러분이 함게 가꾸고 즐기는 휴식공간이자 동식물이 행복하게 공존하는 생태공원입니다"
                            ,R.drawable.children,rating,
                            String.valueOf(congestion),car,bus,truck,person,
                            String.valueOf(landmarkCongestion[1]),
                            String.valueOf(landmarkCongestion[2]),
                            String.valueOf(landmarkCongestion[3]),
                            String.valueOf(landmarkCongestion[4]),
                            String.valueOf(landmarkCongestion[5]),
                            String.valueOf(landmarkCongestion[6]),
                            String.valueOf(landmarkCongestion[7]),
                            String.valueOf(landmarkCongestion[8]),
                            String.valueOf(landmarkCongestion[9]),
                            String.valueOf(landmarkCongestion[10])));

                    // 올림픽공원
                    // 교통량
                    car = landMarkList.get(10).get(0).getLandcar();
                    bus = landMarkList.get(10).get(0).getBustest();
                    truck = landMarkList.get(10).get(0).getLandtruck();
                    person = landMarkList.get(10).get(0).getLandperson();
                    f_congestion = Float.parseFloat(landMarkList.get(10).get(0).getLandcongestion()) * 100;
                    congestion = (int) f_congestion;

                    // 레이팅 범위
                    rating = getRating(rating, congestion);

                    // 시간별 혼잡도
                    for (int i = 1; i <= 10; i++) {
                        landmarkCongestion[i] = (int) (Float.parseFloat(landMarkList.get(10).get(i).getLandcongestion()) * 100);
                    }

                    rList.add(new LandMark("올림픽공원","혼잡도","1988년 서울 올림픽을 위해 건설되었으며, 현재는 일반적인 종합 공원으로 이용되고 있다"
                            ,R.drawable.oylimpic,rating,
                            String.valueOf(congestion),car,bus,truck,person,
                            String.valueOf(landmarkCongestion[1]),
                            String.valueOf(landmarkCongestion[2]),
                            String.valueOf(landmarkCongestion[3]),
                            String.valueOf(landmarkCongestion[4]),
                            String.valueOf(landmarkCongestion[5]),
                            String.valueOf(landmarkCongestion[6]),
                            String.valueOf(landmarkCongestion[7]),
                            String.valueOf(landmarkCongestion[8]),
                            String.valueOf(landmarkCongestion[9]),
                            String.valueOf(landmarkCongestion[10])));

                    // 롯데타워
                    // 교통량
                    car = landMarkList.get(11).get(0).getLandcar();
                    bus = landMarkList.get(11).get(0).getBustest();
                    truck = landMarkList.get(11).get(0).getLandtruck();
                    person = landMarkList.get(11).get(0).getLandperson();
                    f_congestion = Float.parseFloat(landMarkList.get(11).get(0).getLandcongestion()) * 100;
                    congestion = (int) f_congestion;

                    // 레이팅 범위
                    rating = getRating(rating, congestion);

                    // 시간별 혼잡도
                    for (int i = 1; i <= 10; i++) {
                        landmarkCongestion[i] = (int) (Float.parseFloat(landMarkList.get(11).get(i).getLandcongestion()) * 100);
                    }

                    rList.add(new LandMark("롯데타워","혼잡도","지상 123층, 높이 554.5m로 2022년 기준 대한민국 최고층 건물이자 세계에서 5번째로 높은 건물이자 OECD 중에서 가장 높은 건물이다"
                            ,R.drawable.lottetower,
                            rating,
                            String.valueOf(congestion),car,bus,truck,person,
                            String.valueOf(landmarkCongestion[1]),
                            String.valueOf(landmarkCongestion[2]),
                            String.valueOf(landmarkCongestion[3]),
                            String.valueOf(landmarkCongestion[4]),
                            String.valueOf(landmarkCongestion[5]),
                            String.valueOf(landmarkCongestion[6]),
                            String.valueOf(landmarkCongestion[7]),
                            String.valueOf(landmarkCongestion[8]),
                            String.valueOf(landmarkCongestion[9]),
                            String.valueOf(landmarkCongestion[10])));

                    // 창덕궁
                    // 교통량
                    car = landMarkList.get(12).get(0).getLandcar();
                    bus = landMarkList.get(12).get(0).getBustest();
                    truck = landMarkList.get(12).get(0).getLandtruck();
                    person = landMarkList.get(12).get(0).getLandperson();
                    f_congestion = Float.parseFloat(landMarkList.get(12).get(0).getLandcongestion()) * 100;
                    congestion = (int) f_congestion;

                    // 레이팅 범위
                    rating = getRating(rating, congestion);

                    // 시간별 혼잡도
                    for (int i = 1; i <= 10; i++) {
                        landmarkCongestion[i] = (int) (Float.parseFloat(landMarkList.get(12).get(i).getLandcongestion()) * 100);
                    }

                    rList.add(new LandMark("창덕궁","혼잡도"," 대한제국시대의 궁궐. 1997년 조선 5대 궁궐 중 유일하게 유네스코 세계유산으로 등재되었다"
                            ,R.drawable.changduck,rating,
                            String.valueOf(congestion),car,bus,truck,person,
                            String.valueOf(landmarkCongestion[1]),
                            String.valueOf(landmarkCongestion[2]),
                            String.valueOf(landmarkCongestion[3]),
                            String.valueOf(landmarkCongestion[4]),
                            String.valueOf(landmarkCongestion[5]),
                            String.valueOf(landmarkCongestion[6]),
                            String.valueOf(landmarkCongestion[7]),
                            String.valueOf(landmarkCongestion[8]),
                            String.valueOf(landmarkCongestion[9]),
                            String.valueOf(landmarkCongestion[10])));

                    // DDP
                    // 교통량
                    car = landMarkList.get(13).get(0).getLandcar();
                    bus = landMarkList.get(13).get(0).getBustest();
                    truck = landMarkList.get(13).get(0).getLandtruck();
                    person = landMarkList.get(13).get(0).getLandperson();
                    f_congestion = Float.parseFloat(landMarkList.get(13).get(0).getLandcongestion()) * 100;
                    congestion = (int) f_congestion;

                    // 레이팅 범위
                    rating = getRating(rating, congestion);

                    // 시간별 혼잡도
                    for (int i = 1; i <= 10; i++) {
                        landmarkCongestion[i] = (int) (Float.parseFloat(landMarkList.get(13).get(i).getLandcongestion()) * 100);
                    }
                    rList.add(new LandMark("DDP","혼잡도","서울특별시 중구의 전시장 및 쇼핑몰. 영국의 건축가 자하 하디드가 설계했다. 홈페이지에 따르면 세계 최대 규모의 3차원 비정형 건축물이라고 한다"
                            ,R.drawable.land3,rating,
                            String.valueOf(congestion),car,bus,truck,person,
                            String.valueOf(landmarkCongestion[1]),
                            String.valueOf(landmarkCongestion[2]),
                            String.valueOf(landmarkCongestion[3]),
                            String.valueOf(landmarkCongestion[4]),
                            String.valueOf(landmarkCongestion[5]),
                            String.valueOf(landmarkCongestion[6]),
                            String.valueOf(landmarkCongestion[7]),
                            String.valueOf(landmarkCongestion[8]),
                            String.valueOf(landmarkCongestion[9]),
                            String.valueOf(landmarkCongestion[10])));

                    adapter.setItems(rList);

                    //정렬 부분 별표 수에 따라 정렬 할 수 있음
                    sortimg = findViewById(R.id.sortimg);
                    sortimg.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Comparator<LandMark> noAsc = new Comparator<LandMark>() {
                                @Override
                                public int compare(LandMark item1, LandMark item2) {
                                    int ret ;

                                    if (item1.getRating() < item2.getRating())
                                        ret = -1 ;
                                    else if (item1.getRating() == item2.getRating())
                                        ret = 0 ;
                                    else
                                        ret = 1 ;

                                    return ret ;
                                }
                            };
                            Collections.sort(rList, noAsc) ;
                            adapter.notifyDataSetChanged() ;
                        }
                    });
                    
                }
            }

            @Override
            public void onFailure(Call<List<List<LandMark>>> call, Throwable t) {
                Log.e("retrofit 연동", "실패");
                t.printStackTrace();
            }
        });
    }
    private static float getRating(float rating, int congestion){
        if (0 <= congestion && congestion < 10){
            rating = 1f;
        } else if (10 <= congestion && congestion < 30) {
            rating = 2f;
        } else if (30 <= congestion && congestion < 50) {
            rating = 3f;
        } else if (50 <= congestion && congestion < 75) {
            rating = 4f;
        } else{
            rating = 5f;
        }
        return rating;
    }
}