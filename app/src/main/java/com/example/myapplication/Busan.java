package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Busan extends AppCompatActivity {
    LandmarkAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<LandMark> rList;
    ImageView sortimg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busan);

        ImageView backbutton = (ImageView)findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(intent);
            }
        });

        Button regionbtn1 = (Button) findViewById(R.id.regionbtn1);
        regionbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Region.class);
                startActivity(intent);
            }
        });

        //리싸이클뷰
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new LandmarkAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        rList = new ArrayList<>();
        rList.add(new LandMark("불국사","혼잡도","경주 불국사 대웅전은 경상북도 경주시, 불국사의 대웅전으로 조선시대의 건축물이다"
                ,R.drawable.bulkuksa,3f,"50","20","15","5","6",
                "10","20","30","40","30","60","70","40","20","10"));
        rList.add(new LandMark("동궁과월지","혼잡도","동궁과 월지는 경상북도 경주시 인왕동에 위치한 경주 월성의 별궁 터이다"
                ,R.drawable.dongung,3f,"50","20","15","5","6",
                "10","20","30","40","30","60","70","40","20","10"));
        rList.add(new LandMark("첨성대","혼잡도","첨성대는 경상북도 경주시 반월성 동북쪽에 위치한 신라 중기의 석조 건축물로, 선덕여왕 때에 세워진 세계에서 현존하는 가장 오래된 천문대 중 하나이다. "
                ,R.drawable.chumsung,5f,"50","20","15","5","6",
                "10","20","30","40","30","60","70","40","20","10"));
        rList.add(new LandMark("대왕암공원","혼잡도","대왕암공원은 울산광역시 동구 일산동 해안에 있는 공원이다"
                ,R.drawable.deanmwang,5f,"50","20","15","5","6",
                "10","20","30","40","30","60","70","40","20","10"));
        rList.add(new LandMark("석굴암","혼잡도","석굴암은 대한민국 경상북도 경주시의 토함산 중턱에 있는 석굴로서 국보 24호로 지정되어 있다"
                ,R.drawable.suckgul,5f,"50","20","15","5","6",
                "10","20","30","40","30","60","70","40","20","10"));
        rList.add(new LandMark("해동용궁사","혼잡도","해동용궁사는 부산광역시 기장군 기장읍 시랑리에 있는 절이다"
                ,R.drawable.heagung,3f,"50","20","15","5","6",
                "10","20","30","40","30","60","70","40","20","10"));

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