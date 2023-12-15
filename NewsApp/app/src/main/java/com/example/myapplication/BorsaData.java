package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BorsaData {
    @SerializedName("ticker")
    private String ticker;
    @SerializedName("results")
    private List<Result> results;
    public String getTicker() {
        return ticker;
    }
    public List<Result> getResults() {
        return results;
    }
}