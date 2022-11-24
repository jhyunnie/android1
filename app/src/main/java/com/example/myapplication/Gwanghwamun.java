package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
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
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Gwanghwamun extends AppCompatActivity {
    private BarChart barChart;
    TextView detail_name,detail_name2,detail_story;
    String name, createdBy, story;
    int image;
    float rating;
    PieChart pieChart;

    Call<List<LandmarkCongest>> landmarkCall;
    private static final String urls = "http://10.0.2.2:5000/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gwanghwamun);

        //리싸이클러뷰 불러오기
        detail_name = findViewById(R.id.detail_name);
        detail_name2 = findViewById(R.id.detail_name2);
        detail_story = findViewById(R.id.detail_story);

        Intent intent = getIntent();

        name = intent.getExtras().getString("name");
        createdBy = intent.getExtras().getString("createdBy");
        story = intent.getExtras().getString("story");

        detail_name.setText(name);
        detail_name2.setText(name);
        detail_story.setText(story);


        //혼잡도 그래프 : congestion 활용
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

        //교통 데이터 // car, bus, person, truck 활용
        pieChart = (PieChart)findViewById(R.id.piechart);

        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        LandmarkAPI landmarkAPI = RetrofitClient.getLandmarkAPI();

        landmarkCall = landmarkAPI.getLandmarkInfo("yongsan");
        landmarkCall.clone().enqueue(new Callback<List<LandmarkCongest>>() {
            @Override
            public void onResponse(Call<List<LandmarkCongest>> call, Response<List<LandmarkCongest>> response) {
                if (response.isSuccessful()){
                    List<LandmarkCongest> landmarkList = response.body();
                    String TAG = "랜드마크 데이터 불러오기 실행";

                    pieChart.setUsePercentValues(true);
                    pieChart.getDescription().setEnabled(false);
                    pieChart.setExtraOffsets(5,10,5,5);

                    pieChart.setDragDecelerationFrictionCoef(0.95f);

                    pieChart.setDrawHoleEnabled(false);
                    pieChart.setHoleColor(Color.WHITE);
                    pieChart.setTransparentCircleRadius(61f);

                    ArrayList yValues = new ArrayList();

                    // 15f, 50f, 30f, 15f
                    yValues.add(new PieEntry(Float.parseFloat(landmarkList.get(0).getPerson()),"Person"));
                    yValues.add(new PieEntry(Float.parseFloat(landmarkList.get(0).getCar()),"Car"));
                    yValues.add(new PieEntry(Float.parseFloat(landmarkList.get(0).getBus()),"Bus"));
                    yValues.add(new PieEntry(Float.parseFloat(landmarkList.get(0).getTruck()),"Truck"));

                    PieDataSet dataSet = new PieDataSet(yValues,"Traffic");
                    dataSet.setSliceSpace(3f);
                    dataSet.setSelectionShift(5f);
                    dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

                    PieData data = new PieData((dataSet));
                    data.setValueTextSize(10f);
                    data.setValueTextColor(Color.BLACK);

                    pieChart.setData(data);

                    Log.d(TAG, "정상출력");
                }
            }

            @Override
            public void onFailure(Call<List<LandmarkCongest>> call, Throwable t) {
                Log.e("retrofit 연동", "실패");
                t.printStackTrace();
            }
        });



    }
}