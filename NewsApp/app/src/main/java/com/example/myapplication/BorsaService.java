package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BorsaService {
    @GET("v2/aggs/ticker/{ticker}/range/1/day/2023-01-09/2023-01-09")
    Call<BorsaData> getBorsaData(
            @Path("ticker") String ticker,
            @Query("adjusted") boolean adjusted,
            @Query("apiKey") String apiKey
    );
}