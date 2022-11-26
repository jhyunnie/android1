package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LandmarkAPI {
    @GET("/landmark/{names}")
    Call<List<LandMark>> getLandmarkInfo(@Path("names") String names);

    @GET("/landmark/recycle")
    Call<List<List<LandMark>>> getRecycleLandmarkInfo();

    @GET("/region")
    Call<List<List<LandMark>>> getRegionLandmarkInfo();

    @GET("/attraction")
    Call<List<List<LandMark>>> getAttractionLandmarkInfo();
}
