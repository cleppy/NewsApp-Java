package com.example.myapplication;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import java.util.List;

public class activity_doviz extends AppCompatActivity {
    public TextView usdRateTextView, eurRateTextView, gbpRateTextView, jpyRateTextView,
            btcRateTextView, cadRateTextView, audRateTextView, chfRateTextView, cnyRateTextView,
            inrRateTextView, zarRateTextView, egpRateTextView, brlRateTextView,
            mxnRateTextView, arsRateTextView, clpRateTextView, sekRateTextView, nokRateTextView,
            dkkRateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doviz);

        usdRateTextView = findViewById(R.id.usdRateTextView);
        eurRateTextView = findViewById(R.id.eurRateTextView);
        gbpRateTextView = findViewById(R.id.gbpRateTextView);
        jpyRateTextView = findViewById(R.id.jpyRateTextView);
        btcRateTextView = findViewById(R.id.btcRateTextView);
        cadRateTextView = findViewById(R.id.cadRateTextView);
        audRateTextView = findViewById(R.id.audRateTextView);
        chfRateTextView = findViewById(R.id.chfRateTextView);
        cnyRateTextView = findViewById(R.id.cnyRateTextView);
        inrRateTextView = findViewById(R.id.inrRateTextView);
        zarRateTextView = findViewById(R.id.zarRateTextView);
        egpRateTextView = findViewById(R.id.egpRateTextView);
        brlRateTextView = findViewById(R.id.brlRateTextView);
        mxnRateTextView = findViewById(R.id.mxnRateTextView);
        arsRateTextView = findViewById(R.id.arsRateTextView);
        clpRateTextView = findViewById(R.id.clpRateTextView);
        sekRateTextView = findViewById(R.id.sekRateTextView);
        nokRateTextView = findViewById(R.id.nokRateTextView);
        dkkRateTextView = findViewById(R.id.dkkRateTextView);

        String apiUrl = "http://api.exchangeratesapi.io/v1/latest?access_key=b7b480e2fb7305c2293fe94d6c490a63";

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, apiUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject rates = response.getJSONObject("rates");
                    double jpyRate = rates.getDouble("JPY");
                    double btcRate = rates.getDouble("BTC");
                    double tryRate = rates.getDouble("TRY");
                    double usdRate = rates.getDouble("USD");
                    double eurRate = rates.getDouble("EUR");
                    double gbpRate = rates.getDouble("GBP");
                    double cadRate = rates.getDouble("CAD");
                    double audRate = rates.getDouble("AUD");
                    double chfRate = rates.getDouble("CHF");
                    double cnyRate = rates.getDouble("CNY");
                    double inrRate = rates.getDouble("INR");
                    double zarRate = rates.getDouble("ZAR");
                    double egpRate = rates.getDouble("EGP");
                    double brlRate = rates.getDouble("BRL");
                    double mxnRate = rates.getDouble("MXN");
                    double arsRate = rates.getDouble("ARS");
                    double clpRate = rates.getDouble("CLP");
                    double sekRate = rates.getDouble("SEK");
                    double nokRate = rates.getDouble("NOK");
                    double dkkRate = rates.getDouble("DKK");

                    jpyRateTextView.setText(String.format("%.2f TRY", tryRate / jpyRate));
                    btcRateTextView.setText(String.format("%.2f TRY", tryRate / btcRate));
                    usdRateTextView.setText(String.format("%.2f TRY", tryRate / usdRate));
                    eurRateTextView.setText(String.format("%.2f TRY", tryRate / eurRate));
                    gbpRateTextView.setText(String.format("%.2f TRY", tryRate / gbpRate));
                    cadRateTextView.setText(String.format("%.2f TRY", tryRate / cadRate));
                    audRateTextView.setText(String.format("%.2f TRY", tryRate / audRate));
                    chfRateTextView.setText(String.format("%.2f TRY", tryRate / chfRate));
                    cnyRateTextView.setText(String.format("%.2f TRY", tryRate / cnyRate));
                    inrRateTextView.setText(String.format("%.2f TRY", tryRate / inrRate));
                    zarRateTextView.setText(String.format("%.2f TRY", tryRate / zarRate));
                    egpRateTextView.setText(String.format("%.2f TRY", tryRate / egpRate));
                    brlRateTextView.setText(String.format("%.2f TRY", tryRate / brlRate));
                    mxnRateTextView.setText(String.format("%.2f TRY", tryRate / mxnRate));
                    arsRateTextView.setText(String.format("%.2f TRY", tryRate / arsRate));
                    clpRateTextView.setText(String.format("%.2f TRY", tryRate / clpRate));
                    sekRateTextView.setText(String.format("%.2f TRY", tryRate / sekRate));
                    nokRateTextView.setText(String.format("%.2f TRY", tryRate / nokRate));
                    dkkRateTextView.setText(String.format("%.2f TRY", tryRate / dkkRate));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                usdRateTextView.setText("Veri alınamadı. İnternet bağlantınızı kontrol edin.");
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}