package com.example.myapplication;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.util.List;
import com.example.myapplication.Article;
import com.example.myapplication.NewsAdapter;
import com.example.myapplication.NewsApiService;
import com.example.myapplication.NewsResponse;


public class activity_news extends AppCompatActivity {
    public static final String BASE_URL = "https://newsapi.org/v2/";
    public static final String API_KEY = "15d080183a3342e4bb4f7c2be9e1d1a1"; // News API key
    public RecyclerView recyclerView;
    public NewsAdapter newsAdapter;
    public TextView errorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        recyclerView = findViewById(R.id.recyclerView);
        errorMessage = findViewById(R.id.errorMessage);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        newsAdapter = new NewsAdapter(this);
        recyclerView.setAdapter(newsAdapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NewsApiService newsApiService = retrofit.create(NewsApiService.class);
        Call<NewsResponse> call = newsApiService.getTopHeadlines("us", API_KEY);

        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(@NonNull Call<NewsResponse> call, @NonNull Response<NewsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Article> articles = response.body().getArticles();
                    if (!articles.isEmpty()) {
                        newsAdapter.setNewsItems(articles);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<NewsResponse> call, @NonNull Throwable t) {
                recyclerView.setVisibility(View.VISIBLE);
                errorMessage.setVisibility(View.VISIBLE);
            }
        });
    }
}
