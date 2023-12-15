package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("c")
    private double close;
    @SerializedName("h")
    private double high;
    @SerializedName("l")
    private double low;
    @SerializedName("n")
    private int trades;
    @SerializedName("o")
    private double open;
    @SerializedName("t")
    private long timestamp;
    @SerializedName("v")
    private long volume;
    @SerializedName("vw")
    private double volumeWeighted;

    public double getClose() {
        return close;
    }

    public double getHigh() {
        return high;
    }

    public double getLow() {
        return low;
    }

    public int getTrades() {
        return trades;
    }

    public double getOpen() {
        return open;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public long getVolume() {
        return volume;
    }

    public double getVolumeWeighted() {
        return volumeWeighted;
    }
}
