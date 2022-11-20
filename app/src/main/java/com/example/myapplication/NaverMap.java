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
import com.naver.maps.map.util.MarkerIcons;

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

        Marker marker1 = new Marker();
        marker1.setIcon(MarkerIcons.BLACK);
        marker1.setIconTintColor(Color.RED);
        marker1.setPosition(new LatLng(37.57975, 126.97668));
        marker1.setMap(naverMap);

        Marker marker2 = new Marker();
        //marker2.setIcon(MarkerIcons.BLACK);
        //marker2.setIconTintColor(Color.GREEN);
        marker2.setPosition(new LatLng(37.57162, 126.97690));
        marker2.setMap(naverMap);

        Marker marker3 = new Marker();
        marker3.setIcon(MarkerIcons.BLACK);
        marker3.setIconTintColor(Color.BLUE);
        marker3.setPosition(new LatLng(37.55244, 126.98843));
        marker3.setMap(naverMap);

        Marker marker4 = new Marker();
        marker4.setIcon(MarkerIcons.BLACK);
        marker4.setIconTintColor(Color.RED);
        marker4.setPosition(new LatLng(37.58192, 127.00302));
        marker4.setMap(naverMap);

        Marker marker5 = new Marker();
        //marker5.setIcon(MarkerIcons.BLACK);
        //marker5.setIconTintColor(Color.GREEN);
        marker5.setPosition(new LatLng(37.56614, 126.97497));
        marker5.setMap(naverMap);

        Marker marker6 = new Marker();
        marker6.setIcon(MarkerIcons.BLACK);
        marker6.setIconTintColor(Color.RED);
        marker6.setPosition(new LatLng(37.57186, 127.01149));
        marker6.setMap(naverMap);

        Marker marker7 = new Marker();
        marker7.setIcon(MarkerIcons.BLACK);
        marker7.setIconTintColor(Color.BLUE);
        marker7.setPosition(new LatLng(37.57234, 127.01566));
        marker7.setMap(naverMap);

        Marker marker8 = new Marker();
        //marker8.setIcon(MarkerIcons.BLACK);
        //marker8.setIconTintColor(Color.GREEN);
        marker8.setPosition(new LatLng(37.56306, 126.98535));
        marker8.setMap(naverMap);

        Marker marker9 = new Marker();
        marker9.setIcon(MarkerIcons.BLACK);
        marker9.setIconTintColor(Color.RED);
        marker9.setPosition(new LatLng(37.55999, 126.97536));
        marker9.setMap(naverMap);

        Marker marker10 = new Marker();
        marker10.setIcon(MarkerIcons.BLACK);
        marker10.setIconTintColor(Color.BLUE);
        marker10.setPosition(new LatLng(37.54954, 127.07823));
        marker10.setMap(naverMap);

        Marker marker11 = new Marker();
        //marker11.setIcon(MarkerIcons.BLACK);
        //marker11.setIconTintColor(Color.GREEN);
        marker11.setPosition(new LatLng(37.51927, 127.12172));
        marker11.setMap(naverMap);

        Marker marker12 = new Marker();
        marker12.setIcon(MarkerIcons.BLACK);
        marker12.setIconTintColor(Color.RED);
        marker12.setPosition(new LatLng(37.51307, 127.10321));
        marker12.setMap(naverMap);

        Marker marker13 = new Marker();
        marker13.setIcon(MarkerIcons.BLACK);
        marker13.setIconTintColor(Color.BLUE);
        marker13.setPosition(new LatLng(37.58239, 126.99170));
        marker13.setMap(naverMap);

        Marker marker14 = new Marker();
        //marker14.setIcon(MarkerIcons.BLACK);
        //marker14.setIconTintColor(Color.GREEN);
        marker14.setPosition(new LatLng(37.56526, 127.00812));
        marker14.setMap(naverMap);

    }



}