package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Gwanghwamun extends AppCompatActivity {
    private BarChart barChart;
    TextView detail_name,detail_name2,detail_story ,nowcongestion;
    ImageView detail_img;
    String name, createdBy, story;
    String congestion, car, bus, truck, person,bustest;
    int numcon, numcar, numbus, numtruck, numperson;
    int image;
    float rating;
    PieChart pieChart;

    String con9,con10,con11,con12,con13,con14,con15,con16,con17,con18;
    int numcon9 ,numcon10,numcon11,numcon12,numcon13,numcon14,numcon15,numcon16,numcon17,numcon18;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gwanghwamun);

        //뒤로가기 버튼
        ImageView backbutton = (ImageView)findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //리싸이클러뷰 불러오기
        detail_name = findViewById(R.id.detail_name);
        detail_name2 = findViewById(R.id.detail_name2);
        detail_story = findViewById(R.id.detail_story);
        detail_img = findViewById(R.id.detail_img);
        nowcongestion = findViewById(R.id.nowcongestion);

        //값 받아오기
        Intent intent = getIntent();

        name = intent.getExtras().getString("name");
        createdBy = intent.getExtras().getString("createdBy");
        story = intent.getExtras().getString("story");
        image = intent.getExtras().getInt("image");
        congestion = intent.getExtras().getString("landcongestion");
        car = intent.getExtras().getString("landcar");
        bus = intent.getExtras().getString("landbus");
        truck = intent.getExtras().getString("landtruck");
        person = intent.getExtras().getString("landperson");
        bustest = intent.getExtras().getString("bustest");

        //시간별 혼잡도
        con9 = intent.getExtras().getString("conges9");
        con10 = intent.getExtras().getString("conges10");
        con11 = intent.getExtras().getString("conges11");
        con12 = intent.getExtras().getString("conges12");
        con13 = intent.getExtras().getString("conges13");
        con14 = intent.getExtras().getString("conges14");
        con15 = intent.getExtras().getString("conges15");
        con16 = intent.getExtras().getString("conges16");
        con17 = intent.getExtras().getString("conges17");
        con18 = intent.getExtras().getString("conges18");


        detail_name.setText(name);
        detail_name2.setText(name);
        detail_story.setText(story);
        detail_img.setImageResource(image);
        nowcongestion.setText(congestion);

        //정수로 변환
        numcon = Integer.parseInt(congestion);
        numcar = Integer.parseInt(car);
        numtruck = Integer.parseInt(truck);
        numperson = Integer.parseInt(person);
        numbus = Integer.parseInt(bustest);
        
        numcon9 = Integer.parseInt(con9);
        numcon10 = Integer.parseInt(con10);
        numcon11 = Integer.parseInt(con11);
        numcon12 = Integer.parseInt(con12);
        numcon13 = Integer.parseInt(con13);
        numcon14 = Integer.parseInt(con14);
        numcon15 = Integer.parseInt(con15);
        numcon16 = Integer.parseInt(con16);
        numcon17 = Integer.parseInt(con17);
        numcon18 = Integer.parseInt(con18);

        //혼잡도 그래프
        barChart =findViewById(R.id.barChart);
        ArrayList<BarEntry> congestion = new ArrayList<>();

        congestion.add(new BarEntry(9,numcon9));
        congestion.add(new BarEntry(10,numcon10));
        congestion.add(new BarEntry(11,numcon11));
        congestion.add(new BarEntry(12,numcon12));
        congestion.add(new BarEntry(13,numcon13));
        congestion.add(new BarEntry(14,numcon14));
        congestion.add(new BarEntry(15,numcon15));
        congestion.add(new BarEntry(16,numcon16));
        congestion.add(new BarEntry(17,numcon17));
        congestion.add(new BarEntry(18,numcon18));

        BarDataSet barDataSet = new BarDataSet(congestion,"혼잡도");
        barDataSet.setColor(ColorTemplate.MATERIAL_COLORS[0]);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(13f);

        BarData barData = new BarData(barDataSet);
        barChart.setFitBars(true);
        barChart.setData(barData);


        //교통 데이터
        pieChart = (PieChart)findViewById(R.id.piechart);

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5,10,5,5);

        pieChart.setDragDecelerationFrictionCoef(0.95f);

        pieChart.setDrawHoleEnabled(false);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(61f);

        ArrayList yValues = new ArrayList();

        yValues.add(new PieEntry(numcar,"Car"));
        yValues.add(new PieEntry(numbus,"Bus"));
        yValues.add(new PieEntry(numtruck,"Truck"));
        yValues.add(new PieEntry(numperson,"Person"));

        PieDataSet dataSet = new PieDataSet(yValues,"Traffic");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData data = new PieData((dataSet));
        data.setValueTextSize(15f);
        data.setValueTextColor(Color.BLACK);

        pieChart.setData(data);
    }
}