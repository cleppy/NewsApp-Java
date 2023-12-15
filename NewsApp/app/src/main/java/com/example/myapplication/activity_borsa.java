package com.example.myapplication;
import static com.example.myapplication.activity_news.API_KEY;

import com.example.myapplication.BuildConfig;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.BorsaData;
import com.example.myapplication.BorsaService;
import com.example.myapplication.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class activity_borsa extends AppCompatActivity {
    private EditText tickerEditText;
    private TextView tickerTextView;
    private TextView firstCloseTextView;
    private TextView firstHighTextView;
    private TextView firstLowTextView;
    private TextView firstTradesTextView;
    private TextView firstOpenTextView;
    private TextView firstTimestampTextView;
    private TextView firstVolumeTextView;
    private TextView firstVolumeWeightedTextView;

    private static final String BASE_URL = "https://api.polygon.io/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borsa);

        tickerEditText = findViewById(R.id.tickerEditText);
        tickerTextView = findViewById(R.id.tickerTextView);
        firstCloseTextView = findViewById(R.id.firstCloseTextView);
        firstHighTextView = findViewById(R.id.firstHighTextView);
        firstLowTextView = findViewById(R.id.firstLowTextView);
        firstTradesTextView = findViewById(R.id.firstTradesTextView);
        firstOpenTextView = findViewById(R.id.firstOpenTextView);
        firstTimestampTextView = findViewById(R.id.firstTimestampTextView);
        firstVolumeTextView = findViewById(R.id.firstVolumeTextView);
        firstVolumeWeightedTextView = findViewById(R.id.firstVolumeWeightedTextView);



    }

    public void getData(View view) {
        Resources res = getResources();
        String apiKey = res.getString(R.string.api_key);

        String tickerEdit = tickerEditText.getText().toString().toUpperCase();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BorsaService borsaService = retrofit.create(BorsaService.class);
        Call<BorsaData> call = borsaService.getBorsaData(tickerEdit, true, apiKey);
        call.enqueue(new Callback<BorsaData>() {
            @Override
            public void onResponse(Call<BorsaData> call, Response<BorsaData> response) {
                if (response.isSuccessful() && response.body() != null) {
                    BorsaData borsaData = response.body();
                    updateUI(borsaData);
                } else {
                    tickerTextView.setText("Veri alınamadı. Kod: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<BorsaData> call, Throwable t) {
                tickerTextView.setText("Hata?");
            }
        });
    }

    private void updateUI(BorsaData borsaData) {
        if (borsaData != null) {
            tickerTextView.setText("Ticker: " + borsaData.getTicker());
            if (borsaData.getResults() != null && !borsaData.getResults().isEmpty()) {
                Result firstResult = borsaData.getResults().get(0);
                firstCloseTextView.setText("First Close: " + firstResult.getClose());
                firstHighTextView.setText("First High: " + firstResult.getHigh());
                firstLowTextView.setText("First Low: " + firstResult.getLow());
                firstTradesTextView.setText("First Trades: " + firstResult.getTrades());
                firstOpenTextView.setText("First Open: " + firstResult.getOpen());
                firstTimestampTextView.setText("First Timestamp: " + firstResult.getTimestamp());
                firstVolumeTextView.setText("First Volume: " + firstResult.getVolume());
                firstVolumeWeightedTextView.setText("First Volume Weighted: " + firstResult.getVolumeWeighted());
            }
        }
    }
}