package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

public class LandmarkCongest {
    private String name;
    @SerializedName("bus")
    private String bus;
    @SerializedName("car")
    private String car;
    @SerializedName("congestion")
    private String congestion;
    @SerializedName("date")
    private String date;
    @SerializedName("person")
    private String person;
    @SerializedName("truck")
    private String truck;


    public LandmarkCongest(String id, String date, String car, String person, String truck, String bus, String congestion, String name) {
        this.date = date;
        this.car = car;
        this.person = person;
        this.truck = truck;
        this.bus = bus;
        this.congestion = congestion;
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public String getCar() {
        return car;
    }

    public String getPerson() {
        return person;
    }

    public String getTruck() {
        return truck;
    }

    public String getBus() {
        return bus;
    }

    public String getCongestion() {
        return congestion;
    }

    public String getName() {
        return name;
    }
}
