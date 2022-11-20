package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LandmarkAPI {
    @GET("/landmark/{names}")
    Call<List<LandmarkCongest>> getLandmarkInfo(@Path("names") String names);
}
