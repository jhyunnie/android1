package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LandmarkList extends AppCompatActivity {
    private Button button;
    private TextView carText;
    private TextView personText;
    private TextView textView3;
    private TextView textView4;
    //Call<Landmark> landmarkCall;
    Call<List<LandmarkCongest>> landmarkCall;

    private static final String urls = "http://10.0.2.2:5000/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landmark_list);

        button = (Button) findViewById(R.id.button);
        carText = findViewById(R.id.carText);
        personText = findViewById(R.id.personText);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);

        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        LandmarkAPI landmarkAPI = RetrofitClient.getLandmarkAPI();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String TAG = "랜드마크 데이터 불러오기 실행";
                landmarkCall = landmarkAPI.getLandmarkInfo("yongsan");
                landmarkCall.clone().enqueue(new Callback<List<LandmarkCongest>>() {
                    @Override
                    public void onResponse(Call<List<LandmarkCongest>> call, Response<List<LandmarkCongest>> response) {
                        if (response.isSuccessful()){
                            List<LandmarkCongest> landmarkList = response.body();
                            carText.setText("자동차 : " + landmarkList.get(0).getCar());
                            personText.setText("사람 : " + landmarkList.get(0).getPerson());
                            textView3.setText("날짜 : " + landmarkList.get(0).getDate());
                            textView4.setText("트럭 : " + landmarkList.get(0).getTruck());
                            Log.d(TAG, "정상출력");
                        }
                    }

                    @Override
                    public void onFailure(Call<List<LandmarkCongest>> call, Throwable t) {
                        Log.e("retrofit 연동", "실패");
                        t.printStackTrace();
                    }
                });
                /*landmarkCall.clone().enqueue(new Callback<Landmark>() {
                    @Override
                    public void onResponse(Call<Landmark> call, Response<Landmark> response) {
                        if (response.isSuccessful()){
                            Landmark landmark = response.body();
                            carText.setText("자동차 : " + landmark.getCar());
                            personText.setText("사람 : " + landmark.getPerson());
                            textView3.setText("날짜 : " + landmark.getDate());
                            textView4.setText("트럭 : " + landmark.getTruck());
                            Log.d(TAG, "정상출력");
                        }
                    }

                    @Override
                    public void onFailure(Call<Landmark> call, Throwable t) {
                        Log.e("retrofit 연동", "실패");
                        t.printStackTrace();
                    }
                });*/
            }
        });

        /*RetrofitClient retrofitClient = RetrofitClient.getInstance();
        LandmarkAPI landmarkAPI = RetrofitClient.getLandmarkAPI();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String TAG = "랜드마크 API 실행";
                landmarkCall = landmarkAPI.getLandmarkInfo(String.valueOf(editTextNumber.getText()));
                //landmarklistCall = landmarkAPI.getLandmarkList();
                landmarkCall.clone().enqueue(new Callback<Landmark>() {
                    @Override
                    public void onResponse(Call<Landmark> call, Response<Landmark> response) {
                        if (response.isSuccessful()) {
                            editTextNumber.setText(response.body().getName());
                            String imageUrl = response.body().getPicture();
                            editTextMultiLine.setText(response.body().getPicture());
                            Glide.with(view)
                                    .load(imageUrl)
                                    .circleCrop()
                                    .into(imageView);
                            Log.d(TAG, "정상출력");
                        }
                    }

                    @Override
                    public void onFailure(Call<Landmark> call, Throwable t) {
                        Log.e("retrofit 연동", "실패");
                        t.printStackTrace();
                    }
                });
            }
        });*/
    }
}