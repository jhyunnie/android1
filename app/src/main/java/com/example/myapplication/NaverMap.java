package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;


import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.MapView;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.UiSettings;
import com.naver.maps.map.overlay.Marker;

public class NaverMap extends AppCompatActivity implements OnMapReadyCallback {
    private MapView mapView;

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

        Marker marker = new Marker();
        marker.setIconTintColor(Color.RED);
        marker.setPosition(new LatLng(37.5494524, 127.0817609));
        marker.setMap(naverMap);

    }



}