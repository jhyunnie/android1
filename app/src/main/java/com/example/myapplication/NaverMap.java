package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;


import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.MapView;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.UiSettings;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.util.MarkerIcons;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NaverMap extends AppCompatActivity implements OnMapReadyCallback {
    private MapView mapView;

    //Retrofit
    private static final String urls = "http://10.0.2.2:5000/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naver_map);

        mapView = findViewById(R.id.map_view);
        mapView.onCreate(savedInstanceState);

        naverMapBasicSettings();
    }

    private void naverMapBasicSettings() {
        mapView.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull com.naver.maps.map.NaverMap naverMap) {
        UiSettings uiSettings = naverMap.getUiSettings();
        uiSettings.setLocationButtonEnabled(false);

        //Retrofit
        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        LandmarkAPI landmarkAPI = RetrofitClient.getLandmarkAPI();

        // Attraction API call
        Call<List<List<LandMark>>> callAttraction = landmarkAPI.getAttractionLandmarkInfo();
        callAttraction.clone().enqueue(new Callback<List<List<LandMark>>>() {
            @Override
            public void onResponse(Call<List<List<LandMark>>> call, Response<List<List<LandMark>>> response) {
                if (response.isSuccessful()) {
                    List<List<LandMark>> landMarkList = response.body();

                    // 현재 교통량
                    float[] rating = new float[14]; // 1~14까지 : 0~13
                    for (int i = 0; i <= 13; i++) {
                        int congestion = (int) (Float.parseFloat(landMarkList.get(i).get(0).getLandcongestion()) * 100);
                        rating[i] = 0f;
                        rating[i] = getRating(rating[i], congestion);
                    }

                    // 경복궁
                    Marker marker1 = new Marker();
                    // 마커 컬러 설정
                    marker1.setIcon(MarkerIcons.BLACK);
                    if (rating[0] == 0f) {
                        marker1.setIconTintColor(Color.GREEN);
                    }
                    else if (rating[0] == 1f){
                        marker1.setIconTintColor(Color.YELLOW);
                    }
                    else if (rating[0] == 2f){
                        marker1.setIconTintColor(Color.RED);
                    }
                    marker1.setPosition(new LatLng(37.57975, 126.97668));
                    marker1.setMap(naverMap);

                    // 광화문
                    Marker marker2 = new Marker();
                    marker2.setIcon(MarkerIcons.BLACK);
                    if (rating[1] == 0f) {
                        marker2.setIconTintColor(Color.GREEN);
                    }
                    else if (rating[1] == 1f){
                        marker2.setIconTintColor(Color.YELLOW);
                    }
                    else if (rating[1] == 2f){
                        marker2.setIconTintColor(Color.RED);
                    }
                    marker2.setPosition(new LatLng(37.57162, 126.97690));
                    marker2.setMap(naverMap);

                    // 남산
                    Marker marker3 = new Marker();
                    marker3.setIcon(MarkerIcons.BLACK);
                    if (rating[2] == 0f) {
                        marker3.setIconTintColor(Color.GREEN);
                    }
                    else if (rating[2] == 1f){
                        marker3.setIconTintColor(Color.YELLOW);
                    }
                    else if (rating[2] == 2f){
                        marker3.setIconTintColor(Color.RED);
                    }
                    marker3.setPosition(new LatLng(37.55244, 126.98843));
                    marker3.setMap(naverMap);

                    // 대학로
                    Marker marker4 = new Marker();
                    marker4.setIcon(MarkerIcons.BLACK);
                    if (rating[3] == 0f) {
                        marker4.setIconTintColor(Color.GREEN);
                    }
                    else if (rating[3] == 1f){
                        marker4.setIconTintColor(Color.YELLOW);
                    }
                    else if (rating[3] == 2f){
                        marker4.setIconTintColor(Color.RED);
                    }
                    marker4.setPosition(new LatLng(37.58192, 127.00302));
                    marker4.setMap(naverMap);

                    // 덕수궁
                    Marker marker5 = new Marker();
                    marker5.setIcon(MarkerIcons.BLACK);
                    if (rating[4] == 0f) {
                        marker5.setIconTintColor(Color.GREEN);
                    }
                    else if (rating[4] == 1f){
                        marker5.setIconTintColor(Color.YELLOW);
                    }
                    else if (rating[4] == 2f){
                        marker5.setIconTintColor(Color.RED);
                    }
                    marker5.setPosition(new LatLng(37.56614, 126.97497));
                    marker5.setMap(naverMap);

                    // 동대문
                    Marker marker6 = new Marker();
                    marker6.setIcon(MarkerIcons.BLACK);
                    if (rating[5] == 0f) {
                        marker6.setIconTintColor(Color.GREEN);
                    }
                    else if (rating[5] == 1f){
                        marker6.setIconTintColor(Color.YELLOW);
                    }
                    else if (rating[5] == 2f){
                        marker6.setIconTintColor(Color.RED);
                    }
                    marker6.setPosition(new LatLng(37.57186, 127.01149));
                    marker6.setMap(naverMap);

                    // 동묘앞
                    Marker marker7 = new Marker();
                    marker7.setIcon(MarkerIcons.BLACK);
                    if (rating[6] == 0f) {
                        marker7.setIconTintColor(Color.GREEN);
                    }
                    else if (rating[6] == 1f){
                        marker7.setIconTintColor(Color.YELLOW);
                    }
                    else if (rating[6] == 2f){
                        marker7.setIconTintColor(Color.RED);
                    }
                    marker7.setPosition(new LatLng(37.57234, 127.01566));
                    marker7.setMap(naverMap);

                    // 명동
                    Marker marker8 = new Marker();
                    marker8.setIcon(MarkerIcons.BLACK);
                    if (rating[7] == 0f) {
                        marker8.setIconTintColor(Color.GREEN);
                    }
                    else if (rating[7] == 1f){
                        marker8.setIconTintColor(Color.YELLOW);
                    }
                    else if (rating[7] == 2f){
                        marker8.setIconTintColor(Color.RED);
                    }
                    marker8.setPosition(new LatLng(37.56306, 126.98535));
                    marker8.setMap(naverMap);

                    // 숭례문
                    Marker marker9 = new Marker();
                    marker9.setIcon(MarkerIcons.BLACK);
                    if (rating[8] == 0f) {
                        marker9.setIconTintColor(Color.GREEN);
                    }
                    else if (rating[8] == 1f){
                        marker9.setIconTintColor(Color.YELLOW);
                    }
                    else if (rating[8] == 2f){
                        marker9.setIconTintColor(Color.RED);
                    }
                    marker9.setPosition(new LatLng(37.55999, 126.97536));
                    marker9.setMap(naverMap);

                    // 어린이대공원
                    Marker marker10 = new Marker();
                    marker10.setIcon(MarkerIcons.BLACK);
                    if (rating[9] == 0f) {
                        marker10.setIconTintColor(Color.GREEN);
                    }
                    else if (rating[9] == 1f){
                        marker10.setIconTintColor(Color.YELLOW);
                    }
                    else if (rating[9] == 2f){
                        marker10.setIconTintColor(Color.RED);
                    }
                    marker10.setPosition(new LatLng(37.54954, 127.07823));
                    marker10.setMap(naverMap);

                    // 올림픽공원
                    Marker marker11 = new Marker();
                    marker11.setIcon(MarkerIcons.BLACK);
                    if (rating[10] == 0f) {
                        marker11.setIconTintColor(Color.GREEN);
                    }
                    else if (rating[10] == 1f){
                        marker11.setIconTintColor(Color.YELLOW);
                    }
                    else if (rating[10] == 2f){
                        marker11.setIconTintColor(Color.RED);
                    }
                    marker11.setPosition(new LatLng(37.51927, 127.12172));
                    marker11.setMap(naverMap);

                    // 롯데타워
                    Marker marker12 = new Marker();
                    marker12.setIcon(MarkerIcons.BLACK);
                    if (rating[11] == 0f) {
                        marker12.setIconTintColor(Color.GREEN);
                    }
                    else if (rating[11] == 1f){
                        marker12.setIconTintColor(Color.YELLOW);
                    }
                    else if (rating[11] == 2f){
                        marker12.setIconTintColor(Color.RED);
                    }
                    marker12.setPosition(new LatLng(37.51307, 127.10321));
                    marker12.setMap(naverMap);

                    // 창덕궁
                    Marker marker13 = new Marker();
                    marker13.setIcon(MarkerIcons.BLACK);
                    if (rating[12] == 0f) {
                        marker13.setIconTintColor(Color.GREEN);
                    }
                    else if (rating[12] == 1f){
                        marker13.setIconTintColor(Color.YELLOW);
                    }
                    else if (rating[12] == 2f){
                        marker13.setIconTintColor(Color.RED);
                    }
                    marker13.setPosition(new LatLng(37.58239, 126.99170));
                    marker13.setMap(naverMap);

                    // DDP
                    Marker marker14 = new Marker();
                    marker14.setIcon(MarkerIcons.BLACK);
                    if (rating[13] == 0f) {
                        marker14.setIconTintColor(Color.GREEN);
                    }
                    else if (rating[13] == 1f){
                        marker14.setIconTintColor(Color.YELLOW);
                    }
                    else if (rating[13] == 2f){
                        marker14.setIconTintColor(Color.RED);
                    }
                    marker14.setPosition(new LatLng(37.56526, 127.00812));
                    marker14.setMap(naverMap);
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
        if (0 <= congestion && congestion < 30){
            rating = 0f;
        } else if (30 <= congestion && congestion < 75) {
            rating = 1f;
        } else{
            rating = 2f;
        }
        return rating;
    }


}