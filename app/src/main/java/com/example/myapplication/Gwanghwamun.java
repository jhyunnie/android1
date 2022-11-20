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
    TextView detail_name,detail_name2,detail_story;
    ImageView detail_img;
    String name, createdBy, story;
    int image;
    float rating;
    PieChart pieChart;


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

        Intent intent = getIntent();

        name = intent.getExtras().getString("name");
        createdBy = intent.getExtras().getString("createdBy");
        story = intent.getExtras().getString("story");
        image = intent.getExtras().getInt("image");

        detail_name.setText(name);
        detail_name2.setText(name);
        detail_story.setText(story);
        detail_img.setImageResource(image);


        //혼잡도 그래프
        barChart =findViewById(R.id.barChart);
        ArrayList<BarEntry> congestion = new ArrayList<>();

        congestion.add(new BarEntry(12,10));
        congestion.add(new BarEntry(13,50));
        congestion.add(new BarEntry(14,60));
        congestion.add(new BarEntry(15,20));
        congestion.add(new BarEntry(16,40));
        congestion.add(new BarEntry(17,30));
        congestion.add(new BarEntry(18,10));

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

        yValues.add(new PieEntry(15f,"Person"));
        yValues.add(new PieEntry(50f,"Car"));
        yValues.add(new PieEntry(30f,"Bus"));
        yValues.add(new PieEntry(15f,"Truck"));

        PieDataSet dataSet = new PieDataSet(yValues,"Traffic");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData data = new PieData((dataSet));
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.BLACK);

        pieChart.setData(data);
    }
}